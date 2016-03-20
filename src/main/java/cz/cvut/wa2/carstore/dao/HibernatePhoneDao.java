package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Phone;
import org.springframework.stereotype.Repository;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernatePhoneDao extends AbstractGenericHibernateDao<Phone> {

    public HibernatePhoneDao() {
        super(Phone.class);
    }

    public Phone findPhoneWithPerson(long id) {
        return (Phone) sessionFactory.getCurrentSession().getNamedQuery("Phone.findByIdWithPerson").setParameter("id", id).uniqueResult();
    }

}
