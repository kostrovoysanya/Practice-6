package ru.mirea.kudriashov.room;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static ru.mirea.kudriashov.room.App instance;
    private ru.mirea.kudriashov.room.AppDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, ru.mirea.kudriashov.room.AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }
    public static ru.mirea.kudriashov.room.App getInstance() {
        return instance;
    }
    public ru.mirea.kudriashov.room.AppDatabase getDatabase() {
        return database;
    }
}
