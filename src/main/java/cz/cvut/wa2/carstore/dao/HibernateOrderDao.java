package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateOrderDao extends AbstractGenericHibernateDao<Order> {

    public HibernateOrderDao() {
        super(Order.class);
    }

    public Order findByIdWithPersonAndCar(long id) {
        return (Order) sessionFactory.getCurrentSession().getNamedQuery("Order.findByIdWithPersonAndCar").setParameter("id", id).uniqueResult();
    }

    public List<Order> findOrdersWithPersonsAndCars() {
        return sessionFactory.getCurrentSession().getNamedQuery("Order.findAllWithPersonsAndCars").list();
    }

}
