# Simulador de Comutação de Pacotes

Aplicação acadêmica desenvolvida em Java para demonstrar o funcionamento de uma
fila de pacotes e a perda de pacotes causada por congestionamento.

O simulador recebe pacotes criados por usuários, armazena esses pacotes em uma
fila com capacidade limitada e realiza o envio seguindo a ordem de chegada. Se
um novo pacote chegar quando a fila estiver cheia, ele será descartado por meio
da política **Tail Drop**.

## Objetivo

O projeto apresenta, de forma simplificada, conceitos utilizados em redes de
computadores:

- criação de pacotes com origem, destino e conteúdo;
- armazenamento temporário em uma fila;
- envio na ordem FIFO (*First In, First Out*);
- limitação da capacidade da fila;
- congestionamento e descarte de pacotes;
- contabilização dos pacotes perdidos.

## Funcionamento

Cada `Usuario` pode criar um `Pacote`. O pacote recebe um identificador, o nome
do usuário de origem, o nome do usuário de destino e o conteúdo da mensagem.

Os pacotes são entregues ao `Simulador` pelo método `adicionar`. O simulador
insere inicialmente o pacote na fila e solicita que `PerdaDePacote` verifique se
a capacidade máxima foi ultrapassada.

Quando não existe congestionamento, o pacote permanece na fila. O método
`enviar` retira o primeiro pacote da fila e o apresenta como enviado.

Quando existe congestionamento, o funcionamento é dividido entre duas classes:

1. `PerdaDePacote` compara o tamanho atual da fila com sua capacidade máxima e
   identifica o pacote mais recente como o pacote perdido.
2. `Perda` subtrai o pacote identificado da fila.
3. `Simulador` incrementa o total de perdas e informa o descarte no console.

Essa estratégia é conhecida como **Tail Drop**, pois descarta o pacote que está
no final da fila quando não existe mais espaço no buffer.

## Classes

| Classe | Responsabilidade |
| --- | --- |
| `Main` | Cria os objetos e executa o exemplo da simulação. |
| `Usuario` | Representa um usuário e cria pacotes. |
| `Pacote` | Armazena identificador, origem, destino e conteúdo. |
| `Simulador` | Coordena a fila, os envios e as perdas. |
| `PerdaDePacote` | Detecta o congestionamento e calcula qual pacote será perdido. |
| `Perda` | Remove da fila o pacote selecionado para descarte. |

## Exemplo configurado

No exemplo de `Main.java`, a capacidade da fila é definida como dois pacotes:

```java
Simulador simulador = new Simulador(2);
```

Em seguida, três pacotes são adicionados. Os dois primeiros permanecem na fila,
mas o terceiro é descartado por congestionamento:

```text
Pacote perdido por congestionamento: Pacote3 [ Nalanda -> Pedro ] atrasamos o trabalho
```

Depois do descarte, o primeiro pacote é enviado e o segundo continua aguardando
na fila.

## Compilação e execução

### Requisito

- Java Development Kit (JDK) instalado.

### Comandos

A partir da raiz do repositorio:

```text
cd "simulador - Copia/src"
javac Main.java Simulador.java Usuario.java Pacote.java Perda.java PerdaDePacote.java
java Main
```

Os arquivos `.class` gerados pela compilação ficarão na pasta `src`.

## Diagramas

Os diagramas estao disponiveis na pasta [`diagramas`](diagramas):

1. [Fluxo normal, sem congestionamento](diagramas/01-fluxo-normal.png)
2. [Fluxo do simulador com perda por congestionamento](diagramas/02-perda-por-congestionamento.png)
3. [Diagrama de classes](diagramas/03-diagrama-de-classes.png)

## Estrutura do projeto

```text
simulador-de-comutacao-de-pacotes/
|-- README.md
|-- diagramas/
|   |-- 01-fluxo-normal.png
|   |-- 02-perda-por-congestionamento.png
|   `-- 03-diagrama-de-classes.png
`-- simulador - Copia/
    `-- src/
        |-- Main.java
        |-- Pacote.java
        |-- Perda.java
        |-- PerdaDePacote.java
        |-- Simulador.java
        `-- Usuario.java
```

## Simplificações do modelo

O projeto representa uma fila única e utiliza uma capacidade fixa. Ele ainda
não simula elementos como roteadores, múltiplos enlaces, largura de banda,
atraso de propagação, retransmissão ou controle de congestionamento do TCP.
Esses recursos podem ser incorporados em evoluções futuras.
