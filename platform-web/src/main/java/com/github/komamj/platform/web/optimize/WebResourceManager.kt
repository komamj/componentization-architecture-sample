package com.github.komamj.platform.web.optimize

import com.github.komamj.platform.web.util.clearQueryAndFragment
import java.io.File
import java.net.URL

class WebResourceManager {
    fun intercept(url: String) {

    }

    fun shouldIntercept(url: String) {
    }

    private fun mappingLocalResource(url: String) {
        val tempUrl = url.clearQueryAndFragment()

        when {
            // 通过 host 的方式访问
            isHost(tempUrl) -> {
                // 返回当前根目录下的 index.html
            }
            // 通过 host+entry 的方式访问
            isEntry() -> {
                // 1.当前路径是合法文件夹，返回文件夹下 index.html
                // 2.当前路径是文件，文件不存在，返回父目录下 index.html
                // 3.默认情况
            }
            else -> {
                // 默认情况使用本地缓存根目录路径替换 host url
            }
        }
    }

    private fun isHost(url: String): Boolean {
        val tempUrl = URL(url)
        return tempUrl.path.isEmpty() || tempUrl.path == File.separator // TODO: 1/4/21 判断是否是轻应用的host
    }

    private fun isEntry(): Boolean {
        return false
    }

    companion object {
        private const val INDEX_HTML = "index.html"
    }
}