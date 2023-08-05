package com.appdemo.rxjavaandroid1.example1

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class RxJavaEx1 {
    val result = "Hello RxJava"
    lateinit var observable: Observable<String>
    private lateinit var disposable: Disposable

    fun callRxFunctionality() {
        observable = Observable.just(result)

        val observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                 println(":::== onSubscribe")
            }

            override fun onNext(t: String) {
                println(":::== onNext : " +t)
            }

            override fun onError(e: Throwable) {
                println(":::== onError : " + e.message)
            }

            override fun onComplete() {
                println(":::== onComplete() ")
            }
        }
        observable.subscribe(observer)
    }

    fun dispose() {
        if (::disposable.isInitialized) {
            disposable.dispose()
        }
    }
}