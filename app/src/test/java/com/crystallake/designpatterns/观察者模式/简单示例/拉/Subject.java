/**
 * Created by : yds
 * Time: 2022-03-24 5:02 下午
 */
package com.crystallake.designpatterns.观察者模式.简单示例.拉;


import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private List<Observer> list = new ArrayList<>();

    /**
     * 注册观察者
     * @param observer
     */
    public void attach(Observer observer){
        list.add(observer);
        System.out.println("Attached an observer");
    }

    /**
     * 删除观察者
     * @param observer
     */
    public void detach(Observer observer){
        list.remove(observer);
    }

    public void notifyObservers(Subject subject) {
        for (Observer observer : list) {
            observer.update(subject);
        }
    }
}
