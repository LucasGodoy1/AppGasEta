package lucasgodoy1.com.github.appgaseta.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lucasgodoy1.com.github.appgaseta.R
import lucasgodoy1.com.github.appgaseta.controller.ComponenteDeTelaController

class GasEtaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gaseta)

        val componenteDeTelaController = ComponenteDeTelaController(this)
        componenteDeTelaController.iniciarBotoes()
    }


}