import java.util.Scanner;
import java.util.Random;



public class main{


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Bienvenue sur TowerMonsterWorld");
        System.out.println("Cliquez sur Jouer");
        String jouer =sc.next();

        //Lancement du jeu
        if(jouer.equals("Jouer")){

            System.out.print("Entrez le nom de votre personnage: ");
            String pseudo = sc.next();
            
            //Création Personnage & inventaire potion
            Personnage Perso = new Personnage(pseudo, 20);
            PotionSoin popoSoinMoyen = new PotionSoin(20,"Potion de soin Moyenne", "une potion de soin régénérant une bonne qantité de vie", 3, Perso);
            PotionSoin popoSoinPetit = new PotionSoin(10,"Potion de soin Petite", "une petite potion de soin régénérant peu de vie", 5, Perso);
           
            Perso.ajouterPotion(popoSoinMoyen);
            Perso.ajouterPotion(popoSoinPetit);

            System.out.println(""); 
            System.out.println("Vous rentrez dans la Tour");
            System.out.println("");
           
            


            //Début du jeu 
            while(Perso.getEnVie()){
                Monstre m1 = new Monstre(r.nextInt(4));
                System.out.println("Vous rencontrez un "+m1.getNom());
                System.out.println("");

                //Combat contre un monstre tant que 
                while(m1.isEnVie() && Perso.getEnVie()){

                    //Affichage Etats Joueur & Monstre
                    System.out.println("");
                    System.out.println("ETAT JOUEUR");
                    Perso.etat();
                    System.out.println("");
                    System.out.println("ETAT MONSTRE");
                    m1.etat();


                    //Proposition actions possible
                    System.out.println("");
                    System.out.println("Voulez-vous:");
                    System.out.println("A:  Attaquer");
                    System.out.println("B:  Défendre");
                    System.out.println("C:  Inventaire Potions");
                    System.out.println("D:  Fuire");
                    System.out.println("D:  Ne rien faire");
                    String choix = sc.next();
                    System.out.println("");

                    //Actions du jours en fonction de son choix
                    switch(choix){

                        case "A":
                            m1.prendreDegat(Perso.attaquer());
                            Perso.prendreDegat(m1.attaquer());
                            break;

                        case "B":
                            Perso.prendreDegat(m1.attaquer()*Perso.seDefendre());
                            break;

                        case "C":
                            Perso.afficherPotion();
                            System.out.println("Potion");
                            break;

                        case "D":
                            Perso.fuir();
                            if(Perso.getEnVie()){
                                Perso.prendreDegat(m1.attaquer());
                            }
                            break;

                        default: //Action de base si une personne se trompe de touche
                            System.out.println(Perso.getNom()+" ne faites rien");
                            System.out.println("");
                            break;
                    }

                    //Déclaration mort Joueur
                    if(!Perso.getEnVie()){
                        System.out.println(Perso.getNom()+" est mort, retour au menu");
                        System.out.println("");
                        System.out.println("Bilan");
                        System.out.println("Monstre tué: "+Perso.getNombreMonstreTue());
                        System.out.println("Nombre de points gagné: "+ Perso.getNombrePoints());
                    }else{ // Suite du combat
                        System.out.println("Le combat continue");
                        System.out.println("");
                    }
                    //Déclaration mort Monstre
                    if(!m1.isEnVie()){
                        System.out.println("Le "+m1.getNom() + " est mort, vous gagnez "+m1.getValeurPoints()+" points");
                        Perso.ajouterMonstreTue();
                        Perso.ajouterPoints(m1.getValeurPoints());
                        System.out.println("");
                    }


                }

            }

        }








        System.out.println("Fin du jeu");
        sc.close();
        //Fin du programme
    }

    
}