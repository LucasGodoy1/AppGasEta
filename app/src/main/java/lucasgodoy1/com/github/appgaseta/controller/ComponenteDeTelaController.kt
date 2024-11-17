package lucasgodoy1.com.github.appgaseta.controller

import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import lucasgodoy1.com.github.appgaseta.R
import lucasgodoy1.com.github.appgaseta.util.UtilGasEta
import lucasgodoy1.com.github.appgaseta.view.GasEtaActivity

class ComponenteDeTelaController(private val gasEtaActivity: GasEtaActivity) {

    private val idBtnFinalizar: AppCompatButton = gasEtaActivity.findViewById(R.id.idAndroidBtnFinalizar)
    private val idBtnLimpar: AppCompatButton = gasEtaActivity.findViewById(R.id.idAndroidBtnLimp)
    private val idBtnCalcular : AppCompatButton = gasEtaActivity.findViewById(R.id.idAndroidBtnCalcular)

    private var idEtanol: EditText = gasEtaActivity.findViewById(R.id.idTxtEtanol)
    private var idGasolina : EditText = gasEtaActivity.findViewById(R.id.idTxtGasolina)
    private var idResultado : TextView = gasEtaActivity.findViewById(R.id.idAndroidResultado)


    private fun calcular(){
        idBtnCalcular.setOnClickListener(View.OnClickListener{

            val valorGas = idGasolina.text.toString().toDouble()
            val valorEta = idEtanol.text.toString().toDouble()

            val msg = UtilGasEta.calcularMelhorPreco(valorGas, valorEta)

            idResultado.setText(msg.uppercase())
        })
    }


    private fun limpar(){
        idBtnLimpar.setOnClickListener(View.OnClickListener {
            idGasolina.setText("")
            idEtanol.setText("")
            idResultado.setText("RESULTADO")
        })
    }


    private fun finalizar(){
        idBtnFinalizar.setOnClickListener(View.OnClickListener {
            Toast.makeText(gasEtaActivity, "Até Logo!", Toast.LENGTH_LONG).show()
            gasEtaActivity.finish()
        })
    }

    fun iniciarBotoes(){
        calcular()
        limpar()
        finalizar()
    }



}