package controller;

import Models.FiltrosBusquedas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarController {
    FiltrosBusquedas filtrosBusquedas = new FiltrosBusquedas();

    public void actualizar(JButton btnActualizar, DefaultTableModel model, JTable tblOrdenes){

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrosBusquedas.cargarTablaPrincipal(model,tblOrdenes);

            }

        });
    }
}
