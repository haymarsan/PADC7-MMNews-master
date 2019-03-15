package com.padcmyanmar.padc7.mmnews.utils;

import com.google.gson.Gson;

public class CommomInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
