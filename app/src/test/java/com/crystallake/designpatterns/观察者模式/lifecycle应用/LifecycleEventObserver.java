package com.crystallake.designpatterns.观察者模式.lifecycle应用;

/**
 * 抽象观察者
 */
public interface LifecycleEventObserver extends LifecycleObserver{
    /**
     * 拉模式
     * @param source
     */
    void onStateChanged(LifecycleOwner source,String life);
}
