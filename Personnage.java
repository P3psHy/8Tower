class Personnage{


    private String nom;
    private int pointsVie;
    private boolean enVie;
    

    
    public Personnage(String nom, int pointVie, boolean enVie) {
        this.nom = nom;
        this.pointsVie = pointVie;
        this.enVie = enVie;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getPointsVie() {
        return pointsVie;
    }
    public void setPointsVie(int pointVie) {
        this.pointsVie = pointVie;
    }
    public boolean isEnVie() {
        return enVie;
    }
    public void setEnVie(boolean enVie) {
        this.enVie = enVie;
    }
}