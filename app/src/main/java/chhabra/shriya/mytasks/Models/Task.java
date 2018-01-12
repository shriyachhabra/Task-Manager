package chhabra.shriya.mytasks.Models;

/**
 * Created by LENOVO on 1/10/2018.
 */

public class Task {
    String taskName;
    String placeAddress;
    String radius;

    public Task(String taskName,String placeAddress,String radius)
    {
        this.taskName=taskName;
        this.placeAddress=placeAddress;
        this.radius=radius;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public String getRadius() {
        return radius;
    }


}
