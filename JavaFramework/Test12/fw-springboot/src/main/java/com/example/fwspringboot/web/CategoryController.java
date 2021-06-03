package com.example.fwspringboot.web;

import com.example.fwspringboot.mapper.CategoryMapper;
import com.example.fwspringboot.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {
    /* 对象属性 */
    private final CategoryMapper categoryMapper;    // DAO 层

    @Autowired
    public CategoryController(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @RequestMapping("list")
    public String list(Model model) {
        // 调用 DAO 层查询数据
        List<Category> categoryList = categoryMapper.list(0, 5);    // 测试 Mybatis 用 注解方式
        categoryList.add(categoryMapper.findById(1));                            // 测试 Mybatis 用 XML 方式

        // 添加查询到的结果
        model.addAttribute("categoryList", categoryList);

        return "categoryList";
    }

    /* PageHelper 测试 */
    @RequestMapping("add")
    public String add(Category category) throws Exception {
        // 调用 DAO 层，增加数据
        categoryMapper.save(category);

        return "redirect:listPage";
    }
    @RequestMapping("delete")
    public String delete(Category category) throws Exception {
        // 调用 DAO 层，删除数据
        categoryMapper.delete(category.getId());

        return "redirect:listPage";
    }
    @RequestMapping("update")
    public String update(Category category) throws Exception {
        // 调用 DAO 层，更新数据
        categoryMapper.update(category);

        return "redirect:listPage";
    }
    @RequestMapping("listPage")
    public String listPage(Model model,
                           @RequestParam(value = "start", defaultValue = "0") int start,
                           @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        // 设置 PageHelper
        PageHelper.startPage(start, size, "id DESC");

        // 得到查询结果
        List<Category> categoryList = categoryMapper.listAll();
        PageInfo<Category> page = new PageInfo<>(categoryList);

        // 添加参数
        model.addAttribute("page", page);

        return "categoryListPage";
    }
}
