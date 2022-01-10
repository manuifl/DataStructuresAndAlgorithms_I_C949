package org.manuel.controllers;

import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import org.manuel.controllers.uicomponents.*;
import org.manuel.elements.Node;
import org.manuel.elements.RandomNodes;
import org.manuel.sortingalgorithms.AbstractSort;

import java.util.Arrays;
import java.util.List;

/**
 * @author Manuel Fuentes
 */
public class SortController extends BorderPane{

    //BorderPane borderPane;
    public static final double WINDOW_WIDTH = 800.0;
    public static final double WINDOW_HEIGHT = 600.0;
    static Pane centerPane = new CenterPane();
    ToolBar toolBar = new ToolBar();
    Button sortButton = new Button("Sort");;
    Button resetNodesButton = new Button("Reset");;
    Button skipButton = new Button("Skip");;
    AlgorithmChoiceBox algoChoiceBox;
    SpeedComboBox speedsComboBox = new SpeedComboBox();
    //NodeSlider nodeSlider = new NodeSlider();
    QuantityComboBox quantityComboBox = new QuantityComboBox();
//    private final SequentialTransition sq = new SequentialTransition();
    private static SequentialTransition sq;

    private final Group horizontalLines = new Group();
    private static Duration animationSpeed;
    //private static double CENTER_PANE_WIDTH = 600;
    private static final int NODE_MAX_VAL = 300;
    private static int nodeQuantity;
    private static final int XGAP = 5;
    private static Node[] nodes;
    AbstractSort abstractSort;

    public SortController(){
//        this.centerPane = new CenterPane();
//        toolBar = new ToolBar();
//        sortButton = new Button();
//        resetNodesButton = new Button();
//        skipButton = new Button();
        //CENTER_PANE_WIDTH = centerPane.getWidth();
        sq = new SequentialTransition();
        toolBar.getItems().add(0,sortButton);
        toolBar.getItems().add(1,resetNodesButton);
        toolBar.getItems().add(2, new Button("temp"));
        toolBar.getItems().add(3, quantityComboBox);
        toolBar.getItems().add(4,speedsComboBox);
        toolBar.getItems().add(5,skipButton);
        skipButton.disableProperty().bind(sq.statusProperty().isNotEqualTo(Animation.Status.RUNNING));
        sortButton.disableProperty().bind(sq.statusProperty().isEqualTo(Animation.Status.RUNNING));
        resetNodesButton.disableProperty().bind(sq.statusProperty().isEqualTo(Animation.Status.RUNNING));
//        nodeSlider.disableProperty().bind(sq.statusProperty().isEqualTo(Animation.Status.RUNNING));
        quantityComboBox.disableProperty().bind(sq.statusProperty().isEqualTo(Animation.Status.RUNNING));

        speedsComboBox.disableProperty().bind(sq.statusProperty().isEqualTo(Animation.Status.RUNNING));

        speedsComboBox.getSelectionModel().select(1);
        animationSpeed = speedsComboBox.getValue().getDuration();
//        nodeSlider.setValue(60.0);
        quantityComboBox.getSelectionModel().select(0);

        //nodeQuantity = (int) nodeSlider.getValue();
        nodeQuantity = quantityComboBox.getValue().getQuantity();

        algoChoiceBox = new AlgorithmChoiceBox();
        //Remove temp button holding place for choiceBox
        //choicebox elements cannot be initialized before setting the node quantity from the slider
        toolBar.getItems().remove(2);
        toolBar.getItems().add(2,algoChoiceBox);
        algoChoiceBox.getSelectionModel().select(0);
        // ToolBar Alignment
        BorderPane.setAlignment(toolBar, Pos.CENTER);
        BorderPane.setMargin(toolBar, new Insets(5,5,5,5));
        this.setTop(toolBar);
        // CenterPane Alignment
        BorderPane.setAlignment(toolBar, Pos.CENTER);
        BorderPane.setMargin(toolBar, new Insets(0,0,0,0));
        this.setCenter(centerPane);
        // Create Nodes
        /*-------------------------------------------*/
        generateHorizontalLines();
        centerPane.getChildren().addAll(horizontalLines);
        nodes = RandomNodes.randomCNodes(nodeQuantity);
        centerPane.getChildren().addAll(Arrays.asList(nodes));

        //System.out.println(nodes[0].getWidth());

        //UI Actions
        //SortButton
        sortButton.setOnAction(event ->{
            AbstractSort abstractSort = algoChoiceBox.getSelectionModel().getSelectedItem();
//            if(abstractSort.toString().equals("MergeSort")){
//                resetNodes();
//            }
            sq.getChildren().addAll(abstractSort.startSort(nodes));
            sq.setOnFinished(e -> {
                sq.getChildren().clear();
            });
            sq.play();
        });
        //Slider
//        nodeSlider.valueProperty().addListener((ov, oldValue, newValue) -> {
//            if(newValue != null){
//                nodeQuantity = (int) nodeSlider.getValue();
//                centerPane.getChildren().clear();
//                horizontalLines.getChildren().clear();
//                nodes = RandomNodes.randomCNodes(newValue.intValue());
//                generateHorizontalLines();
//                centerPane.getChildren().addAll(List.of(horizontalLines));
//                centerPane.getChildren().addAll(Arrays.asList(nodes));
//            }
//        });
        quantityComboBox.valueProperty().addListener((ov, oldValue, newValue) -> {
            if(newValue != null){
                nodeQuantity = quantityComboBox.getValue().getQuantity();
                centerPane.getChildren().clear();
                horizontalLines.getChildren().clear();
                nodes = RandomNodes.randomCNodes(newValue.getQuantity());
                generateHorizontalLines();
                centerPane.getChildren().addAll(List.of(horizontalLines));
                centerPane.getChildren().addAll(Arrays.asList(nodes));
            }
        });
        //SkipButton
        skipButton.setOnAction(event ->{
            sq.jumpTo(Duration.INDEFINITE);
            sq.getChildren().clear();
        });
        //ResetButton
        resetNodesButton.setOnAction(event ->{
            resetNodes();
        });
        //SpeedComboBox
        speedsComboBox.valueProperty().addListener((ov, oldValue, newValue) -> {
            if(newValue != null){
                animationSpeed = newValue.getDuration();
            }
        });
    }
    public void generateHorizontalLines(){
        for (int i = 0; i < NODE_MAX_VAL + 10; i += 10) {
//          Line line1 = new Line(i, 0, i, 600);
//          line1.setStroke(Color.LIGHTGRAY);
            Line line2 = new Line(0, i, centerPane.getPrefWidth(), i);
            line2.setStroke(Color.LIGHTGRAY);
            horizontalLines.getChildren().addAll(line2);
        }
    }
    public void generateNodes(int qty){
        nodes = RandomNodes.randomCNodes(qty);
    }

    public void resetNodes(){
        centerPane.getChildren().clear();
        nodes = RandomNodes.randomCNodes(nodeQuantity);
        centerPane.getChildren().addAll(List.of(horizontalLines));
        centerPane.getChildren().addAll(Arrays.asList(nodes));
        System.out.println(nodes.length);
        System.out.println(getNodeQuantity());
    }


    public static Duration getAnimationSpeed() {
        return animationSpeed;
    }

    public static Pane getCenterPane() {
        return centerPane;
    }
    //    public static double getCenterPaneWidth() {
//        return CENTER_PANE_WIDTH;
//    }

    public static int getNodeMaxVal() {
        return NODE_MAX_VAL;
    }

    public static int getNodeQuantity() {
        return nodeQuantity;
    }

    public static int getXgap() {
        return XGAP;
    }
}
