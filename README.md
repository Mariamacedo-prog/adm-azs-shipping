

# Sistema de Frete (azship)

Este é um sistema de frete desenvolvido utilizando Spring Boot. Abaixo estão os detalhes do projeto:

O sistema inclui operações básicas como cadastro, listagem, atualização e remoção de frete, cliente e atributos.


### Tecnologias Utilizadas
Java

Spring Boot

Spring Data JPA

PostgreSQL (para o banco de dados)

node: v20.11.1 

npm: 10.5.0 

yarn: 1.22.19


### Compile e execute o projeto usando o Maven:
mvn -U clean install spring-boot:run

ou 

mvn clean 
mvn -U install
mvn spring-boot:run

Sistema ira rodar por padrao no: http://localhost:8080


### Endpoints:

A Tabela ATRIBUTO_CLIENTE e FRETE são dependentes da tabela CLIENTE. Por isso é necessário primeiro criar um Cliente para poder criar assim um frete e atributos.


### DELETE      /api/cliente/{id}
Remove o Cliente pelo id, caso não encontre retorna a mensagem "Cliente não encontrado com o ID: {id}"

Quando deleta o Cliente ele remove também todos os fretes daquele cliente e todos os atributos.

![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/e20cd08f-4654-4dff-a2d7-17e5fbcdc56c)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/ffe43fe1-2835-4be6-af39-99993e41ed4a)


### POST      /api/cliente
Cria um novo Cliente, caso o ID do cliente enviado não exista retorna o erro "Cliente não encontrado com o ID: {id}"

Para fazer a atualização do Cliente é somente enviar os dados com o ID do cliente.
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/9398ac3d-b34e-43cd-bc65-bf831f89cb79)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/624a79b7-bde1-48db-aaed-3afb2a13a4aa)


### GET      /api/cliente/{id}
Lista um Cliente específico, caso o ID do cliente enviado não exista retorna o erro "Cliente não encontrado com o ID: {id}"

![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/2978f8a6-36c4-42e6-8dc2-2fe740791781)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/9744b288-7859-419a-906e-6ca1a27a4bf5)


### GET      /api/cliente?page=0&search=
Lista todos os Clientes com paginação, que recebe a "search" como a fonte da pesquisa e "page" que recebera o numero da pagina.

![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/d293e92b-3fb1-4d01-9856-df3212364ffd)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/b274890d-b53a-4ddf-bf65-bb0aa35cf0db)





### DELETE      /api/atributo/{id}
Remove o Atributo pelo id, caso não encontre retorna a mensagem "Atributo não encontrado com o ID: {id}"

![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/8a1593b8-ace2-467c-927f-0b9211c1b724)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/ed410a95-8957-4568-85a0-15187d61dd19)



### POST      /api/atributo
Cria um novo Atributo, caso o ID do cliente enviado não exista retorna o erro "Cliente não encontrado com o ID: {id}"

![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/ca71599c-5ec8-4b7e-9d4f-4e2d23eda804)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/e869e729-6f5c-4bfd-a7c5-0541d8e24bbd)


### GET      /api/atributo/cliente/{clienteId}
Lista um todos os Atributos de um Cliente específico.

![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/b8f149c1-3cd2-426e-9bfd-41c7b931b015)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/6ccac7ef-2093-4cf3-b1d0-8c52489abd16)


### GET      /api/atributo/{id}
Lista um Atributo específico pelo seu id.

![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/2e24b56f-2611-417f-8b4b-3c9fdef71134)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/5c21a022-aa1d-478d-b9dc-bc81231b8d5a)






### DELETE      /api/frete/{id}
Remove o frete pelo id, caso não encontre retorna a mensagem "Frete não encontrado com o ID fornecido: {id}"
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/b4ebcf28-fb1d-4a14-9a12-75bc789f2c52)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/79d7b228-f1d5-4712-85d2-2a262c93876a)


### POST      /api/frete
Cria um novo frete para um cliente, caso o ID do cliente enviado não exista retorna o erro "Cliente não encontrado com o ID: {id}"
Para fazer a atualização do frete é somente enviar os dados com o ID do frete.
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/f39879df-7dab-40b6-8fd7-b16f1ad5ccdd)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/e66ef191-8ca9-49a8-a361-bca4de2d1cd3)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/a961e45c-f8a6-4bfa-8679-b774b29587ef)


### GET      /api/frete/{id}
Lista um frete específico.
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/de3f0bc6-4116-48b0-a583-492ab3c336f9)


### GET      /api/frete?page=0&search=
Lista todos os Fretes com paginação, que recebe a "search" como a fonte da pesquisa e "page" que recebera o numero da pagina.

![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/aaf3e175-40c2-4319-8520-1b631cdfeebd)
![image](https://github.com/Mariamacedo-prog/azship-test/assets/69858181/5bb2c498-9470-4f54-a93c-7a5cb026cc55)
