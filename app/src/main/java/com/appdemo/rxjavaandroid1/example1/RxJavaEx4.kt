package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.SchedulerProvider
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver

class RxJavaEx4(private val scheduler: SchedulerProvider) {

    val result1 = "Hello World 1"
    val result2 = "Hello World 2"
    private val compositeDisposable = CompositeDisposable()
    lateinit var observable1: Observable<String>
    lateinit var observable2: Observable<String>

    fun callRxFunctionality() {
        observable1 = Observable.just(result1)
        observable2 = Observable.just(result2)
        compositeDisposable.add(
            observable1.observeOn(scheduler.ui()).subscribeOn(scheduler.io())
                .subscribeWith(getObserver())
        )
        compositeDisposable.add(
            observable2.observeOn(scheduler.ui()).subscribeOn(scheduler.io())
                .subscribeWith(getObserver())
        )
    }

    fun dispose() {
        compositeDisposable.clear()
    }

    private fun getObserver(): DisposableObserver<String> {
        return object : DisposableObserver<String>() {
            override fun onNext(t: String) {
                println(":::== onNext : " + t)
            }

            override fun onError(e: Throwable) {
                println(":::== onError : ")
            }

            override fun onComplete() {
                println(":::== onComplete : ")
            }
        }
    }
}