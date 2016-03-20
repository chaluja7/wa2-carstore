package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernateWarehouseDao;
import cz.cvut.wa2.carstore.entities.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    protected HibernateWarehouseDao hibernateWarehouseDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Warehouse findWarehouse(long id) {
        return hibernateWarehouseDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Warehouse findWarehouseWithSupplier(long id) {
        return hibernateWarehouseDao.findWarehouseWithSupplier(id);
    }

    @Override
    @Transactional
    public void persistWarehouse(Warehouse warehouse) {
        hibernateWarehouseDao.persist(warehouse);
    }

    @Override
    @Transactional
    public void mergeWarehouse(Warehouse warehouse) {
        hibernateWarehouseDao.merge(warehouse);
    }

    @Override
    @Transactional
    public void deleteWarehouse(long id) {
        hibernateWarehouseDao.delete(id);
    }

}
