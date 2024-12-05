package com.example.super_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "DB_Android.db"
        private const val TABLE_NAME = "form_usr"
        private const val COLUMN_ID = "id"
        private const val COLUMN_INPUT = "inputText"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = ("CREATE TABLE $TABLE_NAME ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_INPUT TEXT)")
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertInput(inputText: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_INPUT, inputText)

        val result = db.insert(TABLE_NAME, null, contentValues)
        return result != -1L
    }

    fun getAllInputs(): List<String> {
        val inputList = mutableListOf<String>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val inputText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INPUT))
                inputList.add(inputText)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return inputList
    }
}