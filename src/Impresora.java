//import algo.*; Por ahora no importa nada

/**
 * Un ejemplo que modela una Impresora usando POO
 * 
 * @author (Milton Jesús Vera Contreras)
 * @version (Double.MIN_VALUE) Agosto 2005 / Septiembre 20007
 */
public class Impresora
{
  /**Cantidad de tinta en mililitros*/
  //COMPLETE
  int tinta;

  /**Cantidad de hojas*/
  //COMPLETE
  int hojas;
  
  /**Cantidad de páginas por imprimir*/
  //COMPLETE
  int pag;
  
  int paginas_pendientes;
  boolean atascada_papel = false;
  boolean atascada_tinta = false;
  
  /**Constructor por defecto*/
  public Impresora()
  {
    //COMPLETE
    this.paginas_pendientes = 0;
  }//Fin constructor por defecto
  
  /**Constructor con parámetros*/
  public Impresora(int tinta, int hojas)
  {
    //COMPLETE
    this.paginas_pendientes = 0;
  }//Fin constructor con parámetros
  
  /**Metodo de acceso a la propiedad hojas*/
  public int getHojas()
  {
    //COMPLETE
    return this.hojas;
  }//fin getHojas
  
  /**Metodo de acceso a la propiedad tinta*/
  public int getTinta()
  {
    //COMPLETE
    return this.tinta;
  }//fin getTinta  
  
  /**Metodo para modificacion de propiedad tinta*/
  public void recargarTinta(int tinta)
  {
    //COMPLETE
    this.tinta += tinta;
  }//fin setTinta
  
  /**Metodo para modificacion de propiedad hojas*/
  public void recargarHojas(int hojas)
  {
    //COMPLETE
    this.hojas += hojas;
  }//fin setHojas
  
  /**Imprime una página*/
  private void imprimir()
  {
    //COMPLETE  
    this.hojas -=  1;
    this.tinta -= 10;
      
  }//fin m�todo imprimir
  
  /**Imprime varias páginas*/
  public void imprimir(int paginas)
  {
    //COMPLETE
    if (this.paginas_pendientes > 0) {
        paginas += this.paginas_pendientes;
        this.paginas_pendientes = 0;
        this.atascada_tinta = false;
        this.atascada_papel = false;
    }
    for(int i = 1; i<=paginas; i++) {
        if (this.tienePapel()) {
            if (this.tieneTinta()) {
                this.imprimir();
            } else {
                this.atascada_tinta = true;
                this.paginas_pendientes += 1;
            }
        } else {
            this.atascada_papel = true;
            this.paginas_pendientes += 1;
        }  
    }
    if(this.paginas_pendientes > 0) {
        if(this.atascada_papel) {
            System.out.println("Atascada por papel");
        }
        if(this.atascada_tinta) {
            System.out.println("Atascada por tinta");
        }  
    }
  }//fin imprimir
  
  /**Averigua si la impresora tiene papel*/
  public boolean tienePapel()
  {
    //COMPLETE
    return this.hojas > 0;
  } //fin tienePapel
  
  public boolean tieneTinta()
  {
    //COMPLETE
    return this.tinta >= 10;
  } //fin tieneTinta
  
  public boolean tienePaginasPendientesPorImprimir()
  {
    //COMPLETE
    return this.paginas_pendientes > 0;
  } // hayPaginasPendientesPorImprimir
  
  public int getPaginasPendientesPorImprimir()
  {
    //COMPLETE
    return this.paginas_pendientes;
  }//hayPaginasPendientesPorImprimir  
  
  public boolean estaAtascadaPorPapel()
  {
    //COMPLETE
    return atascada_papel;
  }//fin estaAtascadaPorHojas
  
  public boolean estaAtascadaPorTinta()
  {
    //COMPLETE
    return atascada_tinta;
  }//fin estaAtascadaPorTinta
  
}//fin clase Impresora
