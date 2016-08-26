package br.com.ifrn.ed.hanoi;

public class Main {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.gerarElementos(15);        
        hanoi.Resolver();
    }
}
