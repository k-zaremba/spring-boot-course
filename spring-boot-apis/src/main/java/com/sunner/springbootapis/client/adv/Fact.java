package com.sunner.springbootapis.client.adv;

public class Fact
{
    private Status status;

    private String type;

    private boolean deleted;

    private String _id;

    private int __v;

    private String text;

    private String source;

    private String updatedAt;

    private String createdAt;

    private boolean used;

    private String user;

    private String src;


    public boolean isDeleted() {
        return deleted;
    }

    public boolean isUsed() {
        return used;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return this.status;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }
    public boolean getDeleted(){
        return this.deleted;
    }
    public void set_id(String _id){
        this._id = _id;
    }
    public String get_id(){
        return this._id;
    }
    public void set__v(int __v){
        this.__v = __v;
    }
    public int get__v(){
        return this.__v;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return this.source;
    }
    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
    public String getUpdatedAt(){
        return this.updatedAt;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public void setUsed(boolean used){
        this.used = used;
    }
    public boolean getUsed(){
        return this.used;
    }
    public void setUser(String user){
        this.user = user;
    }
    public String getUser(){
        return this.user;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "status=" + status +
                ", type='" + type + '\'' +
                ", deleted=" + deleted +
                ", _id='" + _id + '\'' +
                ", __v=" + __v +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", used=" + used +
                ", user='" + user + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}

class Status
{
    private boolean verified;

    private int sentCount;

    public void setVerified(boolean verified){
        this.verified = verified;
    }
    public boolean getVerified(){
        return this.verified;
    }
    public void setSentCount(int sentCount){
        this.sentCount = sentCount;
    }
    public int getSentCount(){
        return this.sentCount;
    }

    @Override
    public String toString() {
        return "Status{" +
                "verified=" + verified +
                ", sentCount=" + sentCount +
                '}';
    }
}
