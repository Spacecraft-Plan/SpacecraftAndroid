package com.jamesfchen.myhome;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.metrics.AddTrace;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.jamesfchen.common.util.ActivityUtil;
import com.jamesfchen.loader.App;
import com.jamesfchen.uicomponent.widget.recyclerview.RecyclerViewActivity;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
/**
 * Copyright ® $ 2017
 * All right reserved.
 * Code Link : https://github.com/jamesfchen/Spacecraft
 *
 * @author: jamesfchen
 * @since: 2017/7/4
 */
public class SplashActivity extends AbsPermissionsActivity {
    public static final String TAG = "SplashActivity";
    private FirebaseAnalytics mFirebaseAnalytics;
    private Trace myTrace;
    private HttpMetric mHttpMetric;
    private FirebaseRemoteConfig mFirebaseRemoteConfig = App.getFirebaseRemoteConfig();

    @AddTrace(name = "SplashActivity_onCreate", enabled = true /* optional */)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }
    @SuppressLint("CheckResult")
//    @TraceTime
    protected void onRequestPermissionsResult() {
        Observable.timer(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    ActivityUtil.startActivity(RecyclerViewActivity.class, ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
//                        startActivity(FlutterActivity.createDefaultIntent(SplashActivity.this));
                    finish();
                });

//        myTrace = FirebasePerformance.getInstance().newTrace("loadData");r
//        myTrace.start();r
//        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
//        mHttpMetric = FirebasePerformance.getInstance().newHttpMetric("https://www.google.com", FirebasePerformance.HttpMethod.GET);
//        mHttpMetric.start();
//        onDestroyDisposable.add(Observable.timer(1, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        //todo:需要通过refresh token来判断进入那个界面
//                        myTrace.incrementMetric("started activity", 1);
//                        mHttpMetric.setHttpResponseCode(200);
//                        mHttpMetric.setResponseContentType("application/x-protobuf");
//
//                        Bundle bundle = new Bundle();
//                        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "id");
//                        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "name");
//                        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
//                        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
//                        ActivityUtil.startActivity(LocationActivity.class, ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
////                        TransitionForActivityActivity.startActivity(SplashActivity.this);
//                        finish();
//                    }
//                }));
//        fetchWelcome();
//        myTrace.stop();
//        mHttpMetric.stop();

//        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event);

    }

    // Remote Config keys
    private static final String LOADING_PHRASE_CONFIG_KEY = "loading_phrase";
    private static final String WELCOME_MESSAGE_KEY = "welcome_message";

    private void fetchWelcome() {
        Log.i(TAG, "LOADING_PHRASE_CONFIG_KEY:" + mFirebaseRemoteConfig.getString(LOADING_PHRASE_CONFIG_KEY));
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            boolean updated = task.getResult();
                            Log.i(TAG, "Config params updated: " + updated);
                            Toast.makeText(SplashActivity.this, "Fetch and activate succeeded",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(SplashActivity.this, "Fetch failed",
                                    Toast.LENGTH_SHORT).show();
                        }

                        String welcomeMessage = mFirebaseRemoteConfig.getString(WELCOME_MESSAGE_KEY);
                        Log.i(TAG, "WELCOME_MESSAGE_KEY: " + welcomeMessage);

                    }
                });
    }

}
