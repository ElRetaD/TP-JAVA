public class ClientFidel extends Client {
    private String codeFidelite;
    private float tauxReduction;

    public ClientFidel(String codeClient, String nomClient, String adrClient, String telClient,
                       String codeFidelite, float tauxReduction) {
        super(codeClient, nomClient, adrClient, telClient);
        this.codeFidelite = codeFidelite;
        this.tauxReduction = tauxReduction;
    }

    public String getCodeFidelite() {
        return codeFidelite;
    }

    public float getTauxReduction() {
        return tauxReduction;
    }

    @Override
    public String toString() {
        String parent = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(parent);
        sb.append("CodeFidelite: ").append(codeFidelite).append("\n");
        sb.append("TauxReduction: ").append(tauxReduction).append("%\n");
        return sb.toString();
    }
}
