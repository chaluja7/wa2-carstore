package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Manufacturer;
import cz.cvut.wa2.carstore.entities.Supplier;
import cz.cvut.wa2.carstore.entities.Warehouse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class SupplierServiceTest extends AbstractServiceTest {

    @Autowired
    protected SupplierService supplierService;

    @Autowired
    protected WarehouseService warehouseService;

    @Autowired
    protected ManufacturerService manufacturerService;

    @Test
    public void testSupplier() {
        Supplier supplier = getSupplier();
        Manufacturer manufacturer1 = ManufacturerServiceTest.getManufacturer();
        Manufacturer manufacturer2 = ManufacturerServiceTest.getManufacturer();
        Warehouse warehouse1 = WarehouseServiceTest.getWarehouse();
        Warehouse warehouse2 = WarehouseServiceTest.getWarehouse();

        supplier.addWarehouse(warehouse1);
        supplier.addWarehouse(warehouse2);
        supplier.addManufacturer(manufacturer1);
        supplier.addManufacturer(manufacturer2);

        supplierService.persistSupplier(supplier);
        Supplier retrievedSupplier = supplierService.findByIdWithManufacturersAndWarehouses(supplier.getId());
        Assert.assertFalse(retrievedSupplier.getManufacturers().isEmpty());
        Assert.assertFalse(retrievedSupplier.getWarehouses().isEmpty());

        supplierService.deleteSupplier(supplier.getId());
        Assert.assertNull(warehouseService.findWarehouse(warehouse1.getId()));
        Assert.assertNull(warehouseService.findWarehouse(warehouse2.getId()));
        Assert.assertNotNull(manufacturerService.findManufacturer(manufacturer1.getId()));
        Assert.assertNotNull(manufacturerService.findManufacturer(manufacturer2.getId()));
    }

    public static Supplier getSupplier() {
        Supplier supplier = new Supplier();
        supplier.setName(System.currentTimeMillis() + random.nextInt(999) + "SU");

        return supplier;
    }

}
