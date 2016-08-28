package br.com.ifrn.ed.hanoi;

import br.com.ifrn.ed.hanoi.stack.MyStack;

public class StepsHanoi {

    private MyStack<Integer> stackA, stackB, stackC;
    private long totalMovimentosRealizados;
    private long totalMovimentosNecessarios;

    public StepsHanoi(MyStack<Integer> stackA, MyStack<Integer> stackB, MyStack<Integer> stackC, long totalMovimentosRealizados, long totalMovimentosNecessarios) {
        this.stackA = stackA;
        this.stackB = stackB;
        this.stackC = stackC;
        this.totalMovimentosRealizados = totalMovimentosRealizados;
        this.totalMovimentosNecessarios = totalMovimentosNecessarios;
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

    public long getTotalMovimentosNecessarios() {
        return totalMovimentosNecessarios;
    }

}
