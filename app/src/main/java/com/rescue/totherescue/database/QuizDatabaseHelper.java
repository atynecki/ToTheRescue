package com.rescue.totherescue.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rescue.totherescue.R;
import com.rescue.totherescue.quiz.model.Question;

import java.util.ArrayList;

/**
 * Created by Artur on 2016-04-10.
 */
public class QuizDatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "quiz.db";

    // Table Names
    private static final String TABLE_ZADLAWIENIE = "zadlawienie";
    private static final String TABLE_TONIECIE = "toniecie";
    private static final String TABLE_PORAZENIE = "porazenie";
    private static final String TABLE_OPARZENIE = "oparzenie";
    private static final String TABLE_RANY = "rany";
    private static final String TABLE_RKO = "rko";
    private static final String TABLE_PRZYTOMNOSC = "przytomnosc";
    private static final String TABLE_ZAWAL = "zadlwienie";

    // Common column names
    private static final String KEY_ID = "_id";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_OPTION1 = "option1";
    private static final String KEY_OPTION2 = "option2";
    private static final String KEY_OPTION3 = "option3";
    private static final String KEY_OPTION4 = "option4";
    private static final String KEY_EXPLANATION = "explanation";

    private static final String ID_TYPE = "INTEGER PRIMARY KEY AUTOINCREMENT";
    private static final String TEXT_TYPE = "TEXT NOT NULL";
    private static final String COMMA_SEP = ", ";
    private static final String SPACE_SEP = " ";

    // Table Create Statements
    // Zadławienia table create statement
    private static final String CREATE_TABLE_ZADLAWIENIA =
            "CREATE TABLE " + TABLE_ZADLAWIENIE +
                    "( " + KEY_ID + SPACE_SEP + ID_TYPE + COMMA_SEP +
                    KEY_QUESTION + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION1 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION2 + SPACE_SEP +TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION3 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION4 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_EXPLANATION + SPACE_SEP + TEXT_TYPE + ");";

    private static final String DELETE_TABLE_ZADLAWIENIA =
            "DROP TABLE IF EXISTS " + TABLE_ZADLAWIENIE;

    // Toniecie table create statement
    private static final String CREATE_TABLE_TONIECIE =
            "CREATE TABLE " + TABLE_TONIECIE +
                    "( " + KEY_ID + SPACE_SEP + ID_TYPE + COMMA_SEP +
                    KEY_QUESTION + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION1 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION2 + SPACE_SEP +TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION3 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION4 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_EXPLANATION + SPACE_SEP + TEXT_TYPE + ");";

    private static final String DELETE_TABLE_TONIECIE =
            "DROP TABLE IF EXISTS " + TABLE_TONIECIE;

    // Porażenie table create statement
    private static final String CREATE_TABLE_PORAZENIE =
            "CREATE TABLE " + TABLE_PORAZENIE +
                    "( " + KEY_ID + SPACE_SEP + ID_TYPE + COMMA_SEP +
                    KEY_QUESTION + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION1 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION2 + SPACE_SEP +TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION3 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION4 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_EXPLANATION + SPACE_SEP + TEXT_TYPE + ");";

    private static final String DELETE_TABLE_PORAZENIE =
            "DROP TABLE IF EXISTS " + TABLE_PORAZENIE;

    // Oparzenie table create statement
    private static final String CREATE_TABLE_OPARZENIE =
            "CREATE TABLE " + TABLE_OPARZENIE +
                    "( " + KEY_ID + SPACE_SEP + ID_TYPE + COMMA_SEP +
                    KEY_QUESTION + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION1 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION2 + SPACE_SEP +TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION3 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION4 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_EXPLANATION + SPACE_SEP + TEXT_TYPE + ");";

    private static final String DELETE_TABLE_OPARZENIE =
            "DROP TABLE IF EXISTS " + TABLE_OPARZENIE;

    // Rany table create statement
    private static final String CREATE_TABLE_RANY =
            "CREATE TABLE " + TABLE_RANY +
                    "( " + KEY_ID + SPACE_SEP + ID_TYPE + COMMA_SEP +
                    KEY_QUESTION + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION1 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION2 + SPACE_SEP +TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION3 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION4 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_EXPLANATION + SPACE_SEP + TEXT_TYPE + ");";

    private static final String DELETE_TABLE_RANY =
            "DROP TABLE IF EXISTS " + TABLE_RANY;

    // RKO table create statement
    private static final String CREATE_TABLE_RKO =
            "CREATE TABLE " + TABLE_RKO +
                    "( " + KEY_ID + SPACE_SEP + ID_TYPE + COMMA_SEP +
                    KEY_QUESTION + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION1 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION2 + SPACE_SEP +TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION3 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION4 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_EXPLANATION + SPACE_SEP + TEXT_TYPE + ");";

    private static final String DELETE_TABLE_RKO =
            "DROP TABLE IF EXISTS " + TABLE_RKO;

    // Utrata przytomnosci table create statement
    private static final String CREATE_TABLE_PRZYTOMNOSC =
            "CREATE TABLE " + TABLE_PRZYTOMNOSC +
                    "( " + KEY_ID + SPACE_SEP + ID_TYPE + COMMA_SEP +
                    KEY_QUESTION + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION1 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION2 + SPACE_SEP +TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION3 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION4 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_EXPLANATION + SPACE_SEP + TEXT_TYPE + ");";

    private static final String DELETE_TABLE_PRZYTMONOSC =
            "DROP TABLE IF EXISTS " + TABLE_PRZYTOMNOSC;

    // Zawał table create statement
    private static final String CREATE_TABLE_ZAWAL =
            "CREATE TABLE " + TABLE_ZAWAL +
                    "( " + KEY_ID + SPACE_SEP + ID_TYPE + COMMA_SEP +
                    KEY_QUESTION + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION1 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION2 + SPACE_SEP +TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION3 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_OPTION4 + SPACE_SEP + TEXT_TYPE + COMMA_SEP +
                    KEY_EXPLANATION + SPACE_SEP + TEXT_TYPE + ");";

    private static final String DELETE_TABLE_ZAWAL =
            "DROP TABLE IF EXISTS " + TABLE_ZAWAL;

    public QuizDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // creating required tables
        db.execSQL(CREATE_TABLE_ZADLAWIENIA);
        db.execSQL(CREATE_TABLE_TONIECIE);
        db.execSQL(CREATE_TABLE_PORAZENIE);
        db.execSQL(CREATE_TABLE_OPARZENIE);
        db.execSQL(CREATE_TABLE_RANY);
        db.execSQL(CREATE_TABLE_RKO);
        db.execSQL(CREATE_TABLE_PRZYTOMNOSC);
        db.execSQL(CREATE_TABLE_ZAWAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL(DELETE_TABLE_ZADLAWIENIA);
        db.execSQL(DELETE_TABLE_TONIECIE);
        db.execSQL(DELETE_TABLE_PORAZENIE);
        db.execSQL(DELETE_TABLE_OPARZENIE);
        db.execSQL(DELETE_TABLE_RANY);
        db.execSQL(DELETE_TABLE_RKO);
        db.execSQL(DELETE_TABLE_PRZYTMONOSC);
        db.execSQL(DELETE_TABLE_ZAWAL);

        // create new tables
        onCreate(db);
    }

    // closing database
    public void closeQuizDatabase()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    public long addQuestion(String quizCase, Question question)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues newQuestion = new ContentValues();
        newQuestion.put(KEY_QUESTION, question.getQuestion());
        newQuestion.put(KEY_OPTION1, question.getOption1());
        newQuestion.put(KEY_OPTION2, question.getOption2());
        newQuestion.put(KEY_OPTION3, question.getOption3());
        newQuestion.put(KEY_OPTION4, question.getOption4());
        newQuestion.put(KEY_EXPLANATION, question.getExplanation());

        switch(quizCase) {
            case "Zadławienie":
                return db.insert(TABLE_ZADLAWIENIE, null, newQuestion);
            case "Tonięcię":
                return db.insert(TABLE_TONIECIE, null, newQuestion);
            case "Porażenie prądem<":
                return db.insert(TABLE_PORAZENIE, null, newQuestion);
            case "Oparzenie":
                return db.insert(TABLE_OPARZENIE, null, newQuestion);
            case "Rany":
                return db.insert(TABLE_RANY, null, newQuestion);
            case "RKO":
                return db.insert(TABLE_RKO, null, newQuestion);
            case "Utrata przytomności":
                return db.insert(TABLE_PRZYTOMNOSC, null, newQuestion);
            case "Zawał":
                return db.insert(TABLE_ZAWAL, null, newQuestion);
            default:
                return 0;
        }
    }

    public ArrayList<Question> getQuestions(String quizCase)
    {
        ArrayList<Question> questions = new ArrayList<Question>();

        SQLiteDatabase db = this.getReadableDatabase();


        return questions;
    }
}
