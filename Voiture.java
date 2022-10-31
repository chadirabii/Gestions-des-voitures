public class Voiture {

    private int matricule;
    private String marque;
    private float prixLocation;

    public Voiture(int matricule, String marque, float prixLocation) {
        this.matricule = matricule;
        this.marque = marque;
        this.prixLocation = prixLocation;
    }

    public int getmatricule() {
        return matricule;
    }

    public void setmatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public float getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(float prixLocation) {
        this.prixLocation = prixLocation;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Voiture) {
            Voiture v = (Voiture) obj;
            return v.matricule == matricule && v.marque.equals(marque);
        }
        return false;
    }

    public String toString() {
        return "immatriculation: " + matricule + "  marque: " + marque + " prix dde location: " + prixLocation;
    }
}
