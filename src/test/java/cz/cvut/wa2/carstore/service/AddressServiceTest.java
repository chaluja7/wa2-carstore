package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class AddressServiceTest extends AbstractServiceTest {

    @Autowired
    protected AddressService addressService;

    @Autowired
    protected PersonService personService;

    @Autowired
    protected SupplierService supplierService;

    @Test
    public void testAddress() {
        Address address = getAddress();
        Person person = PersonServiceTest.getPerson();
        address.setPerson(person);

        addressService.persistAddress(address);

        Address retrievedAddress = addressService.findAddressWithPerson(address.getId());

        Assert.assertNotNull(retrievedAddress.getPerson().getName());

        addressService.deleteAddress(address.getId());

        Person retrievedPerson = personService.findPerson(retrievedAddress.getPerson().getId());
        Assert.assertNotNull(retrievedPerson);
    }

    @Test
    @Ignore
    //SELECT pres 6 urovni
    public void testFindByCity() {
        List<Address> addresses = addressService.findAddressesByCity("Praha");
        Assert.assertFalse(addresses.isEmpty());

        for(Address address : addresses) {
            Person person = address.getPerson();
            Assert.assertNotNull(person);

            Set<Order> orders = person.getOrders();
            Assert.assertFalse(orders.isEmpty());

            for(Order order : orders) {
                Car car = order.getCar();
                Assert.assertNotNull(car);

                Manufacturer manufacturer = car.getManufacturer();
                Assert.assertNotNull(manufacturer);

                Set<Supplier> suppliers = manufacturer.getSuppliers();
                Assert.assertFalse(suppliers.isEmpty());

                for(Supplier supplier : suppliers) {
                    Set<Warehouse> warehouses = supplier.getWarehouses();
                    Assert.assertFalse(warehouses.isEmpty());

                    for(Warehouse warehouse : warehouses) {
                        Assert.assertNotNull(warehouse.getName());
                    }
                }
            }
        }
    }

    @Test
    //UPDATE pres 5 urovni
    public void testCascadeUpdateAddress() {
        List<Address> addresses = addressService.findAddressesByCity("Praha");
        Address address = addresses.get(0);

        Person person = address.getPerson();
        person.setSurname("CHANGE!");
        Set<Order> orders = person.getOrders();
        for(Order order : orders) {
            if(order.getId().equals(1L)) {
                Car car = order.getCar();
                Manufacturer manufacturer = car.getManufacturer();
                manufacturer.setName("CHANGE!");

                Set<Supplier> suppliers = manufacturer.getSuppliers();
                suppliers.add(SupplierServiceTest.getSupplier());
            }
        }

        address.setNote("CHANGE!");
        addressService.mergeAddress(address);
    }

    public static Address getAddress() {
        Address address = new Address();
        address.setCity("Praha");
        address.setStreet("Pricna");
        address.setNumber("999");
        address.setNote(System.currentTimeMillis() + random.nextInt(999) + "NO");

        return address;
    }

}
