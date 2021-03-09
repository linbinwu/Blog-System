package com.lin.blog.controller;

import com.lin.blog.common.Result;
import com.lin.blog.model.entity.Category;
import com.lin.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    @ResponseBody
    public Result getCategoryList() {
        List<Category> list = categoryService.getCategoryList();
        if (list.size() > 0) {
            return Result.success().data("data", list);
        }
        return Result.fail();
    }

}
