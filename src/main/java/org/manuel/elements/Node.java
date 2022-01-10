package org.manuel.elements;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
//import org.manuel.controllers.AnimationController;
//import org.manuel.controllers.MainController;
import org.manuel.controllers.SortController;

public class Node extends Rectangle {

  private int value;

  public Node(int n) {
    this.value = n;
    this.setFill(Color.CRIMSON);
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public TranslateTransition moveX(int x) {
    TranslateTransition t = new TranslateTransition();
    t.setNode(this);
    t.setDuration(SortController.getAnimationSpeed());
    t.setByX(x);
    return t;
  }
  @Override
  public String toString(){
      return String.valueOf(value);
  }

}
