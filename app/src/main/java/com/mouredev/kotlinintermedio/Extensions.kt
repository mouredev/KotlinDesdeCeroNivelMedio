package com.mouredev.kotlinintermedio

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by MoureDev by Brais Moure on 5/28/21.
 * www.mouredev.com
 */

fun Date?.customFormat() : String? {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Locale.getDefault())
    if (this != null) {
        return formatter.format(this)
    }
    return null
}

val Date?.formatSize : Int
    get() = this.customFormat()?.length ?: 0