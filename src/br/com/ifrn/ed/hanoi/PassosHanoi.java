package br.com.ifrn.ed.hanoi;

import br.com.ifrn.ed.hanoi.stack.MyStack;

/**
 * Esta classe guarda o passo a passo da solução da torre de hanoi;
 *
 * @author Herlan & Sávio
 */
public class PassosHanoi {

    private MyStack<Integer> stackA, stackB, stackC;
    private long totalMovimentosRealizados;

    public PassosHanoi(MyStack<Integer> stackA, MyStack<Integer> stackB, MyStack<Integer> stackC, long totalMovimentosRealizados) {
        this.stackA = stackA;
        this.stackB = stackB;
        this.stackC = stackC;
        this.totalMovimentosRealizados = totalMovimentosRealizados;
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

    public long getTotalMovimentosRealizados() {
        return totalMovimentosRealizados;
    }
}
