package com.uep.wap.controller;

import com.uep.wap.dto.CategoryDTO;
import com.uep.wap.model.Category;
import com.uep.wap.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categoryController")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {this.categoryService = categoryService;}

    @GetMapping(path = "/getCategories")
    public Iterable<Category> getAllCategories() {return categoryService.getAllCategories();}

    @PostMapping(path = "/addCategory")
    public String addCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.addCategory(categoryDTO);
        return "Category added!";
    }
}
