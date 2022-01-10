package org.manuel.sortingalgorithms;

//import org.manuel.controllers.MainController;
import org.manuel.controllers.SortController;
import org.manuel.elements.Node;
//import org.manuel.controllers.AnimationController;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public abstract class AbstractSort {

  final Color START_COLOR = Color.CRIMSON;
  final Color SELECT_COLOR = Color.BLUE;
  final Color HIGHLIGHT_COLOR = Color.DARKMAGENTA;
  final Color SORTED_COLOR = Color.GREEN;

  static int DX;
  static {
    DX = (int) (SortController.getCenterPane().getPrefWidth() / SortController.getNodeQuantity());
    System.out.println("Width = " + SortController.getCenterPane().getPrefWidth() + " Node Qty = " + SortController.getNodeQuantity());
  }

  ParallelTransition colorCNode(Node[] arr, Color color, int...a) {
    ParallelTransition pt = new ParallelTransition();

    for (int i = 0; i < a.length; i++) {
      FillTransition ft = new FillTransition();
      ft.setShape(arr[a[i]]);
      ft.setToValue(color);
//      ft.setDuration(Duration.millis(100));
      ft.setDuration(SortController.getAnimationSpeed());
      pt.getChildren().add(ft);
    }
//      System.out.println("Abstract Fill Speed" + MainController.getAnimationSpeed());
    return pt;
  }

  ParallelTransition colorCNode(List<Node> list, Color color) {
    ParallelTransition pt = new ParallelTransition();

    for (Node c : list) {
      FillTransition ft = new FillTransition();
      ft.setShape(c);
      ft.setToValue(color);
//      ft.setDuration(Duration.millis(100));
      ft.setDuration(SortController.getAnimationSpeed());
      pt.getChildren().add(ft);
    }
//      System.out.println("Abstract Fill Speed" + MainController.getAnimationSpeed());
    return pt;
  }

  ParallelTransition swap(Node[] arr, int i, int j) {
    DX = (int) (SortController.getCenterPane().getPrefWidth() / SortController.getNodeQuantity());
    ParallelTransition pt = new ParallelTransition();

    int dxFactor = j - i;

    pt.getChildren().addAll(arr[i].moveX(DX * dxFactor), arr[j].moveX(-DX * dxFactor));

    Node tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
//    System.out.println(dxFactor);

    return pt;
  }


  public abstract ArrayList<Transition> startSort(Node[] arr);
}
