package top.jie65535

import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object HttpUtil {
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    fun get(url: String): ByteArray {
        val request = Request.Builder().url(url).build()
        return okHttpClient.newCall(request).execute().body!!.bytes()
    }
}