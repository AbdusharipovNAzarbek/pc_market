package com.company.PC_market.service;

import com.company.PC_market.entity.Action;
import com.company.PC_market.entity.Product;
import com.company.PC_market.payload.ActionDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.repository.ActionRepository;
import com.company.PC_market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActionService {
    @Autowired
    ActionRepository actionRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Action> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return actionRepository.findAll(pageable).getContent();
    }

    public Action getOne(Integer id) {
        return actionRepository.findById(id).orElse(null);
    }

    public Response create(ActionDto actionDto) {
        if (actionRepository.existsByName(actionDto.getName())) {
            return new Response("Bunday aksiya mavjud", false);
        }
        Optional<Product> optionalProduct = productRepository.findById(actionDto.getProducts_id());
        if (optionalProduct.isEmpty()) {
            return new Response("Bunday mahsulo topilmadi", false);
        }
        List<Product> products = new ArrayList<>();
        products.add(optionalProduct.get());
        Action action = new Action(actionDto.getName(), actionDto.getDescription(), products);
        return new Response("Aksiya muvaffaqiyatli saqlandi", true);
    }

    public Response edit(Integer id, ActionDto actionDto) {
        Optional<Action> optionalAction = actionRepository.findById(id);
        if (optionalAction.isEmpty()) {
            return new Response("Bunday aksiya topilmadi", false);
        }
        Optional<Product> optionalProduct = productRepository.findById(actionDto.getProducts_id());
        if (optionalProduct.isEmpty()) {
            return new Response("Bunday mahsulot topilmadi", false);
        }
        Action action = optionalAction.get();
        action.setName(actionDto.getName());
        action.setDescription(actionDto.getDescription());
        List<Product> products = action.getProducts();
        products.clear();
        products.add(optionalProduct.get());
        action.setProducts(products);
        actionRepository.save(action);
        return new Response("Aksiya muvaffaqiyatli tahrirlandi",true);
    }

    public Response delete(Integer id) {
        try {
            actionRepository.deleteById(id);
            return new Response("Aksiya muvaffaqiyatli o'chirildi",true);
        }
        catch (Exception e){
            return new Response("Aksiya o'chirilmadi",false);
        }
    }
}
