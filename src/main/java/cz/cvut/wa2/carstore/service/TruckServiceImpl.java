package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernateTruckDao;
import cz.cvut.wa2.carstore.entities.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    protected HibernateTruckDao hibernateTruckDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Truck findTruck(long id) {
        return hibernateTruckDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Truck findTruckWithManufacturerAndOrders(long id) {
        return hibernateTruckDao.findTruckWithManufacturerAndOrders(id);
    }

    @Override
    @Transactional
    public void persistTruck(Truck truck) {
        hibernateTruckDao.persist(truck);
    }

    @Override
    @Transactional
    public void mergeTruck(Truck truck) {
        hibernateTruckDao.merge(truck);
    }

    @Override
    @Transactional
    public void deleteTruck(long id) {
        hibernateTruckDao.delete(id);
    }

}
