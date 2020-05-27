# Projeto: springboot_angular_primeng
## Objetivos
* Pesquisa e Estudo das tecnologias
* Divultar conhecimentos para interessados

## Tecnologias:
* Spring Boot
* Angular 8
* PrimeNG
* Sql Server Express

## Telas da Aplicação

* Tela Home

<img src="https://github.com/ricardojbcordeiro/springboot_angular_primeng/blob/master/resources/telas/tela_home.PNG" width="800" heigth="600">

* Tela de Cadastro de Contatos

<img src="https://github.com/ricardojbcordeiro/springboot_angular_primeng/blob/master/resources/telas/tela_cadastro_contato.PNG" width="800" heigth="600">

* Tela de Lista de Contatos

<img src="https://github.com/ricardojbcordeiro/springboot_angular_primeng/blob/master/resources/telas/Inkedtela_lista_contatos.jpg" width="800" heigth="600">


## Definindo o Banco de Dados
```SQL
CREATE TABLE [dbo].[contatos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](255) NOT NULL,
	[idade] [int] NOT NULL,
	[endereco] [varchar](255) NULL,
	[data_criacao] [datetime] NOT NULL,
	[data_alteracao] [datetime] NULL,
	[cpf] [varchar](255) NULL,
	[nome_imagem] [varchar](255) NULL,
	[tamanho_imagem] [bigint] NULL,
	[tipo_imagem] [varchar](255) NULL,
	[image64] [ntext] NULL,
	[imagem] [image] NULL,
 CONSTRAINT [pk_contatos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

```

## Arquitetura da Aplicação

# Backend
* Modelo
* Repositório
* Serviço
* Controller

# Frontend
* Componentes
* Serviço

