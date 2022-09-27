public class PotionSoin extends Potion{
    

    private int effet;

    
    public PotionSoin(int unEffet, String unNom, String uneDescription, int uneQtt, Personnage unPerso){
        super(unNom, uneDescription, uneQtt, unPerso);
        this.effet = unEffet;
    }


    public int getEffet() {
        return this.effet;
    }

    public void setEffet(int effet) {
        this.effet = effet;
    }
    
    @Override
    public String toString(){
        return "Potion: "+super.getNom()+" Quantité: "+getQtt()+" Description"+super.getDescription();
    }


}
