import static org.junit.jupiter.api.Assertions.*;
import sort.*;
import org.junit.jupiter.api.*;

public class TestSort {
	int[] ascendingAnswer = {0,1,2,3,4,5,6,7,8,9};
	int[] descendingAnswer = {9,8,7,6,5,4,3,2,1,0};
	int[] result;

	@Test
	void testBubbleSortAscending(){
		sort.Sort test = new sort.BubbleSort();
		result = test.sortAscending(descendingAnswer);
		assertArrayEquals(ascendingAnswer, result);
	}

	@Test
	void testBubbleSortDescending(){
		sort.Sort test = new sort.BubbleSort();
		result = test.sortDescending(ascendingAnswer);
		assertArrayEquals(descendingAnswer, result);
	}

	@Test
	void testQuickSortAscending(){
		sort.Sort test = new sort.QuickSort();
		result = test.sortAscending(descendingAnswer);
		assertArrayEquals(ascendingAnswer, result);
	}

	@Test
	void testQuickSortDescending(){
		sort.Sort test = new sort.QuickSort();
		result = test.sortDescending(ascendingAnswer);
		assertArrayEquals(descendingAnswer, result);
	}

	@Test
	void testInsertionSortAscending(){
		sort.Sort test = new sort.InsertionSort();
		result = test.sortAscending(descendingAnswer);
		assertArrayEquals(ascendingAnswer, result);
	}

	@Test
	void testInsertionSortDescending(){
		sort.Sort test = new sort.InsertionSort();
		result = test.sortDescending(ascendingAnswer);
		assertArrayEquals(descendingAnswer, result);
	}
}
