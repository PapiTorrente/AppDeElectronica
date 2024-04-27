package fes.aragon.controller;

import fes.aragon.mariadb.Conexion;
import fes.aragon.modelo.Cliente;
import fes.aragon.modelo.Producto;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class InicioController  extends ControlGeneral implements Initializable{
	
	private Conexion cn = this.conexionSQL();

    @FXML
    private Button BtnAgregarProducto;

    @FXML
    private Button BtnHacerVenta;

    @FXML
    private Button BtnSalir;

    @FXML
    private TextField CantidadField;

    @FXML
    private ComboBox<Cliente> ClienteBox = new ComboBox<Cliente>();

    @FXML
    private DatePicker FechaPicker = new DatePicker();

    @FXML
    private TextField FormaPagoField;

    @FXML
    private ListView<?> Lista;

    @FXML
    private ComboBox<Producto> ProductoBox = new ComboBox<Producto>();

    @FXML
    private Menu mnuCliente;

    @FXML
    private MenuItem mnuDevolución;

    @FXML
    private MenuItem mnuEnvio;

    @FXML
    private Menu mnuOpciones;

    @FXML
    private Menu mnuProveedor;

    @FXML
    private Label txtCantidad;

    @FXML
    private Label txtCliente;

    @FXML
    private Label txtFechaVenta;

    @FXML
    private Label txtFormaPago;

    @FXML
    private Label txtProducto;

    @FXML
    void abrirClientes(ActionEvent event) { 
    	nuevaVentana("Clientes");
    }

    @FXML
    void abrirEnvios(ActionEvent event) {
    	nuevaVentana("Envios");
    }
    
    @FXML
    void cerrarVentana(ActionEvent event) {
    	cerrar(BtnSalir);
    }
    
    private Conexion conexionSQL() {
		try {
			return new Conexion();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			this.ProductoBox.getItems().addAll(this.cn.obtenerProductos());
			this.ProductoBox.getSelectionModel().select(0);
			ObservableList<Cliente> c = this.cn.obtenerClientes();
			this.ClienteBox.getItems().addAll(c);
			this.ClienteBox.getSelectionModel().select(0);
			this.FechaPicker.setValue(LocalDate.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
