package es.uji.al439012.gui.vista;

import es.uji.al439012.gui.controlador.Controlador;

import java.util.List;

public interface InformaVista {

    void showRecommendations(List<String> recommendations);

    public void setControlador(Controlador controlador);

}
