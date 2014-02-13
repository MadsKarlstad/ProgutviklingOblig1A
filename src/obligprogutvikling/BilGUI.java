/**
 * Skrevet av: 
 * Mads M Karlstad, studnr: s193949, HINGDATA
 * Erlend Westbye, studnr: s193377, HINGDATA
 * Christoffer B Jønsberg: s193674, HINGDATA
 */

package obligprogutvikling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BilGUI extends JFrame
{
    private JTextField kjennetegnfelt, merkefelt, typefelt, årfelt;
    private JButton regBil, finnBil, fjernBil, visAlle;
    private JTextArea utskriftsområde;
    private Billiste register = new Billiste();
    
    public BilGUI()
    {
        super("BilGUI");
        
        kjennetegnfelt = new JTextField(18);
        merkefelt = new JTextField(18);
        typefelt = new JTextField(18);
        årfelt = new JTextField(18);
        regBil = new JButton("Registrer bil");
        finnBil = new JButton("Finn bil");
        fjernBil = new JButton("Fjern bil");
        visAlle = new JButton("Vis alle registrerte");
        utskriftsområde = new JTextArea(15,45);
        utskriftsområde.setEditable(false);
        
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("Kjennetegn: "));
        c.add(kjennetegnfelt);
        c.add(new JLabel("Merke: "));
        c.add(merkefelt);
        c.add(new JLabel("Type:"));
        c.add(typefelt);
        c.add(new JLabel("Første reg.år: "));
        c.add(årfelt);
        c.add(new JLabel("          "));
        c.add(regBil);
        c.add(finnBil);
        c.add(fjernBil);
        c.add(visAlle);
        c.add(new JScrollPane(utskriftsområde));
        
        Knappelytter lytter = new Knappelytter();
        
        regBil.addActionListener(lytter);
        finnBil.addActionListener(lytter);
        fjernBil.addActionListener(lytter);
        visAlle.addActionListener(lytter);
        setSize(620,500);
        setVisible(true);
    }
    
    public void nyBil()
    {
       String kjennetegn = kjennetegnfelt.getText();
       String merke = merkefelt.getText();
       String type = typefelt.getText();
       String regår = årfelt.getText();
       if(kjennetegn.length() == 0 || merke.length() == 0
	|| type.length() == 0 || regår.length() == 0)
       {
           visMelding("Fyll ut nødvendig informasjon!");
           return;
       }
       try
       {
           register.settInn(
                   new Bil(kjennetegn,merke,type,regår));
           visMelding("Ny bil registrert");
           slettFelter();
       }
       catch(NumberFormatException e)
       {
           visMelding("Feil i tallformat");
       }
    }
    
    public void finnBil()
    {
        String kjennetegn = kjennetegnfelt.getText();
        if(kjennetegn.length() == 0)
        {
            visMelding("Skriv inn regnr plz");
            slettFelter();
        }
        Bil b = register.finn(kjennetegn);
        if(b!=null)
        {
            
            register.skrivListe(utskriftsområde);
            slettFelter();
            
        }
        
        /*try
        {
            
            register.finn(kjennetegn);
        
        }
        catch(NumberFormatException e)
        {
            visMelding("Feil i tallformat");
        }*/
        
    }
    
   public void slettBil()
   {

       String kjennetegn = kjennetegnfelt.getText();
       if(kjennetegn.length() == 0)
       {
            visMelding("Skriv inn regnr plz");
            slettFelter();
       }
       try
       {
           utskriftsområde.setText("");
           register.fjern(kjennetegn);
           slettFelter();
           
       }
       
       catch(NumberFormatException nfe)
       {
           visMelding("Feil i tallformat");
       }
           
       
    }
    public void visRegister()
    {
        utskriftsområde.setText("");
        register.skrivListe(utskriftsområde);
    }
    
    private void visMelding( String melding)
    {
        JOptionPane.showMessageDialog(this,melding);
    }
    
    private void slettFelter()
    {
        kjennetegnfelt.setText( "" );
        merkefelt.setText( "" );
        typefelt.setText( "" );
        årfelt.setText( "" );
    }
    
    
    private class Knappelytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if ( e.getSource() == regBil )
                nyBil();
            else if ( e.getSource() == finnBil )
                finnBil();
            else if ( e.getSource() == fjernBil )
                slettBil();
            else if ( e.getSource() == visAlle )
                visRegister();
        }
    }
}
