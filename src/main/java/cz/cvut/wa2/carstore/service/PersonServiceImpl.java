package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernatePersonDao;
import cz.cvut.wa2.carstore.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    protected HibernatePersonDao hibernatePersonDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Person findPerson(long id) {
        return hibernatePersonDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Person findPersonWithOrdersPhonesAndAddresses(long id) {
        return hibernatePersonDao.findPersonWithOrdersPhonesAndAddresses(id);
    }

    @Override
    @Transactional
    public void persistPerson(Person person) {
        hibernatePersonDao.persist(person);
    }

    @Override
    @Transactional
    public void mergePerson(Person person) {
        hibernatePersonDao.merge(person);
    }

    @Override
    @Transactional
    public void deletePerson(long id) {
        hibernatePersonDao.delete(id);
    }

}
