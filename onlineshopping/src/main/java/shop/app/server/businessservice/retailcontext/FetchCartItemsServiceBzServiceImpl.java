package shop.app.server.businessservice.retailcontext;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Override;
import java.util.List;
import shop.app.shared.retailcontext.FetchCartItems;

@Component
public class FetchCartItemsServiceBzServiceImpl implements FetchCartItemsServiceBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<FetchCartItems> executeQueryFetchCartItems() throws Exception {
        java.util.List<shop.app.shared.retailcontext.FetchCartItems> listDtoInterface = new java.util.ArrayList<shop.app.shared.retailcontext.FetchCartItems>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "218FB403-0A34-4911-B76A-3AAB513274A1");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("shop.app.shared.retailcontext.FetchCartItems", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
