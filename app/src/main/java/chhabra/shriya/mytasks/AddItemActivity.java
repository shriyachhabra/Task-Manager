package chhabra.shriya.mytasks;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import chhabra.shriya.mytasks.Models.Task;

public class AddItemActivity extends AppCompatActivity {
    LinearLayout alarm;
    TextView place,ed;
    ImageView back,imageMap;
    Button addTask;
    EditText  task_name, range_m;
    public  static String TaskName;
    String placeName,remRange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        back=findViewById(R.id.backfromAdd);
        task_name=findViewById(R.id.task_name);
        range_m=findViewById(R.id.range_m);
        addTask=findViewById(R.id.addTask);
        place=findViewById(R.id.place);
        alarm=findViewById(R.id.alarm);
        ed=findViewById(R.id.ed);
        imageMap=findViewById(R.id.imageMap);

        Intent i=getIntent();
        Bundle bundle1=i.getExtras();

        if(bundle1!=null) {
            String p= getIntent().getStringExtra("placeP");
            place.setText(p);
            task_name.setText(TaskName);
        }


        back.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent backtoMain= new Intent(AddItemActivity.this,MainActivity.class);
              startActivity(backtoMain);
          }
      });


      addTask.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
               TaskName=task_name.getText().toString();
              placeName=place.getText().toString();
               remRange=range_m.getText().toString();



              if(TaskName!=""&&placeName!=""&&remRange!="")
              {

                  Task t= new Task(TaskName,placeName,remRange);
                  Intent j= new Intent(AddItemActivity.this,MainActivity.class);
                  j.putExtra("tname",TaskName);
                  j.putExtra("pname",placeName);
                  j.putExtra("remRange",remRange);
                  startActivity(j);


              }

          }
      });


      alarm.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              String txt= ed.getText().toString();

              if(txt.equals("disabled"))
              {
                  ed.setText("enabled");
              }
              if(txt.equals("enabled"))
              {
                  ed.setText("disabled");
              }

          }
      });

      imageMap.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              TaskName=task_name.getText().toString();
              Intent i = new Intent(AddItemActivity.this,Place.class);
              startActivity(i);
          }
      });

    }


}

