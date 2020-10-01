package hh.swd20.bookstore.web;

import hh.swd20.bookstore.domain.CategoryRepository;

import hh.swd20.bookstore.domain.Category;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.CategoryRepository;
@Controller
public class CategoryController {

	 @Autowired
	 private CategoryRepository crepository;
		
		@RequestMapping("/categorylist")
		public String categoryList(Model model) {
		     model.addAttribute("categories", crepository.findAll());
			
			return "categorylist";
}
		
		@RequestMapping(value = "/addcategory")
		public String addCategory(Model model) {
			model.addAttribute("category", new Category());
			return "addcategory";
		}
		
		@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
		public String save(Category c) {
			crepository.save(c);
			return "redirect:categorylist";
		}
}
