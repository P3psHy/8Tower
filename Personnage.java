import java.util.Random;
class Personnage{


    private String nom;
    private double pointsVie;
    private boolean enVie;
    private int degats;

    

    

    
    public Personnage(String nom, double pointVie, boolean enVie, int desDegats) {
        this.nom = nom;
        this.pointsVie = pointVie;
        this.enVie = enVie;
        this.degats = desDegats;
    }

    public void etat(){
        System.out.println(getNom()+" a "+getPointsVie()+" HP et fait" +getDegats()+" dégats");
    }

    public int attaquer(boolean faitCritique, int margeCritique){
        Random rand = new Random();
        int attaque = getDegats();
        int randomCrit=rand.nextInt(5);
        if(randomCrit == 1 || faitCritique){
            System.out.println(getNom()+" a fait un Coup Critique !");
            attaque+= attaqueCritique(margeCritique);
        }
        System.out.println(getNom()+" a fait "+attaque+" degats");
        System.out.println("");

        return attaque;
    }

    private int attaqueCritique(int marge){
        Random rand = new Random();
        int CritPlus = rand.nextInt(marge)+5;

        return CritPlus;
    }

    public void prendreDegat(double degats){
        setPointsVie(getPointsVie() - degats);
        if(getPointsVie() <= 0){
            setPointsVie(0);
            setEnVie(false);
        }
    }

//________________________________________________________________________________

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getPointsVie() {
        return pointsVie;
    }
    public void setPointsVie(double pointsVie) {
        this.pointsVie = pointsVie;
    }
    public boolean isEnVie() {
        return enVie;
    }
    public void setEnVie(boolean enVie) {
        this.enVie = enVie;
    }
    
    public int getDegats() {
    	return this.degats;
    }
    public void setDegats(int degats) {
    	this.degats = degats;
    }
}