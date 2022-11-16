package com.example.sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import db.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.newMenu:
                newRegister();
                return true;
            case R.id.createDB:
                createDB();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void newRegister(){
        Intent openRegister = new Intent(this, Form.class);
        startActivity(openRegister);
    }

    private void createDB(){
        DBHelper dbh = new DBHelper(MainActivity.this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        if(db != null){
            Toast.makeText(MainActivity.this, "Base de datos Creada", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Error al crear la Base de Datos", Toast.LENGTH_SHORT).show();
        }
    }
}