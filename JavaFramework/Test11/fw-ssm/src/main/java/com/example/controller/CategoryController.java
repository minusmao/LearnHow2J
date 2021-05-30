package com.example.controller;

import com.example.pojo.Category;
import com.example.service.CategoryService;
import com.example.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {
    /* 对象属性 */
    private final CategoryService categoryService;    // 表 category 的 Service 层

    /* 构造方法：全参 */
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /* 对象方法 */
    // 路径：list，分页显示
    @RequestMapping("list")
    public ModelAndView list(Page page) {
        // 视图对象
        ModelAndView mav = new ModelAndView("listCategory");

        // 调用 Service 层
        List<Category> categoryList = categoryService.list(page);    // 分页查询
        int total = categoryService.total();                         // 查询总数

        // 更新 page 对象
        page.calculateLast(total);    // 更新后无需添加到 Attribute 中，已存在

        // 查询结果添加到 Attribute 中，范围 requestScope
        mav.addObject("categoryList", categoryList);

        return mav;
    }
    // 路径：listPage，分页显示，使用 pagehelper 插件
    @RequestMapping("listPage")
    public ModelAndView listPage(Page page) {
        // 视图对象
        ModelAndView mav = new ModelAndView("listCategory");

        // 先设置 PageHelper
        PageHelper.offsetPage(page.getStart(), page.getCount());      // 设置开始的位置和查询的个数
        // 调用 Service 层，开始查询
        List<Category> categoryList = categoryService.listPage();     // 因为先设置了 PageHelper 所以不会返回全部内容
        // 查询总数
        int total = (int) new PageInfo<>(categoryList).getTotal();    // 暂时还不知道为什么能得到数据总数
        System.out.println("已查询的数据个数：" + categoryList.size() + "，数据总数：" + total);

        // 更新 page 对象
        page.calculateLast(total);    // 更新后无需添加到 Attribute 中，已存在

        // 查询结果添加到 Attribute 中，范围 requestScope
        mav.addObject("categoryList", categoryList);

        return mav;
    }
    // 路径：add，添加分类
    @RequestMapping("add")
    public ModelAndView add(Category category) {
        // 视图对象
        ModelAndView mav = new ModelAndView("redirect:listPage");    // 设置为客户端跳转

        //  Service 层，添加数据
        categoryService.add(category);
        System.out.println("数据添加成功：" + category.toString());

        return mav;
    }
    // 路径：testUtf，测试表单中文输入问题
    @RequestMapping("testUtf")
    public ModelAndView testUtf(Category category) {
        // 查看是否乱码
        // get 请求不会乱码，post 请求会乱码，需在 web.xml 中配置 CharacterEncodingFilter 过滤器
        System.out.println("中文输入是否乱码：" + category.getName());

        return new ModelAndView("redirect:../index.html");    // 客户端跳转
    }
}
