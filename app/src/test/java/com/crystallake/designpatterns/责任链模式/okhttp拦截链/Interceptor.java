/**
 * Created by : yds
 * Time: 2022-03-09 2:19 下午
 */
package com.crystallake.designpatterns.责任链模式.okhttp拦截链;

import java.io.IOException;

public interface Interceptor {

    Response intercept(Chain chain) throws IOException;

    interface Chain{
        Request request();

        Response proceed(Request request) throws IOException;
    }

}
