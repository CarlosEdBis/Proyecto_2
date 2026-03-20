class CartaMostro(nm: String, lv: Int, atr: String, pw: Int){
    private val nombre = nm
    private val nivel = lv
    private val poder = pw
    private val atributo = atr
    private val atributos = listOf("AGUA", "FUEGO", "VIENTO", "TIERRA", "LUZ", "OSCURIDAD" ,"DIVINO")

    init{
        require(0 < lv) {"El nivel de ${nombre} debe ser mayor a 0"}
        require(lv < 13) {"El nivel de ${nombre} debe ser menor a 13"}
        require(pw % 50 == 0) {"El poder de ${nombre} debe ser múltiplo de 50"}
        require(atr in atributos) {"El atributo de ${nombre} no es válido"}
    }
    fun nombre():String{
        return this.nombre
    }
    fun nivel(): Int{
        return this.nivel
    }
    fun poder(): Int{
        return this.poder
    }
    fun atributo(): String{
        return this.atributo
    }
}