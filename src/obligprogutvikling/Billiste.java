/**
 * Skrevet av: 
 * Mads M Karlstad, studnr: s193949, HINGDATA
 * Erlend Westbye, studnr: s193377, HINGDATA
 * Christoffer B Jønsberg: s193674, HINGDATA
 */

package obligprogutvikling;

import javax.swing.JTextArea;

public class Billiste 
{
    private Bil første;
    
    public void settInn(Bil ny)
    {
        if(første==null)
        {
            første = ny;
            return;
        }
        else
        {
            Bil løper = første;
            while(løper.neste != null)
            {
                løper = løper.neste;
            }
            løper.neste = ny;
        }
        
        
    }
    public Bil finn(String kjennetegn)
    {
                Bil løper = første;
        while(løper != null){
            if((løper.getKjennetegn()).equalsIgnoreCase(kjennetegn)){
                return løper;
            }
            else{
                løper = løper.neste;
            }
        }
        return null;
        
    }
       
        public Bil fjern( String kjennetegn )
        {
            if( første == null ) 
                return null;

            if( første.getKjennetegn().equals( kjennetegn ) )
            {
                Bil retur = første;
                første = første.neste;
                return retur;
            }

            Bil løper = første;

            while( løper.neste != null )
            {
                if( løper.neste.getKjennetegn().equals( kjennetegn ) )
                {
                    Bil retur = løper.neste;
                    løper.neste = løper.neste.neste;
                    return retur;
                }
                else
                løper = løper.neste;
                }

            return null;
  }
        
  public void skrivListe(JTextArea biler)
  {
        if(første==null)
            biler.append("Ingen biler registrert.");
        else
        {
            //biler.setText("");
            Bil løper = første;
            while(løper!=null)
            {
                biler.append(løper.toString() + "\n\n");
                løper = løper.neste;
            }
        }
    }
}
