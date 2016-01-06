### Documentação

Para rodar os testes, executar o comando: `sbt test`

Para executar as Mains, `sbt run` e selecionar qual das duas deseja (path ou sum). As instruções para entrada dos dados
serão exibidas na tela.

### Observações

- Ambos os problemas foram resolvidos com algoritmos recursivos: em 1, foi utilizado o algoritmo de backtracking 
enquanto que em 2 foi implementada uma busca em profundidade.
- Ambas as implementações utilizaram estruturas de dados imutáveis e fizeram uso de `tail recursion`.
- `List` foi utilizado no lugar de uma `immutable.Stack` pois recomendação da própria 
[documentação](http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.Stack).

### Problemas

1. Escreva um programa que, dado uma lista de números e uma soma alvo, retorne todas as combinações de um ou mais itens da lista que a soma seja igual a soma alvo.
Exemplo:

Entrada: Para soma alvo 6 de lista (1, 2, 3, 4, 6) o resultado é:

Saida: (1, 2, 3)
(2, 4)
(6)


2. Fazer um programa que encontra um caminho a partir de uma origem até o destino navegando entre os nós. Cada nó é representado por um número inteiro. Cada possibilidade de caminho é representado por um dicionário no formato (Inteiro -> Lista( Inteiros)), onde a chave é o número do nó, e a lista são as ligações unidirecional daquele nó. O resultado é uma lista de inteiros representando o caminho pelos nós.
Exemplo:

Entrada: origem: 1, destino: 4, caminhos: ( 1 -> (2, 3), 2 -> (4), 3->(5) )

Saída: (1, 2, 4)
