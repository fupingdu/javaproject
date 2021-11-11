package com.ylr.chapter15.collection;

/**
 * @author By Mr.du  作者
 * @ProjectName idea2020.3.3  项目名称（项目工作空间）
 * @ClassName Demo01
 * @Description 集合的引入
 * @date 2021/11/8 20:19
 */

/*
复习：
 数组：是存储同一种数据类型的集合容器
    数组的语法格式：数据类型[]  变量的名称 = 赋值 [10]
                            案例：创建一个字符串的引用数据类型
                                String[] str = new String[10];

    java中的基本数据类型：
    四类八种
    数值型
        byte short int long
    字符型
        char
    布尔型
        boolean   true/false
    浮点型
        float  单精度
        double  双精度

        引用数据类型：
        String  Object  自定义的类.....

数组:是存储同一种数据类型的集合容器
    数组的特点:
        1.只能存储同一种数据类型的数据;
        2.一旦数组被初始化,长度必须固定;
        3.数组中的元素与元素之间的内存地址是连续的.

需求:收集我们班同学的兴趣爱好
    String[] str = new String[50];
    问题:班上的同学他们的爱好是各不相同,如果大家的爱好各不相同,意味着我们在
    创建数组的时候不好固定数组的长度?
    以上情况,如果使用数组的方式是无法满足的,这个我们就需要使用集合

    注意:object类是一个超级类,Object类型的数组可以存储任意类型的数据.

    在idea中，代码的注释快捷键：
        1.ctrl+/,表示单行注释
        2.ctrl+shift+/,表示多行注释，即注释代码 块

 */
public class Demo01 {
    public static void main(String[] args) {
        String[] str = new String[50];//必须要给定数组的长度,否则要报错
        /*str[1] = "zhangsan";
        //str[2] = 123;//说明String类型的字符串数组是不支持整型的数据
        //str[2] = 'c';//字符串是用双引号,字符是用单引号
        //str[2] = 50.5;//因为是浮点型数据

        str[2] = "lisi";
        str[3] = "wanger";
        System.out.println(str[3]);
        System.out.println(str[2]);
        System.out.println(str[1]);*/


        //使用Object类，实现不同类型的数据的存储
        //比如班级数据：学生的姓名(字符串)   学生的年龄（整型）   学生的班级(字符串)   学生体重（浮点型 ）  学生的爱好 .......
        Object[] arr = new Object[500];
        arr[1] = "zhangsan";
        arr[2] = 20;
        arr[3] = 50.5;
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
    }

}
