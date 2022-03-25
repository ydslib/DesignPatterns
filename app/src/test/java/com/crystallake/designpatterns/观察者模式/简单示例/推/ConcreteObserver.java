/**
 * Created by : yds
 * Time: 2022-03-24 4:47 下午
 */
package com.crystallake.designpatterns.观察者模式.简单示例.推;

public class ConcreteObserver implements Observer {

    @Override
    public void update(String state) {
        System.out.println("状态为" + state);
    }

}
