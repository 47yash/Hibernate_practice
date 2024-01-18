

package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.model.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/getproducts")
	public ModelAndView getProducts(HttpSession session) {
		MyUser u=(MyUser) session.getAttribute("user");
		if(u!=null) {
			System.out.println(u);
			List<Product> plist=pservice.getAllProducts();
			return new ModelAndView("displayproduct","plist",plist);
			
		}
		return new ModelAndView("redirect:/login/");
	}
	
	@GetMapping("/addproduct")
	public String displayaddform(HttpSession session) {
		MyUser u=(MyUser)session.getAttribute("user");
		if(u!=null) {
			return "addproduct";
		}
		
		
		return "redirect:/login/";
		
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct(@RequestParam int pid, @RequestParam String pname,@RequestParam int qty,@RequestParam double price) {
		
		Product p=new Product(pid,pname,qty,price);
		pservice.addnewProperty(p);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") int pid){
		System.out.println("edit="+pid);
		Product p=pservice.getById(pid);
		System.out.println("edit="+p);
		return new ModelAndView("editProduct","p",p);
			
		}
	
	@PostMapping("/updateProduct")
	
		public ModelAndView updateProduct(@RequestParam int pid, @RequestParam String pname,@RequestParam int qty,@RequestParam double price) {
		System.out.println("update="+pid);
		pservice.updateById(new Product(pid,pname,qty,price));
		
		return new ModelAndView("redirect:/product/getproducts");
		
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int pid) {
		pservice.deleteProduct(pid);
		return new ModelAndView("redirect:/product/getproducts");
	}
		
}
	


