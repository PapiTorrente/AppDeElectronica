package fes.aragon.controller;

import fes.aragon.mariadb.Conexion;
import fes.aragon.modelo.Cliente;
import fes.aragon.modelo.Producto;
import fes.aragon.modelo.Venta;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
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
import javafx.stage.Stage;

public class InicioController  extends ControlGeneral implements Initializable{
	
	private Conexion cn = this.conexionSQL();
	
	private Stage stage;
	
	private ObservableList<Venta> ventas = FXCollections.observableArrayList();
	
	private Integer indice = -1;
	

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
    private ListView<Venta> Lista = new ListView<Venta>();
    
    @FXML
    private ComboBox<String> PagoBox = new ComboBox<String>();

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
    	for (Venta venta : ventas) {
			try {
				this.cn.insertarVenta(venta);
			} catch (SQLException e) {
				this.ventanaEmergenteError("Venta", "Error al agregar una venta!!!");
			}
		}
    	this.Lista.getItems().clear();
    }

    @FXML
    void abrirClientes(ActionEvent event) { 
    	abrirVentana("Clientes");
    	this.cerrarPantallaPrincipal();
    }
    
    @FXML
    void abrirProveedores(ActionEvent event) { 
    	abrirVentana("Proveedores");
    	this.cerrarPantallaPrincipal();
    }
    
    @FXML
    void abrirProductos(ActionEvent event) {
    	abrirVentana("Productos");
    	this.cerrarPantallaPrincipal();
    }

    @FXML
    void abrirEnvios(ActionEvent event) {
    	abrirVentana("Envios");
    	this.cerrarPantallaPrincipal();
    }
    
    @FXML
    void abrirDevoluciones(ActionEvent event) {
    	abrirVentana("Devoluciones");
    	this.cerrarPantallaPrincipal();
    }
    
    @FXML
    void agregarProducto(ActionEvent event) {
    	if(this.PagoBox.getSelectionModel().getSelectedIndex() != 0) {
    		if(this.indice == -1) {
    			this.indice = this.ClienteBox.getSelectionModel().getSelectedIndex();
    			this.agregarVentaALista();
            	this.CantidadField.clear();
    		}else {
    			if(this.indice == this.ClienteBox.getSelectionModel().getSelectedIndex()) {
    				this.agregarVentaALista();
                	this.CantidadField.clear();
    			}else {
    				this.indice = this.ClienteBox.getSelectionModel().getSelectedIndex();
    				this.Lista.getItems().clear();
    				this.ventas.clear();
    				this.agregarVentaALista();
    			}
    		}
        }else {
        	this.ventanaEmergenteError("Venta", "Selecciona una forma de pago valida!!!");
    	}
    }
    
    @FXML
    void cerrarVentana(ActionEvent event) {
    	this.cerrar(BtnSalir);
    }
    
    public void cerrarPantallaPrincipal() {
    	stage = (Stage) this.BtnAgregarProducto.getScene().getWindow();
    	stage.close();
    }
    
    public void agregarVentaALista() {
    	Venta v = new Venta();
    	v.setId_Producto(this.ProductoBox.getSelectionModel().getSelectedItem().getId_Producto());
    	v.setNombre_Producto(this.ProductoBox.getSelectionModel().getSelectedItem().getNombre());
    	v.setPrecio(this.ProductoBox.getSelectionModel().getSelectedItem().getPrecio());
    	v.setCantidad(Integer.parseInt(this.CantidadField.getText()));
    	v.setForma_Pago(this.PagoBox.getValue());
    	v.setId_Cliente(this.ClienteBox.getSelectionModel().getSelectedItem().getId_Cliente());
    	v.setFecha_Venta(String.valueOf(this.FechaPicker.getValue()));
    	this.ventas.add(v);
    	this.Lista.getItems().add(0, v);
    	this.CantidadField.clear();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			this.PagoBox.getItems().addAll("Forma de pago:", "Efectivo", "Tarjeta");
			this.PagoBox.getSelectionModel().select(0);
			//-----------------------------------------------------
			this.ProductoBox.getItems().addAll(this.cn.obtenerProductos());
			this.ProductoBox.getSelectionModel().select(0);
			//-----------------------------------------------------
			this.ClienteBox.getItems().addAll(this.cn.obtenerClientes());
			this.ClienteBox.getSelectionModel().select(0);
			//-----------------------------------------------------
			this.FechaPicker.setValue(LocalDate.now());
			//-----------------------------------------------------
		} catch (SQLException e) {
			this.ventanaEmergenteError("Conexion", "Error en la conexion de la BD!!!");
		}
	}
}
