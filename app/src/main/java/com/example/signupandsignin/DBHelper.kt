package com.example.signupandsignin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper ( context: Context) : SQLiteOpenHelper(context, "details.db", null, 1) {

    var sqLiteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table Users( UserName text,Mobile tex,Location tex,password tex ) ")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}


    fun save(s1: String, s2: String, s3: String, s4: String): Long {

        val cv = ContentValues()
        cv.put("UserName", s1)
        cv.put("Mobile", s2)
        cv.put("Location", s3)
        cv.put("password", s4)

        var status = sqLiteDatabase.insert("Users", null, cv)

        return status

    }


    @SuppressLint("Range")
    fun RetrievePass(s1: String): String {

        var c: Cursor = sqLiteDatabase.query("Users", null, "UserName=?", arrayOf(s1),
            null, null, null)

        c.moveToFirst()

        var pass = c.getString(c.getColumnIndex("password"))
        return pass
    }

    @SuppressLint("Range")
    fun Retrieve(s1: String): String {

        var c: Cursor = sqLiteDatabase.query("Users", null, "UserName=?", arrayOf(s1),
            null, null, null)

        c.moveToFirst()

        var info = "Location: " + c.getString(c.getColumnIndex("Location"))
        info += "\n"
        info += "Mobile: " + c.getString(c.getColumnIndex("Mobile"))

        return info
    }

    fun exists(s1: String): Boolean {

        val query = "select * from Users where UserName = ?"
        val cursor = sqLiteDatabase.rawQuery(query, arrayOf(s1))
        val result = cursor.count > 0
        return result


    }

    fun userPresent (user: String, pass: String): Boolean {

        val query = "select * from Users where UserName = ? and password = ?"
        val cursor = sqLiteDatabase.rawQuery(query, arrayOf(user, pass))
        val result = cursor.count > 0

        return result
    }
}