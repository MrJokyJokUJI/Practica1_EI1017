// TODO: Remplazar <nombre> por el nombre de tu paquete
package es.uji.al439012.recSys;

// TODO: Pon los imports especificos a tu proyecto

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.uji.al439012.table.Table;
import es.uji.al439012.algorithm.Algorithm;
import es.uji.al439012.csv.CSV;
import es.uji.al439012.kmeans.KMeans;
import es.uji.al439012.knn.KNN;
import es.uji.al439012.excepciones.LikedItemNotFoundException;
import es.uji.al439012.recSys.RecSys;

import static org.junit.jupiter.api.Assertions.*;

class RecSysTest {

    private String separator = System.getProperty("file.separator");
    // TODO: cambiar ruta si hace falta
    private String songsFolder = "recommender";

    private RecSys recSys;
    private Algorithm algorithm;

    private Table trainTable;
    private Table testTable;
    private List<String> testItemNames;

    private int numRecommendations = 5;

    @AfterEach
    void tearDown() {
        algorithm = null;
        recSys = null;
        trainTable = null;
        testTable = null;
        testItemNames = null;
    }

    @Nested
    class KNNRecSys {

        @BeforeEach
            // TODO: añadir o eliminar excepciones según tu implementación
        void setUp() throws Exception {
            trainTable = new CSV().readTableWithLabels(songsFolder + separator + "songs_train.csv");
            testTable = new CSV().readTableWithLabels(songsFolder + separator + "songs_test.csv");
            testItemNames = readNames(songsFolder + separator + "songs_test_names.csv");

            algorithm = new KNN();
            recSys = new RecSys(algorithm);
            recSys.train(trainTable);
            recSys.initialise(testTable, testItemNames);
        }

        @Test
        @DisplayName("RecSys[KNN] - estimate")
        void estimate() throws LikedItemNotFoundException {
            List<String> recommendations = recSys.recommend("The Weekend", numRecommendations);

            assertEquals(numRecommendations, recommendations.size());
            assertFalse(recommendations.contains("The Weekend"));
        }

        @Test
        @DisplayName("RecSys[KNN] - estimate: liked item not returned")
        void estimate_likedItemNotInRecommendation() throws LikedItemNotFoundException {
            List<String> recommendations = recSys.recommend("Inside Out", numRecommendations);

            assertEquals(numRecommendations, recommendations.size());
            assertFalse(recommendations.contains("Inside Out"));
        }

        @Test
        @DisplayName("RecSys[KNN] - estimate: liked item not found")
        void estimate_likedItemNotFound() {
            assertThrows(LikedItemNotFoundException.class, () -> recSys.recommend("Inside Ouuuut", numRecommendations));
        }

        @Test
        @DisplayName("RecSys[KNN] - estimate: número de recomendaciones negativo")
        void estimate_negativeRecommendations() {
            assertThrows(IllegalArgumentException.class, () -> recSys.recommend("The Weekend", -1));
        }

        @Test
        @DisplayName("RecSys[KNN] - estimate: número de recomendaciones cero")
        void estimate_zeroRecommendations() throws LikedItemNotFoundException {
            List<String> recommendations = recSys.recommend("The Weekend", 0);
            assertTrue(recommendations.isEmpty());
        }

        @Test
        @DisplayName("RecSys[KNN] - estimate: número de recomendaciones mayor que items disponibles")
        void estimate_tooManyRecommendations() throws LikedItemNotFoundException {
            List<String> recommendations = recSys.recommend("The Weekend", 1000);
            assertTrue(recommendations.size() <= testTable.getRowCount() - 1);
        }


        @Test
        @DisplayName("RecSys[KNN] - estimate: item vacío")
        void estimate_emptyItem() {
            assertThrows(LikedItemNotFoundException.class, () -> recSys.recommend("", numRecommendations));
        }

        @Test
        @DisplayName("RecSys[KNN] - estimate: item null")
        void estimate_nullItem() {
            assertThrows(LikedItemNotFoundException.class, () -> recSys.recommend(null, numRecommendations));
        }
    }

    @Nested
    class KMeansRecSys {

        private int numClusters = 15;
        private int numIterations = 10;
        private long seed = 53;

        @BeforeEach
            // TODO: añadir o eliminar excepciones según tu implementación
        void setUp() throws Exception {
            trainTable = new CSV().readTableWithLabels(songsFolder + separator + "songs_train_withoutnames.csv");
            testTable = new CSV().readTableWithLabels(songsFolder + separator + "songs_test_withoutnames.csv");
            testItemNames = readNames(songsFolder + separator + "songs_test_names.csv");

            algorithm = new KMeans(numClusters, numIterations, seed);
            recSys = new RecSys(algorithm);
            recSys.train(trainTable);
            recSys.initialise(testTable, testItemNames);
        }

        @Test
        @DisplayName("RecSys[KMeans] - estimate")
        void estimate() throws LikedItemNotFoundException {
            List<String> recommendations = recSys.recommend("The Weekend", numRecommendations);

            assertEquals(numRecommendations, recommendations.size());
            assertFalse(recommendations.contains("The Weekend"));
        }

        @Test
        @DisplayName("RecSys[KMeans] - estimate: liked item not returned")
        void estimate_likedItemNotInRecommendation() throws LikedItemNotFoundException {
            List<String> recommendations = recSys.recommend("Inside Out", numRecommendations);

            assertEquals(numRecommendations, recommendations.size());
            assertFalse(recommendations.contains("Inside Out"));
        }

        @Test
        @DisplayName("RecSys[KMeans] - estimate: liked item not found")
        void estimate_likedItemNotFound() {
            assertThrows(LikedItemNotFoundException.class, () -> recSys.recommend("Inside Ouuuut", numRecommendations));
        }

        @Test
        @DisplayName("RecSys[KMeans] - estimate: número de recomendaciones negativo")
        void estimate_negativeRecommendations() {
            assertThrows(IllegalArgumentException.class, () -> recSys.recommend("The Weekend", -1));
        }

        @Test
        @DisplayName("RecSys[KMeans] - estimate: número de recomendaciones cero")
        void estimate_zeroRecommendations() throws LikedItemNotFoundException {
            List<String> recommendations = recSys.recommend("The Weekend", 0);
            assertTrue(recommendations.isEmpty());
        }

        @Test
        @DisplayName("RecSys[KMeans] - estimate: número de recomendaciones mayor que items disponibles")
        void estimate_tooManyRecommendations() throws LikedItemNotFoundException {
            List<String> recommendations = recSys.recommend("The Weekend", 1000);
            assertTrue(recommendations.size() <= testTable.getRowCount() - 1);
        }


        @Test
        @DisplayName("RecSys[KMeans] - estimate: item vacío")
        void estimate_emptyItem() {
            assertThrows(LikedItemNotFoundException.class, () -> recSys.recommend("", numRecommendations));
        }

        @Test
        @DisplayName("RecSys[KMeans] - estimate: item null")
        void estimate_nullItem() {
            assertThrows(LikedItemNotFoundException.class, () -> recSys.recommend(null, numRecommendations));
        }
    }

    private List<String> readNames(String fileOfItemNames) throws IOException, URISyntaxException {
        String path = getClass().getClassLoader().getResource(fileOfItemNames).toURI().getPath();

        List<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            names.add(scanner.nextLine());
        }
        scanner.close();
        return names;
    }
}