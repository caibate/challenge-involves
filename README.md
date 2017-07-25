# challenge-involves
Projeto desenvolvido - desafio involves.

**Observações**
- Projeto foi desenvolvido utilizando algumas features java 8 (lambdas, stream e etc).
- O programa é desenvolvido para ser multiplataforma:
    - Windows
        - Entrar no diretório **challenge-involves/scr/main/dist** e executar **run.bat**.
    - Linux
        - Entrar no **challenge-involves/scr/main/dist** e executar **run.sh**.

Se preferir abra em sua IDE predileta e execute a classe Main. 

##Alterando fonte de dados
- Projeto foi desenvolvido para ser flexivel e se adequar a qualquer arquivo CSV, independente do conteúdo. Para efetuar
 testes executar **challenge-involves/scr/main/dist/scr/main/resources/config.properties**.
    - Alterar propriedade **load.dir.csv=src/main/resources/cidades.csv**
    
##Requisitos

A prova consiste em criar um programa que leia todas as linhas do arquivo CSV e utilize esse arquivo como base para consultas, onde a primeira linha (cabeçalho) contém o nome das propriedades e as linhas subsequentes os valores. Após ler o arquivo, o programa deve começar a ouvir o console a espera dos comandos de consulta. Abaixo segue a lista dos comandos que devem ser interpretados:

- **count** * - escreve no console a contagem total de registros importados (não deve considerar a linha de cabeçalho)
- **count distinct [propriedade]** - escreve no console o total de valores distintos da propriedade (coluna) enviada 
- **filter [propriedade] [valor]** - escreve no console a linha de cabeçalho e todas as linhas em que a propriedade enviada possua o valor enviado 

- Testes unitários JUNIT.
- Otimização de pesquisa (Matriz e lambdas).
- Padrões SOLID (Pattern)

- **SRP**	Principio da Responsabilidade Única	Uma classe deve ter um, e somente um, motivo para mudar.
- **OCP**	Princípio Aberto-Fechado	Você deve ser capaz de estender um comportamento de uma classe, sem modificá-lo.
- **LSP**	Princípio da Substituição de Liskov	As classes derivadas devem ser substituíveis por suas classes base.
- **ISP**	Princípio da Segregação da Interface	Muitas interfaces específicas são melhores do que uma interface única.
- **DIP**	Princípio da inversão da dependência	Dependa de uma abstração e não de uma implementação.