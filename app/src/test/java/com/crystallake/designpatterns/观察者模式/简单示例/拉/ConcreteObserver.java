/**
 * Created by : yds
 * Time: 2022-03-24 5:06 下午
 */
package com.crystallake.designpatterns.观察者模式.简单示例.拉;

public class ConcreteObserver implements Observer{

    @Override
    public void update(Subject subject) {
        System.out.println("拉数据："+subject.getState());
    }

}
