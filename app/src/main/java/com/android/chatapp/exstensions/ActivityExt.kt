package com.android.chatapp.exstensions

import android.app.Activity
import android.widget.Toast

fun Activity.toast(text: String, long: Boolean = false) {
    Toast.makeText(this, text, if (long) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}