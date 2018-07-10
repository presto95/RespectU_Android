package com.respect.presto.respectu;

import io.realm.RealmObject;

/**
 * Created by presto on 2017. 10. 13..
 */

public class SongInfo extends RealmObject {
    private int id;
    private String series="";
    private String title="";
    private String composer="";
    private String bpm="";
    private int nm4=0;
    private int nm5=0;
    private int nm6=0;
    private int nm8=0;
    private int hd4=0;
    private int hd5=0;
    private int hd6=0;
    private int hd8=0;
    private int mx4=0;
    private int mx5=0;
    private int mx6=0;
    private int mx8=0;
    private String lowercase="";



    public SongInfo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public int getNm4() {
        return nm4;
    }

    public void setNm4(int nm4) {
        this.nm4 = nm4;
    }

    public int getNm5() {
        return nm5;
    }

    public void setNm5(int nm5) {
        this.nm5 = nm5;
    }

    public int getNm6() {
        return nm6;
    }

    public void setNm6(int nm6) {
        this.nm6 = nm6;
    }

    public int getNm8() {
        return nm8;
    }

    public void setNm8(int nm8) {
        this.nm8 = nm8;
    }

    public int getHd4() {
        return hd4;
    }

    public void setHd4(int hd4) {
        this.hd4 = hd4;
    }

    public int getHd5() {
        return hd5;
    }

    public void setHd5(int hd5) {
        this.hd5 = hd5;
    }

    public int getHd6() {
        return hd6;
    }

    public void setHd6(int hd6) {
        this.hd6 = hd6;
    }

    public int getHd8() {
        return hd8;
    }

    public void setHd8(int hd8) {
        this.hd8 = hd8;
    }

    public int getMx4() {
        return mx4;
    }

    public void setMx4(int mx4) {
        this.mx4 = mx4;
    }

    public int getMx5() {
        return mx5;
    }

    public void setMx5(int mx5) {
        this.mx5 = mx5;
    }

    public int getMx6() {
        return mx6;
    }

    public void setMx6(int mx6) {
        this.mx6 = mx6;
    }

    public int getMx8() {
        return mx8;
    }

    public void setMx8(int mx8) {
        this.mx8 = mx8;
    }

    public String getLowercase() {
        return lowercase;
    }

    public void setLowercase(String lowercase) {
        this.lowercase = lowercase;
    }
}