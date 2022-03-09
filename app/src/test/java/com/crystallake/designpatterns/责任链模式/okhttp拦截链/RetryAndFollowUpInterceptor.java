/**
 * Created by : yds
 * Time: 2022-03-09 2:21 下午
 */
package com.crystallake.designpatterns.责任链模式.okhttp拦截链;

import java.io.IOException;

public class RetryAndFollowUpInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        RealInterceptorChain realChain = (RealInterceptorChain) chain;

        Response response = null;
        try {
            System.out.println("RetryAndFollowUpInterceptor1");
            response = realChain.proceed(request);
        }catch (Exception e){

        }
        System.out.println("RetryAndFollowUpInterceptor2");
        return response;
    }
}
