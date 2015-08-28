package com.materialtest;

/**
 * Created by angel on 8/25/2015.
 */
public class DataPojo {
    String name, description;
    int icon;

    public void setName(String value){
        this.name = value;
    }
    public void setDescription(String value){
        this.description = value;
    }

    public void setIcon(int value){
        this.icon = value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIcon() {
        return icon;
    }
}
