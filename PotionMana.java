public class PotionMana extends Potion{
    public PotionMana(String unType, int unEffet, String unNom, String uneDescription, int uneQtt){
        super(unType, unEffet, unNom, uneDescription, uneQtt);
    }


    //Afficher les informations de la potion
    @Override
    public String toString(){
        return super.getNom()+", Effet: "+super.getEffet()+" "+getType()+", Quantité: "+super.getQtt()+", Description: "+super.getDescription();
    }
}
