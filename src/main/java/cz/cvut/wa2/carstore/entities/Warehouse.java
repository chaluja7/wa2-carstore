package cz.cvut.wa2.carstore.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Entity
@Table(name = "warehouses")
@NamedQueries({
    @NamedQuery(name = "Warehouse.findByIdWithSupplier", query = "from Warehouse w left outer join fetch w.supplier where w.id = :id")
})
@SuppressWarnings("JpaQlInspection")
public class Warehouse extends AbstractEntity {

    private static final long serialVersionUID = -7046044279789502107L;

    @Column(unique = true, nullable = false)
    @Size(max = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
