package clientwsgeojson;

import java.io.Serializable;

public class Country implements Serializable{
    
    private String name;
    private String alpha2_code;
    private String alpha3_code;

    public String getName() {
        return name;
    }

    public String getAlpha2_code() {
        return alpha2_code;
    }

    public String getAlpha3_code() {
        return alpha3_code;
    }
    
    
    
}
