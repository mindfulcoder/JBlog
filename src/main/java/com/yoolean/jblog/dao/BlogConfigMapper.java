package com.yoolean.jblog.dao;

import com.yoolean.jblog.entity.BlogConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BlogConfigMapper {
    List<BlogConfig> selectAll();

    BlogConfig selectByPrimaryKey(String configName);

    int updateByPrimaryKeySelective(BlogConfig record);

}