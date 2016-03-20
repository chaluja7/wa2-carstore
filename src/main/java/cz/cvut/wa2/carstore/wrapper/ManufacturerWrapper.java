package cz.cvut.wa2.carstore.wrapper;

import cz.cvut.wa2.carstore.entities.Manufacturer;

/**
 * @author jakubchalupa
 * @since 20.03.16
 */
public class ManufacturerWrapper extends Manufacturer {

    private static final long serialVersionUID = 5493608634615838153L;

    private String supplierIds;

    public String getSupplierIds() {
        return supplierIds;
    }

    public void setSupplierIds(String supplierIds) {
        this.supplierIds = supplierIds;
    }

}
