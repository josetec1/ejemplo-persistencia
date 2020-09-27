package ejemplo.persistencia


class OrdenDeEstudio {
    
    String prioridad
    String paciente
    String nota
    //   Medico medico
    
    static constraints = {
    }
    
    OrdenDeEstudio (String prioridad, String paciente,String nota, Medico medico){
        this.prioridad
        this.paciente
        this.nota
        //  this.medico
    }
    
    //  def cambiarMedico (Medico otroMedico){this.medico = otroMedico}
    
    def cambiarNota (String otraNota){this.nota = otraNota}
    
    //   def cambiarMedicoSet (Medico otroMedico){setMedico(otroMedico)}
    
    def cambiarNotaSet (String otraNota){setNota(otraNota)}
}
