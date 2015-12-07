package shop.app.server.businessservice;
import org.springframework.stereotype.Service;
import com.athena.deo.camel.utility.ExternalIntegrationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import shop.app.shared.retailcontext.retail.PaymentInfo;
import shop.app.shared.retailcontext.retail.PaymentResponse;

@Service
public class OrderProcessServiceImplService {

    @Autowired
    private ExternalIntegrationCaller externalIntegrationCaller;

    public PaymentResponse processOrder(PaymentInfo paymentInfo) throws Exception {
        try {
            java.util.HashMap map = new java.util.HashMap();
            map.put("paymentInfo", paymentInfo);
            shop.app.shared.retailcontext.retail.PaymentResponse paymentresponse = (shop.app.shared.retailcontext.retail.PaymentResponse) externalIntegrationCaller.executeRoute("6531A19B-2CA7-4EB8-8D7C-D87BE1AF99D0", map);
            return paymentresponse;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
