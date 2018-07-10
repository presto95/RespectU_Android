package com.respect.presto.respectu;

import io.realm.RealmObject;

/**
 * Created by presto on 2017. 10. 13..
 */

public class MissionInfo extends RealmObject {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String type="";
    private String section="";
    private String title="";
    private String song1title="";
    private String song1level="";
    private String song1key="";
    private String song2title="";
    private String song2level="";
    private String song2key="";
    private String song3title="";
    private String song3level="";
    private String song3key="";
    private String song4title="";
    private String song4level="";
    private String song4key="";
    private String song5title="";
    private String song5level="";
    private String song5key="";
    private String song6title="";
    private String song6level="";
    private String song6key="";
    private int scoreLimit=0;
    private int feverLimit=0;
    private int comboLimit=0;
    private int rateLimit=0;
    private int breakLimit=0;
    private String more="";
    private String reward="";

    public MissionInfo(){}
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSong1title() {
        return song1title;
    }

    public void setSong1title(String song1title) {
        this.song1title = song1title;
    }

    public String getSong1level() {
        return song1level;
    }

    public void setSong1level(String song1level) {
        this.song1level = song1level;
    }

    public String getSong1key() {
        return song1key;
    }

    public void setSong1key(String song1key) {
        this.song1key = song1key;
    }

    public String getSong2title() {
        return song2title;
    }

    public void setSong2title(String song2title) {
        this.song2title = song2title;
    }

    public String getSong2level() {
        return song2level;
    }

    public void setSong2level(String song2level) {
        this.song2level = song2level;
    }

    public String getSong2key() {
        return song2key;
    }

    public void setSong2key(String song2key) {
        this.song2key = song2key;
    }

    public String getSong3title() {
        return song3title;
    }

    public void setSong3title(String song3title) {
        this.song3title = song3title;
    }

    public String getSong3level() {
        return song3level;
    }

    public void setSong3level(String song3level) {
        this.song3level = song3level;
    }

    public String getSong3key() {
        return song3key;
    }

    public void setSong3key(String song3key) {
        this.song3key = song3key;
    }

    public String getSong4title() {
        return song4title;
    }

    public void setSong4title(String song4title) {
        this.song4title = song4title;
    }

    public String getSong4level() {
        return song4level;
    }

    public void setSong4level(String song4level) {
        this.song4level = song4level;
    }

    public String getSong4key() {
        return song4key;
    }

    public void setSong4key(String song4key) {
        this.song4key = song4key;
    }

    public String getSong5title() {
        return song5title;
    }

    public void setSong5title(String song5title) {
        this.song5title = song5title;
    }

    public String getSong5level() {
        return song5level;
    }

    public void setSong5level(String song5level) {
        this.song5level = song5level;
    }

    public String getSong5key() {
        return song5key;
    }

    public void setSong5key(String song5key) {
        this.song5key = song5key;
    }

    public String getSong6title() {
        return song6title;
    }

    public void setSong6title(String song6title) {
        this.song6title = song6title;
    }

    public String getSong6level() {
        return song6level;
    }

    public void setSong6level(String song6level) {
        this.song6level = song6level;
    }

    public String getSong6key() {
        return song6key;
    }

    public void setSong6key(String song6key) {
        this.song6key = song6key;
    }

    public int getScoreLimit() {
        return scoreLimit;
    }

    public void setScoreLimit(int scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

    public int getFeverLimit() {
        return feverLimit;
    }

    public void setFeverLimit(int feverLimit) {
        this.feverLimit = feverLimit;
    }

    public int getComboLimit() {
        return comboLimit;
    }

    public void setComboLimit(int comboLimit) {
        this.comboLimit = comboLimit;
    }

    public int getRateLimit() {
        return rateLimit;
    }

    public void setRateLimit(int rateLimit) {
        this.rateLimit = rateLimit;
    }

    public int getBreakLimit() {
        return breakLimit;
    }

    public void setBreakLimit(int breakLimit) {
        this.breakLimit = breakLimit;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }


}
