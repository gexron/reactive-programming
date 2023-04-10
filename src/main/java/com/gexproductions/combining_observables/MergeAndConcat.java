package com.gexproductions.combining_observables;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).map(e ->"Src 1: " + e);
        Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS).map(e ->"Src 2: " + e);
//        Observable.merge(src1, src2)
//                .subscribe(System.out::println);
//
//        Observable.concat(src1, src2)
//                .subscribe(System.out::println);

        src1.mergeWith(src2).subscribe(System.out::println);
        Thread.sleep(3000);
    }
}
