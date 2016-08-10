package br.com.ifrn.ed.hanoi;

import br.com.ifrn.ed.hanoi.stack.MyStack;

/**
 *
 * @author Herlan & Sávio
 */
public class Hanoi {

    private MyStack<Integer> stackA, stackB, stackC;
    private long totalMovimentosRealizados;
    private long totalMovimentosNecessarios;

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

    public MyStack<Integer> getStackA() {
        return stackA;
    }

    public MyStack<Integer> getStackB() {
        return stackB;
    }

    public MyStack<Integer> getStackC() {
        return stackC;
    }

    public long getTotalMovimentosNecessarios() {
        return this.totalMovimentosNecessarios;
    }

    private void setTotalElementosNecessarios(int size) {
        this.totalMovimentosNecessarios = (long) Math.pow(2, size) - 1;
    }

    public static void solve(MyStack<Integer> stackA, MyStack<Integer> stackB, MyStack<Integer> stackC) {
        if (stackA.size() % 2 == 0) {
            if (stackA.isEmpty()) {
                solve(stackB, stackA, stackC);
            } else if (stackB.isEmpty()) {
                stackB.push(stackA.pop());
            } else if (stackA.peek() > stackB.peek()) {
                solve(stackB, stackA, stackC);
            } else {
                stackB.push(stackA.pop());
            }
            solve(stackA, stackB, stackC);
        } else if (stackC.isEmpty()) {
            stackC.push(stackA.pop());
            solve(stackA, stackB, stackC);
        } else if (stackA.peek() > stackC.peek()) {

        } else {
            stackC.push(stackA.pop());
            solve(stackA, stackB, stackC);
        }
    }

}
