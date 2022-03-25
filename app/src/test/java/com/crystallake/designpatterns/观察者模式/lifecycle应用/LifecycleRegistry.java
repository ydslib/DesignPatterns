/**
 * Created by : yds
 * Time: 2022-03-24 5:17 下午
 */
package com.crystallake.designpatterns.观察者模式.lifecycle应用;

import androidx.arch.core.internal.FastSafeIterableMap;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/**
 * 具体主题（被观察者）
 */
public class LifecycleRegistry extends Lifecycle {

    /**
     * 使用弱引用，防止内存泄漏
     */
    private final WeakReference<LifecycleOwner> mLifecycleOwner;


    /**
     * 这里使用map来存储观察者
     */
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap = new FastSafeIterableMap<>();


    public LifecycleRegistry(LifecycleOwner provider) {
        mLifecycleOwner = new WeakReference<>(provider);
    }

    @Override
    public void addObserver(LifecycleObserver observer) {

        ObserverWithState statefulObserver = new ObserverWithState(observer,"INITIALIZED");
        //map中存在该键值对，则返回值，不存储；如果不存在，则存储返回null
        ObserverWithState previous = mObserverMap.putIfAbsent(observer, statefulObserver);

//        //已经存在，直接返回
//        if (previous != null) {
//            return;
//        }

//        LifecycleOwner lifecycleOwner = mLifecycleOwner.get();
//        if (lifecycleOwner == null) {
//            return;
//        }

    }

    @Override
    public void removeObserver(LifecycleObserver observer) {
        mObserverMap.remove(observer);
    }

    public void handleLifecycleEvent(String life){
        sync(life);
    }


    /**
     * 更新观察者
     */
    private void sync(String life){
        LifecycleOwner lifecycleOwner = mLifecycleOwner.get();
        Iterator<Map.Entry<LifecycleObserver,ObserverWithState>> descendingIterator =
                mObserverMap.descendingIterator();
        while (descendingIterator.hasNext()){
            Map.Entry<LifecycleObserver,ObserverWithState> entry = descendingIterator.next();
            ObserverWithState observer = entry.getValue();
            observer.dispatchEvent(lifecycleOwner,life);
        }

    }

    /**
     * 对观察者进行了一层包装
     */
    static class ObserverWithState {
        String mLife;
        LifecycleEventObserver mLifecycleObserver;

        ObserverWithState(LifecycleObserver observer,String life) {
            mLifecycleObserver = (LifecycleEventObserver) observer;
            mLife = life;
        }

        void dispatchEvent(LifecycleOwner owner,String life) {
            mLifecycleObserver.onStateChanged(owner,life);
        }
    }

}
