package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Person;
import cz.cvut.wa2.carstore.entities.Phone;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class PhoneServiceTest extends AbstractServiceTest {

    @Autowired
    protected PhoneService phoneService;

    @Autowired
    protected PersonService personService;

    @Test
    public void testPhone() {
        Phone phone = getPhone();
        Person person = PersonServiceTest.getPerson();
        phone.setPerson(person);

        phoneService.persistPhone(phone);
        Phone retrievedPhone = phoneService.findPhoneWithPerson(phone.getId());
        Assert.assertNotNull(retrievedPhone.getPerson().getName());

        phoneService.deletePhone(phone.getId());
        Person retrievedPerson = personService.findPerson(retrievedPhone.getPerson().getId());
        Assert.assertNotNull(retrievedPerson);
    }

    public static Phone getPhone() {
        Phone phone = new Phone();
        phone.setNote("private");
        phone.setPhoneNumber(System.currentTimeMillis() + random.nextInt(999) + "PH");

        return phone;
    }

}
