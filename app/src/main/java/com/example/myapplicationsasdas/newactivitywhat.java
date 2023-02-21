package com.example.myapplicationsasdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class newactivitywhat extends AppCompatActivity {

    private ListView listView;
    private ArrayList<User> userArrayList;
    private ArrayAdapter<User> userArrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newactivitywhat);
//        textView = findViewById(R.id.textview);

//        Intent intent = getIntent();
//        String varname = intent.getStringExtra (name);
//        textView.setText(food);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.goback) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return true;

    }
}