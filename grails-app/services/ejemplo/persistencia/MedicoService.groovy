package ejemplo.persistencia

import grails.gorm.transactions.Transactional

@Transactional
class MedicoService {
    
    Medico get(Serializable id){
        
        Medico.get(id)
    }
    
    List<Medico> list(Map args){
        Medico.list()
    }
    
    Long count(){
        Medico.count()
    }
    
    void delete(Serializable id){
        this.get(id).delete()
    }
    
    Medico save(Medico medico){
       
       def a= medico.save(failOnError : true)
    //    println(a)
    }
    
    Medico actualizar(Serializable id){
    
        Medico medico = this.get(id)
        medico.cambiarNombre("se cambio")
        println(medico.isDirty())
        println(medico.nombre)
        println(medico.isDirty())
        medico=this.save(medico)
        
    }
    
}
