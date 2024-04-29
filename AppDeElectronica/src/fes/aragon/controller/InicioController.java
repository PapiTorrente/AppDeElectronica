package fes.aragon.controller;

import fes.aragon.mariadb.Conexion;
import fes.aragon.modelo.Cliente;
import fes.aragon.modelo.Producto;
import fes.aragon.modelo.Venta;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

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
    private ListView<Venta> Lista = new ListView<Venta>();

    @FXML
    private ComboBox<Producto> ProductoBox = new ComboBox<Producto>();

    @FXML
    private Menu mnuCrear;

    @FXML
    private MenuItem mnuCrearCliente;

    @FXML
    private MenuItem mnuCrearProveedor;
    
    @FXML
    private MenuItem mnuAgregarProductos;

    @FXML
    private MenuItem mnuDevolución;

    @FXML
    private MenuItem mnuEnvio;

    @FXML
    private Menu mnuOpciones;

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
    void hacerVenta(ActionEvent event){
    	Venta v = new Venta();
    	v.setId_Producto(this.ProductoBox.getSelectionModel().getSelectedItem().getId_Producto());
    	v.setNombre_Producto(this.ProductoBox.getSelectionModel().getSelectedItem().getNombre());
    	v.setPrecio(this.ProductoBox.getSelectionModel().getSelectedItem().getPrecio());
    	v.setCantidad(Integer.parseInt(this.CantidadField.getText()));
    	v.setForma_Pago(this.FormaPagoField.getText());
    	v.setId_Cliente(this.ClienteBox.getSelectionModel().getSelectedItem().getId_Cliente());
    	v.setFecha_Venta(String.valueOf(this.FechaPicker.getValue()));
    	try {
			this.cn.insertarVenta(v);
			this.Lista.setItems(this.cn.obtenerVentas());
		} catch (SQLException e) {
			this.ventanaEmergenteError("Venta", "Error al guardar una venta!!!");
		}
    	this.CantidadField.clear();
    	this.FormaPagoField.clear();
    }

    @FXML
    void abrirClientes(ActionEvent event) { 
    	abrirVentana("Clientes");
    	cerrarVentana("Ventas");
    }
    
    @FXML
    void abrirProveedores(ActionEvent event) { 
    	abrirVentana("Proveedores");
    	cerrarVentana("Ventas");
    }
    
    @FXML
    void abrirProductos(ActionEvent event) {
    	abrirVentana("Productos");
    	cerrarVentana("Ventas");
    }

    @FXML
    void abrirEnvios(ActionEvent event) {
    	abrirVentana("Envios");
    	cerrarVentana("Ventas");
    }
    
    @FXML
    void abrirDevoluciones(ActionEvent event) {
    	abrirVentana("Devoluciones");
    	cerrarVentana("Ventas");
    }
    
    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			System.out.println(this.cn.obtenerProductos());
			this.ProductoBox.getItems().addAll(this.cn.obtenerProductos());
			this.ProductoBox.getSelectionModel().select(0);
			//-----------------------------------------------------
			System.out.println(this.cn.obtenerClientes());
			this.ClienteBox.getItems().addAll(this.cn.obtenerClientes());
			this.ClienteBox.getSelectionModel().select(0);
			//-----------------------------------------------------
			this.FechaPicker.setValue(LocalDate.now());
			//-----------------------------------------------------
			this.Lista.setItems(this.cn.obtenerVentas());
		} catch (SQLException e) {
			this.ventanaEmergenteError("Conexion", "Error en la conexion de la BD!!!");
		}
	}
}
