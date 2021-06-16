package com.example.product_manager.controllers;

import com.example.product_manager.models.Product;
import com.example.product_manager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Product> products = service.getAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product){
        service.saveProduct(product);
        return "redirect:/view/";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model){
        Product product = service.getId(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/view/";
    }
}
