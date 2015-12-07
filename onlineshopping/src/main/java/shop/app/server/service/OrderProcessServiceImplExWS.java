package shop.app.server.service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.app.server.businessservice.OrderProcessServiceImplEx;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import shop.app.shared.retailcontext.retail.PaymentDetails;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/OrderProcessServiceImplExWS")
public class OrderProcessServiceImplExWS {

    @Autowired
    private OrderProcessServiceImplEx orderprocessserviceimplex;

    @RequestMapping(value = "/processOrder", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> processOrder(@RequestBody PaymentDetails paymentInfo) throws Exception {
        ResponseBean responseBean = new ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
        shop.app.shared.retailcontext.retail.TransactionResponse transactionresponse = orderprocessserviceimplex.processOrder(paymentInfo);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully retrived ");
        responseBean.add("data", transactionresponse);
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
    }
}
