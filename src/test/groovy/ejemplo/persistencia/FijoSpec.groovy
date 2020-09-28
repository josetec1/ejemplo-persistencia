package ejemplo.persistencia

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class FijoSpec extends Specification implements DomainUnitTest<Fijo> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
