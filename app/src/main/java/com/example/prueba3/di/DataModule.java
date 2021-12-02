package com.example.prueba3.di;

import android.content.Context;

import androidx.room.Room;

import com.example.prueba3.analytics.AnalyticsAdapter;
import com.example.prueba3.analytics.FlurryAnalytics;
import com.example.prueba3.analytics.GoogleAnalytics;
import com.example.prueba3.data.AppDatabase;
import com.example.prueba3.data.dao.UserDao;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn( SingletonComponent.class )
public class DataModule
{

    @Provides
    @Singleton
    public AnalyticsAdapter provideAnalyticsAdapter()
    {
        return new FlurryAnalytics();
    }

    @Provides
    @Singleton
    public AppDatabase appDatabase(@ApplicationContext Context context)
    {
        AppDatabase db = Room.databaseBuilder(context,
                AppDatabase.class, "database-name").build();
        return db;
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(AppDatabase appDatabase){
        return appDatabase.userDao();
    }

    @Provides
    @Singleton
    public Executor providerExecutorApp(){
        return Executors.newFixedThreadPool(1);
    }

}
