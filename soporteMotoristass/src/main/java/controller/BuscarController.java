package controller;

import Models.FiltrosBusquedas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarController {
    FiltrosBusquedas filtrosBusquedas = new FiltrosBusquedas();

    public void buscar(JButton btnBuscar, JTextField txtFechaInicio, JTextField txtFechafin, JTextField txtMotorista, JTextField txtOrden, JTable tblOrdenes, DefaultTableModel model){
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtFechaInicio.getText().length()>0  && txtFechafin.getText().length()>0  && txtMotorista.getText().length()==0 && txtOrden.getText().length()==0) {
                    filtrosBusquedas.ordenesPorFechas(txtFechaInicio, txtFechafin, tblOrdenes,model);
                    System.out.println("1 exec");
                }else if(txtFechaInicio.getText().length()>0  && txtFechafin.getText().length()>0  && txtMotorista.getText().length()>0 ){
                    filtrosBusquedas.ordenesPorMotorista(txtFechaInicio, txtFechafin, txtMotorista,tblOrdenes,model);
                    System.out.println("2 exec");
                }else if(txtFechaInicio.getText().length()>0  && txtFechafin.getText().length()>0  && txtMotorista.getText().length()==0 && txtOrden.getText().length()>0){

                    filtrosBusquedas.ordenPorNoOrden(txtFechaInicio,txtFechafin,txtOrden,tblOrdenes,model);
                    System.out.println("3 exec");
                }
            }
        });
    }

}
