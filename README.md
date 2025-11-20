"# etec-food" 
| Verbo HTTP | Endpoint                            | Json (quando necessário)                                       |
|------------|--------------------------------------|----------------------------------------------------------------|
| GET        | http://localhost:8080/usuarios       | Não é necessário                                               |
| GET        | http://localhost:8080/usuarios/{id}  | Não é necessário                                               |
| POST       | http://localhost:8080/usuarios       | { "nome": "...", "senha": "...", "tentativasAcesso": 0,       |
|            |                                      |   "dataBloqueio": "2025-01-01T12:00:00",                       |
|            |                                      |   "dataInativacao": "2025-01-01T12:00:00",                     |
|            |                                      |   "status": "ATIVO",                                           |
|            |                                      |   "permissaoList": [ { "id": 1 } ] }                           |
| DELETE     | http://localhost:8080/usuarios/{id}  | Não é necessário                                               |
|------------|--------------------------------------|----------------------------------------------------------------|
| GET        | http://localhost:8080/permissoes     | Não é necessário                                               |
| GET        | http://localhost:8080/permissoes/{id}| Não é necessário                                               |
| POST       | http://localhost:8080/permissoes     | { "authority": "ROLE_ADMIN" }                                  |
| DELETE     | http://localhost:8080/permissoes/{id}| Não é necessário                                               |

