package chhabra.shriya.mytasks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import chhabra.shriya.mytasks.Adapters.TaskRecyclerAdapter;
import chhabra.shriya.mytasks.Models.Task;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Task> tasks=new ArrayList<>();
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,AddItemActivity.class);
                startActivity(i);

            }
        });

        String tname1="",pname1="",remRange="";

        Task t;
        rv=findViewById(R.id.rv);
        Intent intent1=getIntent();
        Bundle bundle1=intent1.getExtras();

        if(bundle1!=null) {
            tname1 = intent1.getStringExtra("tname");
            pname1 = intent1.getStringExtra("pname");
            remRange =intent1.getStringExtra("remRange");

            t = new Task(tname1, pname1,remRange+"m");
            tasks.add(t);
        }

        TaskRecyclerAdapter tra= new TaskRecyclerAdapter(this,tasks);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(tra);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                break;
        }

        return true;
    }
}
