package es.uji.al439012.gui.modelo;

import es.uji.al439012.algorithm.Algorithm;

import java.util.List;

public interface CabioModelo {
    List<String> getRecomendacionesDeModelo(String selectedSong, Algorithm algorithm, int numberOfRecommendations) throws Exception;
}
