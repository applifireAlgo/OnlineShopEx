package shop.app.shared.retailcontext.retail;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartPartial {

    @Min(0)
    @Max(65535)
    private String itemId;

    @Min(0)
    @Max(65535)
    private String product;

    @Min(0)
    @Max(65535)
    private String brand;

    @Min(0)
    @Max(65535)
    private String category;

    @Min(0)
    @Max(65535)
    private String item;

    @Min(0)
    @Max(65535)
    private String itemIcon;

    @Min(-2147483648L)
    @Max(2147483647)
    private Integer quantity;

    @Min(-2147483648L)
    @Max(2147483647)
    private Integer itemPrice;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String _itemId) {
        this.itemId = _itemId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String _product) {
        this.product = _product;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String _brand) {
        this.brand = _brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String _category) {
        this.category = _category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String _item) {
        this.item = _item;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String _itemIcon) {
        this.itemIcon = _itemIcon;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer _quantity) {
        this.quantity = _quantity;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer _itemPrice) {
        this.itemPrice = _itemPrice;
    }
}
