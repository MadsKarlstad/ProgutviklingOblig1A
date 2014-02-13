/**
 * Skrevet av: 
 * Mads M Karlstad, studnr: s193949, HINGDATA
 * Erlend Westbye, studnr: s193377, HINGDATA
 * Christoffer B Jønsberg: s193674, HINGDATA
 */
package obligprogutvikling;

public class Bil 
{
    private String kjennetegn;
    private String merke;
    private String type;
    private String regår;
    
    Bil neste;
    
    public Bil(String k, String m, String t, String r)
    {
        kjennetegn = k;
        merke = m;
        type = t;
        regår = r;
    }
    
    public String getKjennetegn()
    {
        return kjennetegn;
    }
    
    public String toString()
    {
        String s = "Kjennetegn: " + kjennetegn;
        s += "\nMerke: " + merke;
        s += "\nType: " + type;
        s += "\nFørst registrert: " + regår;
        return s;
    }

}
