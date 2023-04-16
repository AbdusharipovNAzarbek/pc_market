package com.company.PC_market.service;

import com.company.PC_market.entity.Backet;
import com.company.PC_market.entity.Product;
import com.company.PC_market.payload.ActionDto;
import com.company.PC_market.payload.BacketDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.repository.ActionRepository;
import com.company.PC_market.repository.BacketRepository;
import com.company.PC_market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BacketService {
    @Autowired
    BacketRepository backetRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Backet> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return backetRepository.findAll(pageable).getContent();
    }

    public Backet getOne(Integer id) {
        return backetRepository.findById(id).orElse(null);
    }

    public Response create(BacketDto backetDto) {
        if (backetRepository.existsByName(backetDto.getName())) {
            return new Response("Bunday savat mavjud", false);
        }
        Optional<Product> optionalProduct = productRepository.findById(backetDto.getProducts_id());
        if (optionalProduct.isEmpty()) {
            return new Response("Bunday mahsulot topilmadi", false);
        }
        List<Product> products = new ArrayList<>();
        products.add(optionalProduct.get());
        Backet backet = new Backet(backetDto.getName(), backetDto.getSubtotal(), backetDto.getQuantity(), products);
        return new Response("Aksiya muvaffaqiyatli saqlandi", true);
    }

    public Response edit(Integer id, BacketDto backetDto) {
        Optional<Backet> optionalBacket = backetRepository.findById(id);
        if (optionalBacket.isEmpty()) {
            return new Response("Bunday savat topilmadi", false);
        }
        Optional<Product> optionalProduct = productRepository.findById(backetDto.getProducts_id());
        if (optionalProduct.isEmpty()) {
            return new Response("Bunday mahsulot topilmadi", false);
        }
        Backet backet = optionalBacket.get();
        backet.setName(backetDto.getName());
        backet.setSubtotal(backetDto.getSubtotal());
        backet.setQuantity(backetDto.getQuantity());
        List<Product> products = backet.getProducts();
        products.clear();
        products.add(optionalProduct.get());
        backet.setProducts(products);
        backetRepository.save(backet);
        return new Response("Savat muvaffaqiyatli tahrirlandi", true);
    }

    public Response delete(Integer id) {
        try {
            backetRepository.deleteById(id);
            return new Response("Savat muvaffaqiyatli o'chirildi", true);
        } catch (Exception e) {
            return new Response("Savat o'chirilmadi", false);
        }
    }
}
