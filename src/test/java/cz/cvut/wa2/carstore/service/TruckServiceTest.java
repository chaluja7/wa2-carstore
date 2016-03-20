package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class TruckServiceTest extends AbstractServiceTest {

    @Autowired
    protected TruckService truckService;

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected ManufacturerService manufacturerService;

    @Test
    public void testTruck() {
        Truck truck = getTruck();
        Manufacturer manufacturer = ManufacturerServiceTest.getManufacturer();
        Order order = OrderServiceTest.getOrder();
        Person person = PersonServiceTest.getPerson();
        order.setPerson(person);

        truck.setManufacturer(manufacturer);
        truck.addOrder(order);

        truckService.persistTruck(truck);
        Truck retrievedTruck = truckService.findTruckWithManufacturerAndOrders(truck.getId());
        Assert.assertNotNull(retrievedTruck.getManufacturer().getName());
        Assert.assertFalse(retrievedTruck.getOrders().isEmpty());

        truckService.deleteTruck(truck.getId());
        Manufacturer retrievedManufacturer = manufacturerService.findManufacturer(manufacturer.getId());
        Assert.assertNotNull(retrievedManufacturer);

        Order retrievedOrder = orderService.findOrder(order.getId());
        Assert.assertNull(retrievedOrder);
    }


    public static Truck getTruck() {
        Truck truck = new Truck();
        truck.setName(System.currentTimeMillis() + random.nextInt(999) + "CA");
        truck.setWeight(100.0);

        return truck;
    }

}
