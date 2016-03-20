package cz.cvut.wa2.carstore.controller;

import cz.cvut.wa2.carstore.entities.Manufacturer;
import cz.cvut.wa2.carstore.service.ManufacturerService;
import cz.cvut.wa2.carstore.service.SupplierService;
import cz.cvut.wa2.carstore.wrapper.ManufacturerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jakubchalupa
 * @since 20.03.16
 */
@Controller
@RequestMapping("manufacturers/*")
public class ManufacturerController {

    @Autowired
    protected ManufacturerService manufacturerService;

    @Autowired
    protected SupplierService supplierService;

    @RequestMapping(value = "/manufacturers", method = RequestMethod.GET)
    public ModelAndView getManufacturers() {
        return new ModelAndView("manufacturers", "manufacturers", manufacturerService.findManufacturersWithSuppliers());
    }

    @RequestMapping(value = "/createManufacturer", method = RequestMethod.GET)
    public ModelAndView createManufacturer() {
        ManufacturerWrapper manufacturerWrapper = new ManufacturerWrapper();
        return new ModelAndView("manufacturer", "command", manufacturerWrapper);
    }

    @RequestMapping(value = "/doCreateManufacturer", method = RequestMethod.POST)
    public String doCreateManufacturer(@ModelAttribute ManufacturerWrapper manufacturerWrapper) {
        manufacturerService.mergeManufacturer(getManufacturerFromWrapper(manufacturerWrapper));
        return "redirect:/manufacturers/manufacturers";
    }

    public Manufacturer getManufacturerFromWrapper(ManufacturerWrapper manufacturerWrapper) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(manufacturerWrapper.getName());
        if(manufacturerWrapper.getSupplierIds() != null) {
            String[] split = manufacturerWrapper.getSupplierIds().split(",");
            for(String s : split) {
                manufacturer.addSupplier(supplierService.findSupplier(Long.parseLong(s)));
            }
        }

        return manufacturer;
    }

}
