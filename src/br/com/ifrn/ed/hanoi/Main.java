package br.com.ifrn.ed.hanoi;

public class Main {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.gerarElementos(4);        
        hanoi.solve();        
    }
}
