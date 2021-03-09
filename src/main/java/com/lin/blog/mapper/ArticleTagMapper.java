package com.lin.blog.mapper;

import com.lin.blog.model.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleTagMapper {
    List<ArticleTag> getArticleTagList();
}
