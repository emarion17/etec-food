"# etec-food" 

Verbo HTTPS         ENDPOINT                   JSON


GET       localhost:8080/horarios           Não é necessário


POST      localhost:8080/restaurantes      { "cnpj": "8546342609",
                                             "nome": "Restaurante Japonês",
                                             "descricao": "Estabelecimento de comida japonesa",
                                             "cep": "05570-002",
                                             "endereco": "Avenida do Estado n° 105",
                                             "TaxaEntrega": 5.00,
                                             "tempoDeEntregaMinimo": 40,
                                             "tempoDeEntregaMaximo": 60,
                                             "aprovado": true,
                                             "tipoDeCozinha": Japonesa }
                                             


POST      Localhost:8080/restaurantes      { "cnpj": "1234566788",
                                             "nome": "Restaurante Chinês",
                                             "descricao": "Estabelecimento de comida chinesa",
                                             "cep": "02260-001",
                                             "endereco": "Avenida Central nº 45",
                                             "TaxaEntrega": 10.00,
                                             "tempoDeEntregaMinimo": 20,
                                             "tempoDeEntregaMaximo": 60,
                                             "aprovado": true,
                                             "tipoDeCozinha": Chinesa }



DELETE      Localhost:8080/restaurantes      É necessário
