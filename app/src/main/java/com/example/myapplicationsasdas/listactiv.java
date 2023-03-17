package com.example.myapplicationsasdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class listactiv extends AppCompatActivity {

    private ListView list_view;
    private ArrayList<User> userArrayList;
    private ArrayAdapter<User> userArrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        list_view = findViewById(R.id.list_view);
        userArrayList = new ArrayList<User>();

        userArrayList.add(new User("Paulina", "pp@gm", "asdasd"));
        userArrayList.add(new User("Paulinwewera", "pp@gwm", "asdasd"));
        userArrayList.add(new User("Pauliwerwerna", "pp@gwwm", "asdasd"));


        userArrayAdapter = new UserArrayAdapter(this,R.layout.custom_row, userArrayList);
        list_view.setAdapter(userArrayAdapter);
//       textView = findViewById(R.id.textview);

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