package com.example.notes.feature_note.notifications

import android.app.AlarmManager

import android.app.PendingIntent
import android.content.Context

import android.content.Intent

var notificationID: Int = 0

fun scheduleNotification(context: Context, time: Long, title: String, text: String, notificationID1: Int) {
    notificationID = notificationID1
    val intent = Intent(context, Notification::class.java)
    intent.putExtra("title", title)
    intent.putExtra("text", text)

    val pending = PendingIntent.getBroadcast(
        context,
        notificationID,
        intent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )
    val manager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, pending)
}