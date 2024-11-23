package lucasgodoy1.com.github.appgaseta.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import lucasgodoy1.com.github.appgaseta.R
import lucasgodoy1.com.github.appgaseta.controller.ComponenteDeTelaController
import lucasgodoy1.com.github.appgaseta.repository.GasetaDatabase

class GasEtaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaseta)

        val componenteDeTelaController = ComponenteDeTelaController(this)

        componenteDeTelaController.iniciarBotoes()
        val gasetaDatabase = GasetaDatabase(this)
        gasetaDatabase.readableDatabase

//        var lista = gasetaDatabase.listarObjetosData()
//        lista.forEach { i -> Log.i("Sua Lista", i.toString()) }
//        var objeto = lista.get(1)
//
//        objeto.precoGasolina = 22.98.toString()
//        objeto.precoEtanol = 12.22.toString()
//        objeto.recomendacao = "NÃO COMPRE MAIS"
////
////        componenteDeTelaController.alterarObjeto(objeto)
    }


}