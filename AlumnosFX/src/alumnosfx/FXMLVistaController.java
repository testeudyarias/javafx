/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnosfx;

import Modelo.Alumno;
import java.net.URL;
import javafx.scene.control.Label;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.fxutils.viewer.JasperViewerFX;


/**
 *
 * @author developer
 */
public class FXMLVistaController implements Initializable {
    
    @FXML
    private Label label;
    
     //@FXML private TextField txtTipoTarta, txtNumPer;
    
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //10 estarán matriculados en DI
        alumnos.add(new Alumno("14785236K",	"DI",	7.5,	"Granada"));
        alumnos.add(new Alumno("36985214P",	"DI",	4.2,	"Madrid"));
        alumnos.add(new Alumno("85236974S",	"DI",	9.5,	"Málaga"));
        alumnos.add(new Alumno("32145698T",	"DI",	8.2,	"Granada"));
        alumnos.add(new Alumno("78965432X",	"DI",	3.0,	"Málaga"));
        alumnos.add(new Alumno("35786918F",	"DI",	6.2,	"Vizcaya"));
        alumnos.add(new Alumno("98324561Z",	"DI",	8.6,	"Barcelona"));
        alumnos.add(new Alumno("41638525D",	"DI",	3.9,	"Madrid"));
        alumnos.add(new Alumno("59635741H",	"DI",	3.0,	"Sevilla"));        
        alumnos.add(new Alumno("30310326Y",	"DI",	9.9,	"Barcelona"));

        //6 en PMDM
        alumnos.add(new Alumno("78965431X",	"PMDM",	3.0,	"Málaga"));
        alumnos.add(new Alumno("35786911F",	"PMDM",	6.2,	"Vizcaya"));
        alumnos.add(new Alumno("98324562Z",	"PMDM",	8.6,	"Barcelona"));
        alumnos.add(new Alumno("41638521D",	"PMDM",	3.9,	"Madrid"));
        alumnos.add(new Alumno("59635742H",	"PMDM",	3.0,	"Sevilla"));        
        alumnos.add(new Alumno("35715941V",	"PMDM",	5.7,	"Huelva"));
        
        //5 en AD
        alumnos.add(new Alumno("32145691T",	"AD",	8.2,	"Granada"));
        alumnos.add(new Alumno("78965431X",	"AD",	3.0,	"Málaga"));
        alumnos.add(new Alumno("35786911F",	"AD",	6.2,	"Vizcaya"));
        alumnos.add(new Alumno("98324563Z",	"AD",	8.6,	"Barcelona"));
        alumnos.add(new Alumno("41638521D",	"AD",	3.9,	"Madrid"));
        
        //3 en PSP
        alumnos.add(new Alumno("14785231K",	"PSP",	7.5,	"Granada"));
        alumnos.add(new Alumno("36985211P",	"PSP",	4.2,	"Madrid"));
        alumnos.add(new Alumno("85236971S",	"PSP",	9.5,	"Málaga"));
        
        
        //Ordenamos el arraylist
         Collections.sort(alumnos);
         
         //System.out.println(String.valueOf(alumnos.size())+" alumnos creados correctamente");
        
    }    
    
    
    @FXML
    private void mostrarReporte(ActionEvent event) {
        try {
           // System.out.println(String.valueOf(alumnos.size())+" alumnos creados correctamente");
            //Definimos la coleccion de datos sobre la que se creará el informe
            JRBeanCollectionDataSource beanColDataSource = 
                new JRBeanCollectionDataSource(
                        alumnos.stream()
                                .filter(x->
                                        x.getSiglaModuloMatriculado()
                                                .equals("DI")
                                ).collect(Collectors.toList()));
            
            //Map parameters = new HashMap();
            /* Obtiene el botón(origen) desde el cuál se hizo clic para llamar al método
           generarGráfico y crea un nodo con él*/
            Node source = (Node) event.getSource();
            /* A continuación, obtiene la escena a la que pertenece ese botón, y con la escena
           obtiene la ventana a la que pertenece la misma */
            Stage stage = (Stage) source.getScene().getWindow();

            /* Al final de la ejecución de las dos líneas anteriores, lo que tenemos en la
           variable stage es una referencia de la ventana desde la cuál se hizo clic,
           para que nuestro informe se muestre como una ventana modal asociada a la 
           ventana que lo invocó */
            //Declaramos nuestro visor de informes
            JasperViewerFX viewerfx;

            /* Creamos el visor de informes, pasándole la ventana desde la cual se solicita
           el informe gráfico, un título para ese informe, la ruta de acceso al informe 
           gráfico que debe cargar el visor, un objeto HashMap que el visor necesita
           pero que en este ejercicio no aporta ninguna funcionalidad, y por último nuestro
           origen de datos representado por el beanColDataSource sobre el cual se creará el
           informe,  */
            viewerfx = new JasperViewerFX(stage,
                    "Informe",
                    "/informes/reportealumnos.jasper",
                    new HashMap() , 
                    beanColDataSource);
            
            //Mostramos el informe en el visor
            viewerfx.show();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

}
