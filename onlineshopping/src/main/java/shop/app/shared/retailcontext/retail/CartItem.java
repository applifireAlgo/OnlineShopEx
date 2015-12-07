package shop.app.shared.retailcontext.retail;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartItem {

    @Min(0)
    @Max(65535)
    private String itemIcon;

    @Min(0)
    @Max(65535)
    private String item;

    @Min(-2147483648L)
    @Max(2147483647)
    private Integer itemUnitPrice;

    @Min(-2147483648L)
    @Max(2147483647)
    private Integer quantity;

    @Min(-2147483648L)
    @Max(2147483647)
    private Integer itemSubTotal;

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String _itemIcon) {
        this.itemIcon = _itemIcon;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String _item) {
        this.item = _item;
    }

    public Integer getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(Integer _itemUnitPrice) {
        this.itemUnitPrice = _itemUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer _quantity) {
        this.quantity = _quantity;
    }

    public Integer getItemSubTotal() {
        return itemSubTotal;
    }

    public void setItemSubTotal(Integer _itemSubTotal) {
        this.itemSubTotal = _itemSubTotal;
    }
}
