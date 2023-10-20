import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        flattenList(nestedList);
    }

    private void flattenList(List<NestedInteger> nestedList) {
        // Traverse the list in reverse order and push each element onto the stack
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        // Ensure there is a next element
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        // Pop the next element from the stack and return its value
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        // Continue popping elements from the stack until an integer is found
        while (!stack.isEmpty()) {
            NestedInteger current = stack.peek();
            if (current.isInteger()) {
                return true;
            }
            // If it's a list, flatten it and continue
            List<NestedInteger> nestedList = stack.pop().getList();
            flattenList(nestedList);
        }
        return false;
    }
}
