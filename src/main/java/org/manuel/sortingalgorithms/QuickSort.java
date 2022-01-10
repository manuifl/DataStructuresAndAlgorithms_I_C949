package org.manuel.sortingalgorithms;

import org.manuel.elements.Node;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class QuickSort extends AbstractSort {

  private static final Color PIVOT_COLOR = Color.DARKMAGENTA;
  private ArrayList<Transition> transitions;


  private void quickSort(Node[] arr, int lo, int hi) {
    if (lo < hi) {
      int q = partition(arr, lo, hi);
      quickSort(arr, lo, q - 1);
      quickSort(arr, q + 1, hi);
    }
  }

  //last element of array chosen as pivot
  private int partition(Node[] arr, int lo, int hi) {
    int i = lo;

    transitions.add(colorCNode(arr, HIGHLIGHT_COLOR, hi));

    for (int j = lo; j < hi; j++) {
      transitions.add(colorCNode(arr, SELECT_COLOR, j));
      if (arr[j].getValue() < arr[hi].getValue()) {
        transitions.add(swap(arr, i, j));
        transitions.add(colorCNode(arr, START_COLOR, i));
        i++;
      } else {
        transitions.add(colorCNode(arr, START_COLOR, j));
      }
    }
    transitions.add(swap(arr, i, hi));
    transitions.add(colorCNode(arr, START_COLOR, i));

    return i;
  }

  @Override
  public ArrayList<Transition> startSort(Node[] arr) {
    transitions = new ArrayList<>();
    quickSort(arr, 0, arr.length - 1);
    transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));

    return transitions;
  }
  @Override
  public String toString() {
    return "QuickSort";
  }
}

