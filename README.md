# Tech Challenge 5 - Póstech JAVA

## Como subir

``docker-compose up `` na raíz do diretório

## Módulos

### Módulo principal (main-service)

* **Descrição:** Recebe as requisições do cliente e manda para os microserviços processarem
* **Documentação da API:** http://localhost:8080/swagger-ui/index.html

### Gestão de lojas e produtos (ms-product-management)

* **Descrição:** Gerenciamento de lojas e seus produtos.

### Módulo de registro e autenticação (ms-login)

* **Descrição:** Registro de usuário e autenticação.

### Módulo de carrinho (ms-cart)

* **Descrição:** Módulo responsável pelo gerenciamento de carrinhos.

### Módulo de pagamento
* **Descrição:** Reponsável por receber a mensagem do AMQ e fazer o processamento do pagamento e reenviar o resultado para a fila.
