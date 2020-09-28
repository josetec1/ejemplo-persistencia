package ejemplo.persistencia

class BootStrap {

    def init = { servletContext ->
        
        new Persona("celular").save(failOnError: true)
        new Persona("lalala").save(failOnError: true)
        new Persona("celular").save(failOnError: true)
        
    }
    def destroy = {
    }
}
