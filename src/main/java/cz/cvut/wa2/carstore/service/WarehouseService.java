package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Warehouse;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface WarehouseService {

    Warehouse findWarehouse(long id);

    Warehouse findWarehouseWithSupplier(long id);

    void persistWarehouse(Warehouse warehouse);

    void mergeWarehouse(Warehouse warehouse);

    void deleteWarehouse(long id);

}
