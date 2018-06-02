package jp.ac.titech.itpro.sdl.serviceex1;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class TestService3 extends IntentService {
    private final static String TAG = "TestService3";
    public final static String EXTRA_MYARG = "MYARG";
    public final static String ACTION_ANSWER = "TestService3_ACTION";
    public final static String EXTRA_ANSWER = "TestService3_EXTRA";

    TestService3() {
        super(TAG);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand in " + Thread.currentThread());
        Intent answerIntent = new Intent();
        answerIntent.setAction(ACTION_ANSWER);
        answerIntent.putExtra(EXTRA_ANSWER, "すごいぜ");
        sendBroadcast(answerIntent);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}

