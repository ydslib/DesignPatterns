/**
 * Created by : yds
 * Time: 2022-03-24 5:12 下午
 */
package com.crystallake.designpatterns.观察者模式.lifecycle应用;


/**
 * 抽象主题（被观察者）
 */
public abstract class Lifecycle {

    /**
     * 添加观察者
     * @param observer
     */
    public abstract void addObserver(LifecycleObserver observer);


    /**
     * 移除观察者
     * @param observer
     */
    public abstract void removeObserver(LifecycleObserver observer);

}
