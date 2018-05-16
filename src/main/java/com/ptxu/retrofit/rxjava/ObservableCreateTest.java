/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年5月7日 下午3:31:30
 * @version V1.0
 */
package com.ptxu.retrofit.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @ClassName: ObservableTest
 * @Description: TODO
 * @author dell
 * @date 2018年5月7日 下午3:31:30
 *
 */
public class ObservableCreateTest {

    /**
     * @Title: main
     * @Description: TODO
     * @param args
     */
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete(); // 结束
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe: " + d.isDisposed() + " " + Thread.currentThread().getName());
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("onNext: " + integer + " " + Thread.currentThread().getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError: " + e.getMessage() + " " + Thread.currentThread().getName());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete: " + " " + Thread.currentThread().getName());
            }
        });
    }

}
