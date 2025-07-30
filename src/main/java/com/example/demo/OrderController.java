package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    private final ItemRepository repo;

    @Autowired
    public OrderController(ItemRepository repo) {
        this.repo = repo;
    }

    // Delete an item by ID
    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/index"; // Ensure "/index" route is mapped
    }

    // Show order page (GET /order)
    @GetMapping("/order")
    public String showOrderPage(Model model) {
        model.addAttribute("orderForm", new OrderForm()); // if you're binding a form
        return "order"; // Maps to templates/order.html
    }

    // Handle order submission (POST /order/submit)
    @PostMapping("/order/submit")
    public String submitOrder(@ModelAttribute OrderForm orderForm,
                              RedirectAttributes redirectAttributes) {
        // TODO: Save orderForm data or pass to a service
        redirectAttributes.addFlashAttribute("message", "Order placed successfully!");
        return "redirect:/order";
    }

    // Show home page (GET / or GET /index)
    @GetMapping({"/", "/index"})
    public String showHomePage(Model model) {
        model.addAttribute("items", repo.findAll()); // Assuming you want to display all items
        return "index"; // Maps to templates/index.html
    }
}
