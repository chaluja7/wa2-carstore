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
@Table(name = "suppliers")
@NamedQueries({
    @NamedQuery(name = "Supplier.findByIdWithManufacturersAndWarehouses",
        query = "from Supplier s left outer join fetch s.manufacturers left outer join fetch s.warehouses where s.id = :id")
})
@SuppressWarnings("JpaQlInspection")
public class Supplier extends AbstractEntity {

    private static final long serialVersionUID = 5145596957946780609L;

    @Column(unique = true, nullable = false)
    @Size(max = 255)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "suppliers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Manufacturer> manufacturers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", cascade = CascadeType.ALL)
    private Set<Warehouse> warehouses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Manufacturer> getManufacturers() {
        if(manufacturers == null) manufacturers = new HashSet<>();
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public void addManufacturer(Manufacturer m) {
        if(!getManufacturers().contains(m)) manufacturers.add(m);
        if(Hibernate.isInitialized(m.getSuppliers()) && !m.getSuppliers().contains(this)) m.getSuppliers().add(this);
    }

    public Set<Warehouse> getWarehouses() {
        if(warehouses == null) warehouses = new HashSet<>();
        return warehouses;
    }

    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public void addWarehouse(Warehouse w) {
        if(!getWarehouses().contains(w)) warehouses.add(w);
        w.setSupplier(this);
    }
}
