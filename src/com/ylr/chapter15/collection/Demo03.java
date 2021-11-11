package com.ylr.chapter15.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author By Mr.du
 * @ProjectName idea2020.3.3
 * @ClassName Demo03
 * @Description 集合的操作
 * @date 2021/11/10 19:01
 */

/*
判断
        isEmpty()
        contains(Object o)
        containsAll(Collection c)
 */
//主函数   也 就是程序运行的入口
public class Demo03 {
    public static void main(String[] args) {
        /*//接口是不能直接创建对象的，需要利用此接口的实现类来创建对象
        Collection c = new ArrayList();
        c.add("张三");
        c.add("李四");
        c.add("王二");
        c.add("麻子");
        System.out.println("当前集合的元素为:" + c);
        //false.    isEmpty()判断集合中的元素是否为空，如果集合中有元素返回false,否则返回true
        System.out.println("判断集合是否为空元素："+ c.isEmpty());
        //contains()  判断集合中是否存在指定的元素，如果存在则返回true,否则返回false
        System.out.println("判断集合是否存在指定的元素："+ c.contains("李四四"));*/

        //创建集合对象    在集合中添加自定义的元素？
        //万物皆对象   在我们现实中，凡是能看到的东西都可以抽象成一个对象
        Collection c = new ArrayList();
        Person person = new Person();
        //设置/传入数据
        person.setId(888);
        person.setPassword("123456");
        person.setUsername("张三");

        c.add(person);
        //1b6d3586：一旦对象被创建，就会在内存中开辟一块空间，即就是内存地址
        System.out.println("当前集合中的元素为：" + c);

        //如何获取对象里面存储的数据呢？
        System.out.println("身份证编号是：" + person.getId());
        System.out.println("密码是：" + person.getPassword());
        System.out.println("姓名是：" + person.getUsername());

        //创建一个集合对象
        Collection c1 = new ArrayList();
        Person person1 = new Person();
        person1.setId(120);
        person1.setUsername("杜燊");
        person1.setPassword("123456");
        c1.add(person1);
        c1.add(c);
        System.out.println("当前集合中的元素为：" + c1);

        Collection c2 = new ArrayList();
        c2.add(new Person(666,"123456","王二"));
        c2.add(new Person(888,"654321","麻子"));
        c2.add(new Person(999,"789456","邓林"));
        System.out.println("当前集合的元素为: " + c2);

        Collection c3 = new ArrayList();
        c3.add(new Person(666,"123456","王二"));
        c3.add(new Person(888,"654321","麻子"));
        c3.add(new Person(999,"789456","邓林1"));
        System.out.println("c2集合有包含c3集合中的所有元素吗？ " + c2.containsAll(c3));

        //其实contains方法内部 是依赖于equals方法进行比较的
        System.out.println("存在该元素吗？" + c3.contains(new Person(999,"88888","邓靖旋")));

        /*c.add(new Person(110,"张三"));//传入实参
        c.add(new Person(120,"李四"));*/

    }


}

//创建一个类Person
//创建类的格式：public/private/protect   class  类名{代码块}
//java中自定义标识符的命名规范：类的名称的首字母必须要大写，而且命名的名称要见名知义
//
 class Person{
    //定义变量id,表示人的身份证号
    int id;
    //定义变量password,表示人的账号密码
    String password;
    //定义变量username,表示人的姓名
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //创建一个带有两个参数的构造函数
    //每一个类都默认带有一个无参的构造 函数
    public Person(int id,String password,String username){
        this.id = id;
        this.password = password;
        this.username = username;
    }
    //创建一个无参的构造函数
    public Person(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //重写对象里面的toString()方法
    //任何类都默认继承了一个超级类Object类
    @Override
    public String toString() {
        //[{123,123456,张三}，{110，321654，李四}...........]
        return "{编号 ：" + this.id + " 姓名 ：" + this.username + " 密码 : " + this.password + "}";
    }

    //重写equals()方法  如果重写了此方法就必须要写hashCode()这个方法配合使用

    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        return this.id == p.id;
    }

    @Override
    public int hashCode() {
        //java规范中：一般重写equals方法我们都会重写hashCode方法
        return this.id;
    }
}


