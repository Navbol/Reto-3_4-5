/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ClsVotante;
import Clases.ClsMensaje;
import Modelos.MdlVotante;
import java.util.LinkedList;

/**
 *
 * @author Jirs bautista
 */
public class CtlVotante {

    MdlVotante modelovotante;

    public CtlVotante() {
        this.modelovotante = new MdlVotante();
    }

    public LinkedList<ClsVotante> Obtenervotante() {

        LinkedList<ClsVotante> listavotante = this.modelovotante.Obtenervotante();
        return listavotante;
    }

    public ClsMensaje agregarvotante(ClsVotante votante) {

        ClsMensaje mensaje = this.modelovotante.agregarvotante(votante);

        return mensaje;
    }

    public ClsMensaje eliminarvotante(String id) {

        ClsMensaje mensaje = this.modelovotante.eliminarvotante(id);

        return mensaje;
    }

    public ClsMensaje actualizarvotante(ClsVotante votante) {

        ClsMensaje mensaje = this.modelovotante.actualizarvotante(votante);

        return mensaje;
    }

}
