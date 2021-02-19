# Explorando Marte :rocket:

Projeto de programação que simula de forma simples a exploração de uma área de Marte com sondas espaciais, utilizando conceitos de Orientação a Objetos.

## Funcionamento:

Cada sonda é inserida na área apontando para uma direção (norte, leste, oeste ou sul). Dada essa posição inicial e uma sequência de movimentos (virar 90 graus para a esquerda, para a direita, ou mover-se um ponto a frente), o programa deve retornar a posição final da sonda.  
Se no decorrer da relização de comandos a sonda colidir com o limite do campo ou com um espaço já ocupado por outra sonda, a sonda irá virar 90 graus para a esquerda, alterando seu percurso.

## Entrada:

Primeira linha: coordenadas do canto superior direito do campo a ser explorado.  
Depois, cada sonda contém duas linhas de informações.

- Primeira linha: Coordenadas e direção da sonda no ponto inicial no formato "X Y D" (Exemplo: 1 3 N)
- Segunda linha: Sequência de movimentos a serem realizados pela sonda (Exemplo: LMLMRMRM)

## Saída:

Cada sonda gera uma linha de saída, indicando sua coordenada final e direção no formato "X Y D".
