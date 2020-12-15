package com.github.komamj.startup

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

class CyclicDependencyInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Log.i(TAG, "Initialized")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(CyclicDependencyInitializer::class.java)
    }

    companion object {
        const val TAG = "CyclicDependencies"
    }
}