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
    private ArrayList <Potion> ListePotions = new ArrayList<>();

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

    public void etat(){
        System.out.println(getNom() +" a "+ getPointsVie() +" PV");
    }

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

    public void prendreDegat(double degats){
        double degatsPris = getPointsVie() - degats;
        setPointsVie((int)degatsPris);

        if(getPointsVie() <= 0){
            setPointsVie(0);
            setEnVie(false);
        }
    }

    public double seDefendre(){
        Random rand = new Random();

        
        double valeurDefense = (double) (Math.round(rand.nextDouble()*10.0)/10.0);
        System.out.println(getNom()+" s'est défendue à hauteur de "+ valeurDefense * 100 +"%");


        return valeurDefense;
    }


    private int attaqueCritique(){
        Random rand = new Random();
        int CritPlus = rand.nextInt(15)+10;

        return CritPlus;
    }

    public void ajouterMonstreTue(){
        System.out.println("Monstre tué ajouté au compteur");
        this.nombreMonstreTue++;
    }

    public void ajouterPoints(int points){
        setNombrePoints(getNombrePoints()+points);
    }


    public void fuir(){
        Random rand = new Random();

        if(rand.nextInt(5) <= 2){
            System.out.println("Vous avez raté votre fuite");
        }else{
            setEnVie(false);
        System.out.println("Vous avez pris la fuite");
        }

        
    }

    public boolean ajouterPotion(Potion potion){
        boolean estDejaPresent = false;
        boolean estAjoute = false;
        int i = 0;

        while(this.ListePotions.size() < i){

            if(potion.getNom().equals(this.ListePotions.get(i).getNom())){
                estDejaPresent = true;
                this.ListePotions.get(i).setQtt(this.ListePotions.get(i).getQtt()+1);
            }

            i++;
        }

        if(!estDejaPresent){
            this.ListePotions.add(potion);
            estAjoute = true;
        }
        
        
    

        
        return estAjoute;
    }


    public void afficherPotion(){
        for(int i=0; i < this.ListePotions.size(); i++){
            System.out.println(i+": "+this.ListePotions.get(i).toString());
        }
    }

    public void retirerPotion(int indexPotion){
        ListePotions.remove(indexPotion);
    }

    public void utiliserPotion(int index){
        ListePotions.get(index).getEffet();
    }


    //_____________________________________________________________________________________________________

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsVie() {
        return this.pointsVie;
    }

    public void setPointsVie(int nombreVie) {
        this.pointsVie = nombreVie;
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDegArme() {
        return this.degArme;
    }

    public void setDegArme(int degArme) {
        this.degArme = degArme;
    }

    public int getNombrePoints() {
        return this.nombrePoints;
    }

    public void setNombrePoints(int nombrePoint) {
        this.nombrePoints = nombrePoint;
    }

    public boolean getEnVie() {
        return this.enVie;
    }

    public void setEnVie(Boolean enVie) {
        this.enVie = enVie;
    }
    
    public int getNombreMonstreTue() {
        return this.nombreMonstreTue;
    }

    public void setNombreMonstreTue(int nombreMonstreTue) {
        this.nombreMonstreTue = nombreMonstreTue;
    }







}