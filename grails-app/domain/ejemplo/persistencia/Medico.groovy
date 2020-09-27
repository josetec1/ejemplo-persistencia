package ejemplo.persistencia


@groovy.transform.ToString
class Medico {
    
    String nombre
    static constraints = {
    }
    
    Medico (String nombre){this.nombre = nombre}
}
