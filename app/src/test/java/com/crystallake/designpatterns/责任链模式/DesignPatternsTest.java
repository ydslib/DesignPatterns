/**
 * Created by : yds
 * Time: 2022-03-09 2:12 下午
 */
package com.crystallake.designpatterns.责任链模式;

import org.junit.Test;

import com.crystallake.designpatterns.责任链模式.okhttp拦截链.BridgeInterceptor;
import com.crystallake.designpatterns.责任链模式.okhttp拦截链.Interceptor;
import com.crystallake.designpatterns.责任链模式.okhttp拦截链.RealInterceptorChain;
import com.crystallake.designpatterns.责任链模式.okhttp拦截链.Request;
import com.crystallake.designpatterns.责任链模式.okhttp拦截链.RetryAndFollowUpInterceptor;
import com.crystallake.designpatterns.责任链模式.简单示例.ConcreteHandler1;
import com.crystallake.designpatterns.责任链模式.简单示例.ConcreteHandler2;
import com.crystallake.designpatterns.责任链模式.简单示例.Handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DesignPatternsTest {

    /**
     * 责任链简单示例测试
     */
    @Test
    public void testSimpleDemo(){
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }

    /**
     * 相较于简单示例，这里解耦更加充分，RetryAndFollowUpInterceptor拦截器和BridgeInterceptor拦截器
     * 不会有依赖关系，它们通过数组列表和第三方类RealInterceptorChain来进行作用。
     */
    @Test
    public void testOkhttpInterceptor(){

        Request request = new Request();

        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new RetryAndFollowUpInterceptor());
        interceptors.add(new BridgeInterceptor());

        Interceptor.Chain chain = new RealInterceptorChain(interceptors,request,0);
        try {
            chain.proceed(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
