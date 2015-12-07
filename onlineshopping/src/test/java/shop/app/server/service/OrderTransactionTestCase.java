package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.OrderTransactionRepository;
import shop.app.shared.defaultdomain.OrderTransaction;
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
import shop.app.shared.retail.OrderMain;
import shop.app.server.repository.OrderMainRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class OrderTransactionTestCase {

    @Autowired
    private OrderTransactionRepository<OrderTransaction> ordertransactionRepository;

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
            ordermain.setOrderBy("iFLUnnuPQgzTy13BevWF9V1lNFWSSWVqyz3ZqcmHIUaeKDaa7g");
            ordermain.setOrderDate(new java.sql.Date(123456789));
            ordermain.setTotal(12.34);
            OrderMain OrderMainTest = ordermainRepository.save(ordermain);
            map.put("OrderMainPrimaryKey", ordermain._getPrimarykey());
            OrderTransaction ordertransaction = new OrderTransaction();
            ordertransaction.setOrderId((java.lang.String) OrderMainTest._getPrimarykey());
            ordertransaction.setStatusMsg("dFSRwEo4PfBFcU3ZormeLIgD6MdN42GU70cvj4ls3GEBXq4FvX");
            ordertransaction.setTransactionId("fAybH2imp4fsgXd3DZC6pK02Pwixo2ymNpH09ZVvrqTQ5KiGnR");
            ordertransaction.setTransactionStatus("YodXjh55LwIVcrEL9uNOmMnvr3BagcSv9i4f7Wcpz9NsSvJcwL");
            ordertransaction.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            ordertransaction.setEntityValidator(entityValidator);
            ordertransaction.isValid();
            ordertransactionRepository.save(ordertransaction);
            map.put("OrderTransactionPrimaryKey", ordertransaction._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private OrderMainRepository<OrderMain> ordermainRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderTransactionPrimaryKey"));
            OrderTransaction ordertransaction = ordertransactionRepository.findById((java.lang.String) map.get("OrderTransactionPrimaryKey"));
            ordertransaction.setStatusMsg("kBFGPI3arw6dnvDHcmAlmMl4sDpxYvTsZuoChRUPwobWMdxrGl");
            ordertransaction.setTransactionId("RD5AXz7JpQ9lchxzGN1DWKe2l114L53JV47edeVHI9muLWS9RZ");
            ordertransaction.setTransactionStatus("1cntPyhlSAnYCMVx11ZtRvxqZm7nPTLNHYtSH9ihDDAMILPpZN");
            ordertransaction.setVersionId(1);
            ordertransaction.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            ordertransactionRepository.update(ordertransaction);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderTransactionPrimaryKey"));
            ordertransactionRepository.findById((java.lang.String) map.get("OrderTransactionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByorderId() {
        try {
            java.util.List<OrderTransaction> listoforderId = ordertransactionRepository.findByOrderId((java.lang.String) map.get("OrderMainPrimaryKey"));
            if (listoforderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("OrderTransactionPrimaryKey"));
            ordertransactionRepository.delete((java.lang.String) map.get("OrderTransactionPrimaryKey")); /* Deleting refrenced data */
            ordermainRepository.delete((java.lang.String) map.get("OrderMainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
