package org.manuel.elements;

//import org.manuel.controllers.MainController;
//import org.manuel.controllers.AnimationController;

import java.util.Random;

import javafx.scene.paint.Color;
import org.manuel.controllers.SortController;

public class RandomNodes {

  public RandomNodes() {

  }
  public static Node[] randomCNodes(int n) {
    Node[] arr = new Node[n];
    Random r = new Random();

    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Node(1 + r.nextInt(20, SortController.getNodeMaxVal()));
//      arr[i].setX(i * ((MainController.CENTER_PANE_WIDTH / arr.length)) + MainController.getCenterPane().getLayoutX());
      //arr[i].setX(i * (SortController.getCenterPane().getPrefWidth() / arr.length));
      arr[i].setX(i * (SortController.getCenterPane().getPrefWidth() / arr.length) + 2);
      //arr[i].setFill(Color.CRIMSON);
      setCNodeDim(arr[i], arr.length);
    }
    return arr;
 
  }

  private static void setCNodeDim(Node cnode, int n) {
    cnode.setWidth(SortController.getCenterPane().getPrefWidth() / n - SortController.getXgap());
    cnode.setHeight(cnode.getValue());
//

  }

  public static void resetNodeValues(Node[] nodes){
    Random r = new Random();
    for (Node node : nodes) {
      node.setValue(r.nextInt(20, SortController.getNodeMaxVal()));
      node.setFill(Color.CRIMSON);
      setCNodeDim(node, nodes.length);
    }

  }

//  public static CNode[] randomCNodes(int n) {
//    CNode[] arr = new CNode[n];
//    Random r = new Random();
//
//    for (int i = 0; i < arr.length; i++) {
//      arr[i] = new CNode(1 + r.nextInt(arr.length));
//      arr[i].setX(i * (AnimationController.WINDOW_WIDTH / arr.length));
//      arr[i].setFill(Color.CRIMSON);
//      setCNodeDim(arr[i], arr.length);
//    }
//    return arr;
// 
//  }
//
//  private static void setCNodeDim(CNode cnode, int n) {
//    cnode.setWidth(AnimationController.WINDOW_WIDTH / n -
//                    AnimationController.XGAP);
//    cnode.setHeight(((AnimationController.WINDOW_HEIGHT - AnimationController.BUTTONROW_BOUNDARY) 
//                      / n) *
//                      cnode.getValue());
//  }
}
