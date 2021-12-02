package com.example.prueba3.analytics;

import android.util.Log;

import java.util.Map;

public class FlurryAnalytics implements AnalyticsAdapter{
    @Override
    public void report(String name, Map<String, String> data) {
        Log.d("developer","Report FlurryAnalytics: "+name);
    }
}
