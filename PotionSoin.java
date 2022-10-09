public class PotionSoin extends Potion{
    


    
    public PotionSoin(int unEffet, String unNom, String uneDescription, int uneQtt){
        super(unEffet, unNom, uneDescription, uneQtt);
    }


    //Afficher les informations de la potion
    @Override
    public String toString(){
        return super.getNom()+", Effet: "+super.getEffet()+" PV, Quantité: "+super.getQtt()+", Description: "+super.getDescription();
    }


}
