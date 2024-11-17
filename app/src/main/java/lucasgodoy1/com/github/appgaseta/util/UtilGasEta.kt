package lucasgodoy1.com.github.appgaseta.util

class UtilGasEta {


    companion object {
        @JvmStatic


        fun calcularMelhorPreco(gasolina : Double, etanol : Double): String {
            var precoIdeial = gasolina * 0.70
            return if (etanol <= precoIdeial) "Abastecer com Etanol" else "Abastecer com Gasolina"
        }
    }

}