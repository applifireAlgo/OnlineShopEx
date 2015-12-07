package shop.app.server.businessservice.retailcontext;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Override;
import java.util.List;
import shop.app.shared.retailcontext.GetTotal;

@Component
public class FetchOrderTotalServiceBzServiceImpl implements FetchOrderTotalServiceBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<GetTotal> executeQueryGetTotal() throws Exception {
        java.util.List<shop.app.shared.retailcontext.GetTotal> listDtoInterface = new java.util.ArrayList<shop.app.shared.retailcontext.GetTotal>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "FDF79EA1-A023-48F5-AC1C-34DB0117C82D");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("shop.app.shared.retailcontext.GetTotal", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
