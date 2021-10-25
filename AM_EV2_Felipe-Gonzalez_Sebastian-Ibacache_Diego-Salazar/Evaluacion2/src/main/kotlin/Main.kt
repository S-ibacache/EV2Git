var libros= arrayListOf<Libro>()
fun main(args: Array<String>) {

    login()

}

fun login(){
    var user:String
    var password:String
    do{
        println("---Bienvenido a nuestra aplicacion de biblioteca---")
        println("--Ingrese su usuario--")
        password= readLine().toString()
        println("--Ingrese su contraseña--")
        user= readLine().toString()
    }while(user != "admin" && password!="admin")
    menu()
}
fun menu(){
    var salir = true
    var decisionMenu:Int
    do {
        println("---Bienvenido a nuestra aplicacion de biblioteca---")
        println("1. Ingresar libro")
        println("2. Mostrar Libros")
        println("3. Modificar Libros")
        println("4. Eliminar Libros")
        println("5. Salir")
        println("Escoja un numero para continuar")
        decisionMenu = readLine()!!.toInt()
        when {
                decisionMenu == 1 -> ingresar()
                decisionMenu == 2 -> mostrar()
                decisionMenu == 3 -> modificar()
                decisionMenu == 4 -> eliminar()
                decisionMenu == 5 -> salir=false
            else -> println("datos ingrasado es erroneo")
        }
    }while(salir)
}



fun ingresar() {
    println("A continuacion ingrese las caracteristicas del libro")
    println("Ingrese el Titulo:")
    val titulo = readLine()!!.toString()
    println("Ingrese el ISBN:")
    val isbn = readLine()!!.toInt()
    println("Ingrese el peso:")
    val peso = readLine()!!.toInt()
    var listaGen: List<String> = listOf("ficcion","drama","infantil")
    println("Ingrese el genero $listaGen")
    val genero = readLine()!!.toString()
    when (genero) {
        "ficcion" -> println("Haz seleccionado ficcion")
        "drama" -> println("Haz seleccionado drama")
        "infantil" -> println("Haz seleccionado infantil")
        else -> println("Seleccione un genero de la lista")
    }
    println("Ingrese un parrafo sobre el autor")
    val detalle = readLine()!!.toString()
    println("Ingrese el precio de venta")
    val precioVenta = readLine()!!.toInt()
    var listaFor: List<String> = listOf("digital","impreso")
    println("Ingrese el tipo de formato $listaFor")
    val formato = readLine()!!.toString()
    when (formato) {
        "digital" -> println("Haz seleccionado digital")
        "impreso" -> println("Haz seleccionado impreso")
        else -> println("Seleccione un formato de la lista")
    }
    var libro = Libro(titulo=titulo, isbn=isbn, peso=peso, genero=genero, detalle=detalle, precioVenta=precioVenta, formato=formato)
    libros.add(libro)
    println("libro ingresado")
    menu()
}

fun mostrar() {
    if (libros!= null && !libros.isEmpty()){
        for (i in libros.indices){
            println("---Listado de libros---")
            print("Titulo: "+libros[i].titulo )
            println("ISBN: "+libros[i].isbn)
            println("Peso: "+libros[i].peso)
            println("Genero: "+libros[i].genero)
            println("Detalle: "+libros[i].detalle)
            println("Precio Venta: "+libros[i].precioVenta)
            println("Formato: "+libros[i].formato)

        }
    }

}

fun mostrarTitulos() {
    if (libros!= null && !libros.isEmpty()){
        for (i in libros.indices) {
            println("---Listado de libros---")
            println("$i)Titulo: $libros.titulo")
        }
    }

}

fun modificar () {
    println("---modificacion de libros---")
    mostrarTitulos()
    if (libros!= null && !libros.isEmpty()){
        println("ingrese el indice del libro para modificar")
        val Modify = readLine()!!.toInt()
        for (i in libros.indices) {
            if (i==Modify){



                //escribir aqui el codigo de modificar



            }else{
                println("el libro ingresado no es coorecto")
            }
        }
    }else{
        println("no hay libros disponibles")
    }

}
fun eliminar () {
    println("---eliminacion de libros---")
    mostrarTitulos()
    if (libros!= null && !libros.isEmpty()){
        println("ingrese el indice del libro para eliminar")
        val delete = readLine()!!.toInt()
        for (i in libros.indices) {
            if (i==delete){
                libros.removeAt(delete)
            }else{
                println("el libro ingresado no es coorecto")
            }
        }
    }else{
        println("no hay libros disponibles")
    }
    menu()
}

