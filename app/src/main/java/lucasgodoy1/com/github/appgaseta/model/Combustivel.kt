package lucasgodoy1.com.github.appgaseta.model

class Combustivel (var precoGasolina : String, var precoEtanol : String, var recomendacao : String){



    override fun toString(): String {
        return "Combustivel(precoGasolina='$precoGasolina', precoEtanol='$precoEtanol', recomendacao='$recomendacao')"
    }
}