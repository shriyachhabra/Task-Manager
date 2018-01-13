package chhabra.shriya.mytasks.db.Tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import chhabra.shriya.mytasks.Models.Task;
import chhabra.shriya.mytasks.db.Consts;

import static chhabra.shriya.mytasks.db.Consts.*;
/**
 * Created by LENOVO on 1/12/2018.
 */

public class TaskTable {

 private TaskTable() {
 }

 public static final String Table_Name="taskTable";

    public interface Columns {
        String ID="id";
        String TaskName= "name";
        String Address= "address";
        String Radius = "radius";
        String Latitude="latitude";
        String Longitude="longitude";
        String notification="notification";
    }

    public static final String CMD_CREATE_TABLE =
            CMD_CREATE_TABLE_INE +  Table_Name
                    + LBR
                    + Columns.ID + TYPE_INT + TYPE_PK_AI + COMMA
                    + Columns.TaskName + TYPE_TEXT + COMMA
                    + Columns.Address + TYPE_TEXT + COMMA
                    + Columns.Radius+ TYPE_INT+ COMMA
                    + Columns.Latitude+ TYPE_DOUBLE+ COMMA
                    + Columns.Longitude+ TYPE_DOUBLE+ COMMA
                    + Columns.notification+ TYPE_BOOLEAN
                    + RBR ;



    public static long insertTask(Task t, SQLiteDatabase db)
    {
        ContentValues newTask= new ContentValues();
        newTask.put(Columns.TaskName,t.getTaskName());
        newTask.put(Columns.Address,t.getPlaceAddress());
        newTask.put(Columns.Radius,t.getRadius());
        newTask.put(Columns.Latitude,t.getLatitude());
        newTask.put(Columns.Longitude,t.getLongitude());
        newTask.put(Columns.notification,t.getNotification());
        return db.insert(Table_Name,null,newTask);
    }



    public static ArrayList<Task> getAllTasks(SQLiteDatabase db)
    {
        Cursor c=db.query(
                Table_Name,
                new String[]{Columns.TaskName,Columns.Address,Columns.Radius,Columns.Latitude,Columns.Longitude,Columns.notification},
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<Task> allTasks= new ArrayList<>();
        c.moveToFirst();

        int idIndex=c.getColumnIndex(Columns.ID);
        int TaskNameIndex=c.getColumnIndex(Columns.TaskName);
        int AddressIndex=c.getColumnIndex(Columns.Address);
        int RadiusIndex=c.getColumnIndex(Columns.Radius);
        int LatitudeIndex=c.getColumnIndex(Columns.Latitude);
        int LongitudeIndex=c.getColumnIndex(Columns.Longitude);
        int NotiIndex=c.getColumnIndex(Columns.notification);



        while (!c.isAfterLast())
        {
            allTasks.add(new Task(
                    c.getString(TaskNameIndex),
                    c.getString(AddressIndex),
                    c.getInt(RadiusIndex),
                    c.getDouble(LatitudeIndex),
                    c.getDouble(LongitudeIndex),
                    c.getInt(NotiIndex)==1
            ));

            c.moveToNext();
        }
        return allTasks;

    }





}