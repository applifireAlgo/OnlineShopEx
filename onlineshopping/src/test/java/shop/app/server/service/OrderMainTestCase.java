package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.OrderMainRepository;
import shop.app.shared.retail.OrderMain;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import shop.app.shared.retail.OrderDetail;
import shop.app.shared.retail.Item;
import shop.app.server.repository.ItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class OrderMainTestCase {

    @Autowired
    private OrderMainRepository<OrderMain> ordermainRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            OrderMain ordermain = new OrderMain();
            ordermain.setOrderBy("FQ4IZZAJEDUMjzJnLewQA66l7kl5JkZQjiI8VVxdegZUNbRicW");
            ordermain.setOrderDate(new java.sql.Date(123456789));
            ordermain.setTotal(12.34);
            java.util.List<OrderDetail> listOfOrderDetail = new java.util.ArrayList<OrderDetail>();
            OrderDetail orderdetail = new OrderDetail();
            Item item = new Item();
            item.setBrand("1P562aud0iO71CgMCzTV6C8LQepgYGZxLsa50VTjrRjiDUwhbm");
            item.setCategory("6Pg4fuT5muJrUO8q32x3ypL294aIbhO5hdsd0qqfEb1GLzFon0");
            item.setItem("mcDrRLPE6xnRJRDA1wZ4uvHVFfwVaAOV38bURjgQ0QscSR58h1");
            item.setItemIcon("FeG");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            item.setProduct("A0HmawUXVPeWf2Vuo9J4EiIOxyoKo0tmq7dxujxEWvxlBPRpMr");
            Item ItemTest = itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
            orderdetail.setItemId((java.lang.String) ItemTest._getPrimarykey());
            orderdetail.setOrderMain(ordermain);
            orderdetail.setQuantity(80275044);
            orderdetail.setSubTotal(12.34);
            orderdetail.setUnitPrice(12.34);
            listOfOrderDetail.add(orderdetail);
            ordermain.addAllOrderDetail(listOfOrderDetail);
            ordermain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            ordermain.setEntityValidator(entityValidator);
            ordermain.isValid();
            ordermainRepository.save(ordermain);
            map.put("OrderMainPrimaryKey", ordermain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            OrderMain ordermain = ordermainRepository.findById((java.lang.String) map.get("OrderMainPrimaryKey"));
            ordermain.setOrderBy("DMBJkuE6xQ8VlCWq0VZkFYlJqdBS9kyXBfbchVrgEtnWWnfGjM");
            ordermain.setOrderDate(new java.sql.Date(123456789));
            ordermain.setTotal(12.34);
            ordermain.setVersionId(1);
            ordermain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            ordermainRepository.update(ordermain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            ordermainRepository.findById((java.lang.String) map.get("OrderMainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderMainPrimaryKey"));
            ordermainRepository.delete((java.lang.String) map.get("OrderMainPrimaryKey")); /* Deleting refrenced data */
            itemRepository.delete((java.lang.String) map.get("ItemPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
