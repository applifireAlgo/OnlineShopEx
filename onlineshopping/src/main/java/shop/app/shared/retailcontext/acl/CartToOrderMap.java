package shop.app.shared.retailcontext.acl;
import shop.app.shared.retail.Cart;
import java.util.List;
import shop.app.shared.retail.OrderMain;

public class CartToOrderMap {

    public CartToOrderMap(List<Cart> _cart) {
        this.cartInput = _cart;
        this.doMapping();
    }

    private List<Cart> cartInput;

    private OrderMain ordermainOutput;

    public OrderMain cartToOrderMap() {
        return ordermainOutput;
    }

    public void doMapping() {
        ordermainOutput = new OrderMain();
        java.util.List<shop.app.shared.retail.OrderDetail> lstorderDetailEntities = new java.util.ArrayList<shop.app.shared.retail.OrderDetail>();
        for (shop.app.shared.retail.Cart _orderDetail : cartInput) {
            shop.app.shared.retail.OrderDetail orderdetail = new shop.app.shared.retail.OrderDetail();
            orderdetail.setItemId(_orderDetail.getItemId());
            orderdetail.setSubTotal(_orderDetail.getItemSubTotal());
            orderdetail.setQuantity(_orderDetail.getQuantity());
            orderdetail.setUnitPrice(_orderDetail.getItemUnitPrice());
            lstorderDetailEntities.add(orderdetail);
        }
        ordermainOutput.setOrderDetail(lstorderDetailEntities);
    }
}
