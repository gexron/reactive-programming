package com.gexproductions.ways_to_multicast;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.*;

import java.util.concurrent.TimeUnit;

public class SubjectTypes {
    public static void main(String[] args) throws InterruptedException {
        //Publish Subject: starts emission of items on the moment of subscription
//        Subject<String> subject = PublishSubject.create();

        //ReplaySubject: emits all items regardless of moment of subscription
//        Subject<String> subject = ReplaySubject.create();

        //BehaviorSubject: emits most recent item on the point of subscription
//        Subject<String> subject = BehaviorSubject.create();

        //AsyncSubject: emits last value after calling onComplete()
        Subject<String> subject = AsyncSubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: "+ e));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: "+e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();

        System.out.println();

        //UnicastSubject: buffers all emissions until it is subscribed by an observer
        Subject<Long> subject2 = UnicastSubject.create();

        Observable.interval(1, TimeUnit.SECONDS).subscribe(subject2);

        Thread.sleep(3000);

        subject2.subscribe(e -> System.out.println("Subscriber: "+ e));

        Thread.sleep(3000);

    }
}
