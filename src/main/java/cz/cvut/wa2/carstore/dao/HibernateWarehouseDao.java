package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Warehouse;
import org.springframework.stereotype.Repository;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateWarehouseDao extends AbstractGenericHibernateDao<Warehouse> {

    public HibernateWarehouseDao() {
        super(Warehouse.class);
    }

    public Warehouse findWarehouseWithSupplier(long id) {
        return (Warehouse) sessionFactory.getCurrentSession().getNamedQuery("Warehouse.findByIdWithSupplier").setParameter("id", id).uniqueResult();
    }

}
