package com.rrinc.pustice.support;

import android.content.Context;
import android.content.SharedPreferences;

public class User {

    Context context;
    private String ID;

    public String getID() {
        ID = sharedPreferences.getString("userdata","");
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
        sharedPreferences.edit().putString("userdata",ID).commit();
    }

    SharedPreferences sharedPreferences;

    public User(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
    }

    public void removeUser(){
        sharedPreferences.edit().clear().commit();
    }
}
