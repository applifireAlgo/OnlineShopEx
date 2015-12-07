package shop.app.shared.retail;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import javax.persistence.Embedded;
import shop.app.shared.EntityAudit;
import shop.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_Item_M")
@Entity
@NamedQueries({ @javax.persistence.NamedQuery(name = "Item.findById", query = "select e from Item e where e.systemInfo.activeStatus=1 and e.itemId =:itemId") })
public class Item implements Serializable, CommonEntityInterface, Comparator<Item> {

    @Column(name = "product")
    @JsonProperty("product")
    @NotNull
    @Size(min = 0, max = 256)
    private String product;

    @Column(name = "brand")
    @JsonProperty("brand")
    @NotNull
    @Size(min = 0, max = 256)
    private String brand;

    @Column(name = "category")
    @JsonProperty("category")
    @NotNull
    @Size(min = 0, max = 256)
    private String category;

    @Column(name = "item")
    @JsonProperty("item")
    @NotNull
    @Size(min = 0, max = 256)
    private String item;

    @Column(name = "itemStock")
    @JsonProperty("itemStock")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer itemStock;

    @Column(name = "itemPrice")
    @JsonProperty("itemPrice")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double itemPrice;

    @Column(name = "itemIcon")
    @JsonProperty("itemIcon")
    @NotNull
    private String itemIcon;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "itemId")
    @JsonProperty("itemId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String itemId;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getProduct() {
        return product;
    }

    public void setProduct(String _product) {
        if (_product != null) {
            this.product = _product;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String _brand) {
        if (_brand != null) {
            this.brand = _brand;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String _category) {
        if (_category != null) {
            this.category = _category;
        }
    }

    public String getItem() {
        return item;
    }

    public void setItem(String _item) {
        if (_item != null) {
            this.item = _item;
        }
    }

    public Integer getItemStock() {
        return itemStock;
    }

    public void setItemStock(Integer _itemStock) {
        if (_itemStock != null) {
            this.itemStock = _itemStock;
        }
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double _itemPrice) {
        if (_itemPrice != null) {
            this.itemPrice = _itemPrice;
        }
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String _itemIcon) {
        if (_itemIcon != null) {
            this.itemIcon = _itemIcon;
        }
    }

    public String getPrimaryKey() {
        return itemId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String _itemId) {
        this.itemId = _itemId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(Item object1, Item object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((item == null ? " " : item));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (itemId == null) {
            return super.hashCode();
        } else {
            return itemId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            shop.app.shared.retail.Item other = (shop.app.shared.retail.Item) obj;
            if (itemId == null) {
                return false;
            } else if (!itemId.equals(other.itemId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
