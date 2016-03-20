package cz.cvut.wa2.carstore.entities;

import javax.persistence.*;

/**
 * @author jakubchalupa
 * @since 26.02.16
 */
@Entity
@Table(name = "cars")
@DiscriminatorValue(value = "truck")
@NamedQueries({
    @NamedQuery(name = "Truck.findByIdWithManufacturerAndOrders",
        query = "from Truck t left outer join fetch t.orders left outer join fetch t.manufacturer where t.id = :id")
})
@SuppressWarnings("JpaQlInspection")
public class Truck extends Car {

    private static final long serialVersionUID = -64860642174821847L;

    @Column
    private Double weight;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
