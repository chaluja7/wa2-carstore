package cz.cvut.wa2.carstore.dao;

import cz.cvut.wa2.carstore.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.wa2.carstore.entities.Person;
import org.springframework.stereotype.Repository;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernatePersonDao extends AbstractGenericHibernateDao<Person> {

    public HibernatePersonDao() {
        super(Person.class);
    }

    public Person findPersonWithOrdersPhonesAndAddresses(long id) {
        return (Person) sessionFactory.getCurrentSession().getNamedQuery("Person.findByIdWithOrdersPhonesAndAddresses").setParameter("id", id).uniqueResult();
    }

}
