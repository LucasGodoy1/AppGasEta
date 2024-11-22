package lucasgodoy1.com.github.appgaseta.model

class Combustivel(var precoGasolina: String, var precoEtanol: String, var recomendacao: String) {

    var id: Int = 0


    override fun toString(): String {
        return "Combustivel(id=$id, precoGasolina='$precoGasolina', precoEtanol='$precoEtanol', recomendacao='$recomendacao')"
    }


}