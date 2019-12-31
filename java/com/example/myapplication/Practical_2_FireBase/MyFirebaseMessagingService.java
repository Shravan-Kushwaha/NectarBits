package com.example.myapplication.Practical_2_FireBase;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.myapplication.Practical1.Activities.AddActivity;
import com.example.myapplication.Practical1.Activities.HomeActivity;
import com.example.myapplication.Practical1.Activities.LoginActivity;
import com.example.myapplication.Practical1.Activities.RegisterActivity;
import com.example.myapplication.Practical1.Activities.SplashActivity;
import com.example.myapplication.R;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    Intent intent = new Intent();
    private static final String TAG = FirebaseMain.class.getSimpleName();
    private static final String CHANNEL_ID = "com.example.myapplication.test";
    private static final String CHANNEL_NAME = "NectarBits";
    private static final String CHANNEL_DESCRPTION = "NectarBits";


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        showNotification(remoteMessage.getData().get("tittle"), remoteMessage.getData().get("body"), remoteMessage.getData().get("data"));

    }


    private void showNotification(String tittle, String body, String data) {
        String Tittle = tittle;
        String Body = body;
        String screen = data;
        Log.e(TAG, "showNotification: Screen:" + screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESCRPTION);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        switch (screen) {
            case "1":
                intent = new Intent(this, SplashActivity.class);
                break;
            case "2":
                intent = new Intent(this, LoginActivity.class);
                break;
            case "3":
                intent = new Intent(this, RegisterActivity.class);
                break;
            case "4":
                intent = new Intent(this, HomeActivity.class);
                break;
            case "5":
                intent = new Intent(this, AddActivity.class);
                break;
            default:
                intent = new Intent(this, HomeActivity.class);
                break;
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                100,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_video_call_black_24dp)
                .setAutoCancel(true)
                .setContentTitle(Tittle)
                .setContentText(Body)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(1, builder.build());

    }


    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //sendRegistrationToServer(token);
    }

//    private void sendRegistrationToServer(String token) {
//        // TODO: Implement this method to send token to your app server.
//    }


//    private void showNotification(String title, String body) {
//
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
//            channel.setDescription(CHANNEL_DESCRPTION);
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//       // Intent intent = new Intent(this, LoginActivity.class);
//
//
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(
//                this,
//                100,
//                intent,
//                PendingIntent.FLAG_CANCEL_CURRENT
//        );
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_video_call_black_24dp)
//                .setContentTitle(title)
//                .setContentText(body)
//                .setAutoCancel(true)
//                .setContentIntent(pendingIntent)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//
//        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
//        managerCompat.notify(1, builder.build());
//
//
//
//
//    }


}