import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleApp {

	private static String nomJeux1 = "Jeu de la vie";

	public static void main(String[] args) throws IOException {

		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputStreamReader);

		String inputGameName;
		System.out.println("Quel nombre de colonnes désirez-vous?");
		int colums = sizer();
		System.out.println("Quel nombre de lignes désirez-vous?");
		int rows = sizer();
		GridJeuVieTorique plateau = new GridJeuVieTorique(rows, colums);
		do {
			menuPrinter();
			inputGameName = br.readLine();

			switch (inputGameName) {
			case ("a"):
				int gameMode = jdvHandler();
				if (gameMode == 0) {
					String cpc; // CANARD PC \o/
					do {
						plateau.update();
						System.out.println(plateau.stateAsString());
						System.out.println("Voulez-vous quitter ? (o)");
						cpc = br.readLine();
					} while (!Objects.equals(cpc, "o"));
				} else if (gameMode > 0) {
					for (int multipleruns = 1; multipleruns < gameMode; multipleruns++) {
						plateau.update();
					}
				}
				break;
			default:
				break;

			}

		} while (!Objects.equals(inputGameName, "q"));
	}

	private static int jdvHandler() throws IOException {
		String gameMode;
		Integer numberOfIteration;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Veuillez choir un mode de jeu");
			System.out.println("\t1 - Pas à pas");
			System.out.println("\t2 - Mode continu");
			System.out.println("Pour quitter - q");
			gameMode = sc.nextLine();
			if (Objects.equals(gameMode, "1")) {
				return 0;
			} else if (Objects.equals(gameMode, "2")) {
				System.out
						.println("Veuillez choisir le nombre d'itération souhaité pour le mode continu");
				if (sc.hasNextInt()) {
					numberOfIteration = sc.nextInt();
					return numberOfIteration;
				}
				// Permet d'éviter les imperfections de scanner
				sc = new Scanner(System.in);
				System.out
						.println("Vous vous êtes raté ! Seul des entier sont acceptés !");
			}
		} while (!Objects.equals(gameMode, "q"));
		return -1;
	}

	private static void menuPrinter() {
		System.out
				.println("Bonjour bienvenue dans l'interface console du DM1 de CPOO5");
		System.out.println("Veuillez choisir un jeu (saisir lettre) :\n");
		System.out.println("\ta - \"" + nomJeux1 + "\"");
		System.out.println("\tb - \"        \"");
		System.out.println("Pour quitter - q");
	}

	private static int sizer() {
		@SuppressWarnings("resource")
		Scanner scc = new Scanner(System.in);
		int numberOfIteration;
		while (true) {
			if (scc.hasNextInt()) {
				numberOfIteration = scc.nextInt();
				if (numberOfIteration < 2) {
					numberOfIteration = 2;
				}
				return numberOfIteration;
			}
		}
	}

}
