package cz.cvut.wa2.carstore.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jakubchalupa
 * @since 26.02.16
 */
@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "Order.findByIdWithPersonAndCar", query = "from Order o left outer join fetch o.person left outer join fetch o.car where o.id = :id"),
    @NamedQuery(name = "Order.findAllWithPersonsAndCars", query = "from Order o left outer join fetch o.person left outer join fetch o.car")

})
@SuppressWarnings("JpaQlInspection")
public class Order extends AbstractEntity {

    private static final long serialVersionUID = -1190645844187308230L;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "personId")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "carId")
    private Car car;

    @Column
    private Date dateFrom;

    @Column
    private Date dateTo;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
