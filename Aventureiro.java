import java.util.ArrayList;

public class Aventureiro {
    private String nome;
    private int linha;
    private int coluna;
    private int vida;
    private int objetivosAlcancados = 0;
    private int chaves = 0;
    private ArrayList<String> tesourosColetados = new ArrayList<>();

    public Aventureiro(String nome, int linhaInicial, int colunaInicial) {
        this.nome = nome;
        this.linha = linhaInicial;
        this.coluna = colunaInicial;
        this.vida = 100;
    }

    public String getNome() { return nome; }
    public int getLinha() { return linha; }
    public int getColuna() { return coluna; }
    public int getVida() { return vida; }
    public int getObjetivosAlcancados() { return objetivosAlcancados; }
    public int getChaves() { return chaves; }
    public ArrayList<String> getTesourosColetados() { return tesourosColetados; }

    public void setNome(String nome) { this.nome = nome; }
    public void setLinha(int linha) { this.linha = linha; }
    public void setColuna(int coluna) { this.coluna = coluna; }

    public void coletarTesouro() {
        tesourosColetados.add("comum");
        if (vida < 100) {
            int cura = Math.min(5, 100 - vida);
            vida += cura;
            System.out.println("💰 Tesouro coletado! +5 de vida. Total: " + tesourosColetados.size() + " | ❤️ Vida: " + vida);
        } else {
            System.out.println("💰 Tesouro coletado! Total: " + tesourosColetados.size() + " | ❤️ Vida já está cheia!");
        }
    }

    public void coletarTesouroRaro() {
        tesourosColetados.add("raro");
        if (vida < 100) {
            int cura = Math.min(50, 100 - vida);
            vida += cura;
            System.out.println("🌟 Tesouro RARO coletado! +50 de vida. Total raros: " + contarTesouros("raro") + " | ❤️ Vida: " + vida);
        } else {
            System.out.println("🌟 Tesouro RARO coletado! Total raros: " + contarTesouros("raro") + " | ❤️ Vida já está cheia!");
        }
    }

    public int contarTesouros(String tipo) {
        return (int) tesourosColetados.stream().filter(t -> t.equals(tipo)).count();
    }

    public void alcançarObjetivo() {
        objetivosAlcancados++;
        System.out.println("🎯 Objetivo alcançado! Total: " + objetivosAlcancados);
    }

    public void receberDano(int dano) {
        vida -= dano;
        System.out.println("⚠️ Perigo! Perdeu " + dano + " de vida. Vida atual: " + vida);
    }

    public boolean mover(String direcao, int maxTamanho) {
        switch (direcao.toLowerCase()) {
            case "cima":
                if (linha > 0) { linha--; return true; }
                System.out.println("Não pode ir mais para cima."); return false;
            case "baixo":
                if (linha < maxTamanho - 1) { linha++; return true; }
                System.out.println("Não pode ir mais para baixo."); return false;
            case "esquerda":
                if (coluna > 0) { coluna--; return true; }
                System.out.println("Não pode ir mais para a esquerda."); return false;
            case "direita":
                if (coluna < maxTamanho - 1) { coluna++; return true; }
                System.out.println("Não pode ir mais para a direita."); return false;
            default:
                System.out.println("Comando inválido.");
                return false;
        }
    }

    public void coletarChave() {
        chaves++;
        System.out.println("🗝️ Chave obtida! Total: " + chaves);
    }

    

    public boolean usarChave() {
        if (chaves > 0) {
            chaves--;
            System.out.println("🔓 Porta aberta com chave.");
            return true;
        } else {
            System.out.println("🚪 Porta trancada! Você precisa de uma chave.");
            return false;
        }
    }

    public void voltarPara(int linhaAntiga, int colunaAntiga) {
        this.linha = linhaAntiga;
        this.coluna = colunaAntiga;
    }
}
