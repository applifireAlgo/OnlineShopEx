package shop.app.shared.retail;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import javax.persistence.Embedded;
import shop.app.shared.EntityAudit;
import shop.app.shared.SystemInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_OrderMain_T")
@Entity
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "orderId")
@NamedQueries({ @javax.persistence.NamedQuery(name = "OrderMain.findById", query = "select e from OrderMain e where e.systemInfo.activeStatus=1 and e.orderId =:orderId") })
public class OrderMain implements Serializable, CommonEntityInterface, Comparator<OrderMain> {

    @Column(name = "orderDate")
    @JsonProperty("orderDate")
    private Date orderDate;

    @Column(name = "orderBy")
    @JsonProperty("orderBy")
    @Size(min = 0, max = 256)
    private String orderBy;

    @Column(name = "total")
    @JsonProperty("total")
    @Min(0)
    @Max(99999999)
    private Double total;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "orderId")
    @JsonProperty("orderId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String orderId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "orderMain")
    private List<OrderDetail> orderDetail;

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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date _orderDate) {
        this.orderDate = _orderDate;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String _orderBy) {
        this.orderBy = _orderBy;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double _total) {
        this.total = _total;
    }

    public String getPrimaryKey() {
        return orderId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String _orderId) {
        this.orderId = _orderId;
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

    public OrderMain addOrderDetail(OrderDetail _orderDetail) {
        if (this.orderDetail == null) {
            this.orderDetail = new java.util.ArrayList<shop.app.shared.retail.OrderDetail>();
        }
        if (_orderDetail != null) {
            _orderDetail.setOrderMain(this);
            this.orderDetail.add(_orderDetail);
        }
        return this;
    }

    public OrderMain removeOrderDetail(OrderDetail _orderDetail) {
        if (this.orderDetail != null) {
            this.orderDetail.remove(_orderDetail);
        }
        return this;
    }

    public OrderMain addAllOrderDetail(List<OrderDetail> _orderDetail) {
        if (this.orderDetail == null) {
            this.orderDetail = new java.util.ArrayList<shop.app.shared.retail.OrderDetail>();
        }
        if (_orderDetail != null) {
            for (int i = 0; i < _orderDetail.size(); i++) {
                _orderDetail.get(i).setOrderMain(this);
            }
            this.orderDetail.addAll(_orderDetail);
        }
        return this;
    }

    @JsonIgnore
    public Integer getTotalNumberOfOrderDetail() {
        if (this.orderDetail != null) {
            return this.orderDetail.size();
        }
        return 0;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> _orderDetail) {
        for (int i = 0; i < _orderDetail.size(); i++) {
            if (_orderDetail.get(i).getOrderMain() == null) {
                _orderDetail.get(i).setOrderMain(this);
            }
        }
        this.orderDetail = _orderDetail;
    }

    @JsonIgnore
    public List<OrderDetail> getDeletedOrderDetailList() {
        List<OrderDetail> orderdetailToRemove = new java.util.ArrayList<OrderDetail>();
        for (OrderDetail _orderdetail : orderDetail) {
            if (_orderdetail.isHardDelete()) {
                orderdetailToRemove.add(_orderdetail);
            }
        }
        orderDetail.removeAll(orderdetailToRemove);
        return orderdetailToRemove;
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
        setValidatororderDetail(_validateFactory);
    }

    private void setValidatororderDetail(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < orderDetail.size(); i++) {
            orderDetail.get(i).setEntityValidator(_validateFactory);
        }
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
        if (this.orderDetail == null) {
            this.orderDetail = new java.util.ArrayList<OrderDetail>();
        }
        for (OrderDetail _orderDetail : orderDetail) {
            _orderDetail.setEntityAudit(customerId, userId, recordType);
            _orderDetail.setSystemInformation(recordType);
        }
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
        if (this.orderDetail == null) {
            this.orderDetail = new java.util.ArrayList<OrderDetail>();
        }
        for (OrderDetail _orderDetail : orderDetail) {
            _orderDetail.setEntityAudit(customerId, userId);
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
            this.systemInfo.setActiveStatus(-1);
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
    public int compare(OrderMain object1, OrderMain object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((orderDate == null ? " " : orderDate));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (orderId == null) {
            return super.hashCode();
        } else {
            return orderId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            shop.app.shared.retail.OrderMain other = (shop.app.shared.retail.OrderMain) obj;
            if (orderId == null) {
                return false;
            } else if (!orderId.equals(other.orderId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    public Integer getTotalQuantity() {
        int sum = 0;
        if (orderDetail.size() > 0 && orderDetail != null) {
            for (OrderDetail field : orderDetail) {
                sum += field.getQuantity();
            }
            return sum;
        }
        return 0;
    }

    public Double getTotalSubTotal() {
        Double sum = 0d;
        if (orderDetail.size() > 0 && orderDetail != null) {
            for (OrderDetail field : orderDetail) {
                sum += field.getSubTotal();
            }
            return sum;
        }
        return 0d;
    }
}
