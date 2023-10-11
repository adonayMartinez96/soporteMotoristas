package controller;

import Models.OrdenSingleton;
import Models.Validaciones;
import view.MotoristaModal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsignarMotoristaController {
    Validaciones validaciones = new Validaciones();

    public void asignarMotorista(JButton btnAsignarMotorista, OrdenSingleton ordenEncontradaSingleton){

        btnAsignarMotorista.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                MotoristaModal modal= new MotoristaModal();
                modal.setVisible(true);
                validaciones.validarSeleccionOrden(ordenEncontradaSingleton);
            }
        });
    }
}
