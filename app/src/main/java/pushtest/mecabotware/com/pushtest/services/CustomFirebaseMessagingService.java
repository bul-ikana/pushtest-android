package pushtest.mecabotware.com.pushtest.services;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CustomFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived (RemoteMessage message) {
        Log.d(TAG, "From: " + message.getFrom());
        Log.d(TAG, "Body: " + message.getNotification().getBody());
    }
}
