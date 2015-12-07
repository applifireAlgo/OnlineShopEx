package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.CoreContactsRepository;
import shop.app.shared.contacts.CoreContacts;
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
import shop.app.shared.contacts.Gender;
import shop.app.server.repository.GenderRepository;
import shop.app.shared.location.Language;
import shop.app.server.repository.LanguageRepository;
import shop.app.shared.location.Timezone;
import shop.app.server.repository.TimezoneRepository;
import shop.app.shared.contacts.Title;
import shop.app.server.repository.TitleRepository;
import shop.app.shared.location.Address;
import shop.app.server.repository.AddressRepository;
import shop.app.shared.location.AddressType;
import shop.app.server.repository.AddressTypeRepository;
import shop.app.shared.location.City;
import shop.app.server.repository.CityRepository;
import shop.app.shared.location.Country;
import shop.app.server.repository.CountryRepository;
import shop.app.shared.location.State;
import shop.app.server.repository.StateRepository;
import shop.app.shared.contacts.CommunicationData;
import shop.app.shared.contacts.CommunicationGroup;
import shop.app.server.repository.CommunicationGroupRepository;
import shop.app.shared.contacts.CommunicationType;
import shop.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("PsSFqeotnKdcAoPpcITDDeafXt5niuZwgovSPsX0euOEuDL3Vz");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("OG");
            language.setAlpha3("dSy");
            language.setAlpha4("L5hL");
            language.setAlpha4parentid(3);
            language.setLanguage("HfLOyNi6paAukD6bpzIbUVaaWMOJO7uNl6Jd5jcZDG4E0ymIY9");
            language.setLanguageDescription("v34iDXCL51S4jclpdPHDLQ5op7CagtAAvI6ZuzGr6GGrT5EOQh");
            language.setLanguageIcon("xOAaqhLprwcHTwENqCzqK1MemOBIBPkXmAa8z0ik1yRjuQY6sM");
            language.setLanguageType("zHLgq4KgCOypzpyQBtFCJjCJJxWEbTZb");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("cxnE31R203lRGBlsCFBhxX8Bvg4aQuSJr20phbGCzpjroAK0O1");
            timezone.setCountry("WpASD3BtzNSSIGIt2CHv39mtagAHuia9gvbwzEHpslbIWk2Fdj");
            timezone.setGmtLabel("XJXv81sNuoffq27Jc1oNBAR4jgJPPG7JqR44Vwm7f652kTrOqn");
            timezone.setTimeZoneLabel("KweQTK3WKFfD6HZrp7RAKpnYHJrx29YrvEHWSldjVUjqKP5dr7");
            timezone.setUtcdifference(4);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("CSqfEsxvlrQjnMe1u2cBUXVAzeaLk59tWnk0LJnByre7FI7BmM");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(119);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("9MhFQTmaaOI0ziNHy3voUd7T4iY47RvC91CjYgOweXijxtjs3L");
            corecontacts.setFirstName("cPiJ2KmrGlrcoqkearUf1Tx37d4F4FpO6Rozr2rjthEFasjF1v");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("23jviODVSvALW7q4Z22zuJzQ9xK8Wsc2chEC7V4drl74uRPo3o");
            corecontacts.setMiddleName("ui7bMorxA7E27fwzSdtrl0Kpx25P59iupMm0NsZIRQwgtae0m7");
            corecontacts.setNativeFirstName("u9kzmHDoOWrgNcgl31mB4Y3VGiFG71yAMIhf1WFD39oOlaan2b");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("bacgsKVQXUk3cgjVarpE8lf6Vn71zM3GLiEQvSrguQawl7D7Cm");
            corecontacts.setNativeMiddleName("3NLTEjrCqbzB31zK4fthCU2aSd50oZwBuc6VfwZv0fPKvZTiCo");
            corecontacts.setNativeTitle("eUz4wNHmlLvh1iDQj2f5ouJ7zMzSkBZPbf4EvQA0X9zLPIeMmB");
            corecontacts.setPhoneNumber("A6ieGSxfrMl9gs9wbScf");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("foMduHLQuYuPOfjuCkk1QjfMcvUy1dkVtCZLIBzLgOlF1roegJ");
            address.setAddress2("3k2rPeENIV50OxiZDSKFhC0fncsbvI40yVMwPSlN6FyF97qvey");
            address.setAddress3("5jlc0UjE0P4JWoyGObyaAJTbmOGnk5B3rCV8RUgU4Vmi5lN4XS");
            address.setAddressLabel("Up5aEjAbvIw");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("PiFDo1RGG9m5XN8vWFzbPlNz3wHct4Y89CIuT3vnftDlwON2n6");
            addresstype.setAddressTypeDesc("t9jbkPjCFahJPsV5lRS1xu9CD3Q2YJGTLCCBkLkKErNOIy0XvY");
            addresstype.setAddressTypeIcon("GZdfQiWNBalxf0rSYbktByD17UVUE9zDKw7tqbjJodvKoyWsIS");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("kYqSXDgsueJ5EzuPgAkJLDU6sQcPBI5G");
            city.setCityDescription("J720IkzPBVCQEZPXMDcKGY9zOsHsOZZ1tOcFj5TJs3JAevqZzg");
            city.setCityFlag("IrdBAWqNTng6XQON3z7uf3nWkOtQzoT7rbMT2qrjaTNBUR63hT");
            city.setCityLatitude(5);
            city.setCityLongitude(5);
            city.setCityName("TBTrslKwhEvdqXjOcUJYJ6kjEXKz9sIJajeOa1HKQMlnh1E9Hw");
            Country country = new Country();
            country.setCapital("5S87uKEQsPLW9inpMT2YLvWA2qF5gL6M");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(10);
            country.setCountryCode1("VDF");
            country.setCountryCode2("eWk");
            country.setCountryFlag("PRt4p7UGmPOQ5K961TklLMFMPsQprjjdoWxUp9K9diN6MYkg0B");
            country.setCountryName("SYsgf7oTKQJzHkn57y5S9yzdAXu5QVHGBnqe57XmDW6q2ls5OZ");
            country.setCurrencyCode("KD4");
            country.setCurrencyName("LsuDVLi2ezMhDRhmfnRcuukh8YoVIzHZ7IQgiTxqCw3vHRQMBW");
            country.setCurrencySymbol("DZrQeYgfjPlaXYiat3JZTSRmc0UMYXrU");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("KFcvY5D1GiIgWbIqU9AiMMZbez0stOTTXXJrgCxRX7Xu1dCdh4");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(10);
            state.setStateCode(1);
            state.setStateCodeChar2("mnva3KVPPtq8Q1yIohovbHDs4IbaxFDF");
            state.setStateCodeChar3("CNE9gZIHgv73x54TJuUvkLKjBZROfW0R");
            state.setStateDescription("CUQFBWnqEusagH5sniBSMy1Q72yNw9UvL6ZN7o88DhsBJCv88A");
            state.setStateFlag("Ny1wObYHvdDQ3VAYRO3t40qgZFZAKw2RYV8FKt3J5hklB0FjbR");
            state.setStateName("Z9Hz19b0FxUbvlJJpjLwxvIkrIKEQ8bXTVul4xbPrEzoMr9cst");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("kIVxJ5Fiew8bSSKX7exozKzVzPi3ZKNE");
            city.setCityDescription("gcbQptKq7FJCQe2X2Kf6zVsbO8xj4zHyYdL8bPOtPEulikzZLX");
            city.setCityFlag("BiRWqFptwq3GxBossTkTxXB60RapGBjaslfVMx0A7otG6ShM2J");
            city.setCityLatitude(4);
            city.setCityLongitude(1);
            city.setCityName("dlLgqienZzWtqM6h3Au3aMxMSrKvcJdL2dZB1DQxHuHbOqCA8s");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("9yJ7nH5RNp0HKOsCbBvIMJvDgnE8C5SGzWSwIHo0lQNOY26kD3");
            address.setAddress2("Bj3a2inlGYxZS94nQXzYKEbFhZaNdnJJm7ctrMufcQggT7YdtD");
            address.setAddress3("9zQvdOUNL0JMPxgL8WgowfKgaO4fR51djeCzJSELTWXfwaV6Br");
            address.setAddressLabel("nUtbQbJjas7");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("H9q6XUhdWREqfG9vfNdjW9rl5xJKPN83GZJl2sbTBlq10Br7mv");
            address.setLongitude("aQjIlMaRVtzMSxUi2iScn55WcgzAXcV9ZSFO6nlVuACzcy5xdf");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("9DZKbb");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Quq");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("mlvAL6d5yGt0LouItUMdM178jMxBBHq7vzbzQIwqQ7FYTXvuKS");
            communicationgroup.setCommGroupName("jVjlUReg8G7jOU8QYdMc1WTGkUmZdeIhMgkuRbw0eGAPLhc2sJ");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("qUJ0EqxRKW10ur698xKcchJ7mmo2P8VmMkrGV6GVEksqVvmYV9");
            communicationtype.setCommTypeName("wWQ9jOYcWo8tkOPeduDtDPNDz4LDBT54LXz3lO8SvFPkDErU93");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("Zxa");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(18);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("BiBcQHfDZfZHI3Vcmj6VteZf3yd3tPHP7dLXKblf5seXWGDV9Z");
            corecontacts.setFirstName("zEBlGQuhH719SoK1ejQRmJIxhK4RjUiJm0RAtQho1JWohtV6gC");
            corecontacts.setLastName("fbVPEgKD4UWOfkfrjBdaH4ymMdG0u03vdxzz4BikElsLI0Q4CQ");
            corecontacts.setMiddleName("yNwowtyhLTBPrJgboaQew0D7VrhKGMDiEdJzUyxQy8GrYmpklS");
            corecontacts.setNativeFirstName("qI4WWiKhSUOHzAcSBJYuafA6pv6Uk0dzyeP4iIsvfm909gvIgz");
            corecontacts.setNativeLastName("v4s6Sh1VOwaRtpKKFDfpzjqNcSup55qo6ksyIxhEu0pJ11ES8Q");
            corecontacts.setNativeMiddleName("u5DgERjgjAgeDHBtVn15zTriu0hrixNzwbNSsh4f3puCrFxWG2");
            corecontacts.setNativeTitle("pF0S4KBIF1K1xdg7BFMXtTTNIofP8NicAwSk7H9RDuGL5l2hOU");
            corecontacts.setPhoneNumber("3nHaZKfQazuJ1h3021bc");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
