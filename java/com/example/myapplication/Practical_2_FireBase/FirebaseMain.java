package com.example.myapplication.Practical_2_FireBase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Practical1.Activities.RegisterActivity;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class FirebaseMain extends AppCompatActivity {
// Log.e(TAG, "onActivityResult: "+data.getStringExtra("Name"));
    //1. Channel Id
    //2. Notification Builder
    //3. Notification Manager

//    private static final String TAG = FirebaseMain.class.getSimpleName();
//    private static final String CHANNEL_ID = "NectarBits";
//    private static final String CHANNEL_NAME = "NectarBits";
//    private static final String CHANNEL_DESCRPTION = "NectarBits";

//    Button buttonNotification, buttonToken;
//    TextView textviewToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);
        // buttonNotification = findViewById(R.id.FireBtnNotification);
     //   buttonToken = findViewById(R.id.FireBtnToken);
        //  textviewToken = findViewById(R.id.FireTxtToken);

//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
//            channel.setDescription(CHANNEL_DESCRPTION);
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//
//
    }

//    public void displayNotification() {
//        Intent intent = new Intent(this, RegisterActivity.class);
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
//                .setContentTitle("Check This Out")
//                .setContentText("You have Got New Message")
//                .setAutoCancel(true)
//                .setContentIntent(pendingIntent)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//
//        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
//        managerCompat.notify(1, builder.build());
//
//    }
//
//    public void Send_Notification(View view) {
//        displayNotification();
//
   // }


}
