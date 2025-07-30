package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {
	
	private final ItemRepository repo;
	
	@Autowired
    public OrderController(ItemRepository repo) {
        this.repo = repo;
    }
	
	 @GetMapping("/deleteItem/{id}")
	    public String deleteItem(@PathVariable int id) {
	        repo.deleteById((long) id);
	        return "redirect:/index";
	    }
	    @GetMapping("/order")
	    public String showOrderPage() {
	        return "order"; // Maps to order.html
	    }

	    @PostMapping("/order/submit")
	    public String submitOrder(RedirectAttributes redirectAttributes) {
	        // Optionally add flash attributes for confirmation
	        redirectAttributes.addFlashAttribute("message", "Order placed successfully!");
	        return "redirect:/"; // Redirects to index.html
	    }

	    @GetMapping("/")
	    public String showHomePage(Model model) {
	        return "add"; // Maps to index.html
	    }
	
	

}
