package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.CartRepository;
import shop.app.shared.retail.Cart;
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
import shop.app.shared.retail.Item;
import shop.app.server.repository.ItemRepository;
import shop.app.shared.authentication.User;
import shop.app.server.repository.UserRepository;
import shop.app.shared.authentication.UserAccessDomain;
import shop.app.server.repository.UserAccessDomainRepository;
import shop.app.shared.authentication.UserAccessLevel;
import shop.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CartTestCase {

    @Autowired
    private CartRepository<Cart> cartRepository;

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
            item.setBrand("t8S555Em8t3a2G6NhW2sOHEYiMPdk0qkvNHXD8Op3tnsIiYnd1");
            item.setCategory("pZvn0F9HHu703lXyT2vm9gVl285REcuZW0ikshSqbIxMTGdWEN");
            item.setItem("k4zdamJaShWzbw1AtWB1n7R72Yfog35ZviQHV1gUFyXr3tLCqz");
            item.setItemIcon("sNW");
            item.setItemPrice(12.34);
            item.setItemStock(2147483647);
            item.setProduct("V0pDIhdjugJcTpDnXOE2RO2yT1wIw2w5oW3Ks9JtXreRn2PHTh");
            Item ItemTest = itemRepository.save(item);
            map.put("ItemPrimaryKey", item._getPrimarykey());
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("mzPnOhv6H11yDkFfp1UwVR7T78frUBydTc29UhOkj7pq2nnHtd");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1509);
            user.setUserAccessCode(10);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("1FTypXFgPZhDzmh95HyHZFJjdCBezqoxHXlkeCFztE2uHSWsUY");
            useraccessdomain.setDomainHelp("gjHrtsByAv8tTtC3I6YoXHXvLhgVKS6ldyh9lyBG1q1k2egPfs");
            useraccessdomain.setDomainIcon("FljGGhP9gmGSrlykjPnQnNJvM0tjFYDtxXprD4fzNBZcos8y2r");
            useraccessdomain.setDomainName("92NHDrvBasOpc5jyXyGggTVhreBa4WnS7t2R18yJLVa0jkcBpP");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("K67yXKI6lHv2mAjvpja0I2YqjgWEshbP1Bf8wnKt5BuoTNPOqI");
            useraccesslevel.setLevelHelp("jPV3N5sszp5iYy7VHvOeJKB0mMaUCAIhjBhq6AUixoG5rR6Ham");
            useraccesslevel.setLevelIcon("6BvvAcETi3FlkwYAOHv8zPUt5jcgkiZLWt4y8ftnMuq6wj5lzl");
            useraccesslevel.setLevelName("CanYmWoXYEtNADegzSJHbeokaHpsS4LiJqnNM1SlhCwJNRxcbB");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("HXpzeM4b3HiMD5NQN9lEjoeZz3zCaV5gH6IQTBmBjWqfLlURKc");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2518);
            user.setUserAccessCode(3);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            User UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
            Cart cart = new Cart();
            cart.setItemId((java.lang.String) ItemTest._getPrimarykey()); /* ******Adding refrenced table data */
            cart.setItemSubTotal(12.34);
            cart.setItemUnitPrice(12.34);
            cart.setQuantity(2147483647);
            cart.setUserId((java.lang.String) UserTest._getPrimarykey());
            cart.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            cart.setEntityValidator(entityValidator);
            cart.isValid();
            cartRepository.save(cart);
            map.put("CartPrimaryKey", cart._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ItemRepository<Item> itemRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            Cart cart = cartRepository.findById((java.lang.String) map.get("CartPrimaryKey"));
            cart.setItemSubTotal(12.34);
            cart.setItemUnitPrice(12.34);
            cart.setQuantity(2147483647);
            cart.setVersionId(1);
            cart.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cartRepository.update(cart);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            cartRepository.findById((java.lang.String) map.get("CartPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByitemId() {
        try {
            java.util.List<Cart> listofitemId = cartRepository.findByItemId((java.lang.String) map.get("ItemPrimaryKey"));
            if (listofitemId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Cart> listofuserId = cartRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CartPrimaryKey"));
            cartRepository.delete((java.lang.String) map.get("CartPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            itemRepository.delete((java.lang.String) map.get("ItemPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
