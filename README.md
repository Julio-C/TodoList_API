# TodoList_Api
É uma API RESTFUL simples para gerenciar tarefas.

Version 1.0.0

Deploy da aplicação:

Para realizar o deploy dessa api, será necessário ter instalado uma IDE JAVA e o POSTGRES.
Para a construção da API utilizei o Spring Tools 4.

Baixe o TodoList_Api
importe como um projeto maven
o projeto esta configurado para executar na porta 8080.

Postgres:

Criar o DataBase tarefas-apirest, que é onde a api criará as tabelas automaticamente após a execução.
Configuração:
		Localhost : http://127.0.0.1
		PORT : 5432
		username=postgres
		password=postgres

Utilizei o Postman e o Curl, a seguir os endpoints para realização de testes.


EndPoints Curl:
Os testes são realizados através do git bash.


List:		curl http://localhost:8080/api/todo/list

Retorno:	 % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100   187    0   187    0     0   1460      0 --:--:-- --:--:-- --:--:--  1460
		[{"id":11,"title":"Delete","detail":"testando api","status":"Pending","date":"20 de outubro"}
		,{"id":12,"title":"Insert","detail":"testando api","status":"Pending","date":"20 de outubro"}]


========================================================================================================================================

FindById:	curl http://localhost:8080/api/todo/{id}

Exemplo:	curl http://localhost:8080/api/todo/11

Retorno:	% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100    92    0    92    0     0    344      0 --:--:-- --:--:-- --:--:--   344
		{"id":11,"title":"Delete","detail":"testando api","status":"Pending","date":"20 de outubro"}


========================================================================================================================================

PUT :	http://localhost:8080/api/todo

Exemplo:	curl -i -X PUT -H "Content-Type: application/json" -d '{"id":12,"title":"Insert","detail":"testando api","status":"Pending","date":"20 de outubro"}' http://localhost:8080/api/todo

Retorno:	 % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100   184    0    92  100    92      6      6  0:00:15  0:00:14  0:00:01    21HTTP/1.1 200
		Content-Type: application/json
		Transfer-Encoding: chunked
		Date: Sun, 20 Oct 2019 21:55:51 GMT

		{"id":12,"title":"Insert","detail":"testando api","status":"Pending","date":"20 de outubro"}


========================================================================================================================================

POST:		curl -i -X POST -H "Content-Type: application/json" -d '{"id": {id},"title": "{title}","detail": "{detail}","status": "{status}","date": "{date}"}' http://localhost:8080/api/todo

Exemplo:	curl -i -X POST -H "Content-Type: application/json" -d '{"title":"Update","detail":"testando api","status":"Completed","date":"20 de outubro"}' http://localhost:8080/api/todo

Retorno:	% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100   180    0    94  100    86    472    432 --:--:-- --:--:-- --:--:--   909HTTP/1.1 200
		Content-Type: application/json
		Transfer-Encoding: chunked
		Date: Sun, 20 Oct 2019 22:00:46 GMT

		{"id":14,"title":"Update","detail":"testando api","status":"Completed","date":"20 de outubro"}


========================================================================================================================================

DELETE:		curl -i -X DELETE -H "Content-Type: application/json" -d '{"id": {id},"title": "{title}","detail": "{detail}","status": "{status}","date": "{date}"}' http://localhost:8080/api/todo

Exemplo:	curl -i -X DELETE -H "Content-Type: application/json" -d '{"id": 11,"title": "Delete","detail": "testando api","status": "Completed","date": "20 de outubro"}' http://localhost:8080/api/todo 

Retorno:	 % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
		100    99    0     0  100    99      0     23  0:00:04  0:00:04 --:--:--     0HTTP/1.1 200
		Content-Length: 0
		Date: Sun, 20 Oct 2019 22:04:04 GMT

====================================================================================================================================================================================================================================

HealthCheck:	curl POST http://localhost:8080/actuator/health

Retorno:	% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
 		0     0    0     0    0     0      0      0 --:--:--  0:00:01 --:--:--     0curl: (6) Could not resolve host: POST
		100    15    0    15    0     0    319      0 --:--:-- --:--:-- --:--:--   319{"status":"UP"}

========================================================================================================================================

Metrics:	curl POST http://localhost:8080/actuator/metrics/{metric}

Exemplo:	curl POST http://localhost:8080/actuator/metrics/process.start.time

Retorno:	% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
 	 	0     0    0     0    0     0      0      0 --:--:--  0:00:01 --:--:--     0curl: (6) Could not resolve host: POST
		100   192    0   192    0     0   8727      0 --:--:-- --:--:-- --:--:--  	
		8727{"name":"process.start.time","description":"Start time of the process since unix 	
		epoch.","baseUnit":"seconds","measurements":[{"statistic":"VALUE","value":1.57162216685E9}],"availableTags":[]}

========================================================================================================================================
========================================================================================================================================

Endpoits Postman:

POST :		http://localhost:8080/api/todo

Obs:		O campo ID é preenchido automaticamente.

Exemplo:	{
        		"title": "Insert",
        		"detail": "testando api",
        		"status": "Pending",
        		"date": "20 de outubro"
    		}


========================================================================================================================================

LIST:		http://localhost:8080/api/todo/list

Obs:		Retorna todas as tarefas da lista.

Exemplo:
		[
    		{
    			"id": 9,
        		"title": "Delete",
        		"detail": "testando api",
        		"status": "Pending",
        		"date": "20 de outubro"
    		},
    		{
        		"id": 10,
        		"title": "List",
        		"detail": "testando api",
        		"status": "Pending",
        		"date": "20 de outubro"
    		}
		]
	

========================================================================================================================================

FindById:	http://localhost:8080/api/todo/{id}

Obs:		Retorna apenas o dado do id informado.

Exemplo:	http://localhost:8080/api/todo/9

Retorno:	{
    			"id": 9,
    			"title": "Delete",
    			"detail": "testando api",
    			"status": "Pending",
    			"date": "20 de outubro"
		}
	
========================================================================================================================================

PUT:		http://localhost:8080/api/todo

Obs:		Altera é necessario passar todos os dados, inclusive o id.

Exemplo:	{
    			"id": 9,
    			"title": "Delete",
    			"detail": "testando api",
    			"status": "Completed",
    			"date": "20 de outubro"
		}

========================================================================================================================================

DELETE:		http://localhost:8080/api/todo

Obs:		Preencher todos os campos.

Exemplo:	{
        		"id": 6,
       	 		"title": "Insert",
        		"detail": "testando api",
        		"status": "Complete",
        		"data": "21 de outubro"
    		}


========================================================================================================================================

METRICS:	http://localhost:8080/actuator/metrics/{metric}

Exemplo:	http://localhost:8080/actuator/metrics/process.start.time

Retorno: 	{
    			"name": "process.start.time",
    			"description": "Start time of the process since unix epoch.",
    			"baseUnit": "seconds",
    			"measurements": [
       	 		{
            			"statistic": "VALUE",
            			"value": 1.571596411575E9
        		}
			],
    			"availableTags": []
		}

========================================================================================================================================

HealthCheck:	http://localhost:8080/actuator/health

Retorno:	{
    			"status": "UP"
		}



