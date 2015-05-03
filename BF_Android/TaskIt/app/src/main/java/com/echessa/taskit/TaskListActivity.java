package com.echessa.taskit;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;


public class TaskListActivity extends ActionBarActivity {

    private static final String TAG = "TaskListActivity";
    private static final int EDIT_TASK_REQUEST = 10;

    private Task[] mTasks;
    private int mLastPositionClicked;
    private TaskAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        mTasks = new Task[3];
        mTasks[0] = new Task();
        mTasks[0].setName("Task 1");
        mTasks[0].setDueDate(new Date());
        mTasks[1] = new Task();
        mTasks[1].setName("Task 2");
        mTasks[1].setDone(true);
        mTasks[2] = new Task();
        mTasks[2].setName("Task 3");

        ListView listView = (ListView)findViewById(R.id.task_list);
        mAdapter = new TaskAdapter(mTasks);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mLastPositionClicked = position;
                Intent i = new Intent(TaskListActivity.this, TaskActivity.class);
                Task task = (Task)parent.getAdapter().getItem(position);
                i.putExtra(TaskActivity.EXTRA, task);
                startActivityForResult(i, EDIT_TASK_REQUEST);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_TASK_REQUEST) {
            if (resultCode == RESULT_OK) {
                Task task = (Task)data.getSerializableExtra(TaskActivity.EXTRA);
                mTasks[mLastPositionClicked] = task;
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    private class TaskAdapter extends ArrayAdapter<Task> {
        TaskAdapter(Task[] tasks) {
            super(TaskListActivity.this, R.layout.task_list_row, R.id.task_item_name, tasks);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView =  super.getView(position, convertView, parent);
            Task task = getItem(position);
            TextView taskName = (TextView)convertView.findViewById(R.id.task_item_name);
            taskName.setText(task.getName());

            CheckBox doneBox = (CheckBox)convertView.findViewById(R.id.task_item_done);
            doneBox.setChecked(task.isDone());

            return convertView;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
