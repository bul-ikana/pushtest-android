package pushtest.mecabotware.com.pushtest.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.UUID;

import static android.support.v4.app.NotificationCompat.PRIORITY_MAX;

public class CustomFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived (RemoteMessage message) {
        Log.d(TAG, "From: " + message.getFrom());
        Log.d(TAG, "Body: " + message.getNotification().getBody());
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setAutoCancel(true)
                        .setPriority(PRIORITY_MAX)
                        .setContentText(message.getNotification().getBody())
                        .setContentTitle(message.getNotification().getTitle())
                        .setColor(Color.parseColor(message.getNotification().getColor()))
                        .setSmallIcon(this.getResources().getIdentifier(message.getNotification().getIcon(), "drawable", this.getPackageName()));

        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        mNotifyMgr.notify(UUID.randomUUID().hashCode(), mBuilder.build());

    }
}
