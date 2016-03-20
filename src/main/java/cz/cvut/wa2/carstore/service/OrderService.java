package cz.cvut.wa2.carstore.service;

import cz.cvut.wa2.carstore.entities.Order;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface OrderService {

    Order findOrder(long id);

    Order findOrderWithPersonAndCar(long id);

    List<Order> findOrdersWithPersonsAndCars();

    void persistOrder(Order order);

    void mergeOrder(Order order);

    void deleteOrder(long id);

}
