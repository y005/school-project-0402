package sort;

import sort.*;

public class BubbleSort extends Sort {
  @Override
  protected void sortArray() {
    bubbleSort();
  }

  //align numbers by comparing two adjacent number and exchange them
  //if the sizes are not in ascending order.
  private void bubbleSort() {
    for (int i = numbers.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (checkIfOkayToSwap(j, j+1)) {
          swap(j, j+1);
        }
      }
    }
  }

  private boolean checkIfOkayToSwap(int first, int next) {
    if (isAscendingOrder()) {
      return isNotAscendingPosition(first, next);
    }
    else {
      return isNotDescendingPosition(first, next);
    }
  }

  private boolean isNotAscendingPosition(int first, int next) {
      return numbers[first] > numbers[next];
  }

  private boolean isNotDescendingPosition(int first, int next) {
      return numbers[first] < numbers[next];
  }
}
