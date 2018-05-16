/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年5月7日 下午5:23:16
 * @version V1.0
 */
package com.ptxu.retrofit.rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @ClassName: FlatMapTest
 * @Description: TODO
 * @author dell
 * @date 2018年5月7日 下午5:23:16
 *
 */
public class FlatMapTest {

    /**
     * @Title: main
     * @Description: TODO
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value " + integer);
                    System.out.println("I am value " + integer);

                }
                // 随机生成一个时间
                int delayTime = (int) (1 + Math.random() * 1);
                return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("accept: " + s);
            }
        });
    }

}
