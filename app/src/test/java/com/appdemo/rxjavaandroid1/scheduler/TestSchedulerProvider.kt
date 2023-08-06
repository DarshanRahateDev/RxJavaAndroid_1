package com.appdemo.rxjavaandroid1.scheduler

import io.reactivex.rxjava3.core.Scheduler

class TestSchedulerProvider(private val scheduler: Scheduler) : SchedulerProvider {
    override fun io(): Scheduler = scheduler

    override fun ui(): Scheduler = scheduler

    override fun computation(): Scheduler = scheduler
}