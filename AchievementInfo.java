package com.respect.presto.respectu;

import io.realm.RealmObject;

/**
 * Created by presto on 2017. 11. 19..
 */

public class AchievementInfo extends RealmObject{
    private int id;
    private String title="";
    private int level=0;
    private String type="";
    private String item="";

    public AchievementInfo(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


}
