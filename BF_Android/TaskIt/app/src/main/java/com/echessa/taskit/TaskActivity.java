package com.echessa.taskit;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;


public class TaskActivity extends ActionBarActivity {

    public static final String EXTRA = "TaskExtra";
    private static final String TAG = "TaskActivity";

    private Calendar mCal;
    private Task mTask;
    private Button mDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        mTask = (Task)getIntent().getSerializableExtra(EXTRA);

        mCal = Calendar.getInstance();
        if (mTask.getDueDate() != null) {
            mCal.setTime(mTask.getDueDate());
        }

        EditText taskNameInput = (EditText)findViewById(R.id.task_name);
        mDateButton = (Button)findViewById(R.id.task_date);
        CheckBox doneBox = (CheckBox)findViewById(R.id.task_done);
        Button saveButton = (Button)findViewById(R.id.save_button);

        taskNameInput.setText(mTask.getName());
        if (mTask.getDueDate() == null) {
            mDateButton.setText(getResources().getString(R.string.no_date));
        } else {
            updateButton();
        }
        doneBox.setChecked(mTask.isDone());

        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = new DatePickerDialog(TaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mCal.set(Calendar.YEAR, year);
                        mCal.set(Calendar.MONTH, monthOfYear);
                        mCal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        updateButton();
                    }
                }, mCal.get(Calendar.YEAR), mCal.get(Calendar.MONTH), mCal.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void updateButton() {
        DateFormat df = DateFormat.getDateInstance();
        mDateButton.setText(df.format(mCal.getTime()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task, menu);
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
