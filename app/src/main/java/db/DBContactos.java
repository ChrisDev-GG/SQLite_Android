package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import db.DBHelper;

import androidx.annotation.Nullable;

public class DBContactos  extends DBHelper{
    Context context;

    public DBContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public boolean insertarContacto(String nombre, String telefono, String correo){
        boolean id = false;
        try{
            DBHelper dbh = new DBHelper(context);
            SQLiteDatabase db = dbh.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo", correo);

            id = db.insert(TABLE_CONTACTOS, null, values) != 0 ? true : false;
        }catch(Exception e){
            e.toString();
        }
        return id;
    }
}
