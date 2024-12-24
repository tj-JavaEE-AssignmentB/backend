package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.dto.Category;
import com.tj_JavaEE.dto.pst;
import com.tj_JavaEE.mapper.CategoryMapper;
import com.tj_JavaEE.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceimpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories(){
        return categoryMapper.getAll();
    }

    @Override
    public List<pst> getPostsByCategory(long categoryId){
        return categoryMapper.getPostsByCategory(categoryId);
    }


}
