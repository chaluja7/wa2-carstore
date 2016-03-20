package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernatePhoneDao;
import cz.cvut.wa2.carstore.entities.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    protected HibernatePhoneDao hibernatePhoneDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Phone findPhone(long id) {
        return hibernatePhoneDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Phone findPhoneWithPerson(long id) {
        return hibernatePhoneDao.findPhoneWithPerson(id);
    }

    @Override
    @Transactional
    public void persistPhone(Phone phone) {
        hibernatePhoneDao.persist(phone);
    }

    @Override
    @Transactional
    public void mergePhone(Phone phone) {
        hibernatePhoneDao.merge(phone);
    }

    @Override
    @Transactional
    public void deletePhone(long id) {
        hibernatePhoneDao.delete(id);
    }

}
