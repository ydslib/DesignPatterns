/**
 * Created by : yds
 * Time: 2022-03-24 5:04 下午
 */
package com.crystallake.designpatterns.观察者模式.简单示例.拉;

public class ConcreteSubject extends Subject{

    public void change(String newState) {
        System.out.println("主题状态为：" + newState);
        setState(newState);
        this.notifyObservers(this);
    }

}
