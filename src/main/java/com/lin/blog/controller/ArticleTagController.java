package com.lin.blog.controller;

import com.lin.blog.common.Result;
import com.lin.blog.model.entity.ArticleTag;
import com.lin.blog.model.entity.Category;
import com.lin.blog.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class ArticleTagController {

    @Autowired
    private ArticleTagService articleTagService;
    @GetMapping("/getArticleTagList")
    @ResponseBody
    public Result getArticleTagList() {
        List<ArticleTag> list = articleTagService.getArticleTagList();
        if (list.size() > 0) {
            return Result.success().data("data", list);
        }
        return Result.fail();
    }

}
