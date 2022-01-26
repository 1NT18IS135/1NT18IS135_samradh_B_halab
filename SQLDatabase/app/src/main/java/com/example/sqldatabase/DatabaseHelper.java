package com.example.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int version = 1;
    public static final String dbName = "Student.db";
    public static final String TABLE_NAME ="StudData";
    public static final String COL1 = "id";
    public static final String COL2 = "name";
    public static final String COL3 = "usn";
    public static final String COL4 = "semester";
    public static final String COL5 = "marks";

    private static final String CREATE_TABLE = "create table if not exists " +
            TABLE_NAME + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL2 + " TEXT NOT NULL," + COL3 + " TEXT, " + COL4 + " INTEGER, " + COL5 + " INTEGER);";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, dbName,null, version);
        context = this.context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean InsertStudent(Student stud) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL2, stud.getStudentName());
        cv.put(COL3, stud.getStudentUsn());
        cv.put(COL4, stud.getStudentSem());
        cv.put(COL5, stud.getStudentMarks());

        long result = db.insert(TABLE_NAME,null, cv);

        if (result == -1)
            return false;
        else
            return true;
    }
}