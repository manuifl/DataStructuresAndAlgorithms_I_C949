package org.manuel.controllers.uicomponents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;
import org.manuel.sortingalgorithms.*;

/**
 * @author Manuel Fuentes
 */
public class AlgorithmChoiceBox extends ChoiceBox<AbstractSort> {
    /**
     * Create a new ChoiceBox which has an empty list of items.
     */



    public AlgorithmChoiceBox() {
        ObservableList<AbstractSort> observableList = FXCollections.observableArrayList();
        observableList.add(new BubbleSort());
        observableList.add(new SelectionSort());
        observableList.add(new InsertionSort());
        observableList.add(new MergeSort());
        observableList.add(new QuickSort());
        observableList.add(new HeapSort());
        this.setItems(observableList);
        this.setConverter(new StringConverter<AbstractSort>() {
            @Override
            public String toString(AbstractSort abstractSort) {
                if (abstractSort == null) {
                    return "";
                } else {
                    return abstractSort.getClass().getSimpleName();
                }
            }

            @Override
            public AbstractSort fromString(String s) {
                return null;
            }
        });

    }
}
