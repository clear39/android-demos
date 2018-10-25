package com.xqli.annotation;

import com.xqli.annotation.Provider;

/**
 * Created by JokAr on 16/8/6.
 */
public interface Inject<T> {

    void inject(T host, Object object, Provider provider);
}
