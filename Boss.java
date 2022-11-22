import java.util.Random;

public class Boss extends Personnage{
    
    private Armes arme;
    private int valeurPoints;


    public Boss(int random){
        super("Monstre", 1, true, 0);
        switch(random){
            case 0: //Zombie
            
                setNom("Herrscher de la domination");
                setPointsVie(60);
                setArme(arme);
                super.setDegats(arme.getDegats());
                setValeurPoints(50);
                setEnVie(true);
                break;

            case 1: //Squelette
                setNom("Deviluke");
                setPointsVie(45);
                setArme(arme);
                super.setDegats(arme.getDegats());
                setValeurPoints(60);
                setEnVie(true);
                break;

            case 2: //Orc
                setNom("Mathias");
                setPointsVie(70);
                setArme(arme);
                super.setDegats(arme.getDegats());
                setValeurPoints(70);
                setEnVie(true);
                break;

            default: //Slime (= BUG)
                setNom("Giga Chad");
                setPointsVie(10);
                setArme(arme);
                super.setDegats(arme.getDegats());
                setValeurPoints(10);
                setEnVie(true);
        }
    }

    /** Récupère les dégats du monstre + une probabilité de critique, voir méthode attaqueCritique
     * @return int
     */
    public int attaquer(boolean faitCritique){
        Random rand = new Random();
        int attaque = super.getDegats();
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
    @Override
    public void etat(){
        System.out.println("Monstre: "+ getNom() +", Points de vie restant: "+ getPointsVie() +" PV");
    }








//_________________________________________________________


    public void setArme(Armes arme) {
        this.arme = arme;
    }

    public Armes getArmes(){
        return arme;
    }

    public int getValeurPoints() {
        return valeurPoints;
    }



    public void setValeurPoints(int valeurPoints) {
        this.valeurPoints = valeurPoints;
    }




}
