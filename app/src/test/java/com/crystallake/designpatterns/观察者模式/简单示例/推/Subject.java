/**
 * Created by : yds
 * Time: 2022-03-24 4:38 下午
 */
package com.crystallake.designpatterns.观察者模式.简单示例.推;


import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题
 */
public abstract class Subject {

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

    public void notifyObservers(String newState) {
        for (Observer observer : list) {
            observer.update(newState);
        }
    }

}
