package cz.cvut.wa2.carstore.entities;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Entity
@Table(name = "manufacturers")
@NamedQueries({
    @NamedQuery(name = "Manufacturer.findByIdWithCarsAndSuppliers",
        query = "from Manufacturer m left outer join fetch m.cars left outer join fetch m.suppliers where m.id = :id"),
    @NamedQuery(name = "Manufacturer.findAllWithSuppliers",
        query = "select distinct m from Manufacturer m left outer join fetch m.suppliers"),
})
@SuppressWarnings("JpaQlInspection")
public class Manufacturer extends AbstractEntity {

    private static final long serialVersionUID = -1001148071430955251L;

    @Column(unique = true, nullable = false)
    @Size(max = 255)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private Set<Car> cars;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "manufacturer_supplier", joinColumns = @JoinColumn(name = "manufacturerId", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "supplierId", nullable = false, updatable = false))
    private Set<Supplier> suppliers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getCars() {
        if(cars == null) cars = new HashSet<>();
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car c) {
        if(!getCars().contains(c)) cars.add(c);
        c.setManufacturer(this);
    }

    public Set<Supplier> getSuppliers() {
        if(suppliers == null) suppliers = new HashSet<>();
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public void addSupplier(Supplier s) {
        if(!getSuppliers().contains(s)) suppliers.add(s);
        if(Hibernate.isInitialized(s.getManufacturers()) && !s.getManufacturers().contains(this)) s.getManufacturers().add(this);
    }
}
