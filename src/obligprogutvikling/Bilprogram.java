
package obligprogutvikling;

import java.awt.event.*;

public class Bilprogram 
{
    public static void main(String[]args)
    {
        BilGUI vindu = new BilGUI();
        vindu.addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
    }

}
