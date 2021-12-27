package sort;

import sort.*;

public class InsertionSort extends Sort {
  @Override
  protected void sortArray() {
    insertionSort();
  }

  //This is the process of inserting unordered elements into
  //the sorted front array.
  private void insertionSort() {
    int j, key;
    // idx = 0 already sorted so sorting is start in idx = 1
    for (int i = 1; i < numbers.length; i++) {
      key = numbers[i];
      for(j = i - 1; checkIfOkayToMoveOneSpace(j, key); j--) {
        numbers[j + 1] = numbers[j];
      }
      numbers[j + 1] = key;
    }
  }

  private boolean checkIfOkayToMoveOneSpace(int j, int key) {
    if (isAscendingOrder()) {
      return isKeyStilSmallerInOrderedArray(j, key);
    }
    else {
      return isKeyStilBiggerInOrderedArray(j, key);
    }
  }

  private boolean isKeyStilSmallerInOrderedArray(int j, int key) {
    return j >= 0 && numbers[j] > key;
  }

  private boolean isKeyStilBiggerInOrderedArray(int j, int key) {
    return j >= 0 && numbers[j] < key;
  }
}
