package com.gexproductions.observables_and_observers;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Coutinho", "Sakho", "Lovren");
        source.subscribe(i -> System.out.println(i), Throwable::printStackTrace, () -> System.out.println("--Completed--"));
        System.out.println();
        source.subscribe(i -> System.out.println(i), Throwable::printStackTrace);
        System.out.println();
        source.subscribe(i -> System.out.println(i));
    }
}
