package com.example.nestedrecycler;

public class General {

    private String mplayer;
    private String mjob;
    private int mimage;

    public General(){

    }
    public General(String player,String job){
        mplayer=player;
        mjob=job;
    }
    public General(int image){
        this.mimage=image;
    }

    public String getPlayer(){
        return mplayer;
    }

    public String getJob() {
        return mjob;
    }
    public int getImage(){
        return mimage;
    }
}
