package chhabra.shriya.mytasks.Models;

/**
 * Created by LENOVO on 1/10/2018.
 */

public class Task {
    String taskName;
    String placeAddress;
    int radius;
    double latitude;
    double longitude;
    boolean notification;


    public Task(String taskName, String placeAddress, int radius,  double latitude,double longitude, boolean notify)
    {
        this.taskName=taskName;
        this.placeAddress=placeAddress;
        this.radius=radius;
        this.latitude=latitude;
        this.longitude=longitude;
        this.notification=notify;

    }

    public String getTaskName() {
        return taskName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public int getRadius() {
        return radius;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean getNotification() {
        return notification;
    }


}
