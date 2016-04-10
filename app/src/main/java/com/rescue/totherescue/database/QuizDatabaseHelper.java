package com.rescue.totherescue.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Artur on 2016-04-10.
 */
public class QuizDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "quiz.db";
    private static final String TABLE_NAME = "quiz_table";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_CLASS = "class";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_ANSWER1 = "answer1";
    private static final String KEY_ANSWER2 = "answer2";
    private static final String KEY_ANSWER3 = "answer3";
    private static final String KEY_ANSWER4 = "answer4";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME +
                    "(" + KEY_ID +  "INTEGER PRIMARY KEY AUTOINCREMENT," +
                    KEY_CLASS + INTEGER_TYPE + COMMA_SEP +
                    KEY_QUESTION + TEXT_TYPE + COMMA_SEP +
                    KEY_ANSWER1 + TEXT_TYPE + COMMA_SEP +
                    KEY_ANSWER2 + TEXT_TYPE + COMMA_SEP +
                    KEY_ANSWER3 + TEXT_TYPE + COMMA_SEP +
                    KEY_ANSWER4 + TEXT_TYPE + COMMA_SEP + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public QuizDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
