package com.example.notes.feature_note.notifications

import android.app.NotificationManager

import android.app.Notification
import android.app.NotificationChannel

import androidx.core.app.NotificationCompat

import android.content.Intent

import android.content.BroadcastReceiver
import android.content.Context
import android.os.Build
import com.example.notes.R


class Notification : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        createNotificationChannel(context)

        val channelId = "notifications" // Use same Channel ID
        val notification: Notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(intent.getStringExtra("title"))
            .setContentText(intent.getStringExtra("text"))
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(notificationID, notification)
    }
}

fun createNotificationChannel(context: Context) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "notifications"
        val mChannel = NotificationChannel(
            channelId,
            "За братьев бури!",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        mChannel.description = "Раньше меня тоже вела дорога приключений, но потом мне прострелили колено"

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(mChannel)
    }
}