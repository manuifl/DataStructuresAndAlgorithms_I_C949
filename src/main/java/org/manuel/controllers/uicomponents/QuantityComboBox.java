package org.manuel.controllers.uicomponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import org.manuel.elements.Quantities;

public class QuantityComboBox extends ComboBox<Quantities> {
    public QuantityComboBox() {
        ObservableList<Quantities> quantityList = FXCollections.observableArrayList();
        quantityList.add(Quantities.SMALL);
        quantityList.add(Quantities.MEDIUM);
        quantityList.add(Quantities.LARGE);
        this.setItems(quantityList);

        this.setConverter(new StringConverter<Quantities>() {
            @Override
            public String toString(Quantities object) {
                if (object == null) {
                    return "";
                } else {
                    return object.name().charAt(0) + object.name().substring(1).toLowerCase();
                }
            }

            @Override
            public Quantities fromString(String string) {
                return null;
            }
        });
    }
}
