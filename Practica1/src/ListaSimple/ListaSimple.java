/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimple;

/**
 *
 * @author German
 */
public class ListaSimple {
    
    private NodoSimple inicio;
    private int tamaño;

    public ListaSimple() {
        inicio = null;
        tamaño = 0;
    }
    
    public boolean  EsVacia()
    {
      return inicio == null;
    }
    
    public int getTamaño()
    {
      return tamaño;
    }
    
    
    public  void InsertarAlFinal(String ficha, int valor)
    {
    
    NodoSimple nuevo = new NodoSimple();
    
    nuevo.setFicha(ficha);
    nuevo.setValor(valor);
    
        if(EsVacia())
        {
          inicio = nuevo;
        }
        else
        {
            NodoSimple aux = inicio;   
            while(aux.getSiguiente() !=null)
            {
               aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        
    tamaño++;
    }
    
    public void  InsertarAlInicio( String ficha, int valor)
    {
     NodoSimple nuevo = new NodoSimple();
     nuevo.setFicha(ficha);
     nuevo.setValor(valor);
     
     if(EsVacia())
     {
      inicio= nuevo;
     }
     else
     {
      nuevo.setSiguiente(inicio);
      inicio = nuevo;
     
     }
     tamaño++;
    }
    
    
    public boolean  Buscar(String ficha)
    {
     NodoSimple aux = inicio;
     
     boolean  existe = false;
     
     while(aux !=null && existe !=true)
     {
       if(ficha == aux.getFicha())
       {
          existe = true;
       }
       else
       {
        aux = aux.getSiguiente();
       }   
         
     }
        return existe;
    }
    
    public void EliminarFicha(String Ficha)
    {
      if(Buscar(Ficha))
      {
         inicio = inicio.getSiguiente();
      
      }
      else
      {
         NodoSimple aux = inicio;
         
         while(aux.getSiguiente().getFicha() != Ficha)
         {
            aux = aux.getSiguiente();
         }
         NodoSimple siguiente = aux.getSiguiente().getSiguiente();
         
          aux.setSiguiente(siguiente);
      }    
       tamaño--;
    } 
    
    
    
}
