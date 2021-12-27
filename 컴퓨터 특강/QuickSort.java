package sort;

import sort.*;

public class QuickSort extends Sort {
  @Override
  protected void sortArray() {
    quickSort(0, numbers.length - 1);
  }

  //align numbers by making the low value go to the left and the high value go
  //to the right based on the pivot using a recursive call
  private void quickSort(int left, int right) {
    int pivot = -1;
    if (isAscending(left, right)) {
      pivot = partition(left, right);
      quickSort(left, pivot - 1);
      quickSort(pivot + 1, right);
    }
  }

  private boolean isAscending(int left, int right) {
    return left < right;
  }

  //Make the low value go to the left and the high value go to the right based on
  //the pivot value and return the index of pivot value.
  private int partition(int left, int right) {
    int pivot, temp, leftSideToSwap, rightSideToSwap;
    leftSideToSwap = left;
    rightSideToSwap = right + 1;
    //In this function the pivot value is the leftmost in the range of a given array.
    pivot = numbers[left];
    do {
      leftSideToSwap = findLeftSideToSwap(leftSideToSwap, right, pivot);
      rightSideToSwap = findRightSideToSwap(rightSideToSwap, left, pivot);
      if (isAscending(leftSideToSwap, rightSideToSwap)){
        swap(leftSideToSwap, rightSideToSwap);
      }
    } while (isAscending(leftSideToSwap, rightSideToSwap));
    //place pivot value between two partition of array
    swap(left, rightSideToSwap);
    return rightSideToSwap;
  }

  private int findLeftSideToSwap(int leftSideToSwap, int right, int pivot) {
    do {
      leftSideToSwap++;
    } while (isNotFoundLeftSideToSwap(leftSideToSwap, right, pivot));
    return leftSideToSwap;
  }

  private boolean isNotFoundLeftSideToSwap(int leftSideToSwap, int right, int pivot) {
    if (isAscendingOrder()) {
      return isStillleftSideToSwapSmallerThanPivot(leftSideToSwap, right, pivot);
    }
    else {
      return isStillleftSideToSwapBiggerThanPivot(leftSideToSwap, right, pivot);
    }
  }

  private boolean isStillleftSideToSwapSmallerThanPivot(int leftSideToSwap, int right, int pivot) {
    return leftSideToSwap <= right && numbers[leftSideToSwap] < pivot;
  }

  private boolean isStillleftSideToSwapBiggerThanPivot(int leftSideToSwap, int right, int pivot) {
    return leftSideToSwap <= right && numbers[leftSideToSwap] > pivot;
  }

  private int findRightSideToSwap(int rightSideToSwap, int left, int pivot) {
    do {
      rightSideToSwap--;
    } while (isNotFoundRightSideToSwap(rightSideToSwap, left, pivot));
    return rightSideToSwap;
  }

  private boolean isNotFoundRightSideToSwap(int rightSideToSwap, int left, int pivot) {
    if (isAscendingOrder()) {
      return isStillRightSideToSwapBiggerThanPivot(rightSideToSwap, left, pivot);
    }
    else {
      return isStillRightSideToSwapSmallerThanPivot(rightSideToSwap, left, pivot);
    }
  }

  private boolean isStillRightSideToSwapBiggerThanPivot(int rightSideToSwap, int left, int pivot) {
    return rightSideToSwap >= left && numbers[rightSideToSwap] > pivot;
  }

  private boolean isStillRightSideToSwapSmallerThanPivot(int rightSideToSwap, int left, int pivot) {
    return rightSideToSwap >= left && numbers[rightSideToSwap] < pivot;
  }
}
