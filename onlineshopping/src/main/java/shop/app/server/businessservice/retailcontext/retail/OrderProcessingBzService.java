package shop.app.server.businessservice.retailcontext.retail;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.ruleengine.server.bzservice.RuleEngineInterface;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.app.server.repository.CartRepository;
import shop.app.server.repository.OrderMainRepository;
import shop.app.shared.retail.Cart;
import shop.app.shared.retail.OrderMain;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class OrderProcessingBzService {

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private CartRepository<Cart> cartRepository;

    @Autowired
    private RuleEngineInterface ruleEngineInterface;

    @Autowired
    private OrderMainRepository<OrderMain> orderMainRepository;

    @Autowired
    private UpdateStockService updateStockService;

    public void orderProcessing() throws SpartanIncorrectDataException, Exception, SpartanBusinessValidationFailedException, SpartanPersistenceException, SpartanDataNotFoundException {
        try {
            java.lang.String userId = (java.lang.String) sessionService.getSessionData("userId");
            if (userId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
            }
            if (userId == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            java.util.List<shop.app.shared.retail.Cart> cart_2 = cartRepository.findByUserId(userId);
            shop.app.shared.retailcontext.acl.CartToOrderMap carttoordermap_3 = new shop.app.shared.retailcontext.acl.CartToOrderMap(cart_2);
            if (carttoordermap_3.cartToOrderMap() == null) {
                throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("invalid parameter");
            }
            shop.app.shared.retail.OrderMain ordermain_4 = orderMainRepository.save(carttoordermap_3.cartToOrderMap());
            sessionService.setSessionAttributeForString("OrderId", ordermain_4.getOrderId());
            ruleEngineInterface.initialize("25dd2d18-e1d9-47de-9699-78dd524be9a4");
            ruleEngineInterface.add(cart_2);
            ruleEngineInterface.add(carttoordermap_3);
            ruleEngineInterface.add(ordermain_4);
            ruleEngineInterface.add(runtimeLogInfoHelper);
            ruleEngineInterface.executeRule();
            orderMainRepository.update((shop.app.shared.retail.OrderMain) ruleEngineInterface.getResult("ordermain_4"));
            updateStockService.stockUpdate();
        } catch (com.athena.framework.server.exception.biz.RuleInitException | com.athena.framework.server.exception.biz.RuleExecuteException | com.athena.framework.server.exception.biz.RuleWorkingMemoryException | com.athena.framework.server.exception.biz.RuleDataException e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3005");
        } catch (Exception e) {
            e.printStackTrace();
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException(e.getCause().getMessage());
        }
    }
}
