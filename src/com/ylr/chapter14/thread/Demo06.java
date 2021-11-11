package com.ylr.chapter14.thread;
/*
线程的停止

复习：
wait() 等待 如果一个线程进入等待的状态的时候，那么该线程必须要使用notify()方法来唤醒另外一个线程；
notity() 唤醒 唤醒一个线程

使用线程安全要注意的事项：
1.wait()与notify()这两个线程函数所属对象是object对象；
2.wait()与notify()函数必须是在同步的代码块中或者是在同步的函数中使用；
3.wait()与notify()函数必须是在同一个锁对象中使用或调用 ；

问题：通过上一节课案例实战，我们发现线程一直是在运行的状态，线程并没有停止？

如何创建一个线程类？
有两种方式创建线程类：
第一种：就是创建一个类，然后去继承一个Thread线程类，最后再去重写run()方法即可；
第二种：就是创建一个类，然后去实现一个Runnable接口类，最后再去重写run()方法即可；

停止线程的方式：
    1.我们可以使用简单直接粗暴的方式，即直接关闭控制台“停止”按钮（不现实也不推荐使用此方法）
    2.可以自定义变量的方式来停止一个线程
    3.我们可以使用wait()和notify在同步的函数体中和或同步的代码块中来停止线程（推荐使用）


 */
//创建一个类   创建类的格式：public class 类名 {}   注意：创建类的名称的首字母必须是大写
//如何创建一个线程类
//public class Demo06 implements Runnable {
//
//    @Override
//    public void run() {
//
//    }
//}

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class Demo06 extends Thread {
    //定义一个变量flag，表示默认为true表示开启标记
    boolean flag = true;

//    如何获取线程的名称
//    创建一个带参数的构造函数
    public Demo06(String name){
        super(name);
    }

//    创建一个无参的构造函数
//    public Demo06(){}

    @Override
    public synchronized void run() {
//        this：代表当前对象
//        自定义一个变量i,并赋值为0
        int i = 0;//全局变量
        while (flag){
            int j = 0;//局部变量
            //如何获取线程的名称
            //在控制台显示格式：线程名称 + i
            try {//捕获异常
                this.wait();//让线程进入等待的状态，如果线程进入等待的状态的时候，就要将此线程通过使用notify方法唤醒另外一个线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +"：" + i);
            i ++;//在循环控制 语句 里面，必须要使用自增运算，否则的话就是一个无限死循环
        }
    }

    //主函数
    public static void main(String[] args) {
        //如何使用线程？》
        //创建一个对象
        Demo06 demo06 = new Demo06("张三");

        demo06.setPriority(10);//设置线程的优先级

        //如何调用线程
        demo06.start();


        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            if (i == 50){
                synchronized (demo06){
                    demo06.notify();//唤醒线程
//                    demo06.flag = false;
                };
            }
        }
    }
}
