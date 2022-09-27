import java.util.Scanner;
import java.util.Random;



public class main{

    public static Monstre spawnMonstre(){
        Monstre monstre = new Monstre();
        Random rand = new Random();

        int monstreRandom = rand.nextInt(4);

        switch(monstreRandom){
            case 0: //Zombie
                monstre.setNom("Zombie");
                monstre.setNombreVie(60);
                monstre.setDegats(16);
                monstre.setValeurPoints(50);
                monstre.setEnVie(true);
                break;

            case 1: //Squelette
                monstre.setNom("Squelette");
                monstre.setNombreVie(45);
                monstre.setDegats(20);
                monstre.setValeurPoints(60);
                monstre.setEnVie(true);
                break;

            case 2: //Orc
                monstre.setNom("Orc");
                monstre.setNombreVie(70);
                monstre.setDegats(12);
                monstre.setValeurPoints(70);
                monstre.setEnVie(true);
                break;

            case 3: //Gobelin
                monstre.setNom("Gobelin");
                monstre.setNombreVie(35);
                monstre.setDegats(11);
                monstre.setValeurPoints(30);
                monstre.setEnVie(true);
                break;

            default: //Slime (= BUG)
            monstre.setNom("Slime");
            monstre.setNombreVie(10);
            monstre.setDegats(10);
            monstre.setValeurPoints(10);
            monstre.setEnVie(true);
        }   

        return monstre;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        

        System.out.println("Bienvenue sur TowerMonsterWorld");
        System.out.println("Cliquez sur Jouer");
        String jouer =sc.next();

        if(jouer.equals("Jouer")){

            System.out.print("Entrez le nom de votre personnage: ");
            String pseudo = sc.next();
            
            Personnage Perso = new Personnage(pseudo, 20);
            PotionSoin popoSoinMoyen = new PotionSoin(20,"Potion de soin Moyenne", "une potion de soin régénérant une bonne qantité de vie", 3, Perso);
            PotionSoin popoSoinPetit = new PotionSoin(10,"Potion de soin Petite", "une petite potion de soin régénérant peu de vie", 5, Perso);
           
            Perso.ajouterPotion(popoSoinMoyen);
            Perso.ajouterPotion(popoSoinPetit);

            System.out.println(""); 
            System.out.println("Vous rentrez dans la Tour");
            System.out.println("");
           
            



            while(Perso.getEnVie()){
                Monstre m1 = spawnMonstre();
                System.out.println("Vous rencontrez un "+m1.getNom());
                System.out.println("");

                while(m1.isEnVie() && Perso.getEnVie()){

                    System.out.println("");
                    System.out.println("ETAT JOUEUR");
                    Perso.etat();
                    System.out.println("");
                    System.out.println("ETAT MONSTRE");
                    m1.etat();


                    System.out.println("");
                    System.out.println("Voulez-vous:");
                    System.out.println("A:  Attaquer");
                    System.out.println("B:  Défendre");
                    System.out.println("C:  Inventaire Potions");
                    System.out.println("D:  Fuire");
                    System.out.println("D:  Ne rien faire");
                    String choix = sc.next();
                    System.out.println("");


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

                        default:
                            System.out.println(Perso.getNom()+" ne faites rien");
                            System.out.println("");
                            break;
                    }


                    if(!Perso.getEnVie()){
                        System.out.println(Perso.getNom()+" est mort, retour au menu");
                        System.out.println("");
                        System.out.println("Bilan");
                        System.out.println("Monstre tué: "+Perso.getNombreMonstreTue());
                        System.out.println("Nombre de points gagné: "+ Perso.getNombrePoints());
                    }else{
                        System.out.println("Le combat continue");
                        System.out.println("");
                    }
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