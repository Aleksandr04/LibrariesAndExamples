package typeOfSorts;

/**
 * Created by local on 05-Feb-17.
 */
public class BubbleSortFactory implements SortedFactory {
    @Override
    public Sorted create() {
        return new BubbleSort();
    }
}
