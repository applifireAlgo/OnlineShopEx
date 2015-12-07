package shop.app.shared.retailcontext;
import com.athena.server.bizService.DTOMapperInterface;

public class FetchCartItems implements DTOMapperInterface {

    private Integer quantity;

    private Double itemUnitPrice;

    private Double itemSubTotal;

    private String item;

    private String itemIcon;

    public FetchCartItems(Object[] aryObject) {
        if (aryObject != null) {
            quantity = (java.lang.Integer) aryObject[0];
            itemUnitPrice = (java.lang.Double) aryObject[1];
            itemSubTotal = (java.lang.Double) aryObject[2];
            item = (java.lang.String) aryObject[3];
            itemIcon = (java.lang.String) aryObject[4];
        } else {
            quantity = null;
            itemUnitPrice = null;
            itemSubTotal = null;
            item = null;
            itemIcon = null;
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getItemUnitPrice() {
        return itemUnitPrice;
    }

    public Double getItemSubTotal() {
        return itemSubTotal;
    }

    public String getItem() {
        return item;
    }

    public String getItemIcon() {
        return itemIcon;
    }
}
