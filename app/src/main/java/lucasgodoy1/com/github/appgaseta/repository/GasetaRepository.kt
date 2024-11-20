package lucasgodoy1.com.github.appgaseta.repository

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class GasetaRepository(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        const val DB_NAME = "gaseta.db"
        const val DB_VERSION = 1
    }

    lateinit var cursor : Cursor


    override fun onCreate(db: SQLiteDatabase) {
        val combustivel
        = "CREATE TABLE Combustivel (ID INTEGER PRIMARY KEY AUTOINCREMENT, PRECO_GASOLINA REAL, PRECO_ETANOL REAL, RECOMENDACAO TEXT)"
        db.execSQL(combustivel)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}