package shop.app.server.businessservice.retailcontext;
import java.util.List;
import shop.app.shared.retailcontext.FetchCartItems;

public interface FetchCartItemsServiceBzService {

    public List<FetchCartItems> executeQueryFetchCartItems() throws Exception;
}
