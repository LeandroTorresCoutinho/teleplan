# teleplan
API de Crud de planos de telefonia

A API disponibiliza as seguintes funções:

-Cadastro de um plano
-Atualização de um plano
-Remoção de um plano
-Listagem de um plano(OBS: Na listagem é possível realizar buscas por tipo, operadora ou plano específico(todas as buscas utilizam DDD))

O plano de telefonia tem as seguintes características:

-Código do plano 
-Minutos 
-Franquia de internet
-Valor
-Tipo (Controle, Pós, Pré) 
-Operadora

Regra: Cada plano pode estar ou não disponível para um ou mais DDDs.

Feita em Java 8 com SpringBoot, Spring Data JPA, banco de dados mysql.
