package com.lin.blog.service.Impl;

import com.lin.blog.mapper.ArticleTagMapper;
import com.lin.blog.model.entity.ArticleTag;
import com.lin.blog.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagServiceImpl implements ArticleTagService {

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    public List<ArticleTag> getArticleTagList() {
        return articleTagMapper.getArticleTagList();
    }
}
