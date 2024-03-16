package com.example.mcdse105.controller;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mcdse105.entity.Product;
import com.example.mcdse105.service.CustomUserDetails;
import com.example.mcdse105.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/productsProcces")
	public String getProductsProcces(Model model, @AuthenticationPrincipal CustomUserDetails loggedInUser) {
		model.addAttribute("username", loggedInUser.getUsername());
		String role = loggedInUser.getAuthorities().iterator().next().getAuthority();

	    if ("ADMIN".equals(role)) {
	        return "redirect:/products"; // Return admin view
	    } else if ("USER".equals(role)) {
	        return "redirect:/productview"; // Return user view
	    } else {
	        // Handle other roles or unauthenticated users
	        return "login"; // Return an error view
	    }
	}
	
	
	@GetMapping("/products")
	public String getProductsPage(Model model, @AuthenticationPrincipal CustomUserDetails loggedInUser) {
		model.addAttribute("username", loggedInUser.getUsername());
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/products/NewProduct")
	public String getNewProductPage() {
		
		return "product-NewProduct";
	}
	
	@PostMapping("/products/NewProduct")
	public String AddNewProduct(Model model, @ModelAttribute("product") Product product) {
		
			productService.addNewProduct(product);
			return "redirect:/products";
		}
	
	
	@GetMapping("/products/{id}")
	public String getProductPage(Model model, @PathVariable("id") Long id) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "product";
	}
	
	@PostMapping("/products/{id}/update") 
	public String updateProduct(Model model, @ModelAttribute("product") Product product, @PathVariable("id") Long id) {
		productService.updateProductDetails(id, product);
		model.addAttribute("msg" , "Product updated succesfully.");
		return "product";
	}
	
	@GetMapping("/products/{id}/delete")
	public String deleteProduct(@PathVariable("id")Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
	
	@GetMapping("/productsview")
	public String getProductView(Model model, @AuthenticationPrincipal CustomUserDetails loggedInUser) {
		model.addAttribute("username", loggedInUser.getUsername());
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "productsview";
	}
	
	@GetMapping("/products/search")
    public String searchProducts(@RequestParam("name") String name, Model model, @AuthenticationPrincipal CustomUserDetails loggedInUser) {
		model.addAttribute("username", loggedInUser.getUsername());
        List<Product> products = productService.searchProductsByName(name);
        model.addAttribute("products", products);
        return "products"; 
    }
		
	
	}

