package cz.cvut.wa2.carstore.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jakubchalupa
 * @since 26.02.16
 */
@Entity
@Table(name = "persons")
@NamedQueries({
    @NamedQuery(name = "Person.findByIdWithOrdersPhonesAndAddresses",
        query = "from Person p left outer join fetch p.orders left outer join fetch p.phones left outer join fetch p.addresses where p.id = :id")
})
@SuppressWarnings("JpaQlInspection")
public class Person extends AbstractEntity {

    private static final long serialVersionUID = -6719668226224017418L;

    @Column(nullable = false)
    @Size(max = 255)
    private String name;

    @Column(nullable = false)
    @Size(max = 255)
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Address> addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Order> getOrders() {
        if(orders == null) orders = new HashSet<>();
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order o) {
        if(!getOrders().contains(o)) orders.add(o);
        o.setPerson(this);
    }

    public Set<Phone> getPhones() {
        if(phones == null) phones = new HashSet<>();
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public void addPhone(Phone p) {
        if(!getPhones().contains(p)) phones.add(p);
        p.setPerson(this);
    }

    public Set<Address> getAddresses() {
        if(addresses == null) addresses = new HashSet<>();
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address a) {
        if(!getAddresses().contains(a)) addresses.add(a);
        a.setPerson(this);
    }
}
