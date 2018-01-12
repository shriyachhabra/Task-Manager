package chhabra.shriya.mytasks.db.Tables;

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

    }

    public static final String CMD_CREATE_TABLE =
            CMD_CREATE_TABLE_INE +  Table_Name
                    + LBR
                    + Columns.ID + TYPE_INT + TYPE_PK_AI + COMMA
                    + Columns.TaskName + TYPE_TEXT + COMMA
                    + Columns.Address + TYPE_TEXT + COMMA
                    + Columns.Radius+TYPE_TEXT+COMMA
                    + Columns.Latitude+TYPE_TEXT+COMMA
                    + Columns.Longitude+TYPE_TEXT
                    + RBR + SEMI;

}