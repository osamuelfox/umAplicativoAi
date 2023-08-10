package dev.samuel.teste.agenda.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class IMC_BD extends SQLiteOpenHelper {

    private static final String DB_NAME = "IMC_DB";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db1;

    public IMC_BD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db1 = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        String sqlTableIMC =
                "CREATE TABLE IMC (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Peso TEXT, " +
                        "ALtura TEXT, " +
                        "Resultado TEXT)";

        db1.execSQL(sqlTableIMC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados){

        db1.insert(tabela, null, dados);

    }
}
