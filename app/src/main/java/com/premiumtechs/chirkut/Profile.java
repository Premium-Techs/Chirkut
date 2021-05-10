package com.premiumtechs.chirkut;

import java.io.Serializable;

public class Profile implements Serializable {
    private String profileId;
    private String profileName;
    private String profileBio;
    private String profilePhoneNo;

    public Profile() {

    }

    public Profile(String profileId, String profileName, String profilePhoneNo, String profileBio) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.profilePhoneNo = profilePhoneNo;
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

    public String getProfilePhoneNo() {
        return profilePhoneNo;
    }

    public void setProfilePhoneNo(String profilePhoneNo) {
        this.profilePhoneNo = profilePhoneNo;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId='" + profileId + '\'' +
                ", profileName='" + profileName + '\'' +
                ", profileBio='" + profileBio + '\'' +
                ", profilePhoneNo='" + profilePhoneNo + '\'' +
                '}';
    }
}
