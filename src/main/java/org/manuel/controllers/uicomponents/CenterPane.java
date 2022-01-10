package org.manuel.controllers.uicomponents;

import javafx.scene.layout.Pane;

/**
 * @author Manuel Fuentes
 */
public class CenterPane extends Pane {

    public CenterPane(){
        this.setPrefSize(800.0, 500.0);
        this.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        this.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
        this.setStyle("-fx-border-color: lightgrey");
    }
}
