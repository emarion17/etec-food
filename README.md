"# etec-food"



get 	localhost:8080/pagamentos 	não é necessário

&nbsp;				 

post 	localhost:8080/pagamentos	"nr\_valor": 12.05

&nbsp;					"tx\_nome": 'Júlia Leite'

&nbsp;					"nr\_numero": 5

&nbsp;				 	"tx\_expiracao": '19-10-2019'

&nbsp;				 	"tx\_codigo": '5224 4517 8002 5748'

&nbsp;				 	"tx\_status": 'CANCELADO'



put 	localhost:8080/pagamentos/6 	"nr\_valor": 12.05

 					"tx\_nome": 'Júlia Leite'

 					"nr\_numero": 5

 				 	"tx\_expiracao": '19-10-2019'

 				 	"tx\_codigo": '5224 4517 8002 5748'

 				 	"tx\_status": 'CONFIRMADO'





delete 	localhost:8080/pagamentos/6 	não é necessário







&nbsp;







