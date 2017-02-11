/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lectura;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author German
 */
public class Leer  extends DefaultHandler{

    public ArrayList<Casillas> casilla =  new ArrayList<Casillas>();
    public ArrayList<String> dicci =  new ArrayList<String>();

    public ArrayList<Casillas> getCasilla() {
        return casilla;
    }

    public ArrayList<String> getDicci() {
        return dicci;
    }
    
    private Casillas casillas;
    String doblar="";
    String di ="";
    String x = "";
    String y = "";
    
    private StringBuilder buffer = new StringBuilder();
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
     buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       switch(qName)
       {
            case "dimension": 
                di = buffer.toString();
                System.out.println("\ndimension: "+di);
                break;
           
            case "x":
               
                x = buffer.toString();
                break;
            case "y":
               
                y = buffer.toString();
                casillas.setX(x);
                casillas.setY(y);
                casillas.setValor(doblar);
                
                System.out.println("x: "+x +" y: "+y+" "+"valor: "+doblar);
            
                break;
            
            case "palabra":
                  System.out.println("palabra = "+buffer.toString() );
                  dicci.add(buffer.toString());
                break;
       } 
        
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
         
        switch(qName)
        {
            case "dimension":
                buffer.delete(0, buffer.length());
                break;
            case "casillas":
             
            case "dobles": 
                doblar ="2";
                System.out.println("Casillas dobles:");
                break;
            case "triples":
                doblar ="3"; 
                System.out.println("Casillas Triples:");   
                break;        
            case "x":
                casillas = new Casillas();
                casilla.add(casillas);
                buffer.delete(0, buffer.length());
                break;
            case "y":
                buffer.delete(0, buffer.length());
                break;
            case "diccionario":
                  System.out.println("Diccionario");
                break; 
            case "palabra": 
                buffer.delete(0, buffer.length());
                break;
        }
    }
    
   
}