
package Controlador;

import Modelo.MDB;
import Vista.VistaUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Controlador implements ActionListener{
    
    private VistaUser _view;
    private MDB _model;

    @Override
    public void actionPerformed(ActionEvent e) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
     String leyenda="";
     
     if(e.getSource()==_view.cmdAlta){
         leyenda=_model.registrarAlta("tbusuarios",""+_view.txtuser.getText()+",'"+_view.txtpass.getText()+"',"+
               "',"+_view.txtnombre.getText()+"',"+"'"+_view.txtappaterno.getText()+"',null");
                 
           
     JOptionPane.showMessageDialog(null, leyenda);//Se manda mensaje con el resultado de la consulta de inserción
     
     limpiar();//se limpian las cajas de texto
     //agregar otros botones si se necesitan implementar
        
     }
     
     if(e.getSource()==_view.cmdEliminar){
         leyenda = _model.borrarRegistro("TbUsuarios", "id ="+ _view.txtid.getText());
                 
           
     JOptionPane.showMessageDialog(null, leyenda);//Se manda mensaje con el resultado de la consulta de inserción
     
     limpiar();//se limpian las cajas de texto
     //agregar otros botones si se necesitan implementar
        
     }
            if(e.getSource()==_view.cmdActualizar){
            leyenda = _model.modificarRegistro("TbUsuarios", "user='"+_view.txtuser.getText()+"' , psw = '"+_view.txtpass.getText()+"' ,  nombre= '"+_view.txtnombre.getText()+"' , apPaterno='"+_view.txtappaterno.getText()+"'", "id = "+_view.txtid.getText());
            JOptionPane.showMessageDialog(null, leyenda);
         
        limpiar();//se limpian las cajas de texto
     //agregar otros botones si se necesitan implementar
        
        } 
            
            if(e.getSource()==_view.cmdConsultar){
         
         
        
         List<ArrayList<String>> datosObtenidos = _model.consultarDatos("tbUsuarios", "id,psw,nombre,apPaterno,user", "id = "+_view.txtid.getText());
         System.out.println(leyenda);
                  
         DefaultTableModel model=new DefaultTableModel();
         model.addColumn("user");
         model.addColumn("psw");
         model.addColumn("nombre");
         model.addColumn("apPaterno");
         model.addColumn("id");
           
         _view.tabla.setModel(model); 
         
         String dato;
         String [] datos = new String[5];
                  
         int i=0;
    for(i=0;i<datosObtenidos.size();i++)
    {
             ArrayList<String> renglonObtenido = datosObtenidos.get(i);
             int j;
                    for(j=0;j<renglonObtenido.size();j++){
      dato=renglonObtenido.get(j);
                        datos[j]=dato;
                    }
                    model.addRow(datos);
                    System.out.println();
    }
        
      
     }
            
    }
    
    public Controlador(VistaUser view,MDB model){
        this._model=model;
        this._view=view;
        
        this._view.cmdAlta.addActionListener(this);
        this._view.cmdEliminar.addActionListener(this);
        this._view.cmdActualizar.addActionListener(this);
        this._view.cmdConsultar.addActionListener(this);
    }
    
    
    public void iniciar(){
        _view.setTitle("MVC_Visual");
    }
    
    public void limpiar(){
        _view.txtuser.setText(null);
        _view.txtpass.setText(null);
        _view.txtnombre.setText(null);
        _view.txtappaterno.setText(null);
    }
    
    }
    
