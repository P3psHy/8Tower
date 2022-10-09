import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;


class Personnage{

    private static int id=0;
    private String nom;
    private int pointsVie;
    private int mana;
    private int degArme; // A changer lors de l'implémentation des armes
    private int nombrePoints;
    private boolean enVie;
    private int nombreMonstreTue;
    private ArrayList <Potion> inventairePotion = new ArrayList<>();


    public Personnage(String unNom, int uneArme){
        this.id++;
        this.nom = unNom;
        this.pointsVie = 100;
        this.mana = 50;
        this.degArme = uneArme;
        this.nombrePoints = 0;
        this.enVie = true;
        this.nombreMonstreTue = 0;
        
    }

    //Afficher l'état du personnage
    public void etat(){
        System.out.println(getNom() +" a "+ getPointsVie() +" PV");
    }

    
    /** Récupère les dégats de l'arme + une probabilité de critique, voir méthode attaqueCritique
     * 
     * @return int retourne valeur attaque
     */
    public int attaquer(){
        Random rand = new Random();
        int attaque = this.degArme;
        int randomCrit=rand.nextInt(4);
        if(randomCrit == 1){
            System.out.println(getNom()+"a fait un Coup Critique !");
            attaque+= attaqueCritique();
        }
        System.out.println(getNom()+" a fait "+attaque+" dégats");

        return attaque;
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

    
    /** Renvoi la valeur d'un double qui permet de créer le pourcentage de défense (entre 0 et 1)
     * @return double
     */
    public double seDefendre(){
        Random rand = new Random();

        
        double valeurDefense = (double) (Math.round(rand.nextDouble()*10.0)/10.0);
        System.out.println(getNom()+" s'est défendue à hauteur de "+ valeurDefense * 100 +"%");


        return valeurDefense;
    }


    
    /** Renvoi une puissance Critique entre 10 et 25
     * @return int
     */
    private int attaqueCritique(){
        Random rand = new Random();
        int CritPlus = rand.nextInt(15)+10;

        return CritPlus;
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
        for (Potion potion : inventairePotion) {
            System.out.println(potion.toString());
        }
    }

    
    /** Retirer une potion à partir de son index dans l'Arraylist
     * @param indexPotion index de la potion
     */
    public void retirerPotion(int indexPotion){
        inventairePotion.remove(indexPotion);
    }

    
    /** Utiliser la potion choisis à l'index
     * @param index index de la potion à utiliser
     */
    public void utiliserPotion(int index){
        inventairePotion.get(index).getEffet();
    }


    
    
    //_____________________________________________________________________________________________________


    /** 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
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
    public int getPointsVie() {
        return this.pointsVie;
    }

    
    /** 
     * @param nombreVie
     */
    public void setPointsVie(int nombreVie) {
        this.pointsVie = nombreVie;
    }

    
    /** 
     * @return int
     */
    public int getMana() {
        return this.mana;
    }

    
    /** 
     * @param mana
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    
    /** 
     * @return int
     */
    public int getDegArme() {
        return this.degArme;
    }

    
    /** 
     * @param degArme
     */
    public void setDegArme(int degArme) {
        this.degArme = degArme;
    }

    
    /** 
     * @return int
     */
    public int getNombrePoints() {
        return this.nombrePoints;
    }

    
    /** 
     * @param nombrePoint
     */
    public void setNombrePoints(int nombrePoint) {
        this.nombrePoints = nombrePoint;
    }

    
    /** 
     * @return boolean
     */
    public boolean getEnVie() {
        return this.enVie;
    }

    
    /** 
     * @param enVie
     */
    public void setEnVie(Boolean enVie) {
        this.enVie = enVie;
    }
    
    
    /** 
     * @return int
     */
    public int getNombreMonstreTue() {
        return this.nombreMonstreTue;
    }

    
    /** 
     * @param nombreMonstreTue
     */
    public void setNombreMonstreTue(int nombreMonstreTue) {
        this.nombreMonstreTue = nombreMonstreTue;
    }







}