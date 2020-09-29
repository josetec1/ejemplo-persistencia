package ejemplo.persistencia

import grails.compiler.GrailsCompileStatic

class Persona {
    
    Telefono telefono
    static constraints = {
    }
    
    def Persona (String telefono){
        if (telefono == "celular"){
            this.telefono= new Celular()
        }else{
            this.telefono= new Fijo()
        }
        
    }
    @GrailsCompileStatic
    void encenderTelefono (){
        this.telefono.encender()
    }
}
