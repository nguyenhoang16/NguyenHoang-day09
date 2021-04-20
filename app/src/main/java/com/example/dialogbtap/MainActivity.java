package com.example.dialogbtap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dialogbtap.databinding.ActivityMainBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    int day = 0;
    int month = 0;
    int year =0;
    int hour = 0;
    int minute = 0;
    int savedDay = 0;
    int savedMonth = 0;
    int savedYear =0;
    int savedHour = 0;
    int savedMinute = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        binding.rlone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_save,popupMenu.getMenu());

                popupMenu.show();
            }
        });

        //Spinner type
        List<String> list = new ArrayList<>();
        list.add("Family");
        list.add("Work");
        list.add("Friend");

        ArrayAdapter<String>stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,list);
        binding.spType.setAdapter(stringArrayAdapter);

        String[] strings = {"Android","Kotlin","Flutter","IOS","PHP",".Net"};
        boolean[] booleans = {true,true,false,false,false,false};
        binding.tvTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose tags")
                        .setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                booleans[which] = isChecked;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String check = "";
                                boolean k =true;
                                for(int i = 0 ;i<booleans.length;i++){
                                    if(booleans[i] && k){
                                        check +=  strings[i];
                                        k = false;
                                    }
                                    else if(booleans[i] && k == false) {
                                        check += ", " + strings[i]  ;
                                    }
                                }
                                binding.tvTags.setText(check);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(),"No",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alertDialog.show();
            }
        });
        String[] strings1 = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        boolean[] booleans1 = {true,false,false,true,false,true,false};
        binding.tvWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose weeks")
                        .setMultiChoiceItems(strings1, booleans1, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                booleans1[which] = isChecked;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String check = "";
                                boolean k =true;
                                for(int i = 0 ;i<booleans1.length;i++){
                                    if(booleans1[i] && k){
                                        check +=  strings1[i];
                                        k = false;
                                    }
                                    else if(booleans1[i] && k == false) {
                                        check += ", " + strings1[i]  ;
                                    }
                                }
                                binding.tvWeeks.setText(check);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(),"No",Toast.LENGTH_LONG).show();
                            }
                        }).create();
                alertDialog.show();
            }
        });
        binding.btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_tune,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mnDefaults:
                                String[] strings = {"Nexus Tune","Winphone Tune","Peep Tune","Nokia Tune","Etc"};

                                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("").setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(getBaseContext(),strings[which],Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(getBaseContext(),"Okla",Toast.LENGTH_LONG).show();
                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(getBaseContext(),"No",Toast.LENGTH_LONG).show();
                                            }
                                        }).create();
                                alertDialog.show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        Calendar cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH) + 1;
        year = cal.get(Calendar.YEAR);
        hour = cal.get(Calendar.HOUR);
        minute = cal.get(Calendar.MINUTE);
        binding.tvTime.setText(DateFormat.format("hh:mm aa",cal));
        binding.tvDate.setText(DateFormat.format("dd/MM/yyyy",cal));
        binding.tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        savedHour = hourOfDay;
                        savedMinute = minute;

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,savedHour,savedMinute);
                       binding.tvTime.setText(DateFormat.format("hh:mm aa",calendar));
                    }
                },12,0,false);
                timePickerDialog.updateTime(savedHour,savedMinute);
                timePickerDialog.show();
            }
        });
        binding.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        savedDay = dayOfMonth;
                        savedMonth = month;
                        savedYear = year;

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(savedYear,savedMonth,savedDay,0,0);
                        binding.tvDate.setText(DateFormat.format("dd/MM/yyyy",calendar));
                    }
                },year,month,day);
                datePickerDialog.updateDate(savedYear,savedMonth,savedDay);
                datePickerDialog.show();
            }
        });
    }

}