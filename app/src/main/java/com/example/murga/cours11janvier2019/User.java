package com.example.murga.cours11janvier2019;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String login;
    private String password;
    public User(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }
    public User(Parcel source) {
        this.login = source.readString();
        this.password = source.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(password);
    }

    public static final Parcelable.Creator<User> CREATOR = new
            Parcelable.Creator<User>() {
                @Override
                public User createFromParcel(Parcel source) {
                    return new User(source);
                }
                @Override
                public User[] newArray(int size) {
                    return new User[size];
                }
            };
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
