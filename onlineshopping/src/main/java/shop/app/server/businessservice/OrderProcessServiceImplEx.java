package shop.app.server.businessservice;
import org.springframework.stereotype.Service;
import com.athena.deo.camel.utility.ExternalIntegrationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import shop.app.shared.retailcontext.retail.PaymentDetails;
import shop.app.shared.retailcontext.retail.TransactionResponse;

@Service
public class OrderProcessServiceImplEx {

    @Autowired
    private ExternalIntegrationCaller externalIntegrationCaller;

    public TransactionResponse processOrder(PaymentDetails paymentInfo) throws Exception {
        try {
	    System.out.println("In processOrder ");
            java.util.HashMap map = new java.util.HashMap();
            map.put("paymentInfo", paymentInfo);
	    System.out.println("Payment Info Object "+ paymentInfo);
            shop.app.shared.retailcontext.retail.TransactionResponse transactionresponse = (shop.app.shared.retailcontext.retail.TransactionResponse) externalIntegrationCaller.executeRoute("3B5F18A5-E120-4ABD-8515-9023985D5C57", map);
	    System.out.println("transactionresponse Info Object "+ transactionresponse);
            return transactionresponse;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
