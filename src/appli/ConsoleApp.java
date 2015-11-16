package appli;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import org.omg.PortableServer.LifespanPolicy;

import square.GridJeuVieSquare;
import square.LifeState;
import triangle.GridJeuVieTriangle;

public class ConsoleApp {

	private static String nomJeux1 = "Jeu de la vie - variante Torique sans diagonales -";
	private static String nomJeux2 = "Jeu de la vie - variante Torique -";
	private static String nomJeux3 = "Jeu de la vie - Triangulaire non torique -";

	public static void main(String[] args) throws IOException {

		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputStreamReader);

		String inputGameName;

		do {
			System.out
			.println("Bonjour bienvenue dans l'interface console du DM1 de CPOO5");
			System.out.println("Veuillez choisir un jeu (saisir lettre) :\n");
			System.out.println("\ta - \"" + nomJeux1 + "\"");
			System.out.println("\tb - \"" + nomJeux2 + "\"");
			System.out.println("\tc - \"" + nomJeux3 + "\"");
			System.out.println("Pour quitter - q");
			inputGameName = br.readLine();
			int gameMode;			
			
			switch (inputGameName) {

			case ("a"):
				GridJeuVieSquare plateau;
				plateau = gridTypeChoice(false);
				gameMode = jdvHandler();
				if (gameMode == 0) {
					String cpc; // CANARD PC \o/

					do {
						System.out.println(plateau.stateAsString());
						plateau.update();
						System.out.println(plateau.stateAsString());
						System.out.println("Voulez-vous quitter ? (o)");
						cpc = br.readLine();
					} while (!Objects.equals(cpc, "o"));
				} else if (gameMode > 0) {
					System.out.println(plateau.stateAsString());
					for (int multipleruns = 1; multipleruns < gameMode; multipleruns++) {
						plateau.update();
					}
					System.out.println(plateau.stateAsString());
				}
				break;
			
			case ("b"):
				GridJeuVieSquare plateau2;
				plateau2 = gridTypeChoice(true);
				gameMode = jdvHandler();
				if (gameMode == 0) {
					String cpc; // CANARD PC \o/

					do {
						System.out.println(plateau2.stateAsString());
						plateau2.update();
						System.out.println(plateau2.stateAsString());
						System.out.println("Voulez-vous quitter ? (o)");
						cpc = br.readLine();
					} while (!Objects.equals(cpc, "o"));
				} else if (gameMode > 0) {
					System.out.println(plateau2.stateAsString());
					for (int multipleruns = 1; multipleruns < gameMode; multipleruns++) {
						plateau2.update();
					}
					System.out.println(plateau2.stateAsString());
				}				
				break;

			case ("c"):
				GridJeuVieTriangle plateauTriangle;
				plateauTriangle = gridTypeChoice();
				gameMode = jdvHandler();
				if (gameMode == 0) {
					String cpc; // CANARD PC \o/

					do {
						System.out.println(plateauTriangle.stateAsString());
						plateauTriangle.update();
						System.out.println(plateauTriangle.stateAsString());
						System.out.println("Voulez-vous quitter ? (o)");
						cpc = br.readLine();
					} while (!Objects.equals(cpc, "o"));
				} else if (gameMode > 0) {
					System.out.println(plateauTriangle.stateAsString());
					for (int multipleruns = 1; multipleruns < gameMode; multipleruns++) {
						plateauTriangle.update();
					}
					System.out.println(plateauTriangle.stateAsString());
				}				
				break;
				
			default:
				break;
			}

		} while (!Objects.equals(inputGameName, "q"));
	}

	/**TODO
	 * Offre le choix entre des presets et grid normaux
	 * @return : un grid généré ou de preset
	 */
	private static GridJeuVieSquare gridTypeChoice(boolean diag) {
		String gameMode;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir une grille :");
		System.out.println("\ta - Preset Gosper Gun");
		System.out.println("\tb - Preset Puffers");
		System.out.println("\t\"\" - Génération personnalisée");
		System.out.println("Pour quitter - q");
		do {
			gameMode = sc.nextLine();
			if (Objects.equals(gameMode, ("a")) || Objects.equals(gameMode, ("b"))) {
				return new GridJeuVieSquare(gameMode, diag);
			} else if (Objects.equals(gameMode, (""))) {
				System.out.println("Quel nombre de colonnes désirez-vous?");
				int colums = sizer();
				System.out.println("Quel nombre de lignes désirez-vous?");
				int rows = sizer();
				GridJeuVieSquare gjvs = new GridJeuVieSquare(rows, colums, true);
				String cellRegeneration;//Twelve is the best
				do{
				// TODO MAKE A CELL CHOOSER FOR THE GRID
					System.out.println
					("Veuillez choisir un ligne et une colonne où rendre la cellule vivante");
					System.out.println("A quelle ligne désirez-vous rendre la cellule vivante?");
					int firstInt = integerInput(sc);
					System.out.println("A quelle colonne désirez-vous rendre la cellule vivante?");
					int secondInt = integerInput(sc);
					
					if(firstInt < gjvs.getRows() && secondInt < gjvs.getColums()){
						gjvs.getCell(firstInt, secondInt).setState(LifeState.ALIVE);
						System.out.println(gjvs.stateAsString());
					} else {
						System.out.println("Vous essayez d'inserer hors du tableau !");
					}
					System.out.println("Pour arrêter d'inserer des cellules : q");
					cellRegeneration = sc.next();
				} while (!Objects.equals(cellRegeneration, "q"));
				return gjvs;
			}
			System.out
			.println("Vous vous êtes raté !\n");
		} while (!Objects.equals(gameMode, "q"));
		return null;
	}
	
	/**TODO
	 * Offre le choix entre des presets et grid normaux
	 * @return : un grid généré ou de preset
	 */
	private static GridJeuVieTriangle gridTypeChoice() {
		String gameMode;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir une grille :");
		System.out.println("\ta - Preset Gosper Gun");
		System.out.println("\tb - Preset Puffers");
		System.out.println("\t\"\" - Génération personnalisée");
		System.out.println("Pour quitter - q");
		do {
			gameMode = sc.nextLine();
			if (Objects.equals(gameMode, ("a")) || Objects.equals(gameMode, ("b"))) {
				return new GridJeuVieTriangle(gameMode);
			} else if (Objects.equals(gameMode, (""))) {
				System.out.println("Quel nombre de colonnes désirez-vous?");
				int colums = sizer();
				System.out.println("Quel nombre de lignes désirez-vous?");
				int rows = sizer();
				GridJeuVieTriangle gjvt = new GridJeuVieTriangle(rows, colums);
				// TODO MAKE A CELL RANDOMIZER FOR THE GRID
				return gjvt;
			}
			System.out
			.println("Vous vous êtes raté !\n");
		} while (!Objects.equals(gameMode, "q"));
		return null;
	}

	/**
	 * Proposes gamemode to the user
	 * @return : te value of the chosen gamemode
	 */
	private static int jdvHandler() {
		String gameMode;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Veuillez choisir un mode de jeu");
			System.out.println("\t1 - Pas à pas");
			System.out.println("\t2 - Multiple itérations");
			System.out.println("Pour quitter - q");
			gameMode = sc.nextLine();
			if (Objects.equals(gameMode, "1")) {
				return 0;
			} else if (Objects.equals(gameMode, "2")) {
				System.out
						.println("Veuillez choisir le nombre d'itération souhaité pour le mode continu");
				return sc.nextInt();
			}
		} while (!Objects.equals(gameMode, "q"));
		return -1;
	}

	/**
	 * Get the size of side of the grid
	 * @return : the value inputed by the user
	 */
	private static int sizer() {
		Scanner scc = new Scanner(System.in);
		int numberOfIteration = integerInput(scc);
		if (numberOfIteration < 2) {
			numberOfIteration = 2;
		}
		return numberOfIteration;
	}
	
	/**
	 * get and input from the user
	 * @param sc : a previously declared scanner
	 * @return : the integer inputed by the user
	 */
	private static int integerInput(Scanner sc){
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException i) {
				System.out
				.println("Vous vous êtes raté ! Seul des entier sont acceptés !");				
				sc.next();
			}			
		}
	}
}
