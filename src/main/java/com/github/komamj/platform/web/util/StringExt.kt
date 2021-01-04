package com.github.komamj.platform.web.util

import android.net.Uri

fun String.clearQueryAndFragment(): String = let {
    val originUri = Uri.parse(this).buildUpon().build()
    val newUri = Uri.Builder()
        .scheme(originUri.scheme)
        .encodedAuthority(originUri.encodedAuthority)
        .encodedPath(originUri.encodedPath)
    newUri.build().toString()
}