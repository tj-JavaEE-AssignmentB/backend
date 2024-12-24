package com.tj_JavaEE.service;

import com.tj_JavaEE.dto.Category;
import com.tj_JavaEE.dto.pst;

import java.util.List;

import com.tj_JavaEE.dto.CategoryAddInfo;

public interface CategoryService {

    List<Category> getAllCategories();

    List<pst> getPostsByCategory(long categoryId);
    void categoryAdd(CategoryAddInfo categoryAddInfo);
}
