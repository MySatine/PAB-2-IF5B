package com.if5b.contact.loaders;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.if5b.contact.databases.UserDatabase;

public class DeleteLoader extends AsyncTaskLoader<Integer> {
    private UserDatabase db;
    private int userId;

    public DeleteLoader(@NonNull Context context, int userId) {
        super(context);
        db = UserDatabase.getInstance(context);
        this.userId = userId;
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        return db.userDao().deleteUser(userId);
    }
}
