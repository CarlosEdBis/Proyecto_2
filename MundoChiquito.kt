import java.io.File

fun mundoChiquito(cartas: Grafo<CartaMostro>){

    for(c1 in cartas.obtenerVertices()){
        for(c2 in cartas.obtenerVertices()){
            if(valido(c1,c2)){
                cartas.conectar(c1,c2)
            }
        }
    }

    for(c1 in cartas.obtenerVertices()){
        for(c2 in cartas.obtenerArcosSalida(c1)){
            for(c3 in cartas.obtenerArcosSalida(c2)){                    
                println("${c1.nombre()} ${c2.nombre()} ${c3.nombre()}")               
            }
        }
    }
}

fun valido(ct1: CartaMostro, ct2: CartaMostro): Boolean{
    var v = 0
    if (ct1.nivel() == ct2.nivel()) v++
    if (ct1.poder() == ct2.poder()) { v++; if (v > 1) return false }
    if (ct1.atributo() == ct2.atributo()) { v++; if (v > 1) return false }
    return v == 1
}

fun entrada(): Grafo<CartaMostro>{
    val archivo = "deck.csv"
    var cartas: Grafo<CartaMostro> = ListaAdyacenciaGrafo()

    File(archivo).bufferedReader().useLines { lines ->
        lines.drop(1).forEach { line ->
            val datos = line.split(",")
            cartas.agregarVertice(CartaMostro(datos[0], datos[1].toInt(), datos[2], datos[3].toInt()))
        }
    }
    return cartas
}

fun main(){
    val cartas = entrada()
    mundoChiquito(cartas)
}