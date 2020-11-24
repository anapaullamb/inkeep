# INKEEP [![Author](https://img.shields.io/badge/author-anapaullamb-7225d0?style=flat-square)](https://github.com/anapaullamb)

O Inkeep é uma plataforma de gerenciamento de anotações construido com JSF utilizando o framework PrimeFaces que permite que o usuário crie e admnistre suas anotações, lembretes ou tarefas simples.

## :scroll: Itens Implementados

  A, B, F, G, J
  
  Site hospedado no heroku: https://inkeep.herokuapp.com

## :electric_plug: Instalação

1. Configurar o banco de dados [É utilizado por padrão o PostgreSQL]
1. Alterar as varíaveis da classe FabricaConexao `URL, USERNAME, PASSWORD`
    - localização: `inkeep/src/main/java/ana/paula/inkeep/util/FabricaConexao.jar`
    ```java
        public class FabricaConexao {
          private static Connection conexao;
          private static final String URL_CONEXAO= "";
          private static final String USUARIO= "";
          private static final String SENHA= "";
    ```
    
1. Execute `$ mvn clean install` para gerar um arquivo .war
1. Por fim, realize o deploy do arquivo para o web server java

## :bulb: Tecnologias

O projeto foi construído com:

- JSF 2.2
- [PrimeFaces](https://www.primefaces.org)
- [Bootstrap](https://getbootstrap.com)
- [PostgreSQL](https://www.postgresql.org/)

---
_Obrigada pela atenção!._
