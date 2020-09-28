package ejemplo.persistencia

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MedicoServiceSpec extends Specification {
    
    MedicoService medicoService
    SessionFactory sessionFactory
    
    private Long setupData() {
        
        // TODO: Populate valid domain instances and return a valid ID
        
        new Medico("jose").save(flush: true, failOnError: true)
        new Medico("pedro").save(flush: true, failOnError: true)
        Medico medico = new Medico("juan").save(flush: true, failOnError: true)
        
        new Medico("anibal").save(flush: true, failOnError: true)
        new Medico("marcos").save(flush: true, failOnError: true)
        // assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        medico.id
    }
    
    void "07 test funciona sin siquiera llamar a save "() {
        
        Long medicoId = setupData()
        Medico medico = Medico.get(medicoId)
        Medico vuelvoAtraerAlMedico
        expect:
        medico.nombre == "juan"
        
        when: 'hago medico.cambiar nombre y sin usar save, vuelvo a sacar al medico del repositorio '
        medico.cambiarNombre("pedro")
        //medicoService.save(medico)
        // sessionFactory.currentSession.flush()
        vuelvoAtraerAlMedico =medicoService.get(medicoId)
        
        then: 'el nombre lo cambio igual como si tuviera un save automatico'
        vuelvoAtraerAlMedico.nombre == "pedro"
        vuelvoAtraerAlMedico.nombre != "juan"
    }
    
    
    
    
    
    
    void "test get"() {
        setupData()
        
        expect:
        medicoService.get(1) != null
    }
    
    
    void "test list"() {
        setupData()
        
        when:
        List<Medico> medicoList = medicoService.list(max: 2, offset: 2)
        
        then:
        assert medicoList.size() == 2 , "TODO: Verify the correct instances are returned"
        
    }
    
    void "test count"() {
        setupData()
        
        expect:
        medicoService.count() == 5
    }
    
    void "test count sin setup"() {
        // setupData()
        
        expect:
        medicoService.count() == 0
    }
    
    void "test delete"() {
        Long medicoId = setupData()
        
        expect:
        medicoService.count() == 5
        
        when:
        medicoService.delete(medicoId)
        sessionFactory.currentSession.flush()
        
        then:
        medicoService.count() == 4
    }
    
    void "test save"() {
        when:
        //  assert false, "TODO: Provide a valid instance to save"
        Medico medico = new Medico("pedro")
        medicoService.save(medico)
        
        then:
        medico.id != null
    }
    
    
    
}
