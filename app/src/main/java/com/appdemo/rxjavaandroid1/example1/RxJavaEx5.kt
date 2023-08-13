package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.SchedulerProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver

class RxJavaEx5(private val scheduler: SchedulerProvider) {
    lateinit var observable: Observable<String>
    lateinit var observableFromArray: Observable<String>
    lateinit var observableRanges: Observable<Int>
    private val compositeDisposable = CompositeDisposable()

    fun callRxFunctionality() {
        observable = Observable.just("Hello 1", "Hello 2", "Hello 3")
        compositeDisposable.add(
            observable
                .subscribeOn(scheduler.ui())
                .observeOn(scheduler.io())
                .subscribeWith(getObserver())
        )

        observableFromArray = Observable.fromArray("Hello 1", "Hello 2", "Hello 3")
        compositeDisposable.add(
            observableFromArray
                .subscribeOn(scheduler.ui())
                .observeOn(scheduler.io())
                .subscribeWith(getObserver())
        )

        observableRanges = Observable.range(1, 10)
        compositeDisposable.add(
            observableRanges
                .subscribeOn(scheduler.ui())
                .observeOn(scheduler.io())
                .subscribeWith(getObserverInt())
        )
    }

    private fun getObserver(): DisposableObserver<String> {
        return object : DisposableObserver<String>() {
            override fun onNext(t: String) {
                println(":::== String : onNext : " + t)
            }

            override fun onError(e: Throwable) {
                println(":::== onError : ")
            }

            override fun onComplete() {
                println(":::== onComplete : ")
            }
        }
    }

    private fun getObserverInt(): DisposableObserver<Int> {
        return object : DisposableObserver<Int>() {
            override fun onNext(t: Int) {
                println(":::== Int : onNext : " + t)
            }

            override fun onError(e: Throwable) {
                println(":::== onError : ")
            }

            override fun onComplete() {
                println(":::== onComplete : ")
            }
        }
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}