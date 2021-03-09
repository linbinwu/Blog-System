package com.lin.blog.service.Impl;

import com.lin.blog.common.Result;
import com.lin.blog.mapper.CategoryMapper;
import com.lin.blog.model.entity.Category;
import com.lin.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }
}
