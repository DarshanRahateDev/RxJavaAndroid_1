package com.appdemo.rxjavaandroid1.example1

import org.junit.Test

class RxJavaEx1Test {

    @Test
    fun test1() {
        val rxJavaEx1 = RxJavaEx1()

        rxJavaEx1.callRxFunctionality()
        val observable = rxJavaEx1.observable.test()

        observable.assertValue(rxJavaEx1.result)
        observable.assertResult(rxJavaEx1.result)
        observable.assertValueAt(0, rxJavaEx1.result)
        observable.assertComplete()
    }
}