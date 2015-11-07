import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class appli {

	private static String nomJeux1 = "Jeu de la vie";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// TODO UNFUCK BY ADDING MOTHERFUCKING EQUALS FOR STRINGS
		String inputGameName;
		int colums = columsSizer();
		int rows = rowsSizer();
		GridJeuVieTorique plateau = new GridJeuVieTorique(rows, colums);
		do {
			menuPrinter();
			inputGameName = br.readLine();
			switch (inputGameName) {
			case ("a"):
				int gameMode = gameHandler();
			if (gameMode == 0) {
				String cpc; // CANARD PC \o/
				do {
					plateau.update();
					System.out.println(plateau.stateAsString());
					System.out
					.println("Voulez-vous quitter ? (o)");
					cpc = br.readLine();
				} while (!Objects.equals(cpc, "o"));
			} else if (gameMode > 0) {
				for (int multipleruns = 1; multipleruns < gameMode; multipleruns++) {
					plateau.update();
				}
			}

			default:
				break;

			}

		} while (!Objects.equals(inputGameName, "q"));
		br.close();
	}

	private static int gameHandler() throws IOException {
		String gameMode;
		Integer numberOfIteration;
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
		sc.close();
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

	private static int rowsSizer() {
		Scanner sc = new Scanner(System.in);
		int numberOfIteration;
		System.out.println("Quel nombre de lignes désirez-vous?");
		while (true) {
			if (sc.hasNextInt()) {
				numberOfIteration = sc.nextInt();
				return numberOfIteration;
			}
			System.out.println("Quel nombre de lignes désirez-vous?");
		}
	}

	private static int columsSizer() {
		Scanner sc = new Scanner(System.in);
		int numberOfIteration;
		System.out.println("Quel nombre de colonnes désirez-vous?");
		while (true) {
			if (sc.hasNextInt()) {
				numberOfIteration = sc.nextInt();
				return numberOfIteration;
			}
			System.out.println("Quel nombre de colonnes désirez-vous?");
		}
	}
}
