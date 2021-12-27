package sort;

abstract public class Sort {
  protected int[] numbers;
  private boolean isAscendingOrder;

  public int[] sortAscending(int array[]) {
    isAscendingOrder = true;
    return sort(array);
  }

  public int[] sortDescending(int array[]) {
    isAscendingOrder = false;
    return sort(array);
  }

  private int[] sort(int array[]) {
    copyArray(array);
    sortArray();
    return numbers;
  }

  private void copyArray(int array[]) {
    numbers = new int[array.length];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = array[i];
    }
  }

  abstract protected void sortArray();

  protected boolean isAscendingOrder() {
    return isAscendingOrder;
  }

  protected void swap(int first, int next) {
    int temp;
    temp = numbers[first];
    numbers[first] = numbers[next];
    numbers[next] = temp;
  }
}
