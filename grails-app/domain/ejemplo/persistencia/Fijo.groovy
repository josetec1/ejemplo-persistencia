package ejemplo.persistencia

class Fijo extends Telefono{

    static constraints = {
    }
    
    @Override
    void encender() {
        println("soy un telefono Celular")
    }
}
