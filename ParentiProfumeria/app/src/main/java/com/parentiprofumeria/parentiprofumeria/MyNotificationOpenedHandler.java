package com.parentiprofumeria.parentiprofumeria;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

public class MyNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
    private static String TAG = MyNotificationOpenedHandler.class.getSimpleName();

    // This fires when a notification is opened by tapping on it.
    @Override
    public void notificationOpened(OSNotificationOpenResult osNotificationOpenResult) {


        OSNotificationAction.ActionType actionType = osNotificationOpenResult.action.type;
        JSONObject data = osNotificationOpenResult.notification.payload.additionalData;
        String activityToBeOpened;

        //While sending a Push notification from OneSignal dashboard
        // you can send an addtional data named "activityToBeOpened" and retrieve the value of it and do necessary operation
        //If key is "activityToBeOpened" and value is "AnotherActivity", then when a user clicks
        //on the notification, AnotherActivity will be opened.
        //Else, if we have not set any additional data MainActivity is opened.
       /* if (data != null) {
            Intent intent = new Intent(MyApplication.getContext(), MainActivity.class);
            MyApplication.getContext().startActivity(intent);
        }*/

        /*if (data != null) {
            activityToBeOpened = data.optString("activityToBeOpened", null);
            if (activityToBeOpened != null && activityToBeOpened.equals("NotificationDetailsActivity")) {
                Log.i("OneSignalExample", "customkey set with value : " + activityToBeOpened);
                Intent intent = new Intent(MyApplication.getContext(), NotificationDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContext().startActivity(intent);
                intent .setAction(Intent.ACTION_MAIN);
                intent .addCategory(Intent.CATEGORY_LAUNCHER);
            } else if (activityToBeOpened != null && activityToBeOpened.equals("NotificationActivity")) {
                Log.i("OneSignalExample", "customkey set with value : " + activityToBeOpened);
                Intent intent = new Intent(MyApplication.getContext(), NotificationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContext().startActivity(intent);
                intent .setAction(Intent.ACTION_MAIN);
                intent .addCategory(Intent.CATEGORY_LAUNCHER);
            } else {
                Intent intent = new Intent(MyApplication.getContext(), NotificationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContext().startActivity(intent);
                intent .setAction(Intent.ACTION_MAIN);
                intent .addCategory(Intent.CATEGORY_LAUNCHER);
            }
        }*/
        Intent intent = new Intent(MyApplication.getContext(), NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
        MyApplication.getContext().startActivity(intent);


        if (actionType == OSNotificationAction.ActionType.ActionTaken) {
            Log.i("OneSignalExample", "Button pressed with id: " + osNotificationOpenResult.action.actionID);
            if (osNotificationOpenResult.action.actionID.equals("ActionOne")) {
                Toast.makeText(MyApplication.getContext(), "Notification opening", Toast.LENGTH_LONG).show();
            } else if (osNotificationOpenResult.action.actionID.equals("ActionTwo")) {
                Toast.makeText(MyApplication.getContext(), "Notification closed", Toast.LENGTH_LONG).show();
            }
        }


    }
}
