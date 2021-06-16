package com.yoolean.jblog.controller.blog;

import com.yoolean.jblog.controller.vo.BlogDetailVO;
import com.yoolean.jblog.entity.BlogComment;
import com.yoolean.jblog.entity.BlogLink;
import com.mindcoder.jblog.service.*;
import com.mindcoder.jblog.util.*;
import com.mindfulcoder.jblog.service.*;
import com.mindfulcoder.jblog.util.*;
import com.yoolean.jblog.service.*;
import com.yoolean.jblog.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
@Controller
public class MyBlogController {

    //public static String theme = "default";
    //public static String theme = "yummy-jekyll";
    public static String theme = "amaze";
    @Resource
    private BlogService blogService;
    @Resource
    private TagService tagService;
    @Resource
    private LinkService linkService;
    @Resource
    private CommentService commentService;
    @Resource
    private ConfigService configService;
    @Resource
    private CategoryService categoryService;

    /**
     * 首页
     *
     * @return
     */
    @GetMapping({"/", "/index", "index.html"})
    public String index(Model model) {
        return this.page(model, 1);
    }

    /**
     * 首页 分页数据
     *
     * @return
     */
    @GetMapping({"/page/{pageNum}"})
    public String page(Model model, @PathVariable("pageNum") int pageNum) {
        PageResult blogPageResult = blogService.getBlogsForIndexPage(pageNum);
        if (blogPageResult == null) {
            return "error/error_404";
        }
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        model.addAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("pageName", "首页");
        model.addAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/index";
    }

    /**
     * Categories页面(包括分类数据和标签数据)
     *
     * @return
     */
    @GetMapping({"/categories"})
    public String categories(Model model) {
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("pageName", "分类页面");
        model.addAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/category";
    }

    /**
     * 详情页
     *
     * @return
     */
    @GetMapping({"/blog/{blogId}", "/article/{blogId}"})
    public String detail(Model model, @PathVariable("blogId") Long blogId, @RequestParam(value = "commentPage", required = false, defaultValue = "1") Integer commentPage) {
        BlogDetailVO blogDetailVO = blogService.getBlogDetail(blogId);
        if (blogDetailVO != null) {
            model.addAttribute("blogDetailVO", blogDetailVO);
            model.addAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
        }
        model.addAttribute("pageName", "详情");
        model.addAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/detail";
    }

    /**
     * 标签列表页
     *
     * @return
     */
    @GetMapping({"/tag/{tagName}"})
    public String tag(Model model, @PathVariable("tagName") String tagName) {
        return tag(model, tagName, 1);
    }

    /**
     * 标签列表页
     *
     * @return
     */
    @GetMapping({"/tag/{tagName}/{page}"})
    public String tag(Model model, @PathVariable("tagName") String tagName, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageByTag(tagName, page);
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("pageName", "标签");
        model.addAttribute("pageUrl", "tag");
        model.addAttribute("keyword", tagName);
        model.addAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        model.addAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
    }

    /**
     * 分类列表页
     *
     * @return
     */
    @GetMapping({"/category/{categoryName}"})
    public String category(Model model, @PathVariable("categoryName") String categoryName) {
        return category(model, categoryName, 1);
    }

    /**
     * 分类列表页
     *
     * @return
     */
    @GetMapping({"/category/{categoryName}/{page}"})
    public String category(Model model, @PathVariable("categoryName") String categoryName, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageByCategory(categoryName, page);
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("pageName", "分类");
        model.addAttribute("pageUrl", "category");
        model.addAttribute("keyword", categoryName);
        model.addAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        model.addAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
    }

    /**
     * 搜索列表页
     *
     * @return
     */
    @GetMapping({"/search/{keyword}"})
    public String search(Model model, @PathVariable("keyword") String keyword) {
        return search(model, keyword, 1);
    }

    /**
     * 搜索列表页
     *
     * @return
     */
    @GetMapping({"/search/{keyword}/{page}"})
    public String search(Model model, @PathVariable("keyword") String keyword, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageBySearch(keyword, page);
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("pageName", "搜索");
        model.addAttribute("pageUrl", "search");
        model.addAttribute("keyword", keyword);
        model.addAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        model.addAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/list";
    }


    /**
     * 友情链接页
     *
     * @return
     */
    @GetMapping({"/link"})
    public String link(Model model) {
        model.addAttribute("pageName", "友情链接");
        Map<Byte, List<BlogLink>> linkMap = linkService.getLinksForLinkPage();
        if (linkMap != null) {
            //判断友链类别并封装数据 0-友链 1-推荐 2-个人网站
            if (linkMap.containsKey((byte) 0)) {
                model.addAttribute("favoriteLinks", linkMap.get((byte) 0));
            }
            if (linkMap.containsKey((byte) 1)) {
                model.addAttribute("recommendLinks", linkMap.get((byte) 1));
            }
            if (linkMap.containsKey((byte) 2)) {
                model.addAttribute("personalLinks", linkMap.get((byte) 2));
            }
        }
        model.addAttribute("configurations", configService.getAllConfigs());
        return "blog/" + theme + "/link";
    }

    /**
     * 评论操作
     */
    @PostMapping(value = "/blog/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request, HttpSession session,
                          @RequestParam Long blogId, @RequestParam String verifyCode,
                          @RequestParam String commentator, @RequestParam String email,
                          @RequestParam String websiteUrl, @RequestParam String commentBody) {
        if (StringUtils.isEmpty(verifyCode)) {
            return ResultGenerator.genFailResult("验证码不能为空");
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (!verifyCode.equals(kaptchaCode)) {
            return ResultGenerator.genFailResult("验证码错误");
        }
        String ref = request.getHeader("Referer");
        if (StringUtils.isEmpty(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (null == blogId || blogId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (StringUtils.isEmpty(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (StringUtils.isEmpty(email)) {
            return ResultGenerator.genFailResult("请输入邮箱地址");
        }
        if (!PatternUtil.isEmail(email)) {
            return ResultGenerator.genFailResult("请输入正确的邮箱地址");
        }
        if (StringUtils.isEmpty(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResultGenerator.genFailResult("评论内容过长");
        }
        BlogComment comment = new BlogComment();
        comment.setBlogId(blogId);
        comment.setCommentator(MyBlogUtils.cleanString(commentator));
        comment.setEmail(email);
        if (PatternUtil.isURL(websiteUrl)) {
            comment.setWebsiteUrl(websiteUrl);
        }
        comment.setCommentBody(MyBlogUtils.cleanString(commentBody));
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }

    /**
     * 关于页面 以及其他配置了subUrl的文章页
     *
     * @return
     */
    @GetMapping({"/{subUrl}"})
    public String detail(Model model, @PathVariable("subUrl") String subUrl) {
        BlogDetailVO blogDetailVO = blogService.getBlogDetailBySubUrl(subUrl);
        if (blogDetailVO != null) {
            model.addAttribute("blogDetailVO", blogDetailVO);
            model.addAttribute("pageName", subUrl);
            model.addAttribute("configurations", configService.getAllConfigs());
            return "blog/" + theme + "/detail";
        } else {
            return "error/error_400";
        }
    }
}
