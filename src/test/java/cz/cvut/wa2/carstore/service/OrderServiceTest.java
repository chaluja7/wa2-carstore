package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Address;
import cz.cvut.wa2.carstore.entities.Car;
import cz.cvut.wa2.carstore.entities.Order;
import cz.cvut.wa2.carstore.entities.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class OrderServiceTest extends AbstractServiceTest {

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected PersonService personService;

    @Autowired
    protected CarService carService;

    @Test
    public void testOrder() {
        Order order = getOrder();
        Person person = PersonServiceTest.getPerson();
        Car car = CarServiceTest.getCar();
        order.setCar(car);
        order.setPerson(person);

        orderService.persistOrder(order);
        Order retrievedOrder = orderService.findOrderWithPersonAndCar(order.getId());
        Assert.assertNotNull(retrievedOrder.getCar().getName());
        Assert.assertNotNull(retrievedOrder.getPerson().getName());

        orderService.deleteOrder(order.getId());
        Person retrievedPerson = personService.findPerson(person.getId());
        Assert.assertNotNull(retrievedPerson);

        Car retrievedCar = carService.findCar(car.getId());
        Assert.assertNotNull(retrievedCar);
    }

    public static Order getOrder() {
        Order order = new Order();
        order.setDateFrom(new Date());
        order.setDateTo(new Date());

        return order;
    }

    @Test
    //INSERT pres 3 urovne
    public void testCascadePersist() {
        Order order = getOrder();
        Car car = CarServiceTest.getCar();
        Person person = PersonServiceTest.getPerson();

        Address address1 = AddressServiceTest.getAddress();
        Address address2 = AddressServiceTest.getAddress();

        person.addAddress(address1);
        person.addAddress(address2);

        order.setPerson(person);
        order.setCar(car);
        orderService.persistOrder(order);
    }

}
