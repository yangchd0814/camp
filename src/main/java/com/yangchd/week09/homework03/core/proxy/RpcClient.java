package com.yangchd.week09.homework03.core.proxy;

public interface RpcClient {

    /**
     * create proxy
     * @param serviceClass service class
     * @param url server url
     * @param <T> T
     * @return proxy class
     */
    <T> T create(final Class<T> serviceClass, final String url);
}
