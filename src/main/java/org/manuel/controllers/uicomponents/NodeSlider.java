package org.manuel.controllers.uicomponents;

import javafx.scene.control.Slider;

/**
 * @author Manuel Fuentes
 */
public class NodeSlider extends Slider {
    public NodeSlider(){
        this.setBlockIncrement(10);
        this.setMin(10);
        this.setMax(100);
        this.setMajorTickUnit(10);
        this.setMinorTickCount(0);
        this.setSnapToTicks(true);
        this.setShowTickLabels(true);
        this.setShowTickMarks(true);
        //this.setValue(40);


    }
}
