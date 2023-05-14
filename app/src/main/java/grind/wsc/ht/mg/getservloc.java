package grind.wsc.ht.mg;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

import android.util.Log;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;


public class getservloc extends Service {
    private static final String CHANNEL_ID = "grinch1";
    private Looper myLooperService;
    private ServiceHandler mServiceHandler;
    Handler mHandler;
    Timer timer = new Timer();
    TimerTask task;
    private String getrecin;


    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {

            try {

                task = new TimerTask() {

                    @Override
                    public void run() {
                        try {


                            getreqmsg();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                timer.schedule(task, 0, 5000);

            } catch (Exception e) {

                Thread.currentThread().interrupt();
            }

        }
    }

    @Override
    public void onCreate() {

        HandlerThread thread = new HandlerThread("grindsar");
        thread.start();

        myLooperService = thread.getLooper();
        mServiceHandler = new ServiceHandler(myLooperService);
    }
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);


        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onDestroy() {


    }
    public String getreqmsg(){
        String url = "http://www.grindlaysmangalam.com/android/getmsg.ashx";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        getrecin = response.toString();
                        Intent intent = new Intent(MangalamAct.RECEIVER_INTENT);
                        intent.putExtra(MangalamAct.RECEIVER_MESSAGE, getrecin);
                        LocalBroadcastManager.getInstance(getservloc.this).sendBroadcast(intent);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.wtf("snwc", "tec");


                    }
                });


        singletongm.getInstance(this).addToRequestQueue(jsonObjectRequest);
        return getrecin;
    }
}