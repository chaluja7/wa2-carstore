package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Car;
import cz.cvut.wa2.carstore.entities.Truck;
import org.springframework.stereotype.Repository;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
public class HibernateTruckDao extends AbstractGenericHibernateDao<Truck> {

    public HibernateTruckDao() {
        super(Truck.class);
    }

    public Truck findTruckWithManufacturerAndOrders(long id) {
        return (Truck) sessionFactory.getCurrentSession().getNamedQuery("Truck.findByIdWithManufacturerAndOrders").setParameter("id", id).uniqueResult();
    }

}
