package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernateOrderDao;
import cz.cvut.wa2.carstore.entities.Order;
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
public class OrderServiceImpl implements OrderService {

    @Autowired
    protected HibernateOrderDao hibernateOrderDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Order findOrder(long id) {
        return hibernateOrderDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Order findOrderWithPersonAndCar(long id) {
        return hibernateOrderDao.findByIdWithPersonAndCar(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Order> findOrdersWithPersonsAndCars() {
        return hibernateOrderDao.findOrdersWithPersonsAndCars();
    }

    @Override
    @Transactional
    public void persistOrder(Order order) {
        hibernateOrderDao.persist(order);
    }

    @Override
    @Transactional
    public void mergeOrder(Order order) {
        hibernateOrderDao.merge(order);
    }

    @Override
    @Transactional
    public void deleteOrder(long id) {
        hibernateOrderDao.delete(id);
    }

}
