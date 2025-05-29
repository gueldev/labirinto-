import java.util.ArrayList;
import java.util.Random;

public class Perigo {
    private int linha;
    private int coluna;
    private int dano = 10;

    public Perigo(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getDano() {
        return dano;
    }

    public void aplicarDano(Aventureiro player) {
         player.receberDano(dano);
        if (player.getVida() <= 0) {
            System.out.println("☠️ Você morreu! Fim do jogo.");
            System.out.println("Jogo encerrado automaticamente pelo Perigo.");
            System.exit(0);
        }
    }

    public static void gerarPerigos(int quantidade, int tam, ArrayList<ArrayList<Character>> mapa) {
        Random rand = new Random();
        int adicionados = 0;
        while (adicionados < quantidade) {
            int i = rand.nextInt(tam);
            int j = rand.nextInt(tam);
            if (mapa.get(i).get(j) == '.') {
                mapa.get(i).set(j, 'P');
                adicionados++;
            }
        }
    }
}
