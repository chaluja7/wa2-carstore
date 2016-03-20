package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class PersonServiceTest extends AbstractServiceTest {

    @Autowired
    protected PersonService personService;

    @Autowired
    protected AddressService addressService;

    @Autowired
    protected PhoneService phoneService;

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected CarService carService;

    @Test
    public void testPerson() {
        Person person = getPerson();
        Phone phone1 = PhoneServiceTest.getPhone();
        Phone phone2 = PhoneServiceTest.getPhone();

        Address address = AddressServiceTest.getAddress();
        Order order = OrderServiceTest.getOrder();
        Car car = CarServiceTest.getCar();
        order.setCar(car);

        person.addPhone(phone1);
        person.addPhone(phone2);
        person.addAddress(address);
        person.addOrder(order);

        personService.persistPerson(person);
        Person retrievedPerson = personService.findPersonWithOrdersPhonesAndAddresses(person.getId());
        Assert.assertFalse(retrievedPerson.getAddresses().isEmpty());
        Assert.assertFalse(retrievedPerson.getOrders().isEmpty());
        Assert.assertFalse(retrievedPerson.getPhones().isEmpty());

        personService.deletePerson(person.getId());
        Assert.assertNull(phoneService.findPhone(phone1.getId()));
        Assert.assertNull(phoneService.findPhone(phone2.getId()));
        Assert.assertNull(addressService.findAddress(address.getId()));
        Assert.assertNull(orderService.findOrder(order.getId()));
    }

    public static Person getPerson() {
        Person person = new Person();
        person.setName("Jmeno");
        person.setSurname("Prijmeni");

        return person;
    }

}
