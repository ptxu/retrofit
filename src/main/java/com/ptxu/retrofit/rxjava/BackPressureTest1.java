/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年5月7日 下午5:47:05
 * @version V1.0
 */
package com.ptxu.retrofit.rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: BackPressureTest1
 * @Description: TODO
 * @author dell
 * @date 2018年5月7日 下午5:47:05
 *
 */
public class BackPressureTest1 {

    public static void main(String[] args) {
        Flowable.interval(1, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Thread.sleep(1000);
                System.out.println("onNext: " + aLong);
            }
        });
    }
}
