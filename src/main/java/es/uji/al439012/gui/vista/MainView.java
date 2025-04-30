// Modifica MainView.java

package es.uji.al439012.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.List;

public class MainView implements Vista{
    private final HBox root;

    public MainView() {
        root = new HBox(20);
        root.setPadding(new Insets(20, 20, 20, 20));

        LeftPanel leftPanel = new LeftPanel();
        CenterPanel centerPanel = new CenterPanel(leftPanel); // Modifica esta línea
        RightPanel rightPanel = new RightPanel();

        HBox.setHgrow(leftPanel.getPanel(), Priority.ALWAYS);
        HBox.setHgrow(centerPanel.getPanel(), Priority.ALWAYS);
        HBox.setHgrow(rightPanel.getPanel(), Priority.ALWAYS);

        root.getChildren().addAll(leftPanel.getPanel(), centerPanel.getPanel(), rightPanel.getPanel());

        root.getStyleClass().add("root");
    }

    public HBox getView() {
        return root;
    }

    @Override
    public List<String> getSelectedSongs() {
        return null;
    }

    @Override
    public String getRecommendationType() {
        return null;
    }

    @Override
    public String getDistanceType() {
        return null;
    }

    @Override
    public int getNumberOfRecommendations() {
        return 0;
    }

    @Override
    public void showRecommendations(List<String> recommendations) {

    }
}