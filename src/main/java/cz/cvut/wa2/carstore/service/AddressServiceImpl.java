package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.dao.HibernateAddressDao;
import cz.cvut.wa2.carstore.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    protected HibernateAddressDao hibernateAddressDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Address findAddress(long id) {
        return hibernateAddressDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Address findAddressWithPerson(long id) {
        return hibernateAddressDao.findAddressWithPerson(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Address> findAddressesWithPersons() {
        return hibernateAddressDao.findAddressesWithPersons();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Address> findAddressesByCity(String city) {
        return hibernateAddressDao.findAddressesByCity(city);
    }

    @Override
    @Transactional
    public void persistAddress(Address address) {
        hibernateAddressDao.persist(address);
    }

    @Override
    @Transactional
    public void mergeAddress(Address address) {
        hibernateAddressDao.merge(address);
    }

    @Override
    @Transactional
    public void deleteAddress(long id) {
        hibernateAddressDao.delete(id);
    }

}
