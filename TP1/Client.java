import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {
    private String codeClient;
    private String nomClient;
    private String adrClient;
    private String telClient;
    private List<Commande> listeCommandes;

    public Client(String codeClient, String nomClient, String adrClient, String telClient) {
        this.codeClient = codeClient;
        this.nomClient = nomClient;
        this.adrClient = adrClient;
        this.telClient = telClient;
        this.listeCommandes = new ArrayList<>();
    }

    public String getCodeClient() {
        return codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getAdrClient() {
        return adrClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public boolean enregistrerCommande(Commande cmd) {
        if (cmd == null) return false;
        return listeCommandes.add(cmd);
    }

    public boolean supprimerCommande(int numCommande) {
        Iterator<Commande> it = listeCommandes.iterator();
        while (it.hasNext()) {
            Commande c = it.next();
            if (c.getNumCommande() == numCommande) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CodeClient: ").append(codeClient).append("\n");
        sb.append("NomClient: ").append(nomClient).append("\n");
        sb.append("AdrClient: ").append(adrClient).append("\n");
        sb.append("TelClient: ").append(telClient).append("\n");
        sb.append("Commandes:\n");
        if (listeCommandes.isEmpty()) {
            sb.append("  Aucune commande.\n");
        } else {
            for (Commande c : listeCommandes) {
                sb.append("  ").append(c).append("\n");
            }
        }
        return sb.toString();
    }
}
