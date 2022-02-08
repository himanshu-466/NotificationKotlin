package com.example.notificationkotlin

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    private val CHANNEL_ID = "My Channel"
    private val NOTIFICATION_ID = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawable = ResourcesCompat.getDrawable(resources, R.drawable.fog, null)
        val bitmap = drawable as BitmapDrawable?
        val largeicon = bitmap!!.bitmap
        val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val not: Notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            not = Notification.Builder(this).setLargeIcon(largeicon)
                .setSmallIcon(R.drawable.ic_launcher_background).setContentText("New Message")
                .setSubText("New message form Mohit")
                .setChannelId(CHANNEL_ID)
                .build()
            nm.createNotificationChannel(
                NotificationChannel(
                    CHANNEL_ID,
                    "New Channel",
                    NotificationManager.IMPORTANCE_HIGH
                )
            )
        } else {
            not = Notification.Builder(this).setLargeIcon(largeicon)
                .setSmallIcon(R.drawable.ic_launcher_background).setContentText("New Message")
                .setSubText("New message form Mohit")
                .build()
        }

        nm.notify(NOTIFICATION_ID, not)
    }
}