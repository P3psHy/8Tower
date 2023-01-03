import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class sauvegarderCompte {
    
    public void sauvegarderCompteJoueur(Joueur unJoueur){

        JSONObject cptJoueur = new JSONObject();
        JSONObject armeJoueur = new JSONObject();
        JSONObject listePotionsJoueur = new JSONObject();
        JSONObject potion = new JSONObject();
        FileWriter fileSave;

        //Informations du compte joueur
        cptJoueur.put("Nom", unJoueur.getNom());
        cptJoueur.put("pvMax", unJoueur.getPointsVie());
        cptJoueur.put("manaMax", unJoueur.getMana());
        cptJoueur.put("enVie", unJoueur.isEnVie());
        cptJoueur.put("degats", unJoueur.getArmes().getDegats());
        cptJoueur.put("nombrePoints", unJoueur.getNombrePoints());
        cptJoueur.put("nombreMonstreTue", unJoueur.getNombreMonstreTue());
        
        Armes armeDuJoueur = unJoueur.getArmes();

        //Informations de l'arme du joueur
        armeJoueur.put("NomArme", armeDuJoueur.getNom());
        armeJoueur.put("DegatsArme", armeDuJoueur.getDegats());
        armeJoueur.put("Description", armeDuJoueur.getDescription());
        
        //Ajout des infos de l'arme du joueur au compte
        cptJoueur.put("Arme", armeJoueur);

        //Informations potion

        
        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            fileSave = new FileWriter("compteJoueur.json");
            fileSave.write(cptJoueur.toJSONString());

            fileSave.flush();
            fileSave.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void chargerCompteJoueur(Joueur unJoueur){

    }


}
