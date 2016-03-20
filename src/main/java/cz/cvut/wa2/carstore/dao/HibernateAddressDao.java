package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateAddressDao extends AbstractGenericHibernateDao<Address> {

    public HibernateAddressDao() {
        super(Address.class);
    }

    public Address findAddressWithPerson(long id) {
        return (Address) sessionFactory.getCurrentSession().getNamedQuery("Address.findByIdWithPerson").setParameter("id", id).uniqueResult();
    }

    public List<Address> findAddressesWithPersons() {
        return sessionFactory.getCurrentSession().getNamedQuery("Address.findAllWithPersons").list();
    }

    public List<Address> findAddressesByCity(String city) {
        return sessionFactory.getCurrentSession().getNamedQuery("Address.findAddressesByCity").setParameter("city", "%" + city + "%").list();
    }

}
