package br.com.ifrn.ed.hanoi;

public class Main {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.gerarElementos(4);
        Hanoi.solve(hanoi.getStackA(), hanoi.getStackB(), hanoi.getStackC());

        System.out.println("A: " + hanoi.getStackA());
        System.out.println("B: " + hanoi.getStackB());
        System.out.println("C: " + hanoi.getStackC());
    }
}
