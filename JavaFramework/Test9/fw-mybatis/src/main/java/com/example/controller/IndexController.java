package com.example.controller;

import com.example.mapper.CategoryMapper;
import com.example.mapper.OrderMapper;
import com.example.mapper.ProductMapper;
import com.example.pojo.Category;
import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping({"/", "/index"})
    public ModelAndView index() throws IOException {
        /* 通过 Mybatis 获得数据库数据 */
        // 1、根据配置文件 mybatis-config.xml 得到 sqlSessionFactory
        String resource = "mybatis-config.xml";                                            // 配置文件名
        InputStream in = Resources.getResourceAsStream(resource);                          // 加载配置文件
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);    // 得到 sqlSessionFactory
        // 2、根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        // 3、通过 session 的 selectList 方法，调用 sql 语句 listCategory
        List<Category> resultList = session.selectList("listCategory");

        // 处理结果
        for (Category c : resultList) {
            System.out.println(c.toString());
        }

        // 练习：查询 product 表
        System.out.println("练习：查询 product 表");
        List<Product> productList = session.selectList("listProduct");
        for (Product p : productList) {
            System.out.println(p.toString());
        }

        // 动态 SQL
        System.out.println("动态 SQL");
        Map<String, Object> paramMapProduct = new HashMap<>();
        paramMapProduct.put("name", "荣耀");
        paramMapProduct.put("price", 2000);
        List<Product> productListByName = session.selectList("listProduct", paramMapProduct);
        for (Product p : productListByName) {
            System.out.println(p.toString());
        }

        // 动态 SQL: foreach
        System.out.println("动态 SQL: foreach");
        List<Integer> idList = new ArrayList<>();
        idList.add(2);
        idList.add(4);
        idList.add(6);
        List<Product> productList1 = session.selectList("listProductIn", idList);
        for (Product p : productList1) {
            System.out.println(p.toString());
        }


        // 测试：给 category 表增加数据
//        Category category = new Category();
//        category.setName("联想");
//        session.insert("addCategory", category);

        // 测试：更新 category 表
//        Category c2 = new Category();
//        c2.setId(1);
//        c2.setName("VIVO");
//        session.update("updateCategory", c2);

        // 测试：查询 category 表
        Category c3 = session.selectOne("getCategory", 1);
        System.out.println(c3.getName());

        // 提交
//        session.commit();    // mybatis 默认不自动提交事务

        // 测试：模糊搜索
        System.out.println("测试：模糊搜索");
        Map<String, Object> paramMap = new HashMap<>();    // 需要传入多个参数时
        paramMap.put("id", 4);          // id 大于 5
        paramMap.put("name", "荣耀");    // name 包含“荣耀”
        List<Product> proList = session.selectList("listProductByName", paramMap);
        for (Product p : proList) {
            System.out.println(p.toString());
        }

        // 测试：联结查询（一对多）
        System.out.println("测试：联结查询（一对多）");
        List<Category> cateList = session.selectList("listCategoryWithProduct");
        for (Category c: cateList) {
            System.out.println(c.toString());
            // 得到该分类下的商品列表
            List<Product> plist = c.getProductList();
            for (Product p : plist) {
                System.out.println("\t" + p.toString());
            }
        }

        // 测试：联结查询（多对一）
        System.out.println("测试：联结查询（多对一）");
        List<Product> pList = session.selectList("listProductWithCategory");
        for (Product p : pList) {
            System.out.println(p.toString() + " --> " + p.getCategory().toString());
        }

        // 测试：联结查询（多对多）
        System.out.println("测试：联结查询（多对多）");
        List<Order> orderList = session.selectList("listOrderWithItem");
        for (Order o : orderList) {
            System.out.println(o.toString());
            List<OrderItem> orderItemList = o.getOrderItemList();
            for (OrderItem oi : orderItemList) {
                System.out.println("\t" + oi.toString());
            }
        }

        // 测试：注解方式
        System.out.println("测试：注解方式");
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);    // 注解方式：需要得到 Mapper
        Category category = categoryMapper.get(2);
        System.out.println(category.toString());

        // 测试：注解方式，传入 Map
        System.out.println("测试：注解方式，传入 Map");
        Map<String, Integer> params = new HashMap<>();
        params.put("begin", 1);
        params.put("length", 2);
        List<Category> categoryList = categoryMapper.list(params);
        for (Category c : categoryList) {
            System.out.println(c.toString());
        }

        // 测试：注解方式，设置了 Result
        System.out.println("测试：注解方式，设置了 Result");
        ProductMapper productMapper = session.getMapper(ProductMapper.class);
        List<Product> productList2 = productMapper.listByCategory(1);
        for (Product p : productList2) {
            System.out.println(p.toString());
        }

        // 测试：注解方式，一对多
        System.out.println("测试：注解方式，一对多");
        List<Category> categoryList1 = categoryMapper.listWithProduct();
        for (Category c : categoryList1) {
            System.out.println(c.toString());
            for (Product p : c.getProductList()) {
                System.out.println("\t"+ p.toString());
            }
        }

        // 测试：注解方式，多对一
        System.out.println("测试：注解方式，多对一");
        List<Product> productList3 = productMapper.listWithCategory();
        for (Product p : productList3) {
            System.out.println(p.toString());
            System.out.println("\t" + p.getCategory().toString());
        }

        // 测试：注解方式，多对多
        System.out.println("测试：注解方式，多对多");
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        List<Order> orderList1 = orderMapper.listWith();
        for (Order o : orderList1) {
            System.out.println(o.toString());
            List<OrderItem> orderItemList = o.getOrderItemList();
            for (OrderItem oi : orderItemList) {
                System.out.println("\t" + oi.toString());
                System.out.println("\t\t" + oi.getProduct().toString());
            }
        }

        // 视图对象
        return new ModelAndView("index");
    }
}
