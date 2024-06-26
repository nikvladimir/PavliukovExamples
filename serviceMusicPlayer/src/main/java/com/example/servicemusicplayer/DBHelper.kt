package com.example.servicemusicplayer

import com.example.common.Constants

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



private const val dbName = Constants.DB_NAME
private const val DBVersion = 1

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, dbName, null, DBVersion) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Constants.CREATE_PL_TABLE)
        db?.execSQL(Constants.FILLING_THE_PL_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(Constants.DROP_PL_TABLE)
        onCreate(db)
    }

    fun queryAllPlaylistTable(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery(Constants.SELECT_ALL_FROM_PL, null)
    }

    fun queryPlaylistTableByColumnAndValue(column: String, value: String): Cursor? {
        val db = this.readableDatabase
        val query = Constants.SELECT_COLUMN_KEY_FROM_PL.format(column, value)
        return db.rawQuery(query, null)
    }

    fun queryArtist(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery(Constants.SELECT_ARTIST, null)
    }

    fun queryGenre(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery(Constants.SELECT_GENRE, null)
    }
}