package shop.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import shop.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import shop.app.server.repository.AddressRepository;
import shop.app.shared.location.Address;
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
import shop.app.shared.location.AddressType;
import shop.app.server.repository.AddressTypeRepository;
import shop.app.shared.location.City;
import shop.app.server.repository.CityRepository;
import shop.app.shared.location.Country;
import shop.app.server.repository.CountryRepository;
import shop.app.shared.location.State;
import shop.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("pxtRpA8A9JKdl5jgxGzYRq4cMTNMvcAvgOzsYz2v2s4lgc6bjb");
            addresstype.setAddressTypeDesc("2dVGvPsQQJU6YobBcAGPtGVwLam6laWbyIvOeT8u9Gmh7T4ki6");
            addresstype.setAddressTypeIcon("UoCDc13SupilqlAUCyeyz6jLBezgnkIKR35ty5CwTHhGzG5g7D");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("n1rpXaG77Zy9hp6iMJuPApwwCQY69WIT");
            city.setCityDescription("JFZqTnZHPpTca6p7HOGENGGdnhG4Ll7YNYNN2koL3eMCvzSEL0");
            city.setCityFlag("PiMbqunB9BA0BKR2INs5UDTorfgLE7xnRpRD69Voo8qho9OZ0N");
            city.setCityLatitude(8);
            city.setCityLongitude(8);
            city.setCityName("UlsXLI06lF2IPHYI9xvn2L44VPxOJ1zNR7ja9Ce0S6NiNpPbnX");
            Country country = new Country();
            country.setCapital("EFnYpRWHZszbxc0Iha1kuJidMJVlICPC");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(1);
            country.setCountryCode1("96f");
            country.setCountryCode2("uJX");
            country.setCountryFlag("03Bw0POof5ePuQyEvbIB7Xn2j1GZVQNHCs9M5NrRqGJig8NbvL");
            country.setCountryName("Z9stGx6aTXf8WDND3gdwun9i9vaBQvERQ2IVMn8LaEEPSpr8W1");
            country.setCurrencyCode("Lr1");
            country.setCurrencyName("SfY3yZDx6IjUg06nNw6Tr41LFo21UPqlB0FUE6bswGOh8qA1rN");
            country.setCurrencySymbol("IEBY8G1H6voFgHirJ24AhJguUeBr1GHd");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("Q6crsdoEEI9QThxYhdbb8PkPa5aG3thJGMHifQMoPCUKZpL7oW");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(2);
            state.setStateCode(2);
            state.setStateCodeChar2("0kAJ03xskMk3LwB9TuQW7tpQMdWa46Pn");
            state.setStateCodeChar3("NXy35Ry2BIGoeO8F3AFzCIOtTXeIealf");
            state.setStateDescription("thm0xDVELvjSB2wcVf7O7dzXMFkulB0PTSFS69FL9SyISK04bC");
            state.setStateFlag("BuswtgkxWewajp7NmFLDhf8D7lc6XaskkcajGyaXsSTITUHlYw");
            state.setStateName("ins232MpAr3hipBXZqqpMo7lqPte43vsnR5QD84oNJZuN8KyBd");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("j1zStEg1UpsRCUUSAhxExmJMgdgmo9xs");
            city.setCityDescription("8bDNMIovm8lopEaD02hJYdBlVv2PE9CzXikDDF3qZFWqnmOogg");
            city.setCityFlag("Xl648j0SV2n7Zx0CveO08F2uCEQutxaPx09QFxE4EBBiKiPzQo");
            city.setCityLatitude(6);
            city.setCityLongitude(1);
            city.setCityName("pmT5UytvMwWcdsnI3LDDgE0ciNhOdWPAl6Su6nlyLFDWXv0CkA");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("jecWe4tc1Ndhe8viZnD9KhvXVCLWavxR4nsZPzrRL3AfTBeIlz");
            address.setAddress2("vnlvTBd6MqCMvDNwEmbTloffYSoubFjySpzfuBpikGetjk4hik");
            address.setAddress3("BzP40bXU9C8l9kuR9LW1LIIKBpaMiUNY6fCg55PzJst22u69P0");
            address.setAddressLabel("MslAOyHXtvB");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("7hat4IWzQsgqUp2f9lEDeUddniN1qRzMWBudhnrMuyX1RHuZtB");
            address.setLongitude("V7eaozFfpLDqHRSaDJH8H0iHVNepOZtHBFJdahNbM2NWb4h9Nc");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("eICDNc");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("yHrpnUQvofZ9CvNKx3PHKsdS6l4fhfO540n1333CNQs6inHZC8");
            address.setAddress2("YN0gS1FXF6hc4Pb5YqlA8jDvXnk3cfMrIS7UjaP5iRqkfi7BNX");
            address.setAddress3("yeu8EhcHNIHFIX0iUThmnPzs63kcu31m4PZzpvgbbS4dvMMTz9");
            address.setAddressLabel("uUfBMerHP6s");
            address.setLatitude("AtBv87tRwiy0CXdPUbOyiUfeunTh1AlNG4YH7yrYhFrFM7VAKP");
            address.setLongitude("B9X4j38cY5rXKHWIiaZK0PHWqMK2ZKhTQ1c8SekwA34G7TrKEh");
            address.setVersionId(1);
            address.setZipcode("KYgFtb");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
