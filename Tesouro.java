import java.util.ArrayList;
import java.util.Random;

public class Tesouro {
    private String nome;
    private int linha;
    private int coluna;
    private int valor;

    public Tesouro(String nome, int linha, int coluna, int valor) {
        this.nome = nome;
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
    }

    // Getters
    public int getLinha() { return linha; }
    public int getColuna() { return coluna; }
    public int getValor() { return valor; }

    // Métodos utilitários estáticos
    public static void gerarTesourosComuns(int quantidade, int tam, ArrayList<ArrayList<Character>> mapa) {
        Random rand = new Random();
        int adicionados = 0;
        while (adicionados < quantidade) {
            int i = rand.nextInt(tam);
            int j = rand.nextInt(tam);
            if (mapa.get(i).get(j) == '.') {
                mapa.get(i).set(j, 'T');
                adicionados++;
            }
        }
    }

    public static void gerarTesourosRaros(int quantidade, int tam, ArrayList<ArrayList<Character>> mapa) {
        Random rand = new Random();
        int adicionados = 0;
        while (adicionados < quantidade) {
            int i = rand.nextInt(tam);
            int j = rand.nextInt(tam);
            if (mapa.get(i).get(j) == '.') {
                mapa.get(i).set(j, 'R');
                adicionados++;
            }
        }
    }
}
