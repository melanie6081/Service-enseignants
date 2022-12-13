package champollion;

public class UE {
    private final String myIntitule;
    private int heuresCM;
    private int heuresTD;
    private int heuresTP;

    public UE(String intitule) {
        myIntitule = intitule;
    }
    public UE(String intitule,int heuresCM) {
        this(intitule);
        this.heuresCM = heuresCM;
    }
    public UE(String intitule,int heuresCM,int heuresTD){
        this(intitule,heuresCM);
        this.heuresTD = heuresTD;
    }
    public UE(String intitule,int heuresCM,int heuresTD,int heuresTP){
        this(intitule,heuresCM,heuresTD);
        this.heuresTP = heuresTP;
    }

    public String getIntitule() {
        return myIntitule;
    }

    public int getHeuresCM() {
        return heuresCM;
    }

    public int getHeuresTD() {
        return heuresTD;
    }

    public int getHeuresTP() {
        return heuresTP;
    }
}
