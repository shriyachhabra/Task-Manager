package chhabra.shriya.mytasks.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import chhabra.shriya.mytasks.Models.Task;
import chhabra.shriya.mytasks.R;

/**
 * Created by LENOVO on 1/10/2018.
 */

public class TaskRecyclerAdapter extends RecyclerView.Adapter<TaskRecyclerAdapter.CourseViewHolder> {
    private Context context;
    private ArrayList<Task> tasks;

    public TaskRecyclerAdapter(Context context,ArrayList<Task> task) {
        this.context=context;
        this.tasks=task;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(viewType, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.task_item;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
         Task currtask=tasks.get(position);
         String r=String.valueOf(currtask.getRadius());
         holder.TaskName.setText(currtask.getTaskName());
         holder.TaskPlace.setText(currtask.getPlaceAddress());
         holder.TaskRadius.setText(r);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


    public class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView TaskName,TaskPlace,TaskRadius;

        public CourseViewHolder(View itemView) {
            super(itemView);
            TaskName=itemView.findViewById(R.id.task_item_name);
            TaskPlace=itemView.findViewById(R.id.task_item_place);
            TaskRadius=itemView.findViewById(R.id.task_item_radius);
        }
    }
}
