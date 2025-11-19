"# etec-food" 

Verbo HTTPS         ENDPOINT                   JSON


GET       localhost:8080/horarios           Não é necessário



POST      Localhost:8080/restaurantes      { "cnpj": "1234566788"
                                             "nome": "Restaurante Chinês"
                                             "descricao": "Estabelecimento de comida chinesa"
                                             "cep": 02260001
                                             "endereco": "Avenida Central nº 45"
                                             "TaxaEntrega": 10.00
                                             "tempoDeEntregaMinimo": 00:20
                                             "tempoDeEntregaMaximo": 01:00
                                             "aprovado": "TRUE"
                                             "tipoDeCozinha": Chinesa}



DELETE      Localhost:8080/restaurantes      É necessário
