package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Supplier;
import org.springframework.stereotype.Repository;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateSupplierDao extends AbstractGenericHibernateDao<Supplier> {

    public HibernateSupplierDao() {
        super(Supplier.class);
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().createSQLQuery("delete from manufacturer_supplier where supplierid = :id").setParameter("id", id).executeUpdate();
        sessionFactory.getCurrentSession().delete(find(id));
    }

    public Supplier findSupplierWithManufacturersAndWarehouses(long id) {
        return (Supplier) sessionFactory.getCurrentSession().getNamedQuery("Supplier.findByIdWithManufacturersAndWarehouses").setParameter("id", id).uniqueResult();
    }

}
