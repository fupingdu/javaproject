package com.ylr.chapter15.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author By Mr.du
 * @ProjectName idea2020.3.3
 * @ClassName Demo04
 * @Description TODO
 * @date 2021/11/11 14:39
 */

/*
迭代
    iterator()  跌代器
    toArray() 将集合转化成object数组形式
    toArray(T[] a)

--------|    Collection集合接口类，是一个根接口
-----------|   List是Collection接口类的一个子接口，它是实现List接口类的Arraylist类，它的特征：有序的，可重复的
-----------|   Set是Collection接口类的一个子接口，它是实现了Set接口类的HashSet类 它的特征：无序的，不可重复的

 */
public class Demo04 {

    public static void main(String[] args) {
        //collection是一个集合类对象，集合是不能直接实例化对象的，但是我们可以通过此接口的实现类来创建一个对象

        //创建一个集合对象  实例化一个对象
        Collection c = new ArrayList();
        c.add("张三");
        c.add("李四");
        c.add("王二");
        c.add("麻子");

        System.out.println("当前集合中的元素为:" + c);

        Object[] arr = c.toArray();//把集合中的元素全部存储到一个Object类的数组中返回

        System.out.println(Arrays.toString(arr));//Arrays数组操作的工具类

        Collection c1 = new ArrayList();
        c1.add(new Person(110,"123456","张三"));
        c1.add(new Person(120,"321654","李四"));
        c1.add(new Person(119,"65545f3","王二"));
        c1.add(new Person(888,"879793","麻子"));

        //方案1：如何遍历合集中的元素-----》方式一：可以使用toArray()方法来实现
        //自定义标识符命名规范：变量与变量是不能同名的
        //从object数组中取出的元素只能使用Object类型声明变量进行接收，
        Object[] arrs = c1.toArray();
        System.out.println(arrs.length);//length可以获取数组的长度
        for (int i = 0; i < arrs.length; i++) {

            // 如果我们需要其它的类型的数据就需要 进行强制 类型转换
            /**
             数据类型转换：
                1.如果小类型数据转换成大类型数据，程序是可以自动转换的，不需要手动操作
                2.如果大类型数据转换成小类型数据，程序是不能自动转换的，此时需要我们手动进行转换
                        转换的语法格式 ：小数据类型   对象名称 = （小数据类型）大数据类型；
             */
            Person person = (Person) arrs[i];

            //需求：如果ID身份证号为120,就执行输出操作
            if (person.id == 120){
                System.out.println(person.getUsername());
                System.out.println(person.getPassword());
            }
        }
        //System.out.println(Arrays.toString(arrs));

        //方案二：可以使用iterator迭代器遍历集合中数据
        /*
        Collection---迭代的方法：
                toArray()
                iterator()
         迭代器的作用是什么呢？
            答：就是用于抓取集合中的元素1

            hasNext()  问：是否有元素可以遍历。如果有元素可以遍历，并返回true，否则就返回false
            next()  获取元素
            remove() 移除迭代器最后 一个返回 的元素

         */
        //iterator()迭代器
        /*
        返回的是一个迭代器
        疑问：iterator()方法返回的是一个接口类型，为什么接口类型又可以调用方法并能使用呢？
                   实际上，iterator()返回的是iterator接口的实现类对象。此处和多态有关系 了

         面向对象的特征？
            封装
            继承
            多态
         */
        Iterator it = c1.iterator();
        //it.next();
        //System.out.println("当前迭代器的元素为：" );
        /*while (it.hasNext()){//问：是否有元素可以遍历
            System.out.println("-------------");
            //System.out.println(it.next());
            //it.next();//获取元素
            Person person = (Person) it.next();
            System.out.println(person.getId());
            System.out.println(person.getPassword());
            System.out.println(person.getUsername());
        }*/

        //测试remove()的用法
        /*
        作业：利用集合实现注册和登录，账号和密码必须是从控制台输入
            注册：账号（数字:11）密码：123456
                    如果这个注册的账号已经存在，就提示用户：”已经存在此用户，请重新输入“
                    如果这个注册的账号不存在，那就向集合里面存储这个用户的账号

            登录：要输入账号和密码
                    如果账号和密码错误 ，就提示用户重新输入账号密码登录
                    如果输入的账号和密码正确，就提示：登录成功，欢迎使用系统
         */
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        System.out.println("集合的元素为：" + c1);
    }
}
