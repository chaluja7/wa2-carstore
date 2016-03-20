package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Supplier;
import cz.cvut.wa2.carstore.entities.Warehouse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class WarehouseServiceTest extends AbstractServiceTest {

    @Autowired
    protected WarehouseService warehouseService;

    @Autowired
    protected SupplierService supplierService;

    @Test
    public void testWarehouse() {
        Supplier supplier = SupplierServiceTest.getSupplier();
        Warehouse warehouse = getWarehouse();
        warehouse.setSupplier(supplier);

        warehouseService.persistWarehouse(warehouse);
        Warehouse retrievedWarehouse = warehouseService.findWarehouseWithSupplier(warehouse.getId());
        Assert.assertNotNull(retrievedWarehouse.getSupplier().getName());

        warehouseService.deleteWarehouse(warehouse.getId());
        Supplier retrievedSupplier = supplierService.findSupplier(retrievedWarehouse.getSupplier().getId());
        Assert.assertNotNull(retrievedSupplier);
    }

    public static Warehouse getWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(System.currentTimeMillis() + random.nextInt(999) + "WH");

        return warehouse;
    }

}
