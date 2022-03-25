/**
 * Created by : yds
 * Time: 2022-03-25 11:00 上午
 */
package com.crystallake.designpatterns.观察者模式.lifecycle应用;

public class Test01Fragment implements LifecycleOwner{
    LifecycleRegistry registry;
    public void onCreate() {
        TestFragment testFragment = new TestFragment();
        registry = new LifecycleRegistry(testFragment);
        registry.addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(LifecycleOwner source, String life) {
                System.out.println("测试其它类调用：" + life);
            }
        });
        registry.handleLifecycleEvent("onCreate");
    }

    void performStart(){
        registry.handleLifecycleEvent("onStart");
    }

    @Override
    public Lifecycle getLifecycle() {
        return registry;
    }
}
