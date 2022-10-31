import java.util.*;

public class ListVoitures {

    private List<Voiture> voitures;

    public ListVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public ListVoitures() {
        voitures = new ArrayList<>();
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (!voitures.add(v)) {
            throw new VoitureException();
        }
    }

    public void supprimeVoiture(Voiture v) throws VoitureException {
        if (!voitures.remove(v)) {
            throw new VoitureException();
        }
    }

    public int size() {
        return voitures.size();
    }

    public void affiche() {
        voitures.forEach(System.out::println);
    }
}
