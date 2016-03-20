package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernateSupplierDao;
import cz.cvut.wa2.carstore.entities.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    protected HibernateSupplierDao hibernateSupplierDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Supplier findSupplier(long id) {
        return hibernateSupplierDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Supplier findByIdWithManufacturersAndWarehouses(long id) {
        return hibernateSupplierDao.findSupplierWithManufacturersAndWarehouses(id);
    }

    @Override
    @Transactional
    public void persistSupplier(Supplier supplier) {
        hibernateSupplierDao.persist(supplier);
    }

    @Override
    @Transactional
    public void mergeSupplier(Supplier supplier) {
        hibernateSupplierDao.merge(supplier);
    }

    @Override
    @Transactional
    public void deleteSupplier(long id) {
        hibernateSupplierDao.delete(id);
    }

}
