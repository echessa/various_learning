package com.echessa.taskit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TaskListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Task[] items = new Task[3];
        items[0] = new Task();
        items[0].setName("Task 1");
        items[1] = new Task();
        items[1].setName("Task 2");
        items[2] = new Task();
        items[2].setName("Task 3");

        ListView listView = (ListView)findViewById(R.id.task_list);
        listView.setAdapter(new TaskAdapter(items));
    }

    private class TaskAdapter extends ArrayAdapter<Task> {
        TaskAdapter(Task[] tasks) {
            super(TaskListActivity.this, android.R.layout.simple_list_item_1, tasks);
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
