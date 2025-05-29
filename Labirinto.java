import java.util.ArrayList;
import java.util.Random;

public class Labirinto {
    private final int TAM = 30;
    private final int N_OBJETIVOS = 3;
    private final int N_TESOUROS = 50;
    private final int N_PERIGOS = 100;
    private final int N_TESOUROS_RAROS = 5;
    private final int N_CHAVES = 5;
    private final int N_PORTAS = 15;

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    private ArrayList<ArrayList<Character>> estrutura;
    private ArrayList<Tesouro> tesouros;
    private ArrayList<Perigo> perigos;
    private Random random;

    public Labirinto() {
        estrutura = new ArrayList<>();
        tesouros = new ArrayList<>();
        perigos = new ArrayList<>();
        random = new Random();
        gerarLabirinto();
        posicionarAventureiro(0, 0);
        adicionarObjetivos();
        adicionarTesouros();
        adicionarTesourosRaros();
        adicionarPerigos();
        adicionarChaves();
        adicionarPortas();
    }

    private void gerarLabirinto() {
        for (int i = 0; i < TAM; i++) {
            ArrayList<Character> linha = new ArrayList<>();
            for (int j = 0; j < TAM; j++) {
                linha.add('.');
            }
            estrutura.add(linha);
        }
    }

    private void posicionarAventureiro(int linha, int coluna) {
        estrutura.get(linha).set(coluna, 'A');
    }

    private void adicionarObjetivos() {
        int adicionados = 0;
        while (adicionados < N_OBJETIVOS) {
            int l = random.nextInt(TAM);
            int c = random.nextInt(TAM);
            if (estrutura.get(l).get(c) == '.') {
                estrutura.get(l).set(c, 'X');
                adicionados++;
            }
        }
    }

    private void adicionarTesouro(int linha, int coluna) {
        estrutura.get(linha).set(coluna, 'T');
        tesouros.add(new Tesouro("Tesouro comum", linha, coluna, 5));
    }

    private void adicionarTesouros() {
        int adicionados = 0;
        while (adicionados < N_TESOUROS) {
            int l = random.nextInt(TAM);
            int c = random.nextInt(TAM);
            if (estrutura.get(l).get(c) == '.') {
                adicionarTesouro(l, c);
                adicionados++;
            }
        }
    }

    private void adicionarTesourosRaros() {
        int adicionados = 0;
        while (adicionados < N_TESOUROS_RAROS) {
            int l = random.nextInt(TAM);
            int c = random.nextInt(TAM);
            if (estrutura.get(l).get(c) == '.') {
                estrutura.get(l).set(c, 'R');
                tesouros.add(new Tesouro("Tesouro raro", l, c, 50));
                adicionados++;
            }
        }
    }

    private void adicionarPerigos() {
        int adicionados = 0;
        while (adicionados < N_PERIGOS) {
            int l = random.nextInt(TAM);
            int c = random.nextInt(TAM);
            if (estrutura.get(l).get(c) == '.') {
                estrutura.get(l).set(c, 'P');
                Perigo perigo = new Perigo(l, c); // dano default dentro da classe
                perigos.add(perigo);
                adicionados++;
            }
        }
    }

    private void adicionarChaves() {
        int adicionados = 0;
        while (adicionados < N_CHAVES) {
            int l = random.nextInt(TAM);
            int c = random.nextInt(TAM);
            if (estrutura.get(l).get(c) == '.') {
                estrutura.get(l).set(c, 'K');
                adicionados++;
            }
        }
    }

   

    private void adicionarPortas() {
        int adicionados = 0;
        while (adicionados < N_PORTAS) {
            int l = random.nextInt(TAM);
            int c = random.nextInt(TAM);
            if (estrutura.get(l).get(c) == '.') {
                estrutura.get(l).set(c, '#');
                adicionados++;
            }
        }
    }

    public void atualizarPosicaoAventureiro(int linhaAntiga, int colunaAntiga, int novaLinha, int novaColuna) {
        estrutura.get(linhaAntiga).set(colunaAntiga, '.');
        estrutura.get(novaLinha).set(novaColuna, 'A');
    }

    public void imprimirLabirinto() {
        System.out.println("Legenda: "
            + RED + "P=Perigo" + RESET + " "
            + GREEN + "T=Tesouro" + RESET + " "
            + BLUE + "A=Aventureiro" + RESET + " "
            + YELLOW + "X=Objetivo" + RESET + " "
            + PURPLE + "R=Raro" + RESET + " "
            + CYAN + "K=Chave" + RESET + " "
            + WHITE + "C=Caçador" + RESET + " "
            + "#=Porta");

        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                char c = estrutura.get(i).get(j);
                switch (c) {
                    case 'A': System.out.print(BLUE + "A " + RESET); break;
                    case 'T': System.out.print(GREEN + "T " + RESET); break;
                    case 'P': System.out.print(RED + "P " + RESET); break;
                    case 'X': System.out.print(YELLOW + "X " + RESET); break;
                    case 'R': System.out.print(PURPLE + "R " + RESET); break;
                    case 'K': System.out.print(CYAN + "K " + RESET); break;
                    case 'C': System.out.print(WHITE + "C " + RESET); break;
                    case '#': System.out.print("# "); break;
                    default: System.out.print(". "); break;
                }
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Character>> getEstrutura() {
        return estrutura;
    }

    public int getTAM() { return TAM; }
    public ArrayList<Tesouro> getTesouros() { return tesouros; }
    public ArrayList<Perigo> getPerigos() { return perigos; }
}
