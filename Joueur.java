import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;

public class Joueur extends Personnage{
    
    private int mana;
    private Armes arme;
    private int nombrePoints;
    private int nombreMonstreTue;
    private ArrayList <Potion> inventairePotion = new ArrayList<>();

    public Joueur(String unNom, Armes uneArme){
        super(unNom, 100, true);
        this.mana = 50;
        this.arme = uneArme;
        this.nombrePoints = 0;
        this.nombreMonstreTue = 0;
        
    }


    public void etat(){
        System.out.println(getNom()+" a "+getPointsVie()+" PV et "+getMana()+" Manad");
    }

    /** Récupère les dégats de l'arme + une probabilité de critique, voir méthode attaqueCritique
     * 
     * @return int retourne valeur attaque
     */
    public int attaquer(){
        Random rand = new Random();
        int attaque = this.arme.getDegats();
        int randomCrit=rand.nextInt(4);
        if(randomCrit == 1){
            System.out.println(getNom()+" a fait un Coup Critique !");
            attaque+= attaqueCritique();
        }
        System.out.println(getNom()+" a fait "+attaque+" dégats");

        return attaque;
    }

    /** Renvoi une puissance Critique entre 10 et 25
     * @return int
     */
    private int attaqueCritique(){
        Random rand = new Random();
        int CritPlus = rand.nextInt(15)+10;

        return CritPlus;
    }

    /** Renvoi la valeur d'un double qui permet de créer le pourcentage de défense (entre 0 et 1)
     * @return double
     */
    public double seDefendre(){
        Random rand = new Random();
        
        double valeurDefense = (double) (Math.round(rand.nextDouble()*10.0)/10.0);
        System.out.println(getNom()+" s'est défendue à hauteur de "+ valeurDefense * 100 +"%");


        return valeurDefense;
    }

    /**  Inflige les dégats reçus au personnage
     * 
     * @param degats dégats à infliger
     */
    public void prendreDegat(double degats){
        double degatsPris = getPointsVie() - degats;
        setPointsVie((int)degatsPris);

        if(getPointsVie() <= 0){
            setPointsVie(0);
            setEnVie(false);
        }
    }

    public boolean esquiver(){
        boolean aEsquive = false;
        Random rand = new Random();

        if(rand.nextInt(2) == 1){
            aEsquive = true;
            System.out.println("Vous avez esquivé l'attaque du monstre");
        }
        
        return aEsquive;
    }

    //Change l'état de vie du joueur en fonction de sa réussite: 2/5 chance
    public void fuir(){
        Random rand = new Random();

        if(rand.nextInt(5) <= 2){
            System.out.println("Vous avez raté votre fuite");
        }else{
            setEnVie(false);
        System.out.println("Vous avez pris la fuite");
        }

        
    }

    //Ajouter monstre tué au compteur
    public void ajouterMonstreTue(){
        System.out.println("Monstre tué ajouté au compteur");
        this.nombreMonstreTue++;
    }

    
    /** Ajoute des points à l'utilisateur 
     * @param points nombre de points du monstre tué récupéré
     */
    public void ajouterPoints(int points){
        setNombrePoints(getNombrePoints()+points);
    }

    //A tester si Potion déjà présente
    /** Ajouter une potion à l'inventaire, si elle est déjà présente, la quantité augmente, sinon l'ajoute à l'Arraylist
     * @param potion Potion à ajouter
     * @return boolean True si ajouté à la quantité où à l'arraylist
     */
    public boolean ajouterPotion(Potion potion){
        boolean estDejaPresent = false;
        boolean estAjoute = false;
        int i = 0;

        while(this.inventairePotion.size() < i){

            if(potion.getNom().equals(this.inventairePotion.get(i).getNom())){
                estDejaPresent = true;
                estAjoute = true;
                this.inventairePotion.get(i).setQtt(this.inventairePotion.get(i).getQtt()+1);
            }

            i++;
        }

        if(!estDejaPresent){
            this.inventairePotion.add(potion);
            estAjoute = true;
        }
        
        return estAjoute;
    }

    //Afficher les potions dans l'inventaire du joueur
    public void afficherPotion(){
        for (int i = 0; i<inventairePotion.size(); i++) {
            System.out.println(i+1 + " : "+ inventairePotion.get(i).toString());
        }
    }

    
    /** Retirer une potion à partir de son index dans l'Arraylist
     * @param indexPotion index de la potion
     */
    public boolean retirerPotion(int indexPotion, int qttPotion){
        boolean estRetire = true;
        inventairePotion.get(indexPotion).setQtt(inventairePotion.get(indexPotion).getQtt()-qttPotion);

        if(inventairePotion.get(indexPotion).getQtt() <= 0){
            inventairePotion.remove(indexPotion);
        }

        return estRetire;
    }

    
    /** Utiliser la potion choisis à l'index
     * @param index index de la potion à utiliser
     * Limiter suivant le nombre de point de vie.
     */
    public boolean utiliserPotion(int index){
        boolean estUtilise = true;
        index -=1;
        String effect = inventairePotion.get(index).getType();
        
        switch(effect){
            case "Soin":
                ajouterVie(inventairePotion.get(index).getEffet());
                System.out.println("Vous vous êtes soigner de "+inventairePotion.get(index).getEffet()+" HP");
                retirerPotion(index, 1);
                break;

            case "Mana":
                ajouterMana( inventairePotion.get(index).getEffet());
                System.out.println("Vous avez récupéré de "+inventairePotion.get(index).getEffet()+" Mana");
                retirerPotion(index, 1);
                break;
            default:
                estUtilise = false;
                System.out.println("Une erreur c'est produit.");
        }
        return estUtilise;
    }

    public boolean ajouterVie(int qttVie){
        setPointsVie(getPointsVie()+qttVie);
        if(getPointsVie()>100){
            setPointsVie(100);
        }

        return true;
    }

    public boolean ajouterMana(int qttMana){
        setMana(getMana()+qttMana);
        if(getPointsVie()>50){
            setMana(50);
        }

        return true;
    }

    public boolean retirerMana(int qttMana){
        setMana(getMana()-qttMana);
        if(getPointsVie()<0){
            setMana(0);
        }

        return true;
    }

//_________________________________________________

public int getMana() {
    return mana;
}

public void setMana(int mana) {
    this.mana = mana;
}

public int getNombrePoints() {
    return nombrePoints;
}

public void setNombrePoints(int nombrePoints) {
    this.nombrePoints = nombrePoints;
}

public int getNombreMonstreTue() {
    return nombreMonstreTue;
}

public void setNombreMonstreTue(int nombreMonstreTue) {
    this.nombreMonstreTue = nombreMonstreTue;
}

}
