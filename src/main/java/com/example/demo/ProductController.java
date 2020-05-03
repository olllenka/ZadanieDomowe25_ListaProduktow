package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("product", new Product());
        return "home";
    }

    @PostMapping("/")
    public String add(Product product){
        productRepository.add(product);
        System.out.println(product.getName() + " " + product.getPrice());
        return "home";
    }

    @GetMapping("/lista")
    public String showList(Model model){
        model.addAttribute("products", productRepository.getAll());
        model.addAttribute("pricesSum", productRepository.getPricesSum());
        return "list";
    }

    @GetMapping("/tabela")
    public String showTable(Model model){
        model.addAttribute("products", productRepository.getAll());
        model.addAttribute("pricesSum", productRepository.getPricesSum());
        return "table";
    }


}
