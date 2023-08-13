package com.appdemo.rxjavaandroid1.example1

import com.appdemo.rxjavaandroid1.scheduler.TestSchedulerProvider
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Test

class RxJavaEx5Test {

    @Test
    fun `test for just`() {
        val rxJavaEx5 = RxJavaEx5(TestSchedulerProvider(TestScheduler()))
        rxJavaEx5.callRxFunctionality()
        val observable = rxJavaEx5.observable.test()

        observable.assertValues("Hello 1", "Hello 2", "Hello 3")
        observable.assertValueAt(0, "Hello 1")
        observable.assertValueAt(1, "Hello 2")
        observable.assertValueAt(2, "Hello 3")
        observable.assertComplete()
    }

    @Test
    fun `test for fromArray`() {
        val rxJavaEx5 = RxJavaEx5(TestSchedulerProvider(TestScheduler()))
        rxJavaEx5.callRxFunctionality()
        val observable = rxJavaEx5.observableFromArray.test()

        observable.assertValues("Hello 1", "Hello 2", "Hello 3")
        observable.assertValueAt(0, "Hello 1")
        observable.assertValueAt(1, "Hello 2")
        observable.assertValueAt(2, "Hello 3")
        observable.assertComplete()
    }

    @Test
    fun `test for ranges`() {
        val rxJavaEx5 = RxJavaEx5(TestSchedulerProvider(TestScheduler()))
        rxJavaEx5.callRxFunctionality()
        val observable = rxJavaEx5.observableRanges.test()

        observable.assertValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        observable.assertValueAt(0, 1)
        observable.assertValueAt(1, 2)
        observable.assertValueAt(2, 3)
        observable.assertValueAt(3, 4)
        observable.assertValueAt(4, 5)
        observable.assertValueAt(5, 6)
        observable.assertValueAt(6, 7)
        observable.assertValueAt(7, 8)
        observable.assertValueAt(8, 9)
        observable.assertValueAt(9, 10)

        observable.assertComplete()
    }
}