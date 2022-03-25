package com.crystallake.designpatterns.观察者模式.lifecycle应用;

/**
 * 另外的一个抽象主题（被观察者）
 */
public interface LifecycleOwner {
    Lifecycle getLifecycle();
}
