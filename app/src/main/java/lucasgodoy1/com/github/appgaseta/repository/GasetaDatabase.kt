package lucasgodoy1.com.github.appgaseta.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import lucasgodoy1.com.github.appgaseta.model.Combustivel

open class GasetaDatabase(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        const val DB_NAME = "gaseta.db"
        const val DB_VERSION = 1
    }

    lateinit var registroCombustivel: Combustivel
    lateinit var cursor : Cursor
    var db : SQLiteDatabase = writableDatabase



    override fun onCreate(sqsqLiteDatabase : SQLiteDatabase) {
        db = sqsqLiteDatabase
        val combustivel
        = "CREATE TABLE Combustivel (ID INTEGER PRIMARY KEY AUTOINCREMENT, PRECO_GASOLINA REAL, PRECO_ETANOL REAL, RECOMENDACAO TEXT)"
        sqsqLiteDatabase.execSQL(combustivel)
    }

    override fun onUpgrade(sqsqLiteDatabase : SQLiteDatabase, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun salavrObjetosData(nomeTabela : String, dados : ContentValues){
        db.insert(nomeTabela, null, dados)
    }

    fun listarObjetosData() : List<Combustivel>{
        var lista = ArrayList<Combustivel>()
        var querySQL = "SELECT * FROM COMBUSTIVEL"
        cursor = db.rawQuery(querySQL, null)

        if (cursor.moveToFirst()){

            do{
                registroCombustivel = Combustivel(cursor.getDouble(1).toString(), cursor.getDouble(2).toString(), cursor.getString(3))
                registroCombustivel.id = cursor.getInt(0)
                lista.add(registroCombustivel)

            }while (cursor.moveToNext())

        }
        return lista
    }

}