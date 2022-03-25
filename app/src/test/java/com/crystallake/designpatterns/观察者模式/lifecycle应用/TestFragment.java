/**
 * Created by : yds
 * Time: 2022-03-24 5:43 下午
 */
package com.crystallake.designpatterns.观察者模式.lifecycle应用;

public class TestFragment implements LifecycleOwner{

    LifecycleRegistry mLifecycleRegistry;

    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    public void initLifecycle(){
        mLifecycleRegistry = new LifecycleRegistry(this);
    }

    void performCreate(){
        mLifecycleRegistry.addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(LifecycleOwner source,String life) {
                System.out.println("被观察者改变通知到观察者，这里是观察者"+life);
            }
        });

        mLifecycleRegistry.handleLifecycleEvent("onCreate");
    }

    void performStart(){
        mLifecycleRegistry.handleLifecycleEvent("onStart");
    }

    void performCreateView(){
        mLifecycleRegistry.handleLifecycleEvent("onCreateView");
    }

    void performActivityCreated(){
        mLifecycleRegistry.handleLifecycleEvent("onActivityCreated");
    }

    void performResume(){
        mLifecycleRegistry.handleLifecycleEvent("onResume");
    }

}
