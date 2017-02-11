/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaCircular;
import java.io.File;
import java.io.FileWriter;
import ListaSimple.NodoSimple;
import java.io.PrintWriter;

/**
 *
 * @author German
 */
public class ListaCircular {
    
    private NodoCircular inicio;
    private NodoCircular ultimo;
    private int tamaño;
    
   public  String tempFolder = System.getProperty("java.io.tmpdir");
   
    public void Lista()
    {
      inicio = null;
      ultimo = null;
      tamaño = 0;
    }
    
    
    public boolean EsVacio()
    {
      return inicio == null;
    }
    
    public int getTamaño()
    {
      return tamaño; 
    }
    
    
    public void AgregarAlFinal(int valor, String nombre)
    {
        
       NodoCircular nuevo = new NodoCircular();
       nuevo.setNombre(nombre);
       nuevo.setValor(valor);
       
       if(EsVacio())
       {
          inicio = nuevo;
          ultimo = nuevo;   
          ultimo.setSiguiente(inicio);
       }
       else
       {
         ultimo.setSiguiente(nuevo);
         nuevo.setSiguiente(inicio);
         ultimo = nuevo;
       }
       tamaño++;
    
    }
    
    
    
    public void InsertarInicio(int valor , String nombre)
    {
    NodoCircular  nuevo = new NodoCircular();
    
    nuevo.setNombre(nombre);
    nuevo.setValor(valor);
    
    if(EsVacio())
    {
      inicio = nuevo;
      ultimo = nuevo; 
      ultimo.setSiguiente(inicio);
    }
    else
    {
       nuevo.setSiguiente(inicio);
       inicio = nuevo;
       ultimo.setSiguiente(inicio);
    }
    tamaño++;
    }
    
    
    public boolean buscar(String nombre)
    {
    
    NodoCircular aux = inicio;
    
    boolean existe = false;
   
    if(inicio == null)
    {
       return  existe;
    }
    else{
        
    do{
            if(nombre == null ? aux.getNombre() == null : nombre.equals(aux.getNombre()))
            {
              existe = true;
            }
            else
            {
              aux = aux.getSiguiente();
            }
        
    }while(aux != inicio && existe !=true);
    
     return existe;
     
    }
      
    }
       
 
    public void Reportar()
    {   
        if(!EsVacio())
        {
            NodoCircular aux = inicio;
            int i =0;
            System.out.println("Jugadores Existentes:");
            do {
                System.out.println(i +" .[ "+aux.getNombre()+ "]");
                aux = aux.getSiguiente();
                i++;
            } while (aux !=inicio);
            
        }
     
    } 
    
    public void EliminarLista()
    {
     inicio = null;
     ultimo = null;
     tamaño = 0;
    }
    
    
    
    public void Escribir()
    {
    
    FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("grafico1.txt");
            pw = new PrintWriter(fichero);

            
            pw.println("digraph G{");
             pw.println("rankdir = TB;");
              pw.println("node[shape=box, style=filled ,width=1.10, fillcolor=azure1, color =blue]");
               pw.println("subgraph cluster_0{");
                
                 NodoCircular aux = inicio;
                 NodoCircular aux2 = inicio;
                
                 do{ 
                     pw.println("nodo"+aux.getNombre()+"[ label = \"Usuario: "+aux.getNombre()+"\"]");
                    
                 aux = aux.getSiguiente();
                
                } while (aux !=inicio);
                 
                  do{ 
                     pw.println("nodo"+aux2.getNombre()+"-> nodo"+aux2.getSiguiente().getNombre());
                    
                 aux2 = aux2.getSiguiente();
                
                } while (aux2 !=inicio); 
                 
                 
          
              pw.println( " [ label = \" Lista De Usuarios\"]");
                pw.println("}");
                  pw.println("}");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        
        doDot("grafico1.txt","grafico1.jpg");
    }
    
    public  void doDot( String pInput, String pOutput ) {
        try {

            String dotPath =
                "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = pInput;
            String fileOutputPath = pOutput;

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        
         /* 
        try {
            
         
            String[] cmd = new String[4];
            cmd[0] = "cmd";
            cmd[1] = "/C";
            cmd[2] = "start";
            cmd[3] = pOutput;
            
            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }        
          
                 */
    }
                 
                 
                 
    
    
}
