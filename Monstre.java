import java.util.Random;


public class Monstre{

    private String nom;
    private int nombreVie;
    private int degats;
    private int valeurPoints;
    private boolean enVie = true;


    //Créé un monstre aléatoire en fonction de random
    public Monstre(int random){
        switch(random){
            case 0: //Zombie
                setNom("Zombie");
                setNombreVie(60);
                setDegats(16);
                setValeurPoints(50);
                setEnVie(true);
                break;

            case 1: //Squelette
                setNom("Squelette");
                setNombreVie(45);
                setDegats(20);
                setValeurPoints(60);
                setEnVie(true);
                break;

            case 2: //Orc
                setNom("Orc");
                setNombreVie(70);
                setDegats(12);
                setValeurPoints(70);
                setEnVie(true);
                break;

            case 3: //Gobelin
                setNom("Gobelin");
                setNombreVie(35);
                setDegats(11);
                setValeurPoints(30);
                setEnVie(true);
                break;

            default: //Slime (= BUG)
                setNom("Slime");
                setNombreVie(10);
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
        setNombreVie(getNombreVie() - degats);
        if(getNombreVie() <= 0){
            setNombreVie(0);
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
        System.out.println("Monstre: "+ getNom() +", Points de vie restant: "+ getNombreVie() +" PV");
    }

    //_____________________________________________________________________
    
    /** 
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    
    /** 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    /** 
     * @return int
     */
    public int getNombreVie() {
        return this.nombreVie;
    }

    
    /** 
     * @param nombreVie
     */
    public void setNombreVie(int nombreVie) {
        this.nombreVie = nombreVie;
    }

    
    /** 
     * @return double
     */
    public int getDegats() {
        return this.degats;
    }

    
    /** 
     * @param degats
     */
    public void setDegats(int degats) {
        this.degats = degats;
    }

    
    /** 
     * @return int
     */
    public int getValeurPoints() {
        return this.valeurPoints;
    }

    
    /** 
     * @param valeurPoints
     */
    public void setValeurPoints(int valeurPoints) {
        this.valeurPoints = valeurPoints;
    }

    
    /** 
     * @return boolean
     */
    public boolean isEnVie() {
        return this.enVie;
    }

    
    /** 
     * @param enVie
     */
    public void setEnVie(boolean enVie) {
        this.enVie = enVie;
    }

    







}