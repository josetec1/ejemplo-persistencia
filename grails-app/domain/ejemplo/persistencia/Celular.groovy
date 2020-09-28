package ejemplo.persistencia

class Celular extends  Telefono{

    static constraints = {
    }
    
    @Override
    void encender() {
        
            println("soy un telefono Celular")
        
    }
}
