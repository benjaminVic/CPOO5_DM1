import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;


public class appli {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String nomJeux1 = "Jeu de la vie";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//TODO REPLACE GAME NAME WITH LETTER
		//TODO UNFUCK BY ADDING MOTHERFUCKING EQUALS FOR STRINGS
		System.out.println("Bonjour bienvenue dans l'interface console du DM1 de CPOO5");
		System.out.println("Veuillez choisir un jeu :\n");
		System.out.println("\t-\"" + nomJeux1 + "\"");
		System.out.println("\t-\"        \"");
		
		String inputGameName;
		do{
			inputGameName = br.readLine();
			System.out.println(inputGameName);
		} while (!Objects.equals(inputGameName,"*"));
	}
}
