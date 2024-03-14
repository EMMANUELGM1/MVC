
package mvc_emma;

import Controlador.Controlador;
import Modelo.MDB;
import Vista.VistaUser;


public class MVC_EMMA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    VistaUser objV = new VistaUser();
    MDB objM = new MDB();
    objV.setVisible(true);
    Controlador objC = new Controlador(objV,objM); 
               
    }
    
}
