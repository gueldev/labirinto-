import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    A LENDA DO LABIRINTO ASSOMBRADO                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("🌒 Em um mundo onde os labirintos respiram e as paredes observam...");
        System.out.println("Um aventureiro solitário desperta em meio à névoa.");
        System.out.println();
        System.out.println("💀 Por trás de cada sombra, espreita um ser chamado Caçador...");
        System.out.println("Dizem que ele já foi como você, mas o labirinto o enlouqueceu.");
        System.out.println("Ele se camufla entre os perigos, assumindo sua forma quando a escuridão cai.");
        System.out.println();
        System.out.println("🔒 Sua sanidade foi capturada por esse monstro e aprisionada nas profundezas do labirinto.");
        System.out.println();
        System.out.println("🗝️ O objetivo do herói? Alcançar o 'X'. Templos Sagrados que selam o poder do labirinto.");
        System.out.println("Não por glória. Não por ouro.");
        System.out.println("Mas para encerrar uma maldição antiga... E libertar não apenas a si.");
        System.out.println("mas também o próprio Caçador, que ainda guarda vestígios de humanidade.");
        System.out.println();
        System.out.println("👁️ Mas cuidado... O Caçador se disfarça entre os perigos.");
        System.out.println("   À noite, ele se mistura com as armadilhas e aguarda em silêncio.");
        System.out.println();
        System.out.println("⚔️ Cada passo é uma decisão. Cada perigo, um teste.");
        System.out.println("E no final... só um pode vencer.");
        System.out.println();
        System.out.println("Pressione enter para continuar...");
        new java.util.Scanner(System.in).nextLine();  



        while (true) {
            System.out.println("=== LABIRINTO DE AVENTURA ===");
            System.out.println("1. Jogar");
            System.out.println("2. Instruções");
            System.out.println("3. Ranking");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": iniciarJogo(scanner); break;
                case "2": exibirInstrucoes(); break;
                case "3": exibirRanking(); break;
                case "4": System.out.println("\uD83D\uDC4B Até a próxima!"); return;
                default: System.out.println("Opção inválida.\n");
            }
        }
    }

    private static void exibirInstrucoes() {
        System.out.println("\n INSTRUÇÕES:");
        System.out.println("- Explore o labirinto e colete itens:");
        System.out.println("  T (Tesouro) = +5 pontos e cura 5 de vida");
        System.out.println("  R (Tesouro Raro) = +50 pontos e cura 50 de vida");
        System.out.println("  K (Chave) = +30 pontos");
        System.out.println("  # (Porta) = +100 pontos (se aberta com chave)");
        System.out.println("  P (Perigo) = -10 pontos e perde 10 de vida");
        System.out.println("  . (Espaço vazio) = +1 ponto (somente na primeira visita)");
        System.out.println("- Pontuação aparece em tempo real.");
        System.out.println("- Seu nome e pontuação serão salvos no ranking.");
        System.out.println("- Um caçador misterioso vaga pelo labirinto. Evite-o a todo custo.\n");
    }

    private static void exibirRanking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n📊 Escolha a dificuldade do ranking que deseja ver:");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        System.out.print("Digite sua opção: ");
        String opcao = scanner.nextLine();

        String nomeArquivo = switch (opcao) {
            case "2" -> "ranking_medio.txt";
            case "3" -> "ranking_dificil.txt";
            case "1" -> "ranking_facil.txt";
            default -> {
                System.out.println("Opção inválida.");
                yield null;
            }
        };

        if (nomeArquivo == null) return;

        System.out.println("\n📋 RANKING (" + nomeArquivo.replace("ranking_", "").replace(".txt", "") + "):");
        try {
            File file = new File(nomeArquivo);
            if (!file.exists()) {
                System.out.println("Ainda não há jogadores no ranking.");
                return;
            }
            Scanner leitor = new Scanner(file);
            List<String> linhas = new ArrayList<>();
            while (leitor.hasNextLine()) linhas.add(leitor.nextLine());
            leitor.close();

            linhas.sort((a, b) -> Integer.compare(extrairPontos(b), extrairPontos(a)));
            linhas.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Erro ao ler o ranking.");
        }
        System.out.println();
    }

    private static int extrairPontos(String linha) {
        try {
            return Integer.parseInt(linha.split(" - ")[1].replace(" pontos", "").trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private static void iniciarJogo(Scanner scanner) {
        int objetivosNecessarios;
        boolean mundoInvertidoAtivo = false;

        System.out.println("\nEscolha a dificuldade:");
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Difícil");
        System.out.print("Digite sua opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        String dificuldade = switch (opcao) {
            case 2 -> "medio";
            case 3 -> "dificil";
            case 1 -> "facil";
            default -> {
                System.out.println("Opção inválida. Usando fácil por padrão.");
                yield "facil";
            }
        };

        objetivosNecessarios = switch (dificuldade) {
            case "medio" -> 2;
            case "dificil" -> 3;
            default -> 1;
        };


        System.out.print("Digite seu nome de jogador: ");
        String nomeJogador = scanner.nextLine();

        Labirinto labirinto = new Labirinto(); // Garanta que a classe Labirinto esteja no seu projeto
        Aventureiro player = new Aventureiro(nomeJogador, 0, 0); // Garanta que a classe Aventureiro esteja no seu projeto
        int pontuacao = 0;

        ArrayList<ArrayList<Character>> mapa = labirinto.getEstrutura();
        int tam = labirinto.getTAM();

        Tesouro.gerarTesourosComuns(100, tam, mapa); // Garanta que a classe Tesouro esteja no seu projeto
        Tesouro.gerarTesourosRaros(5, tam, mapa);
        Perigo.gerarPerigos(300, tam, mapa); // Garanta que a classe Perigo esteja no seu projeto

        List<Cacador> cacadores = new ArrayList<>(); // Garanta que a classe Cacador esteja no seu projeto
        int quantidadeCacadores = switch (dificuldade) {
            case "medio" -> 2;
            case "dificil" -> 3;
            default -> 1;
        };
        Random rand = new Random();
        while (cacadores.size() < quantidadeCacadores) {
            int l = rand.nextInt(tam), c = rand.nextInt(tam);
            if ((l != 0 || c != 0) && mapa.get(l).get(c) == '.') {
                mapa.get(l).set(c, 'C');
                cacadores.add(new Cacador(l, c));
            }
        }

        boolean[][] pontosColetados = new boolean[tam][tam];

        while (true) {
            labirinto.imprimirLabirinto();
            System.out.printf("\n======= HUD =======\n Jogador: %s\n Vida: %d\n Objetivos: %d/%d\n Pontuação: %d\n Tesouros comuns: %d\n Tesouros raros: %d\n Chaves: %d\n====================\n",
                nomeJogador, player.getVida(), player.getObjetivosAlcancados(), objetivosNecessarios,
                pontuacao, player.contarTesouros("comum"), player.contarTesouros("raro"), player.getChaves());

            System.out.print("Mover (w/a/s/d ): ");
            String comando = scanner.nextLine().toLowerCase();

            if (comando.equals("sair")) break;

            if (comando.equals("mundo invertido") && !mundoInvertidoAtivo) {
                System.out.println("🌪️ Algo no ar mudou... o mundo parece... diferente.");
                mundoInvertidoAtivo = true;
                for (int i = 0; i < tam; i++)
                    for (int j = 0; j < tam; j++) {
                        if (mapa.get(i).get(j) == 'T') mapa.get(i).set(j, 'P');
                        else if (mapa.get(i).get(j) == 'P') mapa.get(i).set(j, 'T');
                    }
                continue;
            }

            String direcao = switch (comando) {
                case "w" -> mundoInvertidoAtivo ? "baixo" : "cima";
                case "s" -> mundoInvertidoAtivo ? "cima" : "baixo";
                case "a" -> mundoInvertidoAtivo ? "direita" : "esquerda";
                case "d" -> mundoInvertidoAtivo ? "esquerda" : "direita";
                default -> {
                    System.out.println("Comando inválido.");
                    yield null;
                }
            };

            if (direcao == null) continue;


            int linhaAntes = player.getLinha();
            int colunaAntes = player.getColuna();

            if (!player.mover(direcao, tam)) continue;

            int novaLinha = player.getLinha();
            int novaColuna = player.getColuna();
            char celula = mapa.get(novaLinha).get(novaColuna);

            if (!pontosColetados[novaLinha][novaColuna]) {
                switch (celula) {
                    case '.' -> pontuacao++;
                    case 'T' -> {
                        if (mundoInvertidoAtivo) { player.receberDano(10); pontuacao -= 10; }
                        else { player.coletarTesouro(); pontuacao += 5; }
                    }
                    case 'P' -> {
                        if (mundoInvertidoAtivo) {
                            player.coletarTesouro();
                            pontuacao += 5;
                        } else {
                            Perigo perigo = new Perigo(novaLinha, novaColuna);
                            perigo.aplicarDano(player);
                            pontuacao -= perigo.getDano();
                            if (player.getVida() <= 0) {
                                System.out.println(" Você morreu devido ao dano! Fim do jogo.");
                                // Substituindo a imagem pela mensagem estilizada
                                exibirYouDied(); 
                                salvarPontuacao(nomeJogador, pontuacao, dificuldade);
                                return;
                            }
                        }
                    }

                    case 'R' -> { player.coletarTesouroRaro(); pontuacao += 50; }
                    case 'K' -> { player.coletarChave(); pontuacao += 30; }
                    case 'X' -> {
                        player.alcançarObjetivo();
                        if (player.getObjetivosAlcancados() >= objetivosNecessarios) {
                            System.out.println(" Parabéns! Você concluiu o objetivo da fase " + dificuldade + "!");
                            salvarPontuacao(nomeJogador, pontuacao, dificuldade);
                            return;
                        }
                    }
                }
                pontosColetados[novaLinha][novaColuna] = true;
            }

            if (celula == '#') {
                if (player.usarChave()) {
                    if (!pontosColetados[novaLinha][novaColuna]) pontuacao += 100;
                    pontosColetados[novaLinha][novaColuna] = true;
                } else {
                    player.voltarPara(linhaAntes, colunaAntes);
                    continue;
                }
            }
            labirinto.atualizarPosicaoAventureiro(linhaAntes, colunaAntes, novaLinha, novaColuna);

            for (Cacador cacador : cacadores) {
                cacador.mover(player.getLinha(), player.getColuna(), tam, mapa);
                if (cacador.getLinha() == player.getLinha() && cacador.getColuna() == player.getColuna()) {
                    if (mundoInvertidoAtivo) {
                        System.out.println(" O caçador olhou nos seus olhos... e sorriu.");
                        System.out.println(" Você foi libertado do mundo invertido.");
                        System.out.println("Parabéns, você desbloqueou um modo de vitória que nem os programadores do jogo sabiam!");
                    } else {
                        System.out.println(" Um caçador alcançou você! Fim do jogo.");
                        // Substituindo a imagem pela mensagem estilizada
                        exibirYouDied();
                    }
                    salvarPontuacao(nomeJogador, pontuacao, dificuldade);
                    return;
                }
            }

           
        }
    }

    private static void salvarPontuacao(String nome, int pontos, String dificuldade) {
        try (FileWriter fw = new FileWriter("ranking_" + dificuldade + ".txt", true)) {
            fw.write(nome + " - " + pontos + " pontos\n");
            System.out.println(" Pontuação salva no ranking (" + dificuldade + ").");
        } catch (IOException e) {
            System.out.println("Erro ao salvar no ranking.");
        }
        System.out.println("Jogo encerrado.\n");
    }

    // Método para exibir a mensagem "YOU DIED" estilizada
    private static void exibirYouDied() {
        System.out.println("\n");
        final String RED = "\u001B[31m";
final String RESET = "\u001B[0m";

        System.out.println("\n\n\n");
        System.out.println(RED + "██    ██  ██████  ██    ██     ██████╗ ██╗███████╗██████╗  " + RESET);
        System.out.println(RED + " ██  ██  ██    ██ ██    ██     ██╔══██╗██║██╔════╝██╔══██╗" + RESET);
        System.out.println(RED + "  ████   ██    ██ ██    ██     ██║  ██║██║█████╗  ██║  ██║ " + RESET);
        System.out.println(RED + "   ██    ██    ██ ██    ██     ██║  ██║██║██╔══╝  ██║  ██║" + RESET);
        System.out.println(RED + "   ██     ██████   ██████      ██████╔╝██║███████╗██████╔╝" + RESET);
        System.out.println("\n   \n");
        System.out.println("☠️  O Caçador te alcançou nas sombras do labirinto...");
        System.out.println("🌒 Sua jornada termina aqui.");
        System.out.println("💀 Mas a maldição... permanece.\n");

        System.out.println("\n");
        System.out.println("        ...e a escuridão te consumiu.");
        System.out.println("        Seu fim era inevitável neste labirinto cruel.");
        System.out.println("        Tente novamente, se tiver coragem.");
        System.out.println("\n");
    }

    // O método abrirImagem não é mais necessário, mas o mantive caso queira para outros fins.
    public static void abrirImagem(String caminho) {
        try {
            File imagem = new File(caminho);
            if (imagem.exists()) {
                java.awt.Desktop.getDesktop().open(imagem);
            } else {
                System.out.println("Imagem não encontrada: " + caminho);
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir a imagem: " + e.getMessage());
        }
    }

}