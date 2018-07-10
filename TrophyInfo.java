package com.respect.presto.respectu;

import io.realm.RealmObject;

/**
 * Created by presto on 2017. 10. 13..
 */

public class TrophyInfo extends RealmObject {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String series="";
    private String titleKor="";
    private String contentKor="";
    private String titleEng="";
    private String contentEng="";
    private String rating="";

    public TrophyInfo(){}
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTitleKor() {
        return titleKor;
    }

    public void setTitleKor(String titleKor) {
        this.titleKor = titleKor;
    }

    public String getContentKor() {
        return contentKor;
    }

    public void setContentKor(String contentKor) {
        this.contentKor = contentKor;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public void setTitleEng(String titleEng) {
        this.titleEng = titleEng;
    }

    public String getContentEng() {
        return contentEng;
    }

    public void setContentEng(String contentEng) {
        this.contentEng = contentEng;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
