# 🏆 Desafio BP - Simulação de Jogo Imobiliário

Este projeto implementa um jogo hipotético inspirado no **Banco Imobiliário**, onde **quatro jogadores competem** por propriedades seguindo diferentes **estratégias de compra**. A simulação é executada para determinar **qual jogador tem a melhor estratégia**.

---

## 📌 Regras do Jogo
- O jogo possui **4 jogadores**, cada um com um comportamento distinto.
- O **tabuleiro** é composto por **20 propriedades** em sequência.
- Todos os jogadores **começam com 300 de saldo**.
- O jogo segue uma ordem de turnos **definida aleatoriamente** no início.
- O jogador rola um **dado de 6 faces** para determinar quantas casas avança.
- **Se cair em uma propriedade sem dono**, ele pode comprá-la.
- **Se cair em uma propriedade com dono**, ele paga o aluguel ao proprietário.
- **Ao completar uma volta no tabuleiro**, o jogador ganha **100 de saldo**.
- **Jogadores que ficarem com saldo negativo são eliminados** e suas propriedades voltam a ficar disponíveis para compra.
- O jogo termina quando **restar apenas um jogador** com saldo positivo.
- **Se o jogo atingir 1000 rodadas**, o jogador com mais saldo vence.

---

## 🎮 Tipos de Jogadores
Cada jogador segue uma **estratégia diferente** para decidir **quando comprar propriedades**:

| Jogador       | Estratégia de Compra |
|--------------|----------------------|
| **Impulsivo** | Compra qualquer propriedade onde parar. |
| **Exigente**  | Compra a propriedade **se o aluguel for maior que 50**. |
| **Cauteloso** | Compra a propriedade **se ainda tiver pelo menos 80 de saldo sobrando**. |
| **Aleatório** | Compra a propriedade com **50% de chance**. |

---

## 🚀 Como Executar a Aplicação

### 📌 1. Pré-requisitos
Certifique-se de ter os seguintes requisitos instalados:
- **Java 17** ([Baixe aqui](https://adoptium.net/))
- **Maven** ([Guia de Instalação](https://maven.apache.org/install.html))
- **Git** (Opcional, para clonar o repositório)

Verifique as versões instaladas:
```sh
java -version
mvn -version
