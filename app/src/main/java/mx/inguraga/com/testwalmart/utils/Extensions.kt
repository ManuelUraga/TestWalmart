package mx.inguraga.com.testwalmart.utils

import android.content.Context
import android.os.Handler
import android.widget.Toast

fun postDelayed(delayMillis: Long, task: () ->Unit){
    Handler().postDelayed(task,delayMillis)
}

inline fun Context.longToast(message: CharSequence): Toast = Toast
        .makeText(this, message, Toast.LENGTH_LONG)
        .apply {
            show()
        }