package com.example.contact.Javabean;

public class Record {
    private String uid;//用户id
    private String id;//备忘录id
    private String title;//备忘录标题
    private String context;//备忘录正文
    private String time;//备忘录时间

    public Record(String uid,String id,String title, String context, String time) {
        this.uid = uid;
        this.id = id;
        this.title = title;
        this.context = context;
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
