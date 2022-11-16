package com.example.sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import db.DBContactos;

public class Form extends AppCompatActivity {
    EditText txtName, txtPhone, txtEmail;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtName = (EditText) findViewById(R.id.txtName);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBContactos dbContactos = new DBContactos(Form.this);
                boolean id = dbContactos.insertarContacto(
                        txtName.getText().toString(),
                        txtPhone.getText().toString(),
                        txtEmail.getText().toString());
                if(id){
                    Toast.makeText(Form.this, "Registro Guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(Form.this, "Error al Guardar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiar(){
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }
}