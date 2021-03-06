import DBUtilitie.DBType;
import DBUtilitie.DBUtilities;
import DBUtilitie.RegistroCombobox;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class Proceso_pilon extends Aplicacion_principal implements Initializable, RegistroCombobox {
    public Label lbl_id_procesopilon;
    public Label lbl_id_proceso_pilon;
    public Label lbl_fecha_proceso;
    public Label lbl_id_remi;
    public Label lbl_entradas_salidas;
    public Label lbl_subtotal;
    public Label lbl_total_libras;
    public JFXDatePicker date_fecha_proceso;
    public JFXTextField txt_id_remision_pilon;
    public JFXTextField txt_entradas_salidas;
    public JFXTextField txt_subtotal;
    public JFXTextField txt_total_libras;
    public JFXButton btn_guardar_proceso_pilon;
    public JFXButton btn_actualizar_proceso_pilon;
    public StackPane stack_proceso_pilon;
    public CheckBox cbx_nombre_tabaco;
    public CheckBox cbx_numero_pilon;
    public Label lbl_nombre_tab;
    public Label lbl_numero_pilon;
    public Label lbl_total_remision;
    public JFXTextField txt_total_remision;
    public JFXCheckBox cbx_tabla_proceso;
    public JFXCheckBox cbx_tabla_pilon;
    public DBUtilities db = new DBUtilities(DBType.MARIADB);
    public JFXTextField txt_nombre_tabaco;
    public JFXTextField txt_numero_pilon;


    @Override
    public void start(Stage primaryStage) throws Exception {
        super.start(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("/proceso_pilon.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setTitle("Registro de proceso");
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    solo_numeros(txt_id_remision_pilon,4);
    solo_letras(txt_entradas_salidas,35);
    soloNumerosyunPunto(txt_subtotal,3,6);
    soloNumerosyunPunto(txt_total_libras,3,6);
    soloNumerosyunPunto(txt_total_remision,3,6);


    }

    public void guardar(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        boton_guardar();
        Object[] campos = { date_fecha_proceso, txt_id_remision_pilon, txt_entradas_salidas,
                txt_nombre_tabaco, txt_subtotal, txt_total_libras,txt_total_remision};


        if (cbx_tabla_proceso.isSelected()){
            String[] mensaje = db.insert("insertar_tabla_procesos",campos) ;
            if (mensaje[1].equals("1")){
                mensaje("Confirmaci\u00f3n", mensaje[0]
                        ,stack_proceso_pilon);
                btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                    try {
                        SidePanelController.datos_tabla_entradas_salidas();
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });
            }else{
                mensaje("Error", mensaje[0]
                        ,stack_proceso_pilon);
                btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    try {
                        SidePanelController.datos_tabla_entradas_salidas();
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });
            }
            System.out.println(Arrays.toString(campos));
        }else if ( cbx_tabla_pilon.isSelected()){

            String[] mensaje = db.insert("insertar_tabla_pilon",campos) ;
            if (mensaje[1].equals("1")){
                mensaje("Confirmaci\u00f3n", mensaje[0]
                        ,stack_proceso_pilon);btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                    try {
                        SidePanelController.datos_tabla_entradas_salidas();
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });
            }else{
                mensaje("Error", mensaje[0]
                        ,stack_proceso_pilon);btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    try {
                        SidePanelController.datos_tabla_entradas_salidas();
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });

            }
        }
    }

    public void Actualizar_proceso(ActionEvent actionEvent) {
        boton_guardar();
        Object[] campos = {lbl_id_proceso_pilon,date_fecha_proceso, txt_id_remision_pilon, txt_entradas_salidas,
                txt_nombre_tabaco, txt_subtotal, txt_total_libras,txt_total_remision};


        if (cbx_tabla_proceso.isSelected()){
            String[] mensaje = db.insert("actualizar_tabla_proceso",campos) ;
            if (mensaje[1].equals("1")){
                mensaje("Confirmaci\u00f3n", mensaje[0]
                        ,stack_proceso_pilon);
                btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                    try {
                        SidePanelController.datos_tabla_entradas_salidas();
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });
            }else{
                mensaje("Error", mensaje[0]
                        ,stack_proceso_pilon);
                btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    try {
                        SidePanelController.datos_tabla_entradas_salidas();
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });
            }
            System.out.println(Arrays.toString(campos));
        }else if ( cbx_tabla_pilon.isSelected()){

            String[] mensaje = db.insert("actualizar_tabla_pilon",campos) ;
            if (mensaje[1].equals("1")){
                mensaje("Confirmaci\u00f3n", mensaje[0]
                        ,stack_proceso_pilon);btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                    try {
                        SidePanelController.datos_tabla_entradas_salidas();
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });
            }else{
                mensaje("Error", mensaje[0]
                        ,stack_proceso_pilon);btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    try {
                        SidePanelController.datos_tabla_entradas_salidas();
                    } catch (Exception throwables) {
                        throwables.printStackTrace();
                    }

                });

            }
        }
    }
    private void boton_guardar() {
        btn_mensaje.setOnAction(event -> {
            dialogo.close();

            try {
                SidePanelController.datos_tabla_entradas_salidas();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }

        });
    }

    public void abrir_tabla_tabaco(ActionEvent actionEvent) throws IOException {
        FXMLLoader vista_tabla_tabaco = new FXMLLoader(getClass().getResource("/tabla_clase_tabaco.fxml"));

        StackPane root = vista_tabla_tabaco.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setTitle("Agregar tabaco");
        tabla_clase_tabaco controlador = vista_tabla_tabaco.getController();
        controlador.registrocontroller(this);
        controlador.btn_guardar_claseTab_entradas_pilones.setVisible(false);
        controlador.btn_actualizar_claseTab_entradas_pilones.setVisible(false);
        controlador.btn_guardar_Tab_control_pilones.setVisible(false);
        controlador.btn_actualizar_Tab_control_pilones.setVisible(false);
        controlador.Ocultar_botones();
        stage.show();

    }

    private void Calcular_existencia(){
        String entradas_salidas;
        double subtotal = 0.00;
        double cant_lbs = 0.00;
        String total_neto ;
        double total = 0.00;

        entradas_salidas = txt_entradas_salidas.getText();
        subtotal = Double.parseDouble(txt_subtotal.getText());
        //System.out.println(txt_entradas_salidas.getText()+txt_subtotal.getText()+txt_total_libras.getText());
        cant_lbs = Double.parseDouble(txt_total_libras.getText());
       // System.out.println(cant_lbs);
        if(entradas_salidas.contains("A ") || entradas_salidas.contains("a ")){
            if(cant_lbs<=subtotal){
            total = subtotal - cant_lbs;

            total_neto = String.valueOf(total);
            txt_total_remision.setText(total_neto);
            }else{
                mensaje("error", "No puede calcular", stack_proceso_pilon);
                btn_mensaje.setOnAction(event -> {
                    dialogo.close();
                    txt_total_libras.setText("");
                    txt_total_remision.setText("");


            });
            }

        }else if(entradas_salidas.contains("De ") || entradas_salidas.contains("DE ")|| entradas_salidas.contains("de ") ){
            total = subtotal + cant_lbs;
            total_neto = String.valueOf(total);
            txt_total_remision.setText(total_neto);
        }

    }




    @Override
    public JFXTextField cargar_datos_tabaco() {
        return txt_nombre_tabaco;
    }

    @Override
    public JFXTextField cargar_datos_pilon() {
        return txt_numero_pilon;
    }

    @Override
    public JFXTextField cargar_datos_entrada_tabaco() {
        return null;
    }

    @Override
    public JFXTextField cargar_datos_entrada_pilon() {
        return null;
    }

    @Override
    public JFXTextField cargar_datos_tab_control_pilones() {
        return null;
    }

    @Override
    public JFXTextField cargar_datos_pilones_control_pilones() {
        return null;
    }

    @Override
    public JFXTextField cargar_total_actual() {
        return null;
    }


    public void Sub_total(KeyEvent keyEvent) {
        Calcular_existencia();
    }

    public void Cant_lbs(KeyEvent keyEvent) {
        Calcular_existencia();
    }

    public void Entradas_Salidas(KeyEvent keyEvent) {
        Calcular_existencia();
    }

    public void borra_lbs(MouseEvent mouseEvent) {
        txt_total_libras.setText("");
    }

    public void abandona_lbs(MouseEvent mouseEvent) {
        if (txt_total_libras.getText().equals("")){
            txt_total_libras.setText("0.00");
        }
    }
}

