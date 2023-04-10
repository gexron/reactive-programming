package com.gexproductions.combining_observables;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ZipAndCombineLatest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("-------zip()-------");
        Observable<Long> src1 = Observable.interval(1, TimeUnit.SECONDS).take(10);
        Observable<Long> src2 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);

        //zip

        Observable.zip(src1, src2,(x,y) -> "Source 1: " + x + " ,Source 2: " + y)
                .subscribe(System.out::println);
        Thread.sleep(12000);

        System.out.println();

        //combineLatest
        System.out.println("---combineLatest()---");
        Observable.combineLatest(src1, src2,(x,y) -> "Source 1: " + x + " ,Source 2: " + y)
                .subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
