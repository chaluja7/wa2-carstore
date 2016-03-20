package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernateCarDao;
import cz.cvut.wa2.carstore.entities.Car;
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
public class CarServiceImpl implements CarService {

    @Autowired
    protected HibernateCarDao hibernateCarDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Car findCar(long id) {
        return hibernateCarDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Car findCarWithManufacturerAndOrders(long id) {
        return hibernateCarDao.findCarWithManufacturerAndOrders(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Car findCarByName(String name) {
        return hibernateCarDao.findCarByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Car> findCarsWithManufacturerAndOrders() {
        return hibernateCarDao.findCarsWithManufacturerAndOrders();
    }

    @Override
    @Transactional
    public void persistCar(Car car) {
        hibernateCarDao.persist(car);
    }

    @Override
    @Transactional
    public void mergeCar(Car car) {
        hibernateCarDao.merge(car);
    }

    @Override
    @Transactional
    public void deleteCar(long id) {
        hibernateCarDao.delete(id);
    }

}
