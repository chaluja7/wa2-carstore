package cz.cvut.wa2.carstore.entities;

import javax.persistence.*;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Entity
@Table(name = "addresses")
@NamedQueries({
    @NamedQuery(name = "Address.findByIdWithPerson", query = "from Address a left outer join fetch a.person where a.id = :id"),
    @NamedQuery(name = "Address.findAllWithPersons", query = "from Address a left outer join fetch a.person"),
    @NamedQuery(name = "Address.findAddressesByCity",
        query = "select distinct a from Address a left outer join fetch a.person p left outer join fetch p.orders o left outer join fetch o.car c " +
            "left outer join fetch c.manufacturer m left outer join fetch m.suppliers s left outer join fetch s.warehouses w where a.city like :city")
})
@SuppressWarnings("JpaQlInspection")
public class Address extends AbstractEntity {

    private static final long serialVersionUID = 7102425005822686301L;

    @Column(nullable = false)
    private String city;

    @Column
    private String street;

    @Column
    private String number;

    @Column
    private String note;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personId")
    private Person person;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
