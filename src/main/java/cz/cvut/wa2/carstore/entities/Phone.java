package cz.cvut.wa2.carstore.entities;

import javax.persistence.*;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Entity
@Table(name = "phones")
@NamedQueries({
    @NamedQuery(name = "Phone.findByIdWithPerson", query = "from Phone p left outer join fetch p.person where p.id = :id")
})
@SuppressWarnings("JpaQlInspection")
public class Phone extends AbstractEntity {

    private static final long serialVersionUID = -1661573266229431073L;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String note;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personId")
    private Person person;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
