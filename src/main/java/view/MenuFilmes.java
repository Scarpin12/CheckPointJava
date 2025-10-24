package view;

import controller.FilmeController;
import model.vo.FilmeResumoVo;
import model.vo.FilmeVo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuFilmes {

    private static FilmeController controller = new FilmeController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        buscarPorCategoria("Terror", "halloween");
                        break;
                    case 2:
                        buscarPorCategoria("Comédia", "hangover");
                        break;
                    case 3:
                        buscarPorCategoria("Suspense", "silence");
                        break;
                    case 4:
                        buscarPorCategoria("Ação", "avengers");
                        break;
                    case 5:
                        buscarPorCategoria("Romance", "notebook");
                        break;
                    case 0:
                        System.out.println("\n👋 Encerrando...");
                        break;
                    default:
                        System.out.println("\n❌ Opção inválida!");
                }
            } catch (IOException e) {
                System.err.println("Erro ao buscar filmes: " + e.getMessage());
            }
        } while (opcao != 0);
    }



        private static void exibirMenuPrincipal () {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║        🎬 CATÁLOGO DE FILMES 🎬       ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║  [1] 👻 Terror                         ║");
            System.out.println("║  [2] 😂 Comédia                        ║");
            System.out.println("║  [3] 🔪 Suspense                       ║");
            System.out.println("║  [4] 💥 Ação                           ║");
            System.out.println("║  [5] 💕 Romance                        ║");
            System.out.println("║  [0] ❌ Sair                           ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
        }

        private static void buscarPorCategoria (String termoBusca, String nomeCategoria) throws IOException {
            System.out.println("\n🔍 Buscando e sincronizando " + nomeCategoria + "...\n");

            List<FilmeResumoVo> filmes = controller.buscarFilmes(termoBusca);

            if (filmes.isEmpty()) {
                System.out.println("❌ Nenhum filme encontrado.");
                return;
            }

            System.out.println("\n📋 Filmes encontrados:\n");
            for (int i = 0; i < filmes.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + filmes.get(i).getTitle() + " (" + filmes.get(i).getYear() + ")");
            }

            System.out.print("\nEscolha um filme (0 para voltar): ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha > 0 && escolha <= filmes.size()) {
                exibirDetalhesFilme(filmes.get(escolha - 1).getImdbID());
            }
        }

        private static void exibirDetalhesFilme (String imdbId) throws IOException {
            System.out.println("\n📽️  Carregando detalhes...\n");

            FilmeVo filme = controller.buscarDetalhes(imdbId);

            System.out.println("═══════════════════════════════════════════════════");
            System.out.println(filme);
            System.out.println("═══════════════════════════════════════════════════");

            System.out.print("\nPressione ENTER para voltar...");
            scanner.nextLine();
        }
    }
