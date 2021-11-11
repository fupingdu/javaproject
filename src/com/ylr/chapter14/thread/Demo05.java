package com.ylr.chapter14.thread;
/*
线程通信：一个线程完成了自己的任务的时候，就要去通知另外一个线程
    去完成另外一个任务
    从设计-》制作-》检验-》销售-》消费者
    消费者和产品是存在关系的，那么他们是存在什么关系呢？

wait():等待   如果线程执行了wait()方法，那么该 线程会进入 等待的状态，等待状态下的线程必须要被其它的线程调用notity方法才能唤醒
notify():唤醒  唤醒等待的线程

//wait与notity方法要注意的事项:
    1.wait方法与notify方法是属于object对象
    2.wait方法与notify方法必须要在同步代码块或同步函数中才能使用;
    3.wait方法与notify方法必须 要有同一个锁对象调用


 */
public class Demo05 {
    public static void main(String[] args) {
        //创建一个产品
        Product product = new Product();
        //如何将产品传递给生产者和消费者
        //创建一个生产者对象
        Productor productor = new Productor(product);
        //创建一个消费者对象
        Custom custom = new Custom(product);

        //开启线程
        //开启生产者线程
        productor.start();
        //开启消费者线程
        custom.start();
    }
}

//编写三个类
//产品类：product
class Product{
    //定义一个变量name,表示产品名称
    String name;
    //定义一个变量price,表示产品价格
    double price;
    //产品是否生产完毕的标识，默认是还没有生产完成
    boolean flag = false;
}

//创建一个生产者类：Productor
class  Productor extends Thread{
    //将产品对象声明为产品变量
    Product product;

    //创建一个带参的构造函数
    public Productor(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        //定义一个临时变量
        int i = 0;
        while (true){
            synchronized (product){
                if (product.flag == false){
                    if (i % 2 == 0){//如果i为偶数的时候就生产电脑
                        product.name = "电脑";
                    /*try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                        product.price = 10000.0;
                    }else{//i为奇数的时候就生产手机
                        product.name = "手机";
                        product.price = 5000.0;
                    }
                    System.out.println("生产者生产出了：" +product.name+ "  价格是：" + product.price);
                    product.flag = true;//给产品打标记，表示可以去消费了
                    i ++;
                    product.notify();//唤醒消费者去消费
                }else{//已经生产完毕，等待消费者去消费
                    try {
                        product.wait();//生产者等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

//创建一个消费对象
class Custom extends Thread{
    //将产品对象声明为变量
    Product product;

    //创建带有参数的构造函数
    public Custom(Product product){
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                    if (product.flag == true){//表示产品生产完毕
                        System.out.println("消费者消费了：" + product.name + "  价格是：" + product.price);
                        product.flag = false;//把产品标记为还没有生产完毕
                        product.notify();//唤醒生产者去生产
                    }else {
                        //产品还没有生，等待生产者生产
                        try {
                            product.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    }
}
