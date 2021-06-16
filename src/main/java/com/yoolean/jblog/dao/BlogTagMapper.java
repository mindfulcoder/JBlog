package com.yoolean.jblog.dao;

import com.yoolean.jblog.entity.BlogTag;
import com.yoolean.jblog.entity.BlogTagCount;
import com.yoolean.jblog.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BlogTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    BlogTag selectByPrimaryKey(Integer tagId);

    BlogTag selectByTagName(String tagName);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);

    List<BlogTag> findTagList(PageQueryUtil pageUtil);

    List<BlogTagCount> getTagCount();

    int getTotalTags(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    int batchInsertBlogTag(List<BlogTag> tagList);
}