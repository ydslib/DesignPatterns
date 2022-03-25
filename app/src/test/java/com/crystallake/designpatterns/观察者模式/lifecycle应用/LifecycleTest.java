/**
 * Created by : yds
 * Time: 2022-03-24 6:11 下午
 */
package com.crystallake.designpatterns.观察者模式.lifecycle应用;

import org.junit.Test;

public class LifecycleTest {

    @Test
    public void testLifecycle(){
        TestFragment testFragment = new TestFragment();
        testFragment.initLifecycle();
        testFragment.performCreate();
        testFragment.performCreateView();
        testFragment.performActivityCreated();
        testFragment.performStart();
        testFragment.performResume();
    }

    @Test
    public void testLifecycle01(){
        Test01Fragment test01Fragment = new Test01Fragment();
        test01Fragment.onCreate();
        test01Fragment.performStart();
    }
}
