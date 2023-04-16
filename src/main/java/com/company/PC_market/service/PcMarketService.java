package com.company.PC_market.service;

import com.company.PC_market.entity.*;
import com.company.PC_market.payload.PcMarketDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class PcMarketService {
    @Autowired
    PcMarketRepository pcMarketRepository;
    @Autowired
    InformationRepository informationRepository;
    @Autowired
    BacketRepository backetRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    ActionRepository actionRepository;
    @Autowired
    ContactRepository contactRepository;


    public List<PcMarket> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return pcMarketRepository.findAll(pageable).getContent();
    }

    public PcMarket getOne(Integer id) {
        return pcMarketRepository.findById(id).orElse(null);
    }

    public Response create(PcMarketDto pcMarketDto) {
        if (pcMarketRepository.existsByName(pcMarketDto.getName())) {
            return new Response("Bunday nomli Market mavjud", false);
        }
        if (informationRepository.findById(pcMarketDto.getInformation_id())
                .isEmpty()) {
            return new Response("Bunday malumot mavjud emas", false);
        }
        if (backetRepository.findById(pcMarketDto.getBacket_id()).isEmpty()) {
            return new Response("Bunday savat mavjud emas", false);
        }
        if (currencyRepository.findById(pcMarketDto.getCurrency_id()).isEmpty()) {
            return new Response("Bunday valyuta mavjud emas", false);
        }
        if (catalogRepository.findById(pcMarketDto.getCatalog_id()).isEmpty()) {
            return new Response("Bunday katalog mavjud emas ", false);
        }
        if (blogRepository.findById(pcMarketDto.getBlog_id()).isEmpty()) {
            return new Response("Bunday blog mavjud emas", false);
        }
        if (actionRepository.findById(pcMarketDto.getAction_id()).isEmpty()) {
            return new Response("Bunday aksiya mavjud emas", false);
        }
        if (contactRepository.findById(pcMarketDto.getContact_id()).isEmpty()) {
            return new Response("Bunday kontakt mavjud emas", false);
        }

        PcMarket pcMarket = new PcMarket(pcMarketDto.getName(), informationRepository.findAll(), backetRepository.findAll(),
                currencyRepository.findAll(), catalogRepository.findAll(), blogRepository.findAll(), actionRepository.findAll(),
                contactRepository.findById(pcMarketDto.getContact_id()).get());
        pcMarketRepository.save(pcMarket);
        return new Response("PcMarket saqlandi", true);

    }

    public Response edit(Integer id, PcMarketDto pcMarketDto) {
        Optional<PcMarket> optionalPcMarket = pcMarketRepository.findById(id);
        if (optionalPcMarket.isEmpty()) {
            return new Response("Bunday PcMarket mavjud emas", false);
        }
        Optional<Information> optionalInformation = informationRepository.findById(pcMarketDto.getInformation_id());
        if (optionalInformation.isEmpty()) {
            return new Response("Bunday malumot mavjud emas", false);
        }
        Optional<Backet> optionalBacket = backetRepository.findById(pcMarketDto.getBacket_id());
        if (optionalBacket.isEmpty()) {
            return new Response("Bunday savat mavjud emas", false);
        }
        Optional<Currency> optionalCurrency = currencyRepository.findById(pcMarketDto.getCurrency_id());
        if (optionalCurrency.isEmpty()) {
            return new Response("Bunday valyuta mavjud emas", false);
        }
        Optional<Catalog> optionalCatalog = catalogRepository.findById(pcMarketDto.getCatalog_id());
        if (optionalCatalog.isEmpty()) {
            return new Response("Bunday katalof mavjud emas", false);
        }
        Optional<Blog> optionalBlog = blogRepository.findById(pcMarketDto.getBlog_id());
        if (optionalBlog.isEmpty()) {
            return new Response("Bunay blog mavjud emas", false);
        }
        Optional<Action> optionalAction = actionRepository.findById(pcMarketDto.getAction_id());
        if (optionalAction.isEmpty()) {
            return new Response("BUnday aksiya mavjud emas", false);
        }
        Optional<Contact> optionalContact = contactRepository.findById(pcMarketDto.getContact_id());
        if (optionalContact.isEmpty()) {
            return new Response("Bunday kontakt topilmadi", false);
        }
        PcMarket pcMarket = optionalPcMarket.get();
        pcMarket.setActions(actionRepository.findAll());
        pcMarket.setInformation(informationRepository.findAll());
        pcMarket.setBackets(backetRepository.findAll());
        pcMarket.setCurrencies(currencyRepository.findAll());
        pcMarket.setCatalogs(catalogRepository.findAll());
        pcMarket.setBlogs(blogRepository.findAll());
        pcMarket.setContact(optionalContact.get());
        pcMarketRepository.save(pcMarket);
        return new Response("PcMarket muvaffqiyatli tahrirlandi", true);

    }

    public Response delete(Integer id) {
        try {
            pcMarketRepository.deleteById(id);
            return new Response("PcMarket o'chirildi", true);
        } catch (Exception e) {
            return new Response("PcMarket o'chirilmadi", false);
        }
    }
}
