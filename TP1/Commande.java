import java.text.SimpleDateFormat;
import java.util.Date;

public class Commande implements Comparable<Commande> {
    private int numCommande;
    private Date dateCommande;
    private String nomFournisseur;

    public Commande(int numCommande, Date dateCommande, String nomFournisseur) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.nomFournisseur = nomFournisseur;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getFournisseur() {
        return nomFournisseur;
    }

    public void setFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = (dateCommande == null) ? "null" : sdf.format(dateCommande);
        return "Commande{Num=" + numCommande + ", Date=" + dateStr + ", Fournisseur='" + nomFournisseur + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Commande)) return false;
        Commande other = (Commande) obj;
        return this.numCommande == other.numCommande;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numCommande);
    }

    @Override
    public int compareTo(Commande cmd) {
        if (this.dateCommande == null && cmd.dateCommande == null) return 0;
        if (this.dateCommande == null) return -1;
        if (cmd.dateCommande == null) return 1;
        return this.dateCommande.compareTo(cmd.dateCommande);
    }
}
