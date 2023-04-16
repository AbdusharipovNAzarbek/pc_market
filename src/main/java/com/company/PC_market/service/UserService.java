package com.company.PC_market.service;

import com.company.PC_market.entity.Order;
import com.company.PC_market.entity.User;
import com.company.PC_market.entity.User;
import com.company.PC_market.payload.UserDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.repository.OrderRepository;
import com.company.PC_market.repository.UserRepository;
import com.company.PC_market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    public List<User> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable).getContent();
    }

    public User getOne(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public Response create(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            return new Response("Bunday nomli buyurtma mavjud", false);
        }
        Optional<Order> optionalOrder = orderRepository.findById(userDto.getOrder_id());
        if (optionalOrder.isEmpty()) {
            return new Response("Bunday buyurtma mavjud emas", false);
        }
        User user = new User(userDto.getName(), userDto.getPhone_number(), userDto.getEmail(), userDto.getAddress(), optionalOrder.get());
        return new Response("User saqlandi", true);
    }
    public Response edit(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            return new Response("Bunday user topilmadi", false);
        }
        Optional<Order> optionalOrder = orderRepository.findById(userDto.getOrder_id());
        if (optionalOrder.isEmpty()) {
            return new Response("Bunday buyurtma topilmadi", false);
        }
        User user = optionalUser.get();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());
        user.setPhone_number(userDto.getPhone_number());
        user.setOrder(optionalOrder.get());
        userRepository.save(user);
        return new Response("User muvaffaqiyatli tahrirlandi", true);
    }

    public Response delete(Integer id) {
        try {
            userRepository.deleteById(id);
            return new Response("User muvaffaqiyatli o'chirildi", true);
        } catch (Exception e) {
            return new Response("User o'chirilmadi", false);
        }
    }
}
