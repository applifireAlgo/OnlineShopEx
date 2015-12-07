package shop.app.server.service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.app.server.businessservice.OrderProcessServiceImplService;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import shop.app.shared.retailcontext.retail.PaymentInfo;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/OrderProcessServiceImplServiceWS")
public class OrderProcessServiceImplServiceWS {

    @Autowired
    private OrderProcessServiceImplService orderprocessserviceimplservice;

    @RequestMapping(value = "/processOrder", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> processOrder(@RequestBody PaymentInfo paymentInfo) throws Exception {
        ResponseBean responseBean = new ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
        shop.app.shared.retailcontext.retail.PaymentResponse paymentresponse = orderprocessserviceimplservice.processOrder(paymentInfo);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully retrived ");
        responseBean.add("data", paymentresponse);
        return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
    }
}
