import java.util.ArrayList;

public class Cacador {
    private int linha;
    private int coluna;
    private char ultimoCaractere = '.'; // Para restaurar caso pise em perigo

    public Cacador(int linhaInicial, int colunaInicial) {
        this.linha = linhaInicial;
        this.coluna = colunaInicial;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void mover(int linhaHeroi, int colunaHeroi, int maxTamanho, ArrayList<ArrayList<Character>> mapa) {
        int deltaLinha = Integer.compare(linhaHeroi, linha);
        int deltaColuna = Integer.compare(colunaHeroi, coluna);

        int novaLinha = linha + deltaLinha;
        int novaColuna = coluna;

        if (!posicaoValida(novaLinha, novaColuna, maxTamanho, mapa)) {
            novaLinha = linha;
            novaColuna = coluna + deltaColuna;
        }

        if (posicaoValida(novaLinha, novaColuna, maxTamanho, mapa)) {
            // Restaura a célula anterior
            mapa.get(linha).set(coluna, ultimoCaractere);

            // Guarda o que está na nova posição
            ultimoCaractere = mapa.get(novaLinha).get(novaColuna);

            // Atualiza a posição do caçador
            linha = novaLinha;
            coluna = novaColuna;
            mapa.get(linha).set(coluna, 'C');
        }
    }

    private boolean posicaoValida(int linha, int coluna, int max, ArrayList<ArrayList<Character>> mapa) {
        if (linha < 0 || linha >= max || coluna < 0 || coluna >= max) return false;
        char c = mapa.get(linha).get(coluna);
        return (c == '.' || c == 'P' || c == 'A');
    }
}
