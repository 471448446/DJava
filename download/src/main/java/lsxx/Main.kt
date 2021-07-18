package lsxx

import jdk.nashorn.api.scripting.JSObject
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.*
import java.net.HttpURLConnection
import java.nio.file.Paths


/**
 * Created by better on 2021/7/18.
 */

const val URL = "http://www.zgpingshu.com/play/58/%d.html"
const val API = "http://www.zgpingshu.com/playdata/58/%d.html"
const val PLAYLIST_START = 369
const val PLAYLIST_END = 485
//const val PLAYLIST_END = 368

fun main(args: Array<String>) {
    Thread(runGetPlayList2()).start()
}

fun runGetPlayList2() = Runnable {
    for (item in PLAYLIST_START until (PLAYLIST_END + 1)) {
        val downloadInfo = getDownloadInfo2(item)
        println("try download ${downloadInfo?.first},${downloadInfo?.second}")
        val suc = download(downloadInfo)
        println("download result ?suc $suc")
        Thread.sleep(5_000)
    }
}

fun getDownloadInfo2(item: Int): Pair<String, String>? {
    val uri = String.format(API, item)
    try {
        val response = get(uri)
        val json = JSONObject(response)
        /*
        {
        "urlpath": "http://oshantianfang1.zgpingshu.com/%E5%8D%95%E7%94%B0%E8%8A%B3%E8%AF%84%E4%B9%A6_%E4%B9%B1%E4%B8%96%E6%9E%AD%E9%9B%84%28485%E5%9B%9E%E7%89%88%29401-485_448MB_32k/7507DE8C1F.flv",
        "indexes": [1, 2]
        }
         */
        val optString = json.optString("urlpath").replace("flv", "mp3")
        return "$item.mp3" to optString
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun runGetPlayList() = Runnable {
    val start = 367
    for (item in start until (PLAYLIST_END + 1)) {
        val downloadInfo = getDownloadInfo(item)
        println("try download ${downloadInfo?.first},${downloadInfo?.second}")
        val suc = download(downloadInfo)
        println("download result ?suc $suc")
        Thread.sleep(1_000)
    }
//    download("365.mp3" to "http://oshantianfang1.zgpingshu.com/%E5%8D%95%E7%94%B0%E8%8A%B3%E8%AF%84%E4%B9%A6_%E4%B9%B1%E4%B8%96%E6%9E%AD%E9%9B%84%28485%E5%9B%9E%E7%89%88%29301-400_527MB_32k/53A466963D.mp3")
}

fun download(downloadInfo: Pair<String, String>?): Boolean {
    if (null == downloadInfo) {
        return false
    }
    try {
        val url = java.net.URL(downloadInfo.second)
        val connection = url.openConnection() as HttpURLConnection
        connection.apply {
            doOutput = false
            doInput = true
            requestMethod = "GET"
            useCaches = true
            instanceFollowRedirects = true
            connectTimeout = 15_000
        }
        connection.connect()
        val responseCode = connection.responseCode
        if (responseCode != 200) {
            return false
        }
        connection.inputStream.use { ins ->
            val currentDirector = File(Paths.get("").toAbsolutePath().toFile(), "data" + File.separator + "lsxy" + File.separator)
            currentDirector.mkdirs()
            val file = File(currentDirector, downloadInfo.first)
            FileOutputStream(file).use { outs ->
                var read = -1
                val buffer = ByteArray(4069)
                while (ins.read(buffer).also { read = it } != -1) {
                    outs.write(buffer, 0, read)
                }
                outs.flush()
            }
        }
        return true
    } catch (e: Exception) {
    }
    return false
}

fun getDownloadInfo(item: Int): Pair<String, String>? {
    val url = String.format(URL, item)
    println("request: $url")
    var doc: Document? = null
    try {
        doc = Jsoup.connect(url)
                .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("accept-encoding", "gzip, deflate")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7")
                .header("Cache-Control", "max-age=0")
                .header("Referer", "http://shantianfang.zgpingshu.com/")
                .header("Host", "www.zgpingshu.com")
                .header("Connection", "keep-alive")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36")
//                .header("Cookie","Hm_lvt_b0c473751826318d7f50af78800e6faf=1626577064; oldList=%5B%7B%22url%22%3A%22http%3A%2F%2Fwww.zgpingshu.com%2Fplay%2F58%2F457.html%22%2C%22statuscurrentTime%22%3A5.039938%2C%22status_convertTime%22%3A%2200%3A05%22%2C%22showtime%22%3A%2207-18%2014%3A22%22%7D%5D; Hm_lpvt_b0c473751826318d7f50af78800e6faf=1626590501; status_convertTime=00%3A11; statuscurrentTime=11.903277")
                .header("Upgrade-Insecure-Requests", "1")
                .get()
    } catch (e: Exception) {
        e.printStackTrace()
    }
    if (null == doc) {
        println("fail request")
        return null
    }
    val elementAudio = doc.getElementById("jp_audio_0")
    if (null == elementAudio) {
        println("fail get audio element")
        return null
    }
    val audioUrl = elementAudio.attr("src")
    val downloadInfo = "$item.mp3" to audioUrl
    return "$item.mp3" to audioUrl
}

fun get(uri: String): String {
    try {
        val url = java.net.URL(uri)
        val connection = url.openConnection() as HttpURLConnection
        connection.apply {
            doOutput = false
            doInput = true
            requestMethod = "GET"
            useCaches = true
            instanceFollowRedirects = true
            connectTimeout = 15_000
        }
        connection.connect()
        val responseCode = connection.responseCode
        if (responseCode != 200) {
            return ""
        }
        BufferedReader(InputStreamReader(connection.inputStream)).use { ins ->
            return ins.readText()
        }
    } catch (e: Exception) {
    }
    return ""
}