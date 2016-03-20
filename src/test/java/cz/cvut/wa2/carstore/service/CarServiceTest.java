package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class CarServiceTest extends AbstractServiceTest {

    @Autowired
    protected CarService carService;

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected ManufacturerService manufacturerService;

    @Autowired
    protected SupplierService supplierService;

    @Test
    public void testCar() {
        Car car = getCar();
        Manufacturer manufacturer = ManufacturerServiceTest.getManufacturer();
        Order order = OrderServiceTest.getOrder();
        Person person = PersonServiceTest.getPerson();
        order.setPerson(person);

        car.setManufacturer(manufacturer);
        car.addOrder(order);

        carService.persistCar(car);
        Car retrievedCar = carService.findCarWithManufacturerAndOrders(car.getId());
        Assert.assertNotNull(retrievedCar.getManufacturer().getName());
        Assert.assertFalse(retrievedCar.getOrders().isEmpty());

        carService.deleteCar(car.getId());
        Manufacturer retrievedManufacturer = manufacturerService.findManufacturer(manufacturer.getId());
        Assert.assertNotNull(retrievedManufacturer);

        Order retrievedOrder = orderService.findOrder(order.getId());
        Assert.assertNull(retrievedOrder);
    }

    @Test
    //SELECT pres 3 urovne
    public void testFindByName() {
        Car carByName = carService.findCarByName("VW Passat");
        Assert.assertNotNull(carByName);

        Manufacturer manufacturer = carByName.getManufacturer();
        Assert.assertNotNull(manufacturer);

        Set<Supplier> suppliers = manufacturer.getSuppliers();
        Assert.assertFalse(suppliers.isEmpty());

        for(Supplier supplier : suppliers) {
           Assert.assertFalse(supplier.getWarehouses().isEmpty());
        }
    }

    @Test
    //INSERT pres 3 urovne
    public void testCascadeMergeCar() {
        Car car = getCar();

        Manufacturer manufacturer = ManufacturerServiceTest.getManufacturer();
        Supplier supplier1 = SupplierServiceTest.getSupplier();
        Supplier supplier2 = SupplierServiceTest.getSupplier();
        Supplier supplier3 = supplierService.findSupplier(1);

        manufacturer.addSupplier(supplier1);
        manufacturer.addSupplier(supplier2);
        manufacturer.addSupplier(supplier3);

        car.setManufacturer(manufacturer);

        carService.mergeCar(car);
    }

    @Test
    //INSERT pres 4 urovne
    public void testCascadeInsertCar() {
        Car car = getCar();

        Manufacturer manufacturer = ManufacturerServiceTest.getManufacturer();
        Supplier supplier1 = SupplierServiceTest.getSupplier();
        Supplier supplier2 = SupplierServiceTest.getSupplier();

        Warehouse warehouse1 = WarehouseServiceTest.getWarehouse();
        Warehouse warehouse2 = WarehouseServiceTest.getWarehouse();
        Warehouse warehouse3 = WarehouseServiceTest.getWarehouse();

        supplier1.addWarehouse(warehouse1);
        supplier1.addWarehouse(warehouse2);
        supplier2.addWarehouse(warehouse3);

        manufacturer.addSupplier(supplier1);
        manufacturer.addSupplier(supplier2);

        car.setManufacturer(manufacturer);
        carService.persistCar(car);
    }

    @Test
    //UPDATE pres 4 urovne
    public void testCascadeUpdateCar() {
        //car ma vsechny kolekce od manufacturera dale
        Car car = carService.findCarByName("VW Passat");

        Manufacturer manufacturer = car.getManufacturer();
        manufacturer.setName("ZMENENY MANUFACTURER");

        Set<Supplier> suppliers = manufacturer.getSuppliers();
        for(Supplier supplier : suppliers) {

            if(supplier.getName().equals("Supplier 1")) {
                supplier.setName("ZMENENY SUPPLIER");

                Set<Warehouse> warehouses = supplier.getWarehouses();
                for(Warehouse warehouse : warehouses) {
                    warehouse.setName(warehouse.getName() + "Z");
                }
            }
        }

        Supplier newSupplier = SupplierServiceTest.getSupplier();
        suppliers.add(newSupplier);

        carService.mergeCar(car);
    }

    public static Car getCar() {
        Car car = new Car();
        car.setName(System.currentTimeMillis() + random.nextInt(999) + "CA");

        return car;
    }

}
