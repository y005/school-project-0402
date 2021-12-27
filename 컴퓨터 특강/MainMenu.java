import static sortMenuConstant.MenuNumber.*;
import sort.*;
import java.util.*;

public class MainMenu {
  private static int menuNumber;
  private static int sortingMethod = 1;
  private static int[] numbers;
  private static Scanner input;
  private static boolean isAscending = true;

  public static void main(String args[]) {
      while (true) {
        try {
          printMainMenu();
          input = new Scanner(System.in);
          menuNumber = input.nextInt();
          if (isUserQuit()) {
            break;
          }
          else {
            executeMenu();
          }
        }
        catch (Exception e) {
          printWrongInputMsg();
        }
      }
      input.close();
  }

  private static void printMainMenu() {
    System.out.println("[ Student ID: 1815060 ]");
    System.out.println("[ Name: Moon Jung Hyun ]\n");
    System.out.println("1. Select a sorting algorithm");
    System.out.println("2. Sort numbers");
    System.out.println("3. Quit");
  }

  private static boolean isUserQuit() {
    return menuNumber == QUIT;
  }

  private static void executeMenu() throws Exception {
    if (menuNumber == SELECTINGMETHOD) {
      selectAlgorithmMenu();
    }
    else if (menuNumber == SORTING) {
      sortingMenu();
    }
    else {
      throw new Exception();
    }
  }

  private static void selectAlgorithmMenu() throws Exception {
    printSelectAlgorithmMenu();
    sortingMethod = input.nextInt();
    System.out.print("\n");
    if (ifUserSelectOtherNumber()) {
      throw new Exception();
    }
  }

  private static void printSelectAlgorithmMenu() {
    System.out.println("\nSelect a sorting algorithm");
    System.out.println("1. Bubble sort");
    System.out.println("2. Quick sort");
    System.out.println("3. Insertion sort");
  }

  private static boolean ifUserSelectOtherNumber() {
    return (sortingMethod > INSERTIONSORT) && (sortingMethod < BUBBLESORT);
  }

  private static void sortingMenu() throws Exception {
    input();
    numbers = sortNumbers();
    printSortedNumbers();
  }

  private static void input() throws Exception {
    inputLengthOfArray();
    inputSortingMode();
    inputElementOfArray();
  }

  private static void inputLengthOfArray() {
    System.out.print("\nThe number of numbers: ");
    int number = input.nextInt();
    numbers = new int[number];
  }

  private static void inputSortingMode() throws Exception {
    input.nextLine();
    System.out.print("\nAscending or descending (a or d): ");
    String sortingMode = input.nextLine();
    if (sortingMode.equals("a")) {
      isAscending = true;
    }
    else if (sortingMode.equals("d")) {
      isAscending = false;
    }
    else {
      throw new Exception();
    }
  }

  private static void inputElementOfArray() {
    System.out.print("\nNumbers: ");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = input.nextInt();
    }
  }

  private static int[] sortNumbers() {
    if (isAscending) {
      return sortNumbersAscending();
    }
    else {
      return sortNumbersDescending();
    }
  }

  private static int[] sortNumbersAscending(){
    int[] sortedArray;
    sort.Sort tmp;

    if (sortingMethod == BUBBLESORT) {
      tmp = new sort.BubbleSort();
    }
    else if (sortingMethod == QUICKSORT) {
      tmp = new sort.QuickSort();
    }
    else {
      tmp = new sort.InsertionSort();
    }
    sortedArray = tmp.sortAscending(numbers);
    return sortedArray;
  }

  private static int[] sortNumbersDescending(){
    int[] sortedArray;
    sort.Sort tmp;

    if (sortingMethod == BUBBLESORT) {
      tmp = new sort.BubbleSort();
    }
    else if (sortingMethod == QUICKSORT) {
      tmp = new sort.QuickSort();
    }
    else {
      tmp = new sort.InsertionSort();
    }
    sortedArray = tmp.sortDescending(numbers);
    return sortedArray;
  }

  private static void printSortedNumbers() {
    System.out.print("Result: ");
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i]);
      System.out.print(" ");
    }
    System.out.print("\n\n");
  }

  private static void printWrongInputMsg() {
    System.out.println("Input right number\n");
  }
}
