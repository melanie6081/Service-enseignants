package champollion;


import java.time.LocalDate;

public class Intervention {
    private TypeIntervention type;
    private LocalDate debut;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;

    public Intervention(TypeIntervention type){
        this.type = type;
    }
    public Intervention(TypeIntervention type, LocalDate debut, int duree, int heureDebut) {
        this(type);
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getType() {
        return type;
    }

    public boolean isAnnulee() {
        return annulee;
    }
}
