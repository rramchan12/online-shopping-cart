package com.ravi.onlineshop.bo;

import com.ravi.onlineshop.model.Orders;
import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.repository.CustomerRepository;
import com.ravi.onlineshop.repository.ItemRepository;
import com.ravi.onlineshop.repository.OrdersDetailsRepository;
import com.ravi.onlineshop.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CartBo {


    private OrdersRepository ordersRepository;
    private OrdersDetailsRepository ordersDetailsRepository;
    private ItemRepository itemRepository;
    private CustomerRepository customerRepository;

    /**
     * Parameterised Constructor to automatically initialize variables
     * @param ordersRepository
     * @param ordersDetailsRepository
     * @param itemRepository
     * @param customerRepository
     */
    @Autowired
    public CartBo(OrdersRepository ordersRepository, OrdersDetailsRepository ordersDetailsRepository, ItemRepository itemRepository,
                  CustomerRepository customerRepository){
        this.ordersRepository = ordersRepository;
        this.ordersDetailsRepository = ordersDetailsRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
    }

    /**
     * Return all the Orders within a Customers Shopping Cart
     * @param customerId - The Id of the Customer
     * @return The list of Items in the cart
     */
    public List<OrderDetails> getShoppingCart(int customerId) {
            List<OrderDetails> cart = new ArrayList<>();
            log.debug("Get Shopping Cart called for CustomerId "+customerId);
            int cart_id=  this.getCustomerOrderId(customerId);
            if (cart_id!= -1){
                cart = ordersDetailsRepository.findById(cart_id);
            }
            else{
                log.debug("No Cart Found for Customer Id "+customerId);
            }
            return cart;
    }


    /**
     * Returns the Customer Cart Id (OrderId) if he has an active cart else returns -1
     * @param customerId Customer Id
     * @return Active OrderId or else return -1
     */
    private int getCustomerOrderId(int customerId) {
        return ordersRepository.findByCustomerId(customerId)
                .stream()
                .filter(orders -> orders.getStatus() ==0)
                .map(Orders::getOrder_id)
                .findAny()
                .orElse(-1);
    }
}
