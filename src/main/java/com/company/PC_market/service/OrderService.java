package com.company.PC_market.service;

import com.company.PC_market.entity.Backet;
import com.company.PC_market.entity.Order;
import com.company.PC_market.entity.Product;
import com.company.PC_market.payload.OrderDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.repository.BacketRepository;
import com.company.PC_market.repository.OrderRepository;
import com.company.PC_market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BacketRepository backetRepository;

    public List<Order> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findAll(pageable).getContent();
    }

    public Order getOne(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Response create(OrderDto orderDto) {
        if (orderRepository.existsByName(orderDto.getName())) {
            return new Response("Bunday nomli buyurtma mavjud", false);
        }
        Optional<Backet> optionalBacket = backetRepository.findById(orderDto.getBacket_id());
        if (optionalBacket.isEmpty()) {
            return new Response("Bunday Savat mavjud emas", false);
        }
        Order order = new Order(orderDto.getName(), orderDto.getDescription(), optionalBacket.get());
        return new Response("Buyurtma saqlandi", true);
    }
    public Response edit(Integer id, OrderDto orderDto) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()){
            return new Response("Bunday buyurtma topilmadi", false);
        }
        Optional<Backet> optionalBacket = backetRepository.findById(orderDto.getBacket_id());
        if (optionalBacket.isEmpty()) {
            return new Response("Bunday savat topilmadi", false);
        }
        Order order = optionalOrder.get();
        order.setName(orderDto.getName());
        order.setBacket(optionalBacket.get());
        order.setDescription(orderDto.getDescription());
        orderRepository.save(order);
        return new Response("Buyurtma muvaffaqiyatli tahrirlandi", true);
    }

    public Response delete(Integer id) {
        try {
            orderRepository.deleteById(id);
            return new Response("Buyurtma muvaffaqiyatli o'chirildi", true);
        } catch (Exception e) {
            return new Response("Buyurtma o'chirilmadi", false);
        }
    }
}
