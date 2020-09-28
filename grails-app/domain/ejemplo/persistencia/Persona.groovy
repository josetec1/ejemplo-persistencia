package ejemplo.persistencia

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
    
    void encenderTelefono (){
        this.telefono.encender()
    }
}
