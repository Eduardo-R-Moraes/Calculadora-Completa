## Calculadora completa
O objetivo desse código foi rever conceitos do Java e aprender novos como ArrayList<>.
Este código é uma calculadora que recebe uma string e calcula o valor, como uma calculadora. 
Exemplo de entrada: 1 + 1 / 2 * 3 * -1 --saída--> -0,5. Não foi implementado a prioridade dos ( ), [ ] e { }.

### Explicando algoritmo:
1. O código recebe um string contendo números e operações.
2. O código é quebrado em tokens, sendo que, se houver + ou - é armazenado junto ao número e se houver * ou / é armazenado separado. <br>

   Entrada: "1 + 1 / 2 * 3 * -1" <br>
   Tokens: ["1", "+1", "/", "2", "*", "3", "*", "-1"]

3. Então os tokens são percorridos e primeiro são resolvidos as multiplicações e divisões. <br>
  O algoritmo procura por / e * e, quando os acha, realiza a operação com o número anterior e posteior ao sinal. <br>
  Por fim o resultado é armazenado no número anterior ao operador, sendo ele e o número posterior então escluídos.

  Entrada: ["1", "+1", "/", "2", "*", "3", "*", "-1"]  
  Saídas:
  - ["1", "0,5", "*", "3", "*", "-1"]
  - ["1", "1,5", "*", "-1"]
  - ["1", "-1,5"]
    
4. Por fim, todas as somas e subtrações são resolvidas. Para resolvê-las, somar os dois primeiros números do array,
   adicionar na posição 0 e excluir a posição 1. Repitir isso até o tamanho do array ser 1.

   Entrada: ["1", "-1,5"]  
   Saída do programa: "-0,5"

### Conceitos aprendidos e revisados
- ArrayLists<>(): métodos e funcionamento;
- Tranformação de tipos: transformar char em int ou em String e assim por diante;
- Operadores lógicos: or -> || e and -> &&.
- Iterar sobre valores dos arrays: for(char caractere : array) { }
- Lógica de programação: essencial para o desenvolvimento inteiro do programa;
- Correção de erros: debugagem do programa.
