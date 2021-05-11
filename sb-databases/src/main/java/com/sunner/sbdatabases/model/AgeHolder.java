package com.sunner.sbdatabases.model;

public class AgeHolder {
    private int lower;
    private int upper;


    public AgeHolder(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public AgeHolder() {
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    @Override
    public String toString() {
        return "AgeHolder{" +
                "lower=" + lower +
                ", upper=" + upper +
                '}';
    }
}
