package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agenda.db";
    public static final String TABLE_CONTACTOS = "tbContactos";

    public DBHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTOS + "(" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "nombre TEXT NOT NULL, " +
                                "telefono TEXT NOT NULL, " +
                                "correo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONTACTOS);
        onCreate(sqLiteDatabase);
    }
}
