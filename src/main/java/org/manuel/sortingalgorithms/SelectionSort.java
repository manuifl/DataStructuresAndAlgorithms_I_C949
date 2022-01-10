package org.manuel.sortingalgorithms;

import org.manuel.elements.Node;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class SelectionSort extends AbstractSort {

  private static final Color MIN_INDEX_COLOR = Color.ORANGE;
  private static final Color NEW_MIN_INDEX_COLOR = Color.LIGHTGREEN;

  private ParallelTransition colorCNode(Node[] arr, int a, int b, Color colorA, Color colorB) {
    ParallelTransition pt = new ParallelTransition();

    pt.getChildren().addAll(colorCNode(arr, colorA, a), colorCNode(arr, colorB, b));

    return pt;
  }

  @Override
  public ArrayList<Transition> startSort(Node[] arr) {
    ArrayList<Transition> transitions = new ArrayList<>();
    int minIndex;

    for (int i = 0; i < arr.length - 1; i++) {
      minIndex = i;
      transitions.add(colorCNode(arr, NEW_MIN_INDEX_COLOR, minIndex));

      for (int j = i + 1; j < arr.length; j++) {
        transitions.add(colorCNode(arr, SELECT_COLOR, j));
        if (arr[j].getValue() < arr[minIndex].getValue()) {
          if (minIndex == i) {
            //.add(colorCNode(arr, minIndex, j, MIN_INDEX_COLOR, NEW_MIN_INDEX_COLOR));
            transitions.add(colorCNode(arr, minIndex, j, HIGHLIGHT_COLOR, HIGHLIGHT_COLOR));

          } else {
            transitions.add(colorCNode(arr, minIndex, j, START_COLOR, NEW_MIN_INDEX_COLOR));
          }
          minIndex = j;
        } else {
          transitions.add(colorCNode(arr, START_COLOR, j));
        }
      }

      if (minIndex != i) {
        transitions.add(swap(arr, i, minIndex));
      }

        transitions.add(colorCNode(arr, START_COLOR, i, minIndex));
    }

    transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));

    return transitions;
  }
  @Override
  public String toString() {
    return "SelectionSort";
  }
}
