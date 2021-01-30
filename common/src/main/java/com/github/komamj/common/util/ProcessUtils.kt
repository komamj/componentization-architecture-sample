package com.github.komamj.common.util

import android.app.Application
import android.os.Build
import android.os.Process
import android.text.TextUtils
import com.github.komamj.common.BuildConfig
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

object ProcessUtils {
    fun getCurrentProcessName(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Application.getProcessName()
        } else {
            getProcessName(Process.myPid())
        }
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private fun getProcessName(pid: Int): String {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName = reader.readLine()
            if (!processName.isNullOrEmpty()) {
                processName = processName.trim()
            }
            return processName
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                reader?.close()
            } catch (exception: IOException) {
                exception.printStackTrace()
            }
        }
        return ""
    }
}