import java.util.Random;


class Monstre{

    private String nom;
    private int nombreVie;
    private double degats;
    private int valeurPoints;
    private boolean enVie = true;

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




    public double attaquer(){
        Random rand = new Random();
        double attaque = this.degats;
        int randomCrit=rand.nextInt(6);
        if(randomCrit == 1){
            System.out.println(getNom()+" a fait un Coup Critique !");
            attaque+= attaqueCritique();
        }
        System.out.println(getNom()+" a fait "+(int)attaque + " degats");
        System.out.println("");

        return attaque;
    }

    public void prendreDegat(int degats){
        setNombreVie(getNombreVie() - degats);
        if(getNombreVie() <= 0){
            setNombreVie(0);
            setEnVie(false);
        }
    }




    private int attaqueCritique(){
        Random rand = new Random();
        int CritPlus = rand.nextInt(15)+10;

        return CritPlus;
    }


    public void etat(){
        System.out.println("Monstre: "+ getNom() +", Points de vie restant: "+ getNombreVie() +" PV");
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreVie() {
        return this.nombreVie;
    }

    public void setNombreVie(int nombreVie) {
        this.nombreVie = nombreVie;
    }

    public double getDegats() {
        return this.degats;
    }

    public void setDegats(double degats) {
        this.degats = degats;
    }

    public int getValeurPoints() {
        return this.valeurPoints;
    }

    public void setValeurPoints(int valeurPoints) {
        this.valeurPoints = valeurPoints;
    }

    public boolean isEnVie() {
        return this.enVie;
    }

    public void setEnVie(boolean enVie) {
        this.enVie = enVie;
    }

    







}