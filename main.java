import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;



public class main{


    public static void main(String[] args) {

        ArrayList <String> listChoix = new ArrayList<>();
        listChoix.add("A");
        listChoix.add("B");
        listChoix.add("C");
        listChoix.add("D");
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Bienvenue sur TowerMonsterWorld");
        System.out.println("Cliquez sur Jouer");
        String jouer =sc.next();

        //Lancement du jeu
        if(jouer.equals("Jouer")){

            System.out.print("Entrez le nom de votre personnage: ");
            String pseudo = sc.next();
            ArrayList <Armes> listArme = new ArrayList<>();
            
            Armes epee = new Armes("Epee du débutant", 20, "Une épée d'entrainement émoussé");
            Armes hache = new Armes("Hache du débutant", 25, "Une hâche puissante pouvant tout découper");
            Armes arc = new Armes("Arc du débutant", 15, "Un arc avec des flêches puissantes");
            Armes hallebarde = new Armes("Hallebarde du débutant", 15, "Une hallebarde qui fait peur (arme par défaut)");
            listArme.add(epee);
            listArme.add(hache);
            listArme.add(arc);
            listArme.add(hallebarde);
            Armes armeJoueur;
            
            System.out.println("");
            System.out.println("Choisissez une armes:");
            for (int i = 0; i<listArme.size(); i++){
               System.out.println(listChoix.get(i)+ " : " +listArme.get(i).toString());
            }
            String armeChoisie = sc.next();



            switch(armeChoisie){
                case "A":
                    armeJoueur = epee;
                    System.out.println("L'épée a été selectionnée.");
                    break;
                
                case "B": 
                    armeJoueur = hache;
                    System.out.println("La hâche a été selectionnée.");
                    break;
                    
                case "C": 
                    armeJoueur = arc;
                    System.out.println("L'arc a été selectionné.");
                    break;

                default:
                    System.out.println("Une erreur à été fait, l'hallebarde a été sélectionnée.");
                    armeJoueur = hallebarde;
                    break;
            }


            //Création Personnage & inventaire potion

            Personnage Perso = new Personnage(pseudo, epee);
            PotionSoin popoSoinMoyen = new PotionSoin("Soin",20,"Potion de soin Moyenne", "une potion de soin régénérant une bonne qantité de vie", 3);
            PotionMana popoManaPetit = new PotionMana("Mana",10,"Potion de mana Petite", "une petite potion de mana régénérant peu de mana", 5);
            
           
            Perso.ajouterPotion(popoSoinMoyen);
            Perso.ajouterPotion(popoManaPetit);

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
                    System.out.println("E:  Ne rien faire");
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
                            System.out.println("");
                            System.out.println("Choississez la potion que vous voulez utiliser: ");
                            String choixInv = sc.next();
                            int potion = Integer.parseInt(choixInv);
                            
                            Perso.utiliserPotion(potion);
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