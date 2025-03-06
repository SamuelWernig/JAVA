package at.htlle.sam.Carcollection;

public class CarCollectionMannager {
    //Attribute
    private Vehilce[] vehilces;
    private int vehilceCount;
    //Constructor
    public CarCollectionMannager() {
        vehilces = new Vehilce[15];
        vehilceCount = 0;
    }
    //Methods

    public String getVehilces() {
        String vehilcesDetails = "";
        for (int i = 0; i < vehilces.length; i++) {
            if (vehilces[i] != null) {
                vehilcesDetails += vehilces[i].getDetails() + "\n";
            }
        }
        return vehilcesDetails;
    }
    public boolean addVehilce(Vehilce vehilce) {
        if(vehilceCount >= vehilces.length) {
            return false;
        }else{
            vehilces[vehilceCount] = vehilce;
            vehilceCount++;
            return true;
        }

    }
    public boolean removeVehilce(Vehilce vehilce) {
        if(vehilceCount<=0){
            return false;
        }else {
            for(int i=0;i<vehilceCount;i++){
                if(vehilces[i]==vehilce){
                    vehilces[i]=vehilces[vehilceCount];
                    vehilces[vehilceCount]=null;
                    vehilceCount--;
                }
            }
            return true;
        }
    }


}
