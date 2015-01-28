package com.inspiron.tharun26.manusys;

/**
 * Created by tharun26 on 28/1/15.
 */
public class NotificationDb {

    int id;
    String notification;

    public NotificationDb(int id, String notification) {
        this.id = id;
        this.notification = notification;
    }

    public NotificationDb(String notification) {
        this.notification = notification;
    }

    public NotificationDb() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

}
