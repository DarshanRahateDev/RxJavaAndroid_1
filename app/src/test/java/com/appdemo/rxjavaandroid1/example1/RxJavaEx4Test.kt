package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.TestSchedulerProvider
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Test

class RxJavaEx4Test {

    @Test
    fun test1() {
        val rxJavaEx4 = RxJavaEx4(TestSchedulerProvider(TestScheduler()));
        rxJavaEx4.callRxFunctionality()
        rxJavaEx4.observable1.test().assertResult(rxJavaEx4.result1).assertValueAt(0, rxJavaEx4.result1).assertComplete()
        rxJavaEx4.observable2.test().assertResult(rxJavaEx4.result2).assertValueAt(0, rxJavaEx4.result2).assertComplete()
    }
}