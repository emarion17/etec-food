"# etec-food" 

## ClienteController

| Verbo HTTP | Endpoint          | JSON (se houver) |
|------------|-------------------|------------------|
| GET        | /clientes         | Não é necessário |
| GET        | /clientes/{id}    | Não é necessário |
| POST       | /clientes         | { "txCpf": "12345678901", "txNome": "João da Silva", "txEmail": "joao@gmail.com", "txTelefone": "11987654321", "inValidado": true } |
| DELETE     | /clientes/{id}    | Não é necessário |

## EntregaController

| Verbo HTTP | Endpoint          | JSON (se houver) |
|------------|-------------------|------------------|
| GET        | /entregas         | Não é necessário |
| GET        | /entregas/{id}    | Não é necessário |
| POST       | /entregas         | { "txCep": "01234567", "txEndereco": "Rua das Flores, 123", "txComplemento": "Apto 45", "idCpf": "12345678901" } |
| DELETE     | /entregas/{id}    | Não é necessário |

