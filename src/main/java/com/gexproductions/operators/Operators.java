package com.gexproductions.operators;

import io.reactivex.rxjava3.core.Observable;

public class Operators {
    public static void main(String[] args) {
        Observable.just(10,20,30,40)
                .scan((x,y) -> x + y)
                .repeat(2)
                .subscribe(e -> System.out.println("Grade A with: " + e));
    }
}
