package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Supplier;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface SupplierService {

    Supplier findSupplier(long id);

    Supplier findByIdWithManufacturersAndWarehouses(long id);

    void persistSupplier(Supplier supplier);

    void mergeSupplier(Supplier supplier);

    void deleteSupplier(long id);

}
