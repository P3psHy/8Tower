public class Armes{

    private String nom;
    private int degats;
    private String description;

    

    public Armes(String unNom, int unDegats, String uneDescription){
        this.nom = unNom;
        this.degats = unDegats;
        this.description = uneDescription;

    }




    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDegats() {
        return this.degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){

        return getNom()+", Degats: "+getDegats()+", Description: "+getDescription();
    }

}