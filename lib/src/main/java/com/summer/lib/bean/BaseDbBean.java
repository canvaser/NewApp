package com.summer.lib.bean;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

public class BaseDbBean implements Serializable {


    public static final String ID = "id";


    @DatabaseField(generatedId = true)
    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
