# ejemplo-persistencia


[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2bc54b6684cc40eb8248b9dbba11d462)](https://app.codacy.com/app/josetec1/ejemplo-persistencia?utm_source=github.com&utm_medium=referral&utm_content=josetec1/ejemplo-persistencia&utm_campaign=Badge_Grade_Dashboard)
[![Build Status](https://travis-ci.com/josetec1/ejemplo-persistencia.svg?branch=master)](https://travis-ci.com/josetec1/ejemplo-persistencia) 


#### Pasos: 

######pegarle 3 veces a esta direccion para crear 3 medicos
http://localhost:8080/medico/crear/


######Verificar en esta lista que estan los 3
http://localhost:8080/medico/index


######Pegarle 1 vez a cada uno de estos links
http://localhost:8080/medico/actualizarconset/1/
http://localhost:8080/medico/actualizarsinset/2/
http://localhost:8080/medico/actualizarconpunto/3/

######Verificar en la lista que dos se modificaron y uno no
http://localhost:8080/medico/index


###### Pero el test de integracion pasa.
https://github.com/josetec1/ejemplo-persistencia/blob/master/src/integration-test/groovy/ejemplo/persistencia/MedicoServiceSpec.groovy
