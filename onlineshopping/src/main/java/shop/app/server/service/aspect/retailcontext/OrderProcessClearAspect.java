package shop.app.server.service.aspect.retailcontext;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import shop.app.server.businessservice.retailcontext.retail.ClearUserCartService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Component
public class OrderProcessClearAspect {

    @Autowired
    private ClearUserCartService clearusercartservice;

    @After("afterorderProcessing()")
    public void afterOrderProcessingBzServiceorderProcessing(JoinPoint joinPoint) throws Throwable {
        clearusercartservice.clearUserCart();
    }

    @Pointcut("execution(* shop.app.server.businessservice.retailcontext.retail.OrderProcessingBzService.orderProcessing(..))")
    public void afterorderProcessing() {
    }
}
