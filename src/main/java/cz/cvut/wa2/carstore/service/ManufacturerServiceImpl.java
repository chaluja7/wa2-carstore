package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernateManufacturerDao;
import cz.cvut.wa2.carstore.entities.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    protected HibernateManufacturerDao hibernateManufacturerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Manufacturer findManufacturer(long id) {
        return hibernateManufacturerDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Manufacturer findManufacturerWithCarsAndSuppliers(long id) {
        return hibernateManufacturerDao.findManufacturerWithCarsAndSuppliers(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Manufacturer> findManufacturersWithSuppliers() {
        return hibernateManufacturerDao.findManufacturersWithSuppliers();
    }

    @Override
    @Transactional
    public void persistManufacturer(Manufacturer manufacturer) {
        hibernateManufacturerDao.persist(manufacturer);
    }

    @Override
    @Transactional
    public void mergeManufacturer(Manufacturer manufacturer) {
        hibernateManufacturerDao.merge(manufacturer);
    }

    @Override
    @Transactional
    public void deleteManufacturer(long id) {
        hibernateManufacturerDao.delete(id);
    }

}
