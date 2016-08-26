package br.com.ifrn.ed.hanoi;

import br.com.ifrn.ed.hanoi.stack.MyStack;

/**
 * Cria Três pilhas dinâmicas utilizadas para a resolução da torre de hánoi.
 *
 * @author Herlan & Sávio
 */
public class Hanoi {

    private MyStack<Integer> stackA, stackB, stackC;
    private long totalMovimentosRealizados;
    private long totalMovimentosNecessarios;

    /**
     * Contrutor padrão da classe hánoi.
     */
    public Hanoi() {
        stackA = new MyStack<>();
        stackB = new MyStack<>();
        stackC = new MyStack<>();
        totalMovimentosRealizados = 0;
    }

    /**
     * Este método gera elementos em ordem crescente para a torre de Hanoi no
     * stackA.
     *
     * @param qtdElementos a ser gerado em ordem crescente;
     */
    public void gerarElementos(int qtdElementos) {
        int valorInicial = 0;

        if (!stackA.isEmpty()) {
            stackA = MyStack.reverse(stackA);
            valorInicial = stackA.peek();
        }

        for (int i = 0; i < qtdElementos; i++) {
            stackA.push(++valorInicial);
        }

        stackA = MyStack.reverse(stackA);

        setTotalElementosNecessarios(stackA.size());
    }

    /**
     * Insere um elemento no topo da pilha. Só pode ser inserido elementos de
     * valor menor do que o elemento do topo.
     *
     * @param elemento a ser inserido.
     * @return true caso seja possível inserir e falso caso ele não obedeça
     * nenhuma condição.
     */
    public boolean inserirElemento(int elemento) {
        if (!stackA.isEmpty()) {
            if (elemento > stackA.peek()) {
                return false;
            }
        }

        stackA.push(elemento);
        setTotalElementosNecessarios(stackA.size());
        return true;
    }

    /**
     * Obtém o valor da pilha A;
     *
     * @return stackA.
     */
    public MyStack<Integer> getStackA() {
        return stackA;
    }

    /**
     * Obtém o valor da pilha B;
     *
     * @return stackB.
     */
    public MyStack<Integer> getStackB() {
        return stackB;
    }

    /**
     * Obtém o valor da pilha C;
     *
     * @return stackC.
     */
    public MyStack<Integer> getStackC() {
        return stackC;
    }

    /**
     * Obtém o cálculo do total de movimentos necessários para resolver a torre
     * de hánoi.
     *
     * @return movimentosNecessarios.
     */
    public long getTotalMovimentosNecessarios() {
        return this.totalMovimentosNecessarios;
    }

    /**
     * Obtém o total de movimentos realizados no processo de resolução da torre
     * de hánoi.
     *
     * @return movimentosRealizados.
     */
    public long getTotalMovimentosRealizados() {
        return totalMovimentosRealizados;
    }

    /**
     * Calcula o total de movimentos necessários para resolver a torre de hánoi
     * com base no total de elemento da pilha principal.
     *
     * @param size
     */
    private void setTotalElementosNecessarios(int size) {
        this.totalMovimentosNecessarios = (long) Math.pow(2, size) - 1;
    }

    /**
     * Resolve a torre de hánoi.
     */
    public void Resolver() {
        setTotalElementosNecessarios(stackA.size());
        for (int i = 1; i <= totalMovimentosNecessarios; i++) {
            switch (i % 3) {
                case 1:
                    MoveHanoi(stackA, stackC);
                    break;
                case 2:
                    MoveHanoi(stackA, stackB);
                    break;
                case 0:
                    MoveHanoi(stackB, stackC);
                    break;
            }
            totalMovimentosRealizados++;
            System.out.println("STACK A: " + stackA);
            System.out.println("STACK B: " + stackB);
            System.out.println("STACK C: " + stackC);
            System.out.println("MOV REALIZADOS: " + getTotalMovimentosRealizados() + "\n\n");
        }
    }

    /**
     * Realiza o movimento entre duas pilhas, pilha de origem e pilha de
     * destino. O movimento pode ser realizado de origem para destino e vice
     * versa.
     *
     * @param stackOrigin pilha de origem.
     * @param stackDesti pilha de destino.
     */
    private static void MoveHanoi(MyStack<Integer> stackOrigin, MyStack<Integer> stackDesti) {
        if (stackOrigin.isEmpty()) {
            stackOrigin.push(stackDesti.pop());
        } else if (stackDesti.isEmpty()) {
            stackDesti.push(stackOrigin.pop());
        } else if (stackDesti.peek() < stackOrigin.peek()) {
            stackOrigin.push(stackDesti.pop());
        } else {
            stackDesti.push(stackOrigin.pop());
        }
    }
}
