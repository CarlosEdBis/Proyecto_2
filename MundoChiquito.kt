import java.io.File

fun mundoChiquito(cartas: MutableList<CartaMostro>){
    val pares: Grafo<CartaMostro> = ListaAdyacenciaGrafo()

    for(c1 in cartas){
        for(c2 in cartas){
            if(c1!=c2 && valido(c1,c2)){
                for(c3 in cartas){                    
                    if (c2!=c3 && valido(c2, c3)){
                        println(c1.nombre() + " " + c2.nombre() + " " + c3.nombre())
                    }                
                }
            }
        }
    }
    println()
    println()
    /* Revisa si este código te parece útil
    
    for(i in cartas){
        for(j in cartas){
            if(valido(i,j)){
                pares.conectar(i,j)
                pares.conectar(j,i)
            }
        }
    }
    for(c1 in cartas){
        val conectar1 = pares.obtenerArcosSalida(c1)
        for(c2 in conectar1){
            val conectar2 = pares.obtenerArcosSalida(c2)
            for(c3 in conectar2){
                println(c1.nombre() + " " + c2.nombre() + " " + c3.nombre())
            }
        }
    }
    */
}

fun valido(ct1: CartaMostro, ct2: CartaMostro): Boolean{
    var v = 0

    if(ct1.nivel() == ct2.nivel()) v++
    if(ct1.poder() == ct2.poder()) v++
    if(ct1.atributo() == ct2.atributo()) v++
    
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
            cartas.add(CartaMostro(datos[0], datos[1].toInt(), datos[2], datos[3].toInt()))
        }
    }
    return cartas
}

fun main(){
    val cartas = entrada()
    mundoChiquito(cartas)
}