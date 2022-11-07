import java.util.Random;

public class Monstre extends Personnage{
    
    private int degats;
    private int valeurPoints;


    public Monstre(int random){
        super("Monstre", 1, true);
        switch(random){
            case 0: //Zombie
            
                setNom("Zombie");
                setPointsVie(60);
                setDegats(16);
                setValeurPoints(50);
                setEnVie(true);
                break;

            case 1: //Squelette
                setNom("Squelette");
                setPointsVie(45);
                setDegats(20);
                setValeurPoints(60);
                setEnVie(true);
                break;

            case 2: //Orc
                setNom("Orc");
                setPointsVie(70);
                setDegats(12);
                setValeurPoints(70);
                setEnVie(true);
                break;

            case 3: //Gobelin
                setNom("Gobelin");
                setPointsVie(35);
                setDegats(11);
                setValeurPoints(30);
                setEnVie(true);
                break;

            default: //Slime (= BUG)
                setNom("Slime");
                setPointsVie(10);
                setDegats(10);
                setValeurPoints(10);
                setEnVie(true);
        }
    }

    /** Récupère les dégats du monstre + une probabilité de critique, voir méthode attaqueCritique
     * @return int
     */
    public int attaquer(boolean faitCritique){
        Random rand = new Random();
        int attaque = this.degats;
        int randomCrit=rand.nextInt(6);
        if(randomCrit == 1 || faitCritique){
            System.out.println(getNom()+" a fait un Coup Critique !");
            attaque+= attaqueCritique();
        }
        System.out.println(getNom()+" a fait "+attaque+" degats");
        System.out.println("");

        return attaque;
    }

    
    /** Inflige les dégats reçus au monstre
     * @param degats
     */
    public void prendreDegat(int degats){
        setPointsVie(getPointsVie() - degats);
        if(getPointsVie() <= 0){
            setPointsVie(0);
            setEnVie(false);
        }
    }

    /** Renvoi une puissance Critique entre 5 et 15
     * @return int
     */
    private int attaqueCritique(){
        Random rand = new Random();
        int CritPlus = rand.nextInt(10)+5;

        return CritPlus;
    }

    //Afficher l'état du monstre
    public void etat(){
        System.out.println("Monstre: "+ getNom() +", Points de vie restant: "+ getPointsVie() +" PV");
    }








//_________________________________________________________


    public int getDegats() {
        return degats;
    }



    public void setDegats(int degats) {
        this.degats = degats;
    }



    public int getValeurPoints() {
        return valeurPoints;
    }



    public void setValeurPoints(int valeurPoints) {
        this.valeurPoints = valeurPoints;
    }




}
