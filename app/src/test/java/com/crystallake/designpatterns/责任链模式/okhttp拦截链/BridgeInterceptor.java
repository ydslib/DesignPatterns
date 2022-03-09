/**
 * Created by : yds
 * Time: 2022-03-09 2:33 下午
 */
package com.crystallake.designpatterns.责任链模式.okhttp拦截链;

import java.io.IOException;

public class BridgeInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request userRequest = chain.request();
        System.out.println("BridgeInterceptor1");
        Response response = new Response();
        System.out.println("BridgeInterceptor2");
        return response;
    }
}
