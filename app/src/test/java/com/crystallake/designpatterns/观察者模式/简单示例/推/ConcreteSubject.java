/**
 * Created by : yds
 * Time: 2022-03-24 4:44 下午
 */
package com.crystallake.designpatterns.观察者模式.简单示例.推;

/**
 * 具体主题
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState) {
        state = newState;
        System.out.println("主题状态为：" + state);
        this.notifyObservers(newState);
    }

}
