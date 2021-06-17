package com.charter.rewardsprogram.controllers;

import com.charter.rewardsprogram.data.CustomerRepository;
import com.charter.rewardsprogram.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String displayAllData(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }
}
