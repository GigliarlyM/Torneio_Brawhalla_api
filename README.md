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

### Exemplo de cadastro
```json
{
  "nome": "nome Time",
  "apelido": "NT",
  "apto": false,
  "confirmacaoIntegrantes": true,
  "jogadores": [
    {
      "nome": "Jonathan",
      "idade": 20,
      "apelido": "DRX",
      "apto": true,
      "documentos": true,
      "nacionalidade": "brasileiro",
      "estado": "Paraiba",
      "cidade": "Campina Grande"
    },
    {
      "nome": "Douglas",
      "idade": 20,
      "apelido": "Draken",
      "apto": true,
      "documentos": true,
      "nacionalidade": "brasileiro",
      "estado": "Paraiba",
      "cidade": "Campina Grande"
    }
  ],
  "nacionalidade": "brasileira",
  "diretor": {
    "nome": "Joaquim",
    "idade": 35,
    "nacionalidade": "brasileiro",
    "estado": "Paraiba",
    "cidade": "Campina Grande"
  },
  "torneioCadastrado": {
    "titulo": "Brawlhalla Summer Championship Singles 2023 Australia & SEA Brawlhalla , Ubisoft 29.07.23 $5 000",
    "vagas": 15,
    "estado": "Paraiba",
    "cidade": "Joao Pessoa",
    "dataInicio": "2025-06-10T00:00:00",
    "concluido": false
  }
}
```

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
