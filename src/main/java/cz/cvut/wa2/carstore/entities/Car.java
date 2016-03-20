package cz.cvut.wa2.carstore.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Entity
@Table(name = "cars")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "car")
@NamedQueries({
    @NamedQuery(name = "Car.findByIdWithManufacturerAndOrders",
        query = "from Car c left outer join fetch c.orders left outer join fetch c.manufacturer where c.id = :id"),
    @NamedQuery(name = "Car.findAllWithManufacturers",
        query = "from Car c left outer join fetch c.manufacturer"),
    @NamedQuery(name = "Car.findByName",
        query = "from Car c left outer join fetch c.manufacturer m left outer join fetch m.suppliers s left outer join fetch s.warehouses w where c.name = :name")
})
@SuppressWarnings("JpaQlInspection")
public class Car extends AbstractEntity {

    private static final long serialVersionUID = 6300901422498667588L;

    @Column(unique = true, nullable = false)
    @Size(max = 255)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "manufacturerId")
    private Manufacturer manufacturer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        o.setCar(this);
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
