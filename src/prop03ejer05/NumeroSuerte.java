package prop03ejer05;

import Sleer2.SLeer2;

/**
 * Clase para crear un número de la suerte según la fecha de nacimiento
 * @author Cristina Franco Esclapez
 * @version 1.0
 * @since version 1.0
 */
public class NumeroSuerte {
    
    int dia;
    int mes;
    int año;
    int numerosuerte;
    
    /**
     * Constructor
     */
    NumeroSuerte(){
    dia=1;
    mes=1;
    año=1;
    }
    
    /**
     * Método para pedir el día de nacimiento
     * @see Sleer2
     * @return día de nacimiento
     * @since version 1.0
     */
        public int pidedia(){
            
            //Importamos un método del paquete Sleer2 el cual no permite introduccir un número entero
            dia=SLeer2.datoInt("\n\nIntroduce el día de tu nacimiento (0 para salir): ");
               
               /*
               Si el día es mayor que 31, se volverá a pedir que se introduzca un 
               número ya que los meses no tienen más de 31 días
               */
               
               while(dia!=0){
               if(dia>31){
                pidedia();
               }else{
                   pidemes();
               }
               }
            
        return dia;
    }
      
   /**
     * Método para pedir el mes de nacimiento
     * @see Sleer2
     * @return mes de nacimiento
     * @since version 1.0
     */
    public int pidemes(){
            
            //Importamos un método del paquete Sleer2 el cual no permite introduccir un número entero
            mes=SLeer2.datoInt("Introduce el mes de tu nacimiento: ");
            
            /*
            Si el mes es mayor que 12, se volverá a pedir que se introduzca un 
            número ya que los años no tienen más de 12 meses
            */
            if(mes>12){
                pidemes();
            }else{
                pideaño();
            }
            
        return mes;
    }
    
    /**
     * Método para pedir el año de nacimiento
     * Importamos un método del paquete Sleer2 el cual no permite introduccir un número entero
     * @see Sleer2
     * @return año de nacimiento
     * @since version 1.0
     */
    public int pideaño(){
            
            //Importamos un método del paquete Sleer2 el cual no permite introduccir un número entero
            año=SLeer2.datoInt("Introduce el año de tu nacimiento: ");
            
            /*
            Si el año es mayor al actual (2021), se volverá a pedir que introduzca 
            otra vez ya que será un nacimiento futuro
            */
            if(año<=2021){
                numero();
            }else{
                System.out.println("Aún no has nacido");
                pideaño();
            }
            
        return año;
    }
       
    
     /**
     * Método que desglosa el numero para sumar día, mes y año y este valor sume cada una de sus cifras
     * @see Sleer2
     * @return valor calculado como número de la suerte
     * @since version 1.0
     */
    public int numero(){
        
        int numero=dia+mes+año;
        
       int cifra1=numero/1000;
       int cifra2=(numero-(cifra1*1000))/100;
       int cifra3=(numero-(cifra1*1000+cifra2*100))/10;
       int cifra4=numero-(cifra1*1000+cifra2*100+cifra3*10);
       
       int suma=cifra1+cifra2+cifra3+cifra4;
       
       if(numero>=10){
           int cifra5=suma/10;
           int cifra6=suma%10;
           numerosuerte=cifra5+cifra6;  
           System.out.print("\n****  Tu número de la suerte es: " + numerosuerte + "  ****"); 
       }else{
           System.out.print("\n****  Tu número de la suerte es: " + suma + "  ****"); 
       }
       pidedia();
       return numerosuerte;        
    }

    public static void main(String[] args) {
        
        NumeroSuerte n;
        n=new NumeroSuerte();
                 
        n.pidedia();  
         
        System.out.println("\n¡¡¡Buena suerte!!!");
    }
          
}
    

