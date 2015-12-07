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

@Table(name = "ast_Card_T")
@Entity
@NamedQueries({ @javax.persistence.NamedQuery(name = "Card.findById", query = "select e from Card e where e.systemInfo.activeStatus=1 and e.cardId =:cardId") })
public class Card implements Serializable, CommonEntityInterface, Comparator<Card> {

    @Column(name = "cardNo")
    @JsonProperty("cardNo")
    @NotNull
    @Size(min = 0, max = 16)
    private String cardNo;

    @Column(name = "expDate")
    @JsonProperty("expDate")
    @NotNull
    @Size(min = 0, max = 256)
    private String expDate;

    @Column(name = "nameOnCard")
    @JsonProperty("nameOnCard")
    @NotNull
    @Size(min = 0, max = 256)
    private String nameOnCard;

    @Column(name = "amt")
    @JsonProperty("amt")
    @NotNull
    @Min(0)
    @Max(9999999)
    private Double amt;

    @Column(name = "cvv")
    @JsonProperty("cvv")
    @NotNull
    @Size(min = 0, max = 3)
    private String cvv;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "cardId")
    @JsonProperty("cardId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String cardId;

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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String _cardNo) {
        if (_cardNo != null) {
            this.cardNo = _cardNo;
        }
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String _expDate) {
        if (_expDate != null) {
            this.expDate = _expDate;
        }
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String _nameOnCard) {
        if (_nameOnCard != null) {
            this.nameOnCard = _nameOnCard;
        }
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double _amt) {
        if (_amt != null) {
            this.amt = _amt;
        }
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String _cvv) {
        if (_cvv != null) {
            this.cvv = _cvv;
        }
    }

    public String getPrimaryKey() {
        return cardId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return cardId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String _cardId) {
        this.cardId = _cardId;
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
    public int compare(Card object1, Card object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((nameOnCard == null ? " " : nameOnCard));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (cardId == null) {
            return super.hashCode();
        } else {
            return cardId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            shop.app.shared.retail.Card other = (shop.app.shared.retail.Card) obj;
            if (cardId == null) {
                return false;
            } else if (!cardId.equals(other.cardId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
