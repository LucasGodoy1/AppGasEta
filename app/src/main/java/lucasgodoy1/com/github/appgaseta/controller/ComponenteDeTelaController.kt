package lucasgodoy1.com.github.appgaseta.controller

import android.content.ContentValues
import android.content.SharedPreferences
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import lucasgodoy1.com.github.appgaseta.R
import lucasgodoy1.com.github.appgaseta.model.Combustivel
import lucasgodoy1.com.github.appgaseta.repository.GasetaDatabase
import lucasgodoy1.com.github.appgaseta.util.UtilGasEta
import lucasgodoy1.com.github.appgaseta.view.GasEtaActivity
import java.time.LocalDateTime

class ComponenteDeTelaController(private val gasEtaActivity: GasEtaActivity) :
    GasetaDatabase(gasEtaActivity) {

    private val idBtnFinalizar: AppCompatButton =
        gasEtaActivity.findViewById(R.id.idAndroidBtnFinalizar)
    private val idBtnLimpar: AppCompatButton = gasEtaActivity.findViewById(R.id.idAndroidBtnLimp)
    private val idBtnCalcular: AppCompatButton =
        gasEtaActivity.findViewById(R.id.idAndroidBtnCalcular)
    private val idBtnSalvar: AppCompatButton = gasEtaActivity.findViewById(R.id.idAndroidBtnSal)

    private var idEtanol: EditText = gasEtaActivity.findViewById(R.id.idTxtEtanol)
    private var idGasolina: EditText = gasEtaActivity.findViewById(R.id.idTxtGasolina)
    private var idResultado: TextView = gasEtaActivity.findViewById(R.id.idAndroidResultado)

    private var sharedPreferences: SharedPreferences =
        gasEtaActivity.getSharedPreferences("calculated_save", 0)
    private lateinit var combustivel: Combustivel

    private fun calcular() {
        idBtnCalcular.setOnClickListener(View.OnClickListener {

            if (validarCampo()) {


                val valorGas = idGasolina.text.toString().toDouble()
                val valorEta = idEtanol.text.toString().toDouble()

                val recomendacao = UtilGasEta.calcularMelhorPreco(valorGas, valorEta)
                idResultado.setText(recomendacao.uppercase())

                combustivel =
                    Combustivel(valorGas.toString(), valorEta.toString(), recomendacao)

                idBtnSalvar.setEnabled(true)
            }


        })
    }


    private fun limpar() {
        idBtnLimpar.setOnClickListener(View.OnClickListener {
            idGasolina.setText("")
            idEtanol.setText("")
            idResultado.setText("RESULTADO")
        })
    }

    private fun salvar() {
        idBtnSalvar.setOnClickListener(View.OnClickListener {
            if (validarCampo() && ::combustivel.isInitialized) {

                var gasEta = sharedPreferences.edit()
                gasEta.putString("valor_gasolina", combustivel.precoGasolina)
                gasEta.putString("valor_etanol", combustivel.precoEtanol)
                gasEta.putString("resultado_calculo", combustivel.recomendacao)
                gasEta.putString("data", LocalDateTime.now().toString())

                gasEta.apply()
                Toast.makeText(gasEtaActivity, "Salvo com Sucesso!", Toast.LENGTH_LONG).show()

                var content = ContentValues()
                content.put("PRECO_GASOLINA", combustivel.precoGasolina)
                content.put("PRECO_ETANOL", combustivel.precoEtanol)
                content.put("RECOMENDACAO", combustivel.recomendacao.uppercase())

                salavrObjetosData("Combustivel", content)
            }

        })
    }

    private fun finalizar() {
        idBtnFinalizar.setOnClickListener(View.OnClickListener {
            Toast.makeText(gasEtaActivity, "Até Logo!", Toast.LENGTH_LONG).show()
            gasEtaActivity.finish()
        })
    }

    fun validarCampo(): Boolean {
        var preenchido = true

        if (idGasolina.text.isEmpty()) {
            idGasolina.setError("* CAMPO OBRIGATORIO")
            idGasolina.requestFocus()
            preenchido = false
        } else if (idEtanol.text.isEmpty()) {
            idEtanol.setError("* CAMPO OBRIGATORIO")
            idEtanol.requestFocus()
            preenchido = false
        }
        return preenchido

    }

    fun iniciarBotoes() {
        calcular()
        limpar()
        salvar()
        finalizar()
    }


}