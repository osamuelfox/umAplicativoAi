package dev.samuel.teste.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Agenda_DB extends SQLiteOpenHelper {

    private static final String DB_NAME = "Agenda_DB";
    private static final int DB_VERSION = 2;

    Cursor cursor;

    SQLiteDatabase db;

    public Agenda_DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    // TODO: 10/07/2023 Terminar isso amanha - Banco de dados

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTable =
                "CREATE TABLE Lista (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Titulo TEXT, " +
                        "Data TEXT, " +
                        "Hora TEXT, " +
                        "Local TEXT, " +
                        "Curso" +")";

        db.execSQL(sqlTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela, null, dados);
    }
}
