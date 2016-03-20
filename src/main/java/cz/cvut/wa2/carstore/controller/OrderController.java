package cz.cvut.wa2.carstore.controller;

import cz.cvut.wa2.carstore.entities.Order;
import cz.cvut.wa2.carstore.service.CarService;
import cz.cvut.wa2.carstore.service.OrderService;
import cz.cvut.wa2.carstore.service.PersonService;
import cz.cvut.wa2.carstore.wrapper.OrderWrapper;
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
@RequestMapping("orders/*")
public class OrderController {

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected CarService carService;

    @Autowired
    protected PersonService personService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView getOrders() {
        return new ModelAndView("orders", "orders", orderService.findOrdersWithPersonsAndCars());
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public ModelAndView createOrder() {
        OrderWrapper orderWrapper = new OrderWrapper();
        return new ModelAndView("order", "command", orderWrapper);
    }

    @RequestMapping(value = "/doCreateOrder", method = RequestMethod.POST)
    public String doCreateOrder(@ModelAttribute OrderWrapper orderWrapper) {
        orderService.mergeOrder(getOrderFromWrapper(orderWrapper));
        return "redirect:/orders/orders";
    }

    public Order getOrderFromWrapper(OrderWrapper orderWrapper) {
        Order order = new Order();

        if(orderWrapper.getPersonId() != null) {
            order.setPerson(personService.findPerson(orderWrapper.getPersonId()));
        }

        if(orderWrapper.getCarId() != null) {
            order.setCar(carService.findCar(orderWrapper.getCarId()));
        }

        return order;
    }

}
