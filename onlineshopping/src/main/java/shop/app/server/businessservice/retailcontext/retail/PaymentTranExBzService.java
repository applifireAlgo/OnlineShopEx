package shop.app.server.businessservice.retailcontext.retail;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.ruleengine.server.bzservice.RuleEngineInterface;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.app.server.businessservice.OrderProcessServiceImplEx;
import shop.app.server.repository.OrderMainRepository;
import shop.app.server.repository.OrderTransactionRepository;
import shop.app.shared.defaultdomain.OrderTransaction;
import shop.app.shared.retail.OrderMain;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import shop.app.shared.retailcontext.retail.PaymentDetails;

@Component
public class PaymentTranExBzService {

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private OrderProcessServiceImplEx orderProcessServiceImplEx;

    @Autowired
    private RuleEngineInterface ruleEngineInterface;

    @Autowired
    private OrderMainRepository<OrderMain> orderMainRepository;

    @Autowired
    private OrderTransactionRepository<OrderTransaction> orderTransactionRepository;

    public void paymentTranProcessing(PaymentDetails payment) throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        try {
            if (payment == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            shop.app.shared.retailcontext.retail.TransactionResponse transactionresponse_24 = orderProcessServiceImplEx.processOrder(payment);
            java.lang.String OrderId = (java.lang.String) sessionService.getSessionData("OrderId");
            if (OrderId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
            }
            if (OrderId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            shop.app.shared.retail.OrderMain ordermain_25 = orderMainRepository.findById(OrderId);
            ruleEngineInterface.initialize("70733eae-2a4f-4e1e-aba7-23061da00c94");
            ruleEngineInterface.add(transactionresponse_24);
            ruleEngineInterface.add(ordermain_25);
            ruleEngineInterface.add(runtimeLogInfoHelper);
            ruleEngineInterface.add(payment);
            ruleEngineInterface.executeRule();
            if ((shop.app.shared.defaultdomain.OrderTransaction) ruleEngineInterface.getResult("ordertransaction_26") == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            shop.app.shared.defaultdomain.OrderTransaction ordertransaction_27 = orderTransactionRepository.save((shop.app.shared.defaultdomain.OrderTransaction) ruleEngineInterface.getResult("ordertransaction_26"));
        } catch (com.athena.framework.server.exception.biz.RuleInitException | com.athena.framework.server.exception.biz.RuleExecuteException | com.athena.framework.server.exception.biz.RuleWorkingMemoryException | com.athena.framework.server.exception.biz.RuleDataException e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3005");
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
    }
}
