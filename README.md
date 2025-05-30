# *A Lenda do Labirinto Assombrado*
Boas-vindas, aventureiro! Prepare-se para mergulhar em um labirinto místico, onde cada passo pode significar a glória ou o fim de sua jornada. "A Lenda do Labirinto Assombrado" é um jogo de exploração baseado em texto, com elementos de estratégia e sobrevivência, desenvolvido em Java. Seu objetivo é navegar por um labirinto gerado proceduralmente, alcançar templos sagrados, coletar tesouros e, o mais importante, sobreviver à perseguição implacável do Caçador.

### 📜 *História*
Em um mundo onde os labirintos respiram e as paredes observam, um aventureiro solitário desperta em meio à névoa. Por trás de cada sombra, espreita um ser chamado Caçador. Dizem que ele já foi como você, mas o labirinto o enlouqueceu. Ele se camufla entre os perigos, assumindo sua forma quando a escuridão cai. Sua sanidade foi capturada por esse monstro e aprisionada nas profundezas do labirinto.

O objetivo do herói é alcançar os "X", Templos Sagrados que selam o poder do labirinto. Não por glória, não por ouro, mas para encerrar uma maldição antiga e libertar não apenas a si, mas também o próprio Caçador, que ainda guarda vestígios de humanidade. Mas cuidado... O Caçador se disfarça entre os perigos. À noite, ele se mistura com as armadilhas e aguarda em silêncio. Cada passo é uma decisão. Cada perigo, um teste. E no final... só um pode vencer.

### ✨ *Funcionalidades do Jogo*
O jogo oferece uma experiência dinâmica com diversas mecânicas:

**Labirinto Gerado Aleatoriamente:** A cada nova partida, um labirinto único é criado, garantindo rejogabilidade.

**Múltiplos Níveis de Dificuldade:** Escolha entre Fácil, Médio e Difícil, que ajustam o número de objetivos a serem alcançados e a quantidade de Caçadores no labirinto.

**Sistema de Vida e Pontuação:** Monitore sua vida e pontuação em tempo real, que aumentam ou diminuem conforme suas ações no labirinto.

**Coleta de Itens:**
**Tesouros Comuns (T):** Concedem +5 pontos e recuperam 5 de vida.

**Tesouros Raros (R):** Concedem +50 pontos e recuperam 50 de vida, sendo cruciais para sua sobrevivência.

**Chaves (K):** Permitem abrir portas trancadas, concedendo +30 pontos ao serem coletadas e +100 pontos ao serem usadas para abrir uma porta.

**Perigos (P):** Armadilhas que causam -10 pontos e 10 de dano à sua vida. Cuidado, o Caçador pode se disfarçar como um perigo

**Objetivos (X):** Locais a serem alcançados para progredir no jogo. A quantidade de objetivos necessários varia com a dificuldade.

**Portas (#):** Barreiras que exigem uma chave para serem abertas.

**Caçador (C):** Um inimigo que persegue o jogador, se misturando com os perigos. Se ele o alcançar, o jogo termina.

**Modo "Mundo Invertido":** Uma funcionalidade secreta ativada por um comando específico (mudar), que inverte a natureza dos tesouros e perigos, e altera os comandos de movimento. Cuidado: o caçador no mundo invertido é imprevisível.

**Ranking de Pontuações:** Suas pontuações são salvas em arquivos de ranking específicos para cada dificuldade, permitindo que você compare seu desempenho com outros jogadores.

**Tela de "Game Over":** Ao perder toda a vida ou ser alcançado pelo Caçador, uma imagem temática de "Game Over" é exibida para imersão (Certifique-se de ter o arquivo you died dark souls.jpg na raiz do projeto).

## *🎮 Como Jogar*
### *Menu Principal:*
**Início:** Ao executar o jogo, você será recebido com uma introdução narrativa e um menu principal.

**1. Jogar:** Inicia uma nova partida. Você poderá escolher a dificuldade e inserir seu nome de jogador.

**2. Instruções:** Exibe as regras do jogo e a legenda dos símbolos do labirinto (veja abaixo).

**3. Ranking:** Permite visualizar as pontuações dos jogadores para cada nível de dificuldade.

**4. Sair:** Encerra o jogo.

## *Movimentação:*
Durante o jogo, você verá o labirinto e seu HUD (indicadores de vida, objetivos, pontuação, etc.). Para se mover, digite:

**w para cima**

**s para baixo**

**a para esquerda**

**d para direita**

**Atenção:** No "Mundo Invertido", esses comandos são invertidos! (ex: w move para baixo, s move para cima, etc.)

**Coleta de Itens:** Simplesmente mova-se para a célula de um item para coletá-lo ou interagir com ele.

**Vitória:** Alcance o número de objetivos necessários para a dificuldade escolhida.

**Derrota:** Sua vida chega a zero ou o Caçador o alcança.

**Legenda do Labirinto no Console:** O jogo utiliza códigos de escape ANSI para exibir o labirinto com cores e formatação no terminal. Para uma visualização correta das cores, é necessário que o terminal (ou console) onde o jogo é executado tenha suporte a ANSI. Em alguns ambientes (como visores de texto simples ou ao colar a saída diretamente em plataformas como GitHub sem tratamento), você pode ver caracteres "estranhos" ou a falta de formatação.

**Aqui está a legenda dos símbolos como eles são exibidos no jogo (com as cores que você verá em um terminal compatível):**
**'A'** = Aventureiro (Azul)

**'T'** = Tesouro Comum (Verde)

**'P'** = Perigo (Vermelho)

**'X'** = Objetivo (Amarelo)

**'R'** = Tesouro Raro (Roxo)

**'K'** = Chave (Ciano)

**'C'** = Caçador (Branco)

**'#'** Porta (Cor Padrão do Terminal)

**'.'** = Caminho Livre (Cor Padrão do Terminal)

## ⚙️ *Lógica de Programação e Estrutura do Código*
O jogo foi estruturado com base nos princípios da Programação Orientada a Objetos (POO) em Java. Essa abordagem permitiu uma modularização clara do código, separando responsabilidades entre as entidades do jogo, o que facilita a manutenção, a escalabilidade e a compreensão de cada componente individualmente.

### *Main.java*
Esta é a classe principal que orquestra todo o jogo, agindo como o controlador central da aplicação. Ela contém o método main, que é o ponto de entrada.

**Gerenciamento do Fluxo do Jogo:** Controla o ciclo de vida do jogo, desde a exibição do menu inicial até a gestão da partida, incluindo a entrada do jogador, a atualização do estado do jogo e a verificação das condições de vitória/derrota.
**Interface do Usuário (HUD):** É responsável por exibir o labirinto e o Head-Up Display (HUD), que fornece informações cruciais sobre o estado do jogador (vida, objetivos, pontuação, chaves). O uso de códigos ANSI para colorir o labirinto demonstra um cuidado com a experiência visual, mesmo em um ambiente de console.

**Lógica de Dificuldade:** Define dinamicamente a quantidade de objetivos e caçadores com base na escolha de dificuldade do jogador, ajustando a complexidade do jogo.

**Sistema de Pontuação e Ranking:** Calcula e atualiza a pontuação em tempo real, com base nas interações do jogador. Além disso, gerencia a persistência dos dados do ranking, salvando as pontuações em arquivos de texto (ranking_facil.txt, ranking_medio.txt, ranking_dificil.txt) e permitindo a visualização ordenada das pontuações.

**"Mundo Invertido":** Implementa a lógica para o modo secreto, alterando as regras de interação com tesouros/perigos e invertendo os comandos de movimento, adicionando uma camada extra de desafio e surpresa.

**Integração com o Sistema Operacional:** A função abrirImagem demonstra a capacidade de interagir com o ambiente externo (sistema de arquivos do sistema operacional) para exibir recursos visuais.

**Aventureiro.java:** Esta classe representa o jogador, encapsulando todo o seu estado e comportamento no labirinto.

### *Atributos Fundamentais:*
**nome:** Identificação do jogador.

**linha, coluna:** Coordenadas atuais do aventureiro, representando sua posição no mapa.

**vida:** Pontos de vida do aventureiro, um atributo crucial para a sobrevivência.

**objetivosAlcancados:** Contador dos objetivos completados, rastreando o progresso do jogador.

**chaves:** Contagem de chaves coletadas, necessárias para interagir com portas.

**tesourosColetados:** Uma lista para registrar os tipos de tesouros coletados, impactando a pontuação e a recuperação de vida.

### *Métodos de Interação e Modificação de Estado:*

**mover(String direcao, int maxTamanho):** Permite ao aventureiro se deslocar pelo labirinto, com validação de limites.

**coletarTesouro() / coletarTesouroRaro():** Métodos que modelam a ação de coletar itens, aplicando os bônus de vida e pontuação.

**receberDano(int dano):** Lida com a perda de vida do aventureiro, um aspecto central da mecânica de sobrevivência.

**alcançarObjetivo():** Atualiza o progresso do jogador ao atingir um objetivo.

**coletarChave() e usarChave():** Gerenciam o inventário de chaves e a interação com portas.

**voltarPara(int linhaAntiga, int colunaAntiga):** Permite o retrocesso em caso de ações bloqueadas (como portas sem chave), um detalhe importante para a jogabilidade.

**Encapsulamento:** Todos os atributos são privados, e o acesso e modificação são feitos através de métodos getter e setter, garantindo o controle sobre o estado do objeto Aventureiro.

**Labirinto.java:** Esta classe é responsável pela geração procedural e pela representação da estrutura do labirinto, atuando como o "mundo" do jogo.

**Constantes de Configuração:** Define o tamanho do labirinto (TAM) e a quantidade inicial de cada tipo de elemento (objetivos, tesouros, perigos, chaves, portas), permitindo fácil ajuste dos parâmetros do jogo.

**Estrutura de Dados do Labirinto:** Utiliza um ArrayList de ArrayList de Character (estrutura) para representar o mapa 2D do labirinto, onde cada caractere simboliza um elemento específico (ex: 'A' para aventureiro, '.' para espaço vazio). Essa escolha de estrutura permite a manipulação dinâmica do mapa.

### *Geração Procedural de Elementos:*
Métodos como gerarLabirinto(), adicionarObjetivos(), adicionarTesouros(), etc., utilizam a classe Random para posicionar os elementos de forma aleatória, garantindo que cada partida seja única. A lógica de verificação de células vazias antes de posicionar elementos garante a integridade do mapa.

**Renderização do Labirinto:** O método imprimirLabirinto() é crucial para a interface textual, exibindo o estado atual do labirinto com a ajuda de códigos de cor ANSI, melhorando a clareza e a imersão. É importante notar que a renderização colorida depende do suporte a códigos ANSI do terminal onde o jogo é executado.

**Isolamento da Lógica do Mapa:** O Labirinto concentra toda a lógica de criação e manipulação da estrutura do mapa, abstraindo esses detalhes das outras classes.

**Cacador.java:** representa o antagonista do jogo, o Caçador, e sua inteligência artificial de perseguição.

### *Atributos de Estado:*
**linha, coluna:** Posição atual do Caçador.

**ultimoCaractere:** Um atributo-chave para simular a camuflagem do Caçador. Ele armazena o caractere original da célula antes de o Caçador se mover para ela, permitindo que a célula seja restaurada quando ele se afasta, criando a ilusão de que ele se "mistura" com o ambiente.

**Lógica de Movimento Autônomo (mover):** Este método implementa um algoritmo simples de perseguição. O Caçador tenta se mover em direção ao aventureiro (priorizando a linha e depois a coluna), mas com validações para evitar colisões com paredes ou outros elementos que não podem ser ocupados.

**Interação com o Mapa:** O Caçador modifica diretamente a estrutura do mapa (passado por parâmetro) para atualizar sua própria posição e restaurar o caractere anterior, demonstrando como diferentes objetos podem colaborar e modificar um estado compartilhado.

**Tesouro.java e Perigo.java**: Estas classes representam os elementos interativos do labirinto.

**Modelagem de Entidades:** Ambas as classes modelam entidades simples do jogo, encapsulando seus atributos (linha, coluna, valor/dano).

**Métodos Estáticos de Geração:** A decisão de usar métodos estáticos (gerarTesourosComuns, gerarTesourosRaros, gerarPerigos) para adicionar esses elementos ao mapa na classe Main é uma escolha de design que centraliza a lógica de preenchimento do labirinto. Isso indica que a responsabilidade de criar e posicionar esses elementos não é de instâncias individuais de Tesouro ou Perigo, mas sim uma função utilitária global para o processo de geração do labirinto.
