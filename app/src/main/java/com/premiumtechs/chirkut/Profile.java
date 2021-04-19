package com.premiumtechs.chirkut;

public class Profile {
    private String profileId;
    private String profileName;
    private String profileBio;

    public Profile(String profileId, String profileName, String profileBio) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.profileBio = profileBio;
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

    @Override
    public String toString() {
        return "Profile{" +
                "profileId='" + profileId + '\'' +
                ", profileName='" + profileName + '\'' +
                ", profileBio='" + profileBio + '\'' +
                '}';
    }
}
