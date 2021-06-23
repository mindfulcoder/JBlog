package com.yoolean.jblog.controller.admin;

import com.yoolean.jblog.entity.UserDetail;
import com.yoolean.jblog.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private AdminUserService adminUserService;
    @Resource
    private BlogService blogService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private LinkService linkService;
    @Resource
    private TagService tagService;
    @Resource
    private CommentService commentService;


    @GetMapping({"/login"})
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        model.addAttribute("path", "index");
        model.addAttribute("categoryCount", categoryService.getTotalCategories());
        model.addAttribute("blogCount", blogService.getTotalBlogs());
        model.addAttribute("linkCount", linkService.getTotalLinks());
        model.addAttribute("tagCount", tagService.getTotalTags());
        model.addAttribute("commentCount", commentService.getTotalComments());
        return "admin/index";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        UserDetail userDetail = adminUserService.findUserDetail(principal.getName());
        if (userDetail == null) {
            return "admin/login";
        }
        model.addAttribute("path", "profile");
        model.addAttribute("userDetail", userDetail);
        return "admin/profile";
    }

    @GetMapping("/password")
    public String password(Model model, Principal principal) {
        UserDetail userDetail = adminUserService.findUserDetail(principal.getName());
        if (userDetail == null) {
            return "admin/login";
        }
        model.addAttribute("path", "password");
        model.addAttribute("userDetail", userDetail);
        return "admin/password";
    }

    @PostMapping("/password")
    @ResponseBody
    public String updatePassword(Principal principal, HttpSession session, @RequestBody Map<String,String> params) {
        try {
            String oldPassword=params.get("oldPassword");
            String newPassword=params.get("newPassword");
            if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)) {
                return "参数不能为空";
            }
            adminUserService.updatePassword(principal.getName(), oldPassword, newPassword);
            session.invalidate();
            return "success";
        } catch (Exception e) {
            LOGGER.error("Failed to update password", e);
            return "failure";
        }
    }

    @PostMapping("/profile/detail")
    @ResponseBody
    public String updateDetail(UserDetail userDetail) {
        try {
            adminUserService.updateUserDetail(userDetail);
            return "success";
        } catch (Exception e) {
            LOGGER.error("Fail to update user detail", e);
            return "failure";
        }
    }

}
