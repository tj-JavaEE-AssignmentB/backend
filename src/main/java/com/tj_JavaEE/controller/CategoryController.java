package com.tj_JavaEE.controller;

import com.tj_JavaEE.entity.Result;
import com.tj_JavaEE.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result getAllCategory() {
        return Result.success(categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public Result getCategoryById(@PathVariable("categoryId") long categoryId) {
        return Result.success(categoryService.getPostsByCategory(categoryId));
    }
}
