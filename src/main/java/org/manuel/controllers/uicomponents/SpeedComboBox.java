package org.manuel.controllers.uicomponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import org.manuel.elements.DurationSpeeds;
import org.manuel.sortingalgorithms.AbstractSort;

/**
 * @author Manuel Fuentes
 */
public class SpeedComboBox extends ComboBox<DurationSpeeds> {

    public SpeedComboBox(){
        ObservableList<DurationSpeeds> speedList = FXCollections.observableArrayList();
        speedList.add(DurationSpeeds.SLOW);
        speedList.add(DurationSpeeds.NORMAL);
        speedList.add(DurationSpeeds.FAST);
        this.setItems(speedList);
        this.setConverter(new StringConverter<DurationSpeeds>() {
            @Override
            public String toString(DurationSpeeds object) {
                if (object == null) {
                    return "";
                } else {
                    return object.name().charAt(0) + object.name().substring(1).toLowerCase();
                }
            }

            @Override
            public DurationSpeeds fromString(String string) {
                return null;
            }
        });
    }

}
