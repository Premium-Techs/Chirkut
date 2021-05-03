package com.premiumtechs.chirkut;

public class Profile {
    private String profileId;
    private String profileName;
    private String profileBio;
    private String profilePhoneNo;

    public Profile() {

    }

    public Profile(String profileId, String profileName, String profileBio, String profilePhoneNo) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.profileBio = profileBio;
        this.profilePhoneNo = profilePhoneNo;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileBio(String profileBio) {
        this.profileBio = profileBio;
    }

    public String getProfileBio() {
        return profileBio;
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
