package com.appdemo.rxjavaandroid1

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.appdemo.rxjavaandroid1.databinding.ActivityMainBinding
import com.appdemo.rxjavaandroid1.example1.*
import com.appdemo.rxjavaandroid1.scheduler.AppSchedulerProvider

class MainActivity : AppCompatActivity() {

    private lateinit var rxJavaEx1: RxJavaEx1
    private lateinit var rxJavaEx2: RxJavaEx2
    private lateinit var rxJavaEx3: RxJavaEx3
    private lateinit var rxJavaEx4: RxJavaEx4
    private lateinit var rxJavaEx5: RxJavaEx5
    private lateinit var rxJavaEx6: RxJavaEx6
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.buttonRxjavaEx1.setOnClickListener {
            rxJavaEx1 = RxJavaEx1()
            RxJavaEx1().callRxFunctionality()
        }
        binding.buttonRxjavaEx2.setOnClickListener {
            rxJavaEx2 = RxJavaEx2(AppSchedulerProvider())
            rxJavaEx2.callRxFunctionality()
        }
        binding.buttonRxjavaEx3.setOnClickListener {
            rxJavaEx3 = RxJavaEx3(AppSchedulerProvider())
            rxJavaEx3.callRxFunctionality()
        }
        binding.buttonRxjavaEx4.setOnClickListener {
            rxJavaEx4 = RxJavaEx4(AppSchedulerProvider())
            rxJavaEx4.callRxFunctionality()
        }
        binding.buttonRxjavaEx5.setOnClickListener {
            rxJavaEx5 = RxJavaEx5(AppSchedulerProvider())
            rxJavaEx5.callRxFunctionality()
        }
        binding.buttonRxjavaEx6.setOnClickListener {
            rxJavaEx6 = RxJavaEx6(AppSchedulerProvider())
            rxJavaEx6.callRxFunctionality()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onPause() {
        super.onPause()
        rxJavaEx1.dispose()
        rxJavaEx2.dispose()
        rxJavaEx3.dispose()
        rxJavaEx4.dispose()
        rxJavaEx5.dispose()
        rxJavaEx6.dispose()
    }
}