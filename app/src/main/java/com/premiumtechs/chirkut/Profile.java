package com.premiumtechs.chirkut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Profile {
    private String profileName;
    private String profileBio;

    public Profile(String profileNameName, String profileBio){
        this.profileName = profileName;
        this.profileBio = profileBio;
    }
    public String getProfileName() {return profileName;}
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileBio() {return profileBio;}
    public void setProfileBio(String profileBio) {
        this.profileBio = profileBio;
    }

}
