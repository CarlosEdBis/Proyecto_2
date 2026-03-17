import java.io.File

fun mundoChiquito(cartas: MutableList<CartaMostro>){
    val pares: Grafo<CartaMostro> = ListaAdyacenciaGrafo()
    for(i in cartas){
        for(j in cartas){
            if(valido(i,j)){
                pares.conectar(i,j)
                pares.conectar(j,i)
            }
        }
    }
    // no está terminado, aún pienso si vale la peno usar lista de adyacencia o imprimo de una arriba
}

fun valido(ct1: CartaMostro, ct2: CartaMostro): Boolean{
    var v = 0

    if(ct1.nivel() == ct2.nivel()) v + 1
    if(ct1.poder() == ct2.poder()) v + 1
    if(ct1.atributo() == ct2.atributo()) v + 1

    if(v == 0 || v > 1){
        return false
    }
    return true
}

fun entrada(): MutableList<CartaMostro>{
    val archivo = "deck.csv"
    var cartas: MutableList<CartaMostro> =mutableListOf()

    File(archivo).bufferedReader().useLines { lines ->
        lines.forEach { line ->
            val datos = line.split(",")
            cartas.add(CartaMostro(datos[0], datos[1].toInt(), datos[2].toInt(), datos[3]))
        }
    }
    return cartas
}

fun main(args: String){
    val cartas = entrada()
    mundoChiquito(cartas)
}