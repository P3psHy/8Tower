public class Potion{
    
    private String nom;
    private String description;
    private int qtt;
    private int effet;

    


    public Potion(int unEffet, String unNom, String uneDescription, int uneQtt){
        this.effet = unEffet;
        this.nom = unNom;
        this.description =uneDescription;
        this.qtt = uneQtt;
    }


    public int getEffet(){
        return this.effet;
    }

    public void setEffet(int unEffet){
        this.effet = unEffet;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQtt() {
        return this.qtt;
    }

    public void setQtt(int qtt) {
        this.qtt = qtt;
    }

    public String toString(){
        return "Nom: "+getNom()+" Description: "+getDescription();
    }



    
    

}
