package com.sunner.springbootapis.api.model;

public class Car {

    private long id;
    private String mark;
    private String color;

    public Car(long id, String mark, String color) {
        this.id = id;
        this.mark = mark;
        this.color = color;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
