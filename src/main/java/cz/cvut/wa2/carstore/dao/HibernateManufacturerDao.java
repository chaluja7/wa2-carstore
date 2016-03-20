package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateManufacturerDao extends AbstractGenericHibernateDao<Manufacturer> {

    public HibernateManufacturerDao() {
        super(Manufacturer.class);
    }

    public Manufacturer findManufacturerWithCarsAndSuppliers(long id) {
        return (Manufacturer) sessionFactory.getCurrentSession().getNamedQuery("Manufacturer.findByIdWithCarsAndSuppliers").setParameter("id", id).uniqueResult();
    }

    public List<Manufacturer> findManufacturersWithSuppliers() {
        return sessionFactory.getCurrentSession().getNamedQuery("Manufacturer.findAllWithSuppliers").list();
    }

}
