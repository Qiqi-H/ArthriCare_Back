package com.example.arthricare.bean.valueObject;

public class ComityUserProfileData {

    private int numPosts;

    private int numLikes;

    public ComityUserProfileData() {
    }


    public int getNumPosts() {
        return numPosts;
    }

    public void setNumPosts(int numPosts) {
        this.numPosts = numPosts;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    @Override
    public String toString() {
        return "ComityUserProfileData{" +
                "numPosts=" + numPosts +
                ", numLikes=" + numLikes +
                '}';
    }
}
