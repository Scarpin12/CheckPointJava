package view;
import model.dao.FilmeDAO;
import model.vo.FilmeVo;

import java.util.List;
import java.util.Scanner;

public class MenuFilmes {

    private static FilmeDAO filmeDao = new FilmeDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    listarFilmesPorGenero("Terror");
                    break;
                case 2:
                    listarFilmesPorGenero("Comédia");
                    break;
                case 3:
                    listarFilmesPorGenero("Suspense");
                    break;
                case 4:
                    listarFilmesPorGenero("Ação");
                    break;
                case 5:
                    listarFilmesPorGenero("Romance");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        🎬 CATÁLOGO DE FILMES 🎬       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  [1] 👻 Terror                         ║");
        System.out.println("║  [2] 😂 Comédia                        ║");
        System.out.println("║  [3] 🔪 Suspense                       ║");
        System.out.println("║  [4] 💥 Ação                           ║");
        System.out.println("║  [5] 💕 Romance                        ║");
        System.out.println("║  [0] ❌ Sair                           ║");
        System.out.println("╚═════════════════════  ═══════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    private static void listarFilmesPorGenero(String genero) {
        System.out.println("\nFilmes do gênero: " + genero);
        List<FilmeVo> filmes = filmeDao.buscarPorGenero(genero);
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
        } else {
            for (FilmeVo filme : filmes) {
                System.out.println(filme.getTitulo() + " (" + filme.getAno() + ")");
            }
        }
    }
}
