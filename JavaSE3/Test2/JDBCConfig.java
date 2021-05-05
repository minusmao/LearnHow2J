/**
 * 文件名：JDBCConfig.java
 * 作者：TechRice
 * 功能：测试 How2J 网站 -> Java中级 -> 注解
 * 时间：2021-5-5
 */

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Inherited;
import java.lang.annotation.Documented;

@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface JDBCConfig {
    String ip();
    int port() default 3306;
    String database();
    String encoding();
    String loginName();
    String password();
}

/* 元注解 */
/*=======================
@Target 表示这个注解能放在什么位置上
    ElementType.TYPE：能修饰类、接口或枚举类型
    ElementType.FIELD：能修饰成员变量
    ElementType.METHOD：能修饰方法
    ElementType.PARAMETER：能修饰参数
    ElementType.CONSTRUCTOR：能修饰构造器
    ElementType.LOCAL_VARIABLE：能修饰局部变量
    ElementType.ANNOTATION_TYPE：能修饰注解
    ElementType.PACKAGE：能修饰包

@Retention 表示生命周期
    RetentionPolicy.SOURCE：注解只在源代码中存在，编译成class之后，就没了
    RetentionPolicy.CLASS： 默认值，注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了
    RetentionPolicy.RUNTIME： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息

@Inherited 表示该注解具有继承性

@Documented 表示在用javadoc命令生成API文档后，文档里会出现该注解说明

@Repeatable（java1.8 新增） 当没有@Repeatable修饰的时候，注解在同一个位置，只能出现一次
=======================*/