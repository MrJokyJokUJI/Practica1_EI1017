package es.uji.al439012.recSys;
import es.uji.al439012.algorithm.Algorithm;
import es.uji.al439012.table.Table;
import es.uji.al439012.excepciones.LikedItemNotFoundException;
import java.util.*;


public class RecSys {
    private Algorithm algorithm;
    private Map<String, Integer> itemClassMap;
    private List<String> testItemNames;

    public RecSys(Algorithm algorithm) {
        this.algorithm = algorithm;
        this.itemClassMap = new HashMap<>();
    }

    public void train(Table trainData) throws Exception {
        algorithm.train(trainData);
    }

    public void initialise(Table testData, List<String> testItemNames) {
        this.testItemNames = testItemNames;
        for (int i = 0; i < testData.getRowCount(); i++) {
            Integer estimatedClass = algorithm.estimate(testData.getRowAt(i).getData());
            itemClassMap.put(testItemNames.get(i), estimatedClass);
        }
    }

    public List<String> recommend(String nameLikedItem, int numRecommendations) throws LikedItemNotFoundException {
        if (!itemClassMap.containsKey(nameLikedItem)) {
            throw new LikedItemNotFoundException("Item not found: " + nameLikedItem);
        }

        int likedClass = itemClassMap.get(nameLikedItem);
        List<String> recommendations = new ArrayList<>();

        for (String item : testItemNames) {
            if (!item.equals(nameLikedItem) && itemClassMap.get(item) == likedClass) {
                recommendations.add(item);
                if (recommendations.size() >= numRecommendations) {
                    break;
                }
            }
        }

        return recommendations;
    }
}
