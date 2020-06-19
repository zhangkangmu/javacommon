package com.tensquare.demo01_threaddemos;

/**
 * Created by zhangyuhong
 * Date:2020/6/4
 */
public class 有序性 {
 /*
    int a = 10; //语句1
    int b = 2; //语句2
    a = a + 3; //语句3
    b = a*a; //语句4
这段代码有4个语句，那么可能的一个执行顺序是：  语句2   语句1    语句3   语句4
不可能是这个执行顺序： 语句2   语句1    语句4   语句3
因为处理器在进行重排序时是会考虑指令之间的数据依赖性，如果一个指令Instruction 2必须用到Instruction 1的结果，
那么处理器会保证Instruction 1会在Instruction 2之前执行。虽然重排序不会影响单个线程内程序执行的结果，但是多线程会有影响

例如:
//线程1:
init = false
context = loadContext(); //语句1  多线程里可能没执行完这个后就设为true了
init = true; //语句2

//线程2:
while(!init){//如果初始化未完成，等待
  sleep();
}
execute(context);//初始化完成，执行逻辑
*/
}
