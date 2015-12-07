package shop.app.server.businessservice.retailcontext;
import java.util.List;
import shop.app.shared.retailcontext.GetTotal;

public interface FetchOrderTotalServiceBzService {

    public List<GetTotal> executeQueryGetTotal() throws Exception;
}
