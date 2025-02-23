# Projeto api para torneio de Brawhalla

## Requisitos nao funcionais

- Java 21
- Spring Boot 3.4.3
  - JPA
  - Web
  - Actuator
- h2 (para ambiente de dev)
- postgresql
- Spring openapi webmvc ui
- Gerenciador de dependencia -> MAVEN 4.0.0

## Diagrama

```mermaid
classDiagram
    class Time {
        - nome : string
        - apelido : string
        - apto : boolean
        - confirmacaoIntegrantes : boolean
        - nacionalidade : string
    }
    class Jogador {
        - nome : string
        - idade : integer
        - apelido : string
        - apto : boolean
        - documentos : boolean
        - nacionalidade : string
        - estado : string
        - cidade : string
    }
    class Diretor {
        - nome : string
        - idade : integer
        - nacionalidade : string
        - estado : string
        - cidade : string
    }
    class Torneio {
        - titulo : string
        - vagas : integer
        - estado : string
        - cidade : string
        - dataInicio : string
        - concluido : boolean
    }
    Time "1" -- "*" Jogador : jogadores
    Time "1" -- "1" Diretor : diretor
    Time "*" -- "1" Torneio : torneio
```
