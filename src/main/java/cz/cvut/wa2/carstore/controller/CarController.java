package cz.cvut.wa2.carstore.controller;

import cz.cvut.wa2.carstore.entities.Car;
import cz.cvut.wa2.carstore.service.CarService;
import cz.cvut.wa2.carstore.service.ManufacturerService;
import cz.cvut.wa2.carstore.wrapper.CarWrapper;
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
@RequestMapping("cars/*")
public class CarController {

    @Autowired
    protected CarService carService;

    @Autowired
    protected ManufacturerService manufacturerService;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView getCars() {
        return new ModelAndView("cars", "cars", carService.findCarsWithManufacturerAndOrders());
    }

    @RequestMapping(value = "/createCar", method = RequestMethod.GET)
    public ModelAndView createCar() {
        CarWrapper carWrapper = new CarWrapper();
        return new ModelAndView("car", "command", carWrapper);
    }

    @RequestMapping(value = "/doCreateCar", method = RequestMethod.POST)
    public String doCreateCar(@ModelAttribute CarWrapper carWrapper) {
        carService.mergeCar(getCarFromWrapper(carWrapper));
        return "redirect:/cars/cars";
    }

    public Car getCarFromWrapper(CarWrapper carWrapper) {
        Car car = new Car();
        car.setName(carWrapper.getName());
        if(carWrapper.getManufacturerId() != null) {
            car.setManufacturer(manufacturerService.findManufacturer(carWrapper.getManufacturerId()));
        }

        return car;
    }

}
