package com.tj_JavaEE.controller;

import com.tj_JavaEE.dto.CategoryAddInfo;
import com.tj_JavaEE.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categoryAdd")
    public ResponseEntity<Boolean> categoryAdd(CategoryAddInfo categoryAddInfo){
        System.out.println(categoryAddInfo.getCategoryName());
        System.out.println(categoryAddInfo.getDescription());
        System.out.println(categoryAddInfo.getImage().isEmpty());
        categoryService.categoryAdd(categoryAddInfo);
        return ResponseEntity.ok(true);
    }
}
