package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateCarDao extends AbstractGenericHibernateDao<Car> {

    public HibernateCarDao() {
        super(Car.class);
    }

    public Car findCarWithManufacturerAndOrders(long id) {
        return (Car) sessionFactory.getCurrentSession().getNamedQuery("Car.findByIdWithManufacturerAndOrders").setParameter("id", id).uniqueResult();
    }

    public List<Car> findCarsWithManufacturerAndOrders() {
        return sessionFactory.getCurrentSession().getNamedQuery("Car.findAllWithManufacturers").list();
    }

    public Car findCarByName(String name) {
        return (Car) sessionFactory.getCurrentSession().getNamedQuery("Car.findByName").setParameter("name", name).uniqueResult();
    }

}
