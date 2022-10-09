public class Potion{
    
    private String type;
    private String nom;
    private String description;
    private int qtt;
    private int effet;


    public Potion(String unType, int unEffet, String unNom, String uneDescription, int uneQtt){
        this.type = unType;
        this.effet = unEffet;
        this.nom = unNom;
        this.description =uneDescription;
        this.qtt = uneQtt;
    }


    public int getType(){
        return this.effet;
    }

    public void setType(String unType){
        this.type = unType;
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
        return "Type: "+getType()+", Nom: "+getNom()+", Description: "+getDescription();
    }



    
    

}
