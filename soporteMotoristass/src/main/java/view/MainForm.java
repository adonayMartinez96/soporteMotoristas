package view;

import Models.OrdenSingleton;
import Models.FiltrosBusquedas;
import Models.Validaciones;
import controller.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class MainForm extends JFrame {
    private JPanel MainPanel;
    private JPanel MainPanel2;

    private JLabel lblName;
    private JTextField txtFechaInicio;
    private JTextField txtFechafin;
    private JTable tblOrdenes;
    private JButton btnBuscar;
    private JTextField txtOrden;
    private JTextField txtMotorista;
    private JButton btnAsignarMotorista;
    private JLabel lblFechaIncio;
    private JLabel lblFechaFin;
    private JLabel lblOrden;
    private JLabel lblMotorista;
    private JButton btnActualizar;
    private JButton btnGenerarExcel;
    private JButton btnAnularOrden;
    private JTextField txtComentario;
    private JLabel lblComentario;
    private JComboBox cbxAnuladas;
    private JButton btnFecha1;
    private JButton btnFechaFinal;


    static Connection con;
    static PreparedStatement pst;
    boolean bandera = false;

    OrdenSingleton ordenEncontradaSingleton = OrdenSingleton.getInstancia();
    Validaciones validaciones = new Validaciones();
    FiltrosBusquedas filtrosBusquedas = new FiltrosBusquedas();
    InvocacionesFechas fechas = new InvocacionesFechas();
    GenerarExcel generarExcel = new GenerarExcel();
    CargaPorDefecto cargaPorDefecto = new CargaPorDefecto();
    FilaObtenidaController filaObtenidaController = new FilaObtenidaController();
    AsignarMotoristaController asignarMotoristaController = new AsignarMotoristaController();
    GenerarExcelController excelController = new GenerarExcelController();
    ActualizarController actualizarController = new ActualizarController();
    BuscarController buscar = new BuscarController();
    AnularOrdenController anularOrdenController = new AnularOrdenController();
    prueba prueba1 = new prueba();
    Fecha2 fecha2 = new Fecha2();

    DefaultTableModel  model = new DefaultTableModel();


    public MainForm(){
        setContentPane(MainPanel);

        setTitle("Soporte");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Obtiene el objeto Toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Obtiene la dimensión de la pantalla
        Dimension screenSize = toolkit.getScreenSize();

        // Obtiene el ancho y alto de la pantalla
        int anchoPantalla = screenSize.width;
        int altoPantalla = screenSize.height;

        setSize(anchoPantalla,altoPantalla-50);
        setLocationRelativeTo(null);
        setVisible(true);

        //establece fecha del sistema a los campos fecha inicial y fecha final por defecto
        cargaPorDefecto.setCamposFehas(txtFechaInicio,txtFechafin);

        //carga lista diaria por defecto
        cargaPorDefecto.loadOrdenes(tblOrdenes,model);

        String valorPorDefecto = (String) cbxAnuladas.getSelectedItem();



        //btnBuscar
        buscar.buscar( btnBuscar, txtFechaInicio, txtFechafin,  txtMotorista, txtOrden, tblOrdenes, model, cbxAnuladas);

        //btnAsignarMotorista
        asignarMotoristaController.asignarMotorista(btnAsignarMotorista,ordenEncontradaSingleton);

        //validaciones campos fechas
        fechas.fecha(txtFechaInicio);
        fechas.fecha(txtFechafin);

        //validacion orden
        validaciones.camposNumericos(txtOrden);

        //obtiene el valor seleccionado
        filaObtenidaController.filaObtenida(tblOrdenes,ordenEncontradaSingleton);

        //btnActualizar lista ventas diarias
        actualizarController.actualizar(btnActualizar,model,tblOrdenes);

        //btnAnularOrden
        anularOrdenController.anularOrden(tblOrdenes,ordenEncontradaSingleton,txtComentario,btnAnularOrden);

        //UAT OFICINA
        //generarExcel.outputeExcel(model,"C:/Users/cliente/Desktop/listaGenerada/lista");

        //PRODUCCION
        //generarExcel.outputeExcel(model,"C:/Users/cliente/Desktop/REPORTES/lista");
        //estado:prod
        
        excelController.generarReporteExcel(btnGenerarExcel,model,"C:/Users/cliente/Desktop/REPORTES/lista");




        btnFecha1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prueba1.mostrar1(txtFechaInicio);

            }
        });
        btnFechaFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecha2.mostrar2(txtFechafin);
            }
        });
    }




    public static void main(String [] args){

        new MainForm();
    }
}

