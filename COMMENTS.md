# 🏆 Guia de Execução da Aplicação - Desafio BP

Este guia fornece instruções detalhadas para configurar e executar a aplicação do **Desafio BP** utilizando **Java 17**, **Maven** e **Spring Boot**.

---

## 📌 1. **Repositório Oficial**
O código-fonte está disponível no GitHub:

🔗 **Repositório:** [testeDesafioBP](https://github.com/gbmeello/testeDesafioBP.git)

Caso queira clonar o projeto, execute:
```sh
git clone https://github.com/gbmeello/testeDesafioBP.git
cd testeDesafioBP
```

Caso tenha recebido o código em um arquivo `.zip`, basta extraí-lo e navegar até a pasta raiz do projeto.

---

## 📌 2. **Pré-requisitos**
Antes de rodar a aplicação, certifique-se de que possui os seguintes requisitos instalados:

✅ **Java 17** instalado ([Baixe aqui](https://adoptium.net/))  
✅ **Maven** instalado ([Guia de Instalação](https://maven.apache.org/install.html))  
✅ **IDE (opcional):** IntelliJ IDEA / VS Code / Eclipse  
✅ **Git** instalado (opcional)

Verifique as versões instaladas com:
```sh
java -version
mvn -version
```

---

## 📌 3. **Compilar e Construir o Projeto**
Dentro da pasta raiz do projeto, execute:
```sh
mvn clean package
```
Isso irá compilar o código, rodar os testes e gerar o **arquivo JAR** dentro da pasta `target/`.

Se não houver erros, a saída esperada será semelhante a:
```
[INFO] BUILD SUCCESS
```

---

## 📌 4. **Executando a Aplicação**
Agora, inicie a aplicação com:
```sh
mvn spring-boot:run
```
Ou, se preferir rodar diretamente o `.jar` gerado:
```sh
java -jar target/desafio-bp.jar
```
Se tudo estiver correto, a saída do terminal mostrará:
```
Started TesteApplication in XX seconds
Tomcat started on port(s): 8080
```
A aplicação agora está rodando no endereço:
```
http://localhost:8080
```

---

## 📌 5. **Testando os Endpoints da API**
Agora, você pode interagir com a API via **Postman**, **Insomnia** ou usando **cURL** no terminal.

### **🔹 Simular um Jogo**
Executa uma simulação do jogo e retorna o vencedor e a lista de jogadores ordenados pelo saldo.
```sh
curl -X GET http://localhost:8080/jogo/simular
```
📌 **Resposta esperada (JSON):**
```json
{
    "vencedor": "CAUTELOSO",
    "jogadores": ["CAUTELOSO", "ALEATORIO", "EXIGENTE", "IMPULSIVO"]
}
```

### **🔹 Listar Jogos Anteriores**
Retorna uma lista de todas as partidas jogadas e armazenadas.
```sh
curl -X GET http://localhost:8080/jogo/listar
```

### **🔹 Iniciar uma Nova Partida**
Executa uma nova simulação e armazena o resultado no banco de dados (caso configurado).
```sh
curl -X POST http://localhost:8080/jogo/iniciar
```

---

## 📌 6. **Erros Comuns e Soluções**
### **🔸 Erro: Porta 8080 já está em uso**
Isso ocorre quando outro processo já está rodando na porta 8080.
**Solução:** Pare o processo existente ou mude a porta no `application.properties`:
```properties
server.port=9090
```
E então execute:
```sh
mvn spring-boot:run
```
Agora a API estará disponível em `http://localhost:9090`.

### **🔸 Erro: "Could not autowire"**
Se houver erros de `@Autowired`, certifique-se de que as classes estão corretamente anotadas com `@Service`, `@Component` ou `@Repository` e execute:
```sh
mvn clean package
```
Isso recompila o projeto e pode corrigir o erro.

---

## 📌 7. **Encerrando a Aplicação**
Para parar o servidor, pressione:
```
CTRL + C
```
Se estiver rodando via `.jar`, finalize o processo com:
```sh
kill -9 $(lsof -t -i:8080)
```

---

## 📌 8. **Considerações Finais**
Agora você tem a aplicação rodando localmente e pode simular partidas conforme necessário! 🚀

Se encontrar problemas, siga estes passos:
1. Verifique os logs no terminal.
2. Confira se Java e Maven estão instalados corretamente.
3. Certifique-se de que a porta 8080 está disponível.



**🎯 Autor:** [Gabriel Mello]  
📅 **Última Atualização:** $(09/02/2025)

