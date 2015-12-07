package shop.app.shared.retailcontext;
import com.athena.server.bizService.DTOMapperInterface;

public class GetTotal implements DTOMapperInterface {

    private Double amount;

    public GetTotal(Object obj) {
        if (obj != null) {
            amount = (java.lang.Double) obj;
        } else {
            amount = null;
        }
    }

    public Double getAmount() {
        return amount;
    }
}
