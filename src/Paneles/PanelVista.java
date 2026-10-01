package Grafica;

import javax.swing.JPanel;

public abstract class PanelVista extends JPanel {
    protected ControladorVistas controlador_vistas;

    protected PanelVista (ControladorVistas controlador_vistas){
        this.controlador_vistas = controlador_vistas;
    }
}
