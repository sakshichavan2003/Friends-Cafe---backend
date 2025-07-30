package com.example.demo;

import java.util.Map;

 // ✅ Make sure this is your actual Items model
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItemController {

    private final ItemRepository repo;

    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/index")
    public String viewHomePage(Model model) {
        model.addAttribute("listItems", repo.findAll());
        return "index";
    }
//    @GetMapping("/order")
//    public String order() {
//   
//        return "order";
//    }

    @GetMapping("/showNewItem")
    public String showNewItem(Model model) {
        model.addAttribute("item", new Item());

        // Dropdown values with labels
        model.addAttribute("hotCoffeeOptions", Map.of(
                "Espresso", "Espresso - ₹100",
                "Cappuccino", "Cappuccino - ₹120",
                "Latte", "Latte - ₹130"
        ));

        model.addAttribute("coldCoffeeOptions", Map.of(
                "Cold Brew", "Cold Brew - ₹110",
                "Iced Latte", "Iced Latte - ₹140",
                "Frappuccino", "Frappuccino - ₹150"
        ));

        model.addAttribute("pizzaCoffeeOptions", Map.of(
                "Chees & corn", "Chees & corn - ₹110",
                "Chees & paneer", "Chees & paneer - ₹140",
                "Tandoor", "Tandoor - ₹150"
        ));

        return "add";
    }

    @PostMapping("/saveItem")
    public String saveItems(@ModelAttribute("item") Item item) {
        item.calculatePrice(); // ✅ calculate total price based on selections
        repo.save(item);
        return "redirect:/index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("item", new Item()); // or whatever your model class is
        return "add";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Item item = repo.findById((long) id).orElseThrow();
        model.addAttribute("item", item);

        // Add dropdown options again for editing
        model.addAttribute("hotCoffeeOptions", Map.of(
                "Espresso", "Espresso - ₹100",
                "Cappuccino", "Cappuccino - ₹120",
                "Latte", "Latte - ₹130"
        ));

        model.addAttribute("coldCoffeeOptions", Map.of(
                "Cold Brew", "Cold Brew - ₹110",
                "Iced Latte", "Iced Latte - ₹140",
                "Frappuccino", "Frappuccino - ₹150"
        ));

        model.addAttribute("pizzaCoffeeOptions", Map.of(
                "Chees & corn", "Chees & corn - ₹110",
                "Chees & paneer", "Chees & paneer - ₹140",
                "Tandoor", "Tandoor - ₹150"
        ));

        
        return "edit";
    }   
}
