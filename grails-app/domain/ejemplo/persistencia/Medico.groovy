package ejemplo.persistencia

//con esta anotation funciona la herencia sin castear
@groovy.transform.ToString
class Medico {
    
    String nombre
    static constraints = {
    }
    
    Medico (String nombre){this.nombre = nombre}
    
    def cambiarNombre (String otroNombre){
        this.nombre = otroNombre
        println(this.nombre)
    }
    
    def cambiarNombreSet (String otroNombre){
        setNombre(otroNombre)
    }
}
