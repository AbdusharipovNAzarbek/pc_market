package com.company.PC_market.service;

import com.company.PC_market.entity.*;
import com.company.PC_market.payload.ProductDto;
import com.company.PC_market.payload.Response;
import com.company.PC_market.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    SsdRepository ssdRepository;
    @Autowired
    CpuRepository cpuRepository;
    @Autowired
    HddRepository hddRepository;
    @Autowired
    RamRepository ramRepository;
    @Autowired
    BrandRepository brandRepository;

    public List<Product> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable).getContent();
    }

    public Product getOne(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Response create(ProductDto productDto) {
        if (productRepository.existsByNameAndCatalogId(productDto.getName(), productDto.getCatalog_id())) {
            return new Response("Bunday mahsulot ushbu katalogda avvaldan mavjud ", false);
        }
        Optional<Catalog> optionalCatalog = catalogRepository.findById(productDto.getCatalog_id());
        if (optionalCatalog.isEmpty()) {
            return new Response("Bunday katalog mavjud emas", false);
        }
        Optional<SSD> optionalSSD = ssdRepository.findById(productDto.getSsd_id());
        if (optionalSSD.isEmpty()) {
            return new Response("Bunday ssd mavjud emas", false);
        }
        Optional<CPU> optionalCPU = cpuRepository.findById(productDto.getCpu_id());
        if (optionalCPU.isEmpty()) {
            return new Response("Bunday cpu mavjud emas", false);
        }
        Optional<HDD> optionalHDD = hddRepository.findById(productDto.getHdd_id());
        if (optionalHDD.isEmpty()) {
            return new Response("Bunday hdd mavjud emas", false);
        }
        Optional<RAM> optionalRAM = ramRepository.findById(productDto.getRam_id());
        if (optionalRAM.isEmpty()) {
            return new Response("Bunday ram mavjud emas", false);
        }
        Optional<Brand> optionalBrand = brandRepository.findById(productDto.getBrand_id());
        if (optionalBrand.isEmpty()) {
            return new Response("Bunday brand topilmadi", false);
        }
        Product product = new Product(productDto.getName(), productDto.getPrice(), productDto.getDescription(),
                optionalCatalog.get(), optionalSSD.get(), optionalCPU.get(), optionalHDD.get(), optionalRAM.get(),
                optionalBrand.get());
        productRepository.save(product);
        return new Response("Mahsulot saqlandi", true);
    }

    public Response edit(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return new Response("Bunday mahsulot topilmadi", false);
        }
        Optional<Catalog> optionalCatalog = catalogRepository.findById(productDto.getCatalog_id());
        if (optionalCatalog.isEmpty()) {
            return new Response("Bunday katalog mavjud emas", false);
        }
        Optional<SSD> optionalSSD = ssdRepository.findById(productDto.getSsd_id());
        if (optionalSSD.isEmpty()) {
            return new Response("Bunday ssd mavjud emas", false);
        }
        Optional<CPU> optionalCPU = cpuRepository.findById(productDto.getCpu_id());
        if (optionalCPU.isEmpty()) {
            return new Response("Bunday cpu mavjud emas", false);
        }
        Optional<HDD> optionalHDD = hddRepository.findById(productDto.getHdd_id());
        if (optionalHDD.isEmpty()) {
            return new Response("Bunday hdd mavjud emas", false);
        }
        Optional<RAM> optionalRAM = ramRepository.findById(productDto.getRam_id());
        if (optionalRAM.isEmpty()) {
            return new Response("Bunday ram mavjud emas", false);
        }
        Optional<Brand> optionalBrand = brandRepository.findById(productDto.getBrand_id());
        if (optionalBrand.isEmpty()) {
            return new Response("Bunday brand topilmadi", false);
        }

        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setHdd(optionalHDD.get());
        product.setCpu(optionalCPU.get());
        product.setCatalog(optionalCatalog.get());
        product.setDescription(productDto.getDescription());
        product.setBrand(optionalBrand.get());
        product.setPrice(productDto.getPrice());
        product.setRam(optionalRAM.get());
        product.setSsd(optionalSSD.get());
        productRepository.save(product);
        return new Response("Mahsulot tahrirlandi", true);

    }

    public Response delete(Integer id) {
        try {
            productRepository.deleteById(id);
            return new Response("Mahsulot o'chirildi", true);
        } catch (Exception e) {
            return new Response("Mahsulot o'chirilmadi", false);
        }
    }
}
