package shop.app.server.businessservice;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.app.server.repository.OrderMainRepository;
import shop.app.shared.retail.OrderMain;
import java.util.List;

@Component
public class OrderMainBusinessService {

    @Autowired
    private OrderMainRepository orderMainRepository;

    public void update(OrderMain entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                orderMainRepository.delete(entity.getOrderId());
            } else {
                orderMainRepository.deleteOrderDetail(entity.getDeletedOrderDetailList());
                orderMainRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<OrderMain> entity) throws SpartanPersistenceException {
        try {
            for (OrderMain _ordermain : entity) {
                if (_ordermain.isHardDelete()) {
                    orderMainRepository.delete(_ordermain.getOrderId());
                } else {
                    orderMainRepository.deleteOrderDetail(_ordermain.getDeletedOrderDetailList());
                    orderMainRepository.update(_ordermain);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
