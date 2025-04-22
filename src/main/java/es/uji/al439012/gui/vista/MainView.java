package es.uji.al439012.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class MainView {
    private final HBox root;

    public MainView() {
        root = new HBox(20);
        root.setPadding(new Insets(20,20,20,20));

        LeftPanel leftPanel = new LeftPanel();
        CenterPanel centerPanel = new CenterPanel();
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
}