package com.premiumtechs.chirkut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Profile {
    private String profileId;
    private String profileName;
    private String profileBio;

    public Profile(String profileId, String profileName, String profileBio) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.profileBio = profileBio;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileBio() {
        return profileBio;
    }

    public void setProfileBio(String profileBio) {
        this.profileBio = profileBio;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId='" + profileId + '\'' +
                ", profileName='" + profileName + '\'' +
                ", profileBio='" + profileBio + '\'' +
                '}';
    }
}
