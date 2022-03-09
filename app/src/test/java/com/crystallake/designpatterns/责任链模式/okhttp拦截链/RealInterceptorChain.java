/**
 * Created by : yds
 * Time: 2022-03-09 2:23 下午
 */
package com.crystallake.designpatterns.责任链模式.okhttp拦截链;

import java.io.IOException;
import java.util.List;

public class RealInterceptorChain implements Interceptor.Chain {

    private final List<Interceptor> interceptors;
    private final Request request;
    private final int index;

    public RealInterceptorChain(List<Interceptor> interceptors,Request request,int index){
        this.index = index;
        this.interceptors = interceptors;
        this.request = request;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Response proceed(Request request) throws IOException {

        if (index >= interceptors.size()) throw new AssertionError();

        RealInterceptorChain next = new RealInterceptorChain(interceptors,request,index+1);
        Interceptor interceptor = interceptors.get(index);
        Response response = interceptor.intercept(next);

        return response;
    }
}
