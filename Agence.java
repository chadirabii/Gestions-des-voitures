
import java.util.*;

public class Agence {
   

    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        vs = new ListVoitures();
        clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        vs.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        vs.supprimeVoiture(v);
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        suppVoiture(v);
        if (!clientVoitureLoue.containsKey(cl)) {
            clientVoitureLoue.put(cl, new ListVoitures());
        }
        clientVoitureLoue.get(cl).ajoutVoiture(v);
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        ajoutVoiture(v);
        clientVoitureLoue.get(cl).supprimeVoiture(v);
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> voitures = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                voitures.add(v);
            }
        }

        for (Map.Entry<Client, ListVoitures> entry : clientVoitureLoue.entrySet()) {
            for (Voiture v : entry.getValue().getVoitures()) {
                if (c.estSatisfaitPar(v)) {
                    voitures.add(v);
                }
            }
        }

        return voitures;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        clientVoitureLoue.forEach((k, v) -> {
            System.out.println(k);
            v.affiche();
        });
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        Map<Client, ListVoitures> map = new TreeMap<>((c1, c2) -> c1.getCode() - c2.getCode());
        map.putAll(clientVoitureLoue);
        return map;
    }

    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> map = new TreeMap<>((c1, c2) -> c1.getNom().compareTo(c2.getNom()));
        map.putAll(clientVoitureLoue);
        return map;
    }
}