public class PotionSoin extends Potion{
    


    
    public PotionSoin(int unEffet, String unNom, String uneDescription, int uneQtt, Personnage unPerso){
        super(unNom, uneDescription, uneQtt, unPerso);
    }


    
    @Override
    public String toString(){
        return "Potion: "+super.getNom()+", Effet: "+super.getEffet()+" PV, Quantité: "+super.getQtt()+", Description"+super.getDescription();
    }


}
