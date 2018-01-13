package chhabra.shriya.mytasks;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.ui.PlacePicker;

import chhabra.shriya.mytasks.Models.Task;

public class AddItemActivity extends AppCompatActivity {
    TextView place_name;
    Switch swtch;
    ImageView imageMap;
    Button addTask;
    EditText  range_m;
    TextInputEditText task_name;
    public  static String TaskName;
    String placeName,remRange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        task_name=findViewById(R.id.task_name);
        range_m=findViewById(R.id.range_m);
        addTask=findViewById(R.id.addTask);
        place_name=findViewById(R.id.place);
        swtch=findViewById(R.id.swtch);
        imageMap=findViewById(R.id.imageMap);

        addTask.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              TaskName=task_name.getText().toString();
              placeName=place_name.getText().toString();
              remRange=range_m.getText().toString();

              if(TaskName!=""&&placeName!=""&&remRange!="") {
                  Task t= new Task(TaskName,placeName,remRange);
                  Intent j= new Intent(AddItemActivity.this,MainActivity.class);
                  j.putExtra("tname",TaskName);
                  j.putExtra("pname",placeName);
                  j.putExtra("remRange",remRange);
                  startActivity(j);
              }
            }
        });
        imageMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
                    Intent intent = intentBuilder.build(AddItemActivity.this);
                    startActivityForResult(intent, 100);

                } catch (GooglePlayServicesRepairableException e) {
                    GooglePlayServicesUtil
                            .getErrorDialog(e.getConnectionStatusCode(),AddItemActivity.this, 0);
                } catch (GooglePlayServicesNotAvailableException e) {
                    Toast.makeText(AddItemActivity.this, "Google Play Services is not available.",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {

                final com.google.android.gms.location.places.Place place = PlacePicker.getPlace(data, this);

                final CharSequence name = place.getName();
                final CharSequence address = place.getAddress();
                final CharSequence phone = place.getPhoneNumber();
                final String placeId = place.getId();
                String attribution = PlacePicker.getAttributions(data);
                if (attribution == null) {
                    attribution = "";
                }

                Log.d("TAG", "Place selected: " + placeId + " (" + name.toString() + ")");
                place_name.setText(name.toString());
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}