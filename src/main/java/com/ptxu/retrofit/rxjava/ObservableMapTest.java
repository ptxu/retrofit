/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年5月7日 下午3:50:00
 * @version V1.0
 */
package com.ptxu.retrofit.rxjava;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: ObservableMapTest
 * @Description: TODO
 * @author dell
 * @date 2018年5月7日 下午3:50:00
 *
 */
public class ObservableMapTest {

    public static void main(String[] args) {

        // Observable.create(new ObservableOnSubscribe<Integer>() {
        // @Override
        // public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
        // e.onNext(1);
        // e.onNext(2);
        // e.onNext(3);
        // e.onNext(4);
        // }
        // }).map(new Function<Integer, String>() {
        // @Override
        // public String apply(@NonNull Integer integer) throws Exception {
        // // map 操作符，就是转换输入、输出 的类型；本例中输入是 Integer , 输出是 String 类型
        // System.out.println("apply: " + integer + " 线程：" + Thread.currentThread().getName());
        // return "This is result " + integer;
        // }
        // }).subscribeOn(Schedulers.io()) // 在子线程发射
        // .observeOn(Schedulers.single()) // 在主线程接收
        // .subscribe(new Consumer<String>() {
        // @Override
        // public void accept(@NonNull String s) throws Exception {
        // System.out.println("accept: " + s + " 线程：" + Thread.currentThread().getName());
        // }
        // });

        Flowable.fromCallable(() -> {
            System.out.println("accept: 线程：" + Thread.currentThread().getName());

            // Thread.sleep(1000); // imitate expensive computation
            return "Done";
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.single()).subscribe(

                new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        System.out.println("accept: " + s + " 线程：" + Thread.currentThread().getName());
                    }
                }

        );

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // <--- wait for the flow to finish
    }
}
