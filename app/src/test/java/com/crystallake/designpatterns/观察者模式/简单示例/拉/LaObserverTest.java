/**
 * Created by : yds
 * Time: 2022-03-24 5:07 下午
 */
package com.crystallake.designpatterns.观察者模式.简单示例.拉;

import org.junit.Test;

public class LaObserverTest {

    @Test
    public void testObserver(){
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer = new ConcreteObserver();
        subject.attach(observer);
        subject.change("test");
    }
}
