package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.ItemRepository;
import shop.app.shared.retail.Item;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ItemTestCase {

    @Autowired
    private ItemRepository<Item> itemRepository;

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
            Item item = new Item();
            item.setBrand("4mO8s6yK5Cy3xow8q3OPsFkX8o4V0ESBHp2UOugSNYfSq5Ynls");
            item.setCategory("5KlpXTFdhwZLJu22fZt3UuC50x3ZvQl8S5i89yrSrpnbTzqg0U");
            item.setItem("SBaGJNXctWYo9RLKOpSJthjhg4cEfsEvVNy3KipCfIs1EKLo08");
            item.setItemIcon("iWH");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            item.setProduct("pIkjlYmWah6V28tj2Re09GpGC6r3zqNbxjro2745KBe8a58UWA");
            item.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            item.setEntityValidator(entityValidator);
            item.isValid();
            itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            Item item = itemRepository.findById((java.lang.String) map.get("ItemPrimaryKey"));
            item.setBrand("0zc5BEQNlGwcAt88RUK8Id47ZbBkBoGU1NVM5w9kSQRpkNt98a");
            item.setCategory("0euChG5bVLqiVJMbAu5WFmNPWfBjgqPX9v758wOFW6BAi9M18F");
            item.setItem("0i1alCROzvgOlWyliXzMXR1NQgbGPeUaySscdxj5pn6mBGFt2c");
            item.setItemIcon("K53");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            item.setProduct("lYTQHjciEQbBy1HjJW5bH5rrKfZwYNPhEtTnU7Qy4LqZQxHoSs");
            item.setVersionId(1);
            item.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            itemRepository.update(item);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            itemRepository.findById((java.lang.String) map.get("ItemPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ItemPrimaryKey"));
            itemRepository.delete((java.lang.String) map.get("ItemPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
