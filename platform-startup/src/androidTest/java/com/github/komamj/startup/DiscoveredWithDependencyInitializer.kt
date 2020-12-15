package com.github.komamj.startup

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

class DiscoveredWithDependencyInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Log.i(TAG, "Initialized")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(DiscoveredNoDependenciesInitializer::class.java)
    }

    companion object {
        private const val TAG = "DiscoveredWithDependency"
    }
}