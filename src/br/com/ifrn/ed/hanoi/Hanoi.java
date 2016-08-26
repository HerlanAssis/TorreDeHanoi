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

    public long getTotalMovimentosRealizados() {
        return totalMovimentosRealizados;
    }

    private void setTotalElementosNecessarios(int size) {
        this.totalMovimentosNecessarios = (long) Math.pow(2, size) - 1;
    }

    public void solve() {
        totalMovimentosNecessarios = (long) Math.pow(2, stackA.size());
        totalMovimentosRealizados = 0;
        for (int i = 1; i < totalMovimentosNecessarios; i++) {
            switch (i % 3) {
                case 1:
                    MoveHanoi(stackA, stackC);
//                    if (stackA.isEmpty()) {
//                        stackA.push(stackC.pop());
//                    } else if (stackC.isEmpty()) {
//                        stackC.push(stackA.pop());
//                    } else if (stackA.peek() < stackC.peek()) {
//                        stackC.push(stackA.pop());
//                    } else {
//                        stackA.push(stackC.pop());
//                    }
                    break;
                case 2:
                    MoveHanoi(stackA, stackB);
//                    if (stackA.isEmpty()) {
//                        stackA.push(stackB.pop());
//                    } else if (stackB.isEmpty()) {
//                        stackB.push(stackA.pop());
//                    } else if (stackA.peek() < stackB.peek()) {
//                        stackB.push(stackA.pop());
//                    } else {
//                        stackA.push(stackB.pop());
//                    }
                    break;
                case 0:
                    MoveHanoi(stackB, stackC);
//                    if (stackB.isEmpty()) {
//                        stackB.push(stackC.pop());
//                    } else if (stackC.isEmpty()) {
//                        stackC.push(stackB.pop());
//                    } else if (stackC.peek() < stackB.peek()) {
//                        stackB.push(stackC.pop());
//                    } else {
//                        stackC.push(stackB.pop());
//                    }
                    break;
            }
            totalMovimentosRealizados++;
            System.out.println("STACK A: " + stackA);
            System.out.println("STACK B: " + stackB);
            System.out.println("STACK C: " + stackC);
            System.out.println("MOV REALIZADOS: " + getTotalMovimentosRealizados()+"\n\n");
        }
    }

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