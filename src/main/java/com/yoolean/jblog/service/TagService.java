package com.yoolean.jblog.service;

import com.yoolean.jblog.entity.BlogTagCount;
import com.yoolean.jblog.util.PageQueryUtil;
import com.yoolean.jblog.util.PageResult;

import java.util.List;

public interface TagService {

    /**
     * 查询标签的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    int getTotalTags();

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();
}
