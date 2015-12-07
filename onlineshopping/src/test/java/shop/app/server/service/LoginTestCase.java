package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.LoginRepository;
import shop.app.shared.authentication.Login;
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
import shop.app.shared.contacts.CoreContacts;
import shop.app.server.repository.CoreContactsRepository;
import shop.app.shared.contacts.Gender;
import shop.app.server.repository.GenderRepository;
import shop.app.shared.location.Language;
import shop.app.server.repository.LanguageRepository;
import shop.app.shared.location.Timezone;
import shop.app.server.repository.TimezoneRepository;
import shop.app.shared.contacts.Title;
import shop.app.server.repository.TitleRepository;
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
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(1);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("2peSVkQUJ1AfTN3lUXg2QXNLd4D4cDamVxZOFi4z7wfhEWwBkM");
            corecontacts.setFirstName("bDT2rQzjpJE9uARotRzjcgc6gZICS3ztOVi6NlJ1hmZhtJ3rm7");
            Gender gender = new Gender();
            gender.setGender("0nTBX7qOkbAs9bJUljK1vVYHO2e3h2KOEz4bVVfbsb4oZBJvmk");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("g8");
            language.setAlpha3("WHz");
            language.setAlpha4("tguh");
            language.setAlpha4parentid(8);
            language.setLanguage("az0FtOHO6vibAmEHte1Kg0BXjCdMwlwtnn6ZO1hMdRE9ZeKOI8");
            language.setLanguageDescription("zKfzqtpeHNJ6hEOmhK23Vc9hNHciCEU6GryRt2Cxfx412EVRim");
            language.setLanguageIcon("Kk1FLXd2RNn2Dp3rrfNKhtxRzwmIeKTdzHmSw9Yu8H0dyjnMIm");
            language.setLanguageType("EVo8mKpq5dLma2dlnzFZhpCyA9BoosX8");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("wASudi6gSstBrhM5v96Jespq61gVdefGb1JnSwJiPVcBUAtuYA");
            timezone.setCountry("BmDHCJao87VXH2iiQCbQcGdkExGZLTtegsDsZtoajaifjLIMej");
            timezone.setGmtLabel("wXsOTLqF3c8GRXIxgRBpjTbXAtCeoNrDYnjTTen2BotfH9MZrG");
            timezone.setTimeZoneLabel("sK2H2hrp30tB5CVZMIZF0kQGbXYIswHm3MirtvjyircQZua8f6");
            timezone.setUtcdifference(1);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("OISXsh87zGayC5LCZTTIqwHWaOyEVuSWVmU6Xk5VIAhasA8WaV");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(16);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("cFhlKLrQhdtdF1y63YVVcU6I79aHk3VVQw1qfkLEph2VVW7U2w");
            corecontacts.setFirstName("iRzqdD9pIzbSAPzdoaWFDXVEivahpkFLz7GAWP3fRg83JWmyX8");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("JN0EUktQnUO0BnK03K4In1ZkuhWVr4PZcFcIo1UpjX4AoK99e4");
            corecontacts.setMiddleName("U3RYmZW8qRss6fLn5cFlIckKVZajedqpxQyyBTKB2frVLRfzZe");
            corecontacts.setNativeFirstName("TRVVguRwxIj5YalNBYOnwSlIyZJUNrdX3N0Hzizn6UhBWELLf0");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("CfV1THr5bZEu1n29kfFH1mOfxuLgwm6cQAjAczhwsFIIEuJqZf");
            corecontacts.setNativeMiddleName("vf2T81V37UEbJjB4Ss9yuXgaxfHkbu3B2YgK9qtqI623IuIBS5");
            corecontacts.setNativeTitle("0m2XNTpDQ3usZUsj8iTToPl7Q8aIX7EF0kc3KdPzGZAU2TkRqb");
            corecontacts.setPhoneNumber("vpXyPK18518o3wcyOVUS");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("6jFZU6vLdNdCN2CLuU0pLwjjcFswv9n2HU072wi2iYxMI2yMix");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1941);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("qLSuKpsGxQ8Svey7erPA6sg7OPsZjXeZ7ysvI33OLQ4g9qj1f5");
            useraccessdomain.setDomainHelp("2FeaaMzGxeOMgBm2SkHUwL0Y4CB9QvZ86DuWVotKthRNk14XVD");
            useraccessdomain.setDomainIcon("KhEiQfc5UYGi35p8q9hihdA0Njzb3RNmbZfEYNfFTwOFikzsJB");
            useraccessdomain.setDomainName("4Mc0I3vtIvcRD5da38mwBWUhP6TAp2HAtbtJ3sdafZ4B7xcXna");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("eoshFMZQPQyYJlySFUrYzdIBznvHJx41BfF4aoymLO8QxIUBDU");
            useraccesslevel.setLevelHelp("eTD8pOZpkCjBiSPkk7dN4IKcb73gmCsdDtZWhafbvGaIqrOxIc");
            useraccesslevel.setLevelIcon("KvXb9VZ353oUIwIFXYLhekgvWQxCDEsmFJX8mFbmnRD5MCXpNf");
            useraccesslevel.setLevelName("SilMJ3x2pmhXUr2BvIiIQIDGDvGclxS8d4JHxk1c6F7A8zt07n");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("KO1QEE9DFCpEG7osBRlPwyZPivpqteTSJZfeOtlgqezuz1W4PV");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1262);
            user.setUserAccessCode(7);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(0);
            login.setIsAuthenticated(true);
            login.setLoginId("iHWjHkPqiaGypO7DOd5lgkWIhKpMHbfV0vlHJZVGRQrWiorfB0");
            login.setServerAuthImage("AfOcLNegMUMqLFSwhe9piMKV2ghnKQoD");
            login.setServerAuthText("sBBoOMrRm196SBg2");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(11);
            login.setLoginId("GY26TrgSjLqw1JUhXrCziINvQtIBpXy4p3R4rirEPfe801HA66");
            login.setServerAuthImage("riSy3Wg3NnoL9w5PIQNA3tB3JnwtKaK6");
            login.setServerAuthText("i1h8wUomY5rrYr7X");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
