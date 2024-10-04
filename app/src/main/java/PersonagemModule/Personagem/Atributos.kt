package PersonagemModule.Personagem

import org.example.Personagem.Personagem


class Atributos(private var forca : Int = 8,
    private var destreza : Int = 8,
    private var constituicao : Int = 8,
    private var inteligencia : Int = 8,
    private var sabedoria : Int = 8,
    private var carisma : Int = 8,
    private var pontosDeHabilidade : Int = 27){

    fun getForca(): Int {
        return forca
    }

    fun getDestreza(): Int {
        return destreza
    }

    fun getConstituicao(): Int {
        return constituicao
    }

    fun getInteligencia(): Int {
        return inteligencia
    }

    fun getSabedoria(): Int {
        return sabedoria
    }

    fun getCarisma(): Int {
        return carisma
    }
    fun getQuantDePontosDeHabilidade() : Int{
        return pontosDeHabilidade
    }

    internal fun incrementaForca(pontos : Int){
        forca += pontos
    }
    internal fun incrementaDestreza(pontos : Int){
        destreza += pontos
    }
    internal fun incrementaConstituicao(pontos : Int){
        constituicao += pontos
    }
    internal fun incrementaInteligencia(pontos : Int){
        inteligencia += pontos
    }
    internal fun incrementaSabedoria(pontos : Int){
        sabedoria += pontos
    }
    internal fun incrementaCarisma(pontos : Int){
        carisma += pontos
    }

    internal fun distribuirPontos(opcaoHabilidade : Int, pontos: Int) {
        if (pontos > 7 || pontos < 1) {
            throw IllegalArgumentException("ERRO: Pontos devem ser entre 7 e 1")
        } else if (pontosDeHabilidade < pontos) {
            throw IllegalArgumentException("ERRO: Não há pontos suficientes!")
        } else {
            modificadorDeCusto(opcaoHabilidade, pontos)
        }
        when (opcaoHabilidade) {
            1 -> forca += pontos
            2 -> destreza += pontos
            3 -> constituicao += pontos
            4 -> inteligencia += pontos
            5 -> sabedoria += pontos
            6 -> carisma += pontos
        }
    }

    private fun modificadorDeCusto(opcaoHabilidade: Int, pontos: Int) {

        val habilidades = intArrayOf(forca, destreza, constituicao, inteligencia, sabedoria, carisma)
        val valorAtualDaHabilidade = habilidades[opcaoHabilidade - 1]
        val valorNovoDaHabilidade = valorAtualDaHabilidade + pontos

        if (valorNovoDaHabilidade > 15) {
            throw IllegalArgumentException("ERRO: Limite de pontos atingido!")
        }
        var custo = 0
        for (pontoAtual in valorAtualDaHabilidade until valorNovoDaHabilidade) {
            custo += when {
                pontoAtual in 8 until 13 -> 1
                pontoAtual in 13 until 15 -> 2
                else -> 0
            }
        }
        if (custo > pontosDeHabilidade) {
            throw IllegalArgumentException("ERRO: Custo maior que a quantidade de pontos restantes!")
        } else {
            pontosDeHabilidade -= custo
        }
    }
}