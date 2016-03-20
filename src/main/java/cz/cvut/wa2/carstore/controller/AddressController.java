package cz.cvut.wa2.carstore.controller;

import cz.cvut.wa2.carstore.entities.Address;
import cz.cvut.wa2.carstore.service.AddressService;
import cz.cvut.wa2.carstore.service.PersonService;
import cz.cvut.wa2.carstore.wrapper.AddressWrapper;
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
@RequestMapping("addresses/*")
public class AddressController {

    @Autowired
    protected AddressService addressService;

    @Autowired
    protected PersonService personService;

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public ModelAndView getAddresses() {
        return new ModelAndView("addresses", "addresses", addressService.findAddressesWithPersons());
    }

    @RequestMapping(value = "/createAddress", method = RequestMethod.GET)
    public ModelAndView createAddress() {
        AddressWrapper addressWrapper = new AddressWrapper();
        return new ModelAndView("address", "command", addressWrapper);
    }

    @RequestMapping(value = "/addressesByCity", method = RequestMethod.GET)
    public ModelAndView getAddressesByCity(String cityPattern) {
        return new ModelAndView("addressesByCity", "addresses", addressService.findAddressesByCity(cityPattern));
    }

    @RequestMapping(value = "/doCreateAddress", method = RequestMethod.POST)
    public String doCreateAddress(@ModelAttribute AddressWrapper addressWrapper) {
        addressService.mergeAddress(getAddressFromWrapper(addressWrapper));
        return "redirect:/addresses/addresses";
    }

    public Address getAddressFromWrapper(AddressWrapper addressWrapper) {
        Address address = new Address();
        address.setNote(addressWrapper.getNote());
        address.setNumber(addressWrapper.getNumber());
        address.setStreet(addressWrapper.getNote());
        address.setCity(addressWrapper.getCity());

        if(addressWrapper.getPersonId() != null) {
            address.setPerson(personService.findPerson(addressWrapper.getPersonId()));
        }

        return address;
    }

}
