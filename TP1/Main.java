import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Commande c1 = new Commande(1001, sdf.parse("2024-05-10"), "Fournisseur A");
            Commande c2 = new Commande(1002, sdf.parse("2024-06-20"), "Fournisseur B");
            Commande c3 = new Commande(1003, sdf.parse("2024-03-15"), "Fournisseur C");
            Commande c4 = new Commande(1004, sdf.parse("2024-06-20"), "Fournisseur D");
            Commande cDuplicate = new Commande(1002, sdf.parse("2024-06-21"), "Fournisseur B2");

            Client client1 = new Client("C001", "Dahak", "Casablanca", "0612345678");
            Client client2 = new ClientFidel("C002", "Ennafati", "Rabat", "0623456789", "F-2024", 10.0f);

            client1.enregistrerCommande(c1);
            client1.enregistrerCommande(c3);
            client1.enregistrerCommande(c2);
            client2.enregistrerCommande(c4);
            client2.enregistrerCommande(c2);

            System.out.println("Avant tri (client1 commandes):");
            for (Commande cmd : client1.getListeCommandes()) {
                System.out.println("  " + cmd);
            }

            Collections.sort(client1.getListeCommandes());

            System.out.println("\nAprès tri (client1 commandes):");
            for (Commande cmd : client1.getListeCommandes()) {
                System.out.println("  " + cmd);
            }

            List<Commande> someList = Arrays.asList(c1, c2, cDuplicate, c3, c2);
            System.out.println("\nListe avec doublons:");
            for (Commande cc : someList) System.out.println("  " + cc);

            Set<Commande> setCommandes = new HashSet<>(someList);
            System.out.println("\nSet après suppression des doublons:");
            for (Commande cc : setCommandes) System.out.println("  " + cc);

            Map<String, Client> mapClients = new HashMap<>();
            mapClients.put(client1.getCodeClient(), client1);
            mapClients.put(client2.getCodeClient(), client2);

            System.out.println("\nMap des clients:");
            for (String code : mapClients.keySet()) {
                System.out.println("  " + code + " -> " + mapClients.get(code).getNomClient());
            }

            String filename = "clients.txt";
            writeClientsToFile(new ArrayList<>(mapClients.values()), filename);

            System.out.println("\nContenu du fichier '" + filename + "':");
            readFileAndPrint(filename);

            System.out.println("\nSuppression commande 1003 du client1 : " + client1.supprimerCommande(1003));
            System.out.println("Client1 après suppression:");
            System.out.println(client1);

        } catch (ParseException e) {
            System.err.println("Erreur parsing date: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erreur IO: " + e.getMessage());
        }
    }

    private static void writeClientsToFile(List<Client> clients, String filename) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Client c : clients) {
                bw.write("=== Client ===");
                bw.newLine();
                bw.write(c.toString());
                bw.newLine();
                bw.newLine();
            }
            bw.flush();
            System.out.println("\nEcriture dans le fichier '" + filename + "' reussie.");
        }
    }

    private static void readFileAndPrint(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
