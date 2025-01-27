import java.util.ArrayDeque;
import java.util.Deque;

public class DequeOperations {
    private Deque<Integer> deque;

    public DequeOperations() {
        deque = new ArrayDeque<>();
    }
	public void append(int value) {
        deque.addLast(value);
    }
	public void appendLeft(int value) {
        deque.addFirst(value);
    }
	public Integer pop() {
        return deque.pollLast(); 
    }
	public Integer popLeft() {
        return deque.pollFirst(); 
    }

    public int index(int ele) {
        int index = 0;
        for (Integer item : deque) {
            if (item == ele) {
                return index;
            }
            index++;
        }
        return -1; 
    }

	public void remove(int value) {
        deque.removeFirstOccurrence(value);
    }

    public int count(int value) {
        int count = 0;
        for (Integer item : deque) {
            if (item == value) {
                count++;
            }
        }
        return count;
    }

    public int size() {
        return deque.size();
    }

    public Integer getFront() {
        return deque.peekFirst();
    }

    public Integer getBack() {
        return deque.peekLast();
    }

    public void extend(int[] values) {
        for (int value : values) {
            append(value);
        }
    }

    public void extendLeft(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            appendLeft(values[i]);
        }
    }

    public void rotate(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                Integer value = pop();
                if (value != null) {
                    appendLeft(value);
                }
            }
        } else {
            for (int i = 0; i < -n; i++) {
                Integer value = popLeft();
                if (value != null) {
                    append(value);
                }
            }
        }
    }

    public void display() {
        System.out.println("Deque: " + deque);
    }

    public static void main(String[] args) {
        DequeOperations dequeOps = new DequeOperations();

        dequeOps.append(1);
        dequeOps.append(2);
        dequeOps.appendLeft(0);
        dequeOps.display();

        dequeOps.pop();
        dequeOps.display();

		dequeOps.remove(2);
        dequeOps.display();

        System.out.println("Count of 1: " + dequeOps.count(1));
        System.out.println("Front: " + dequeOps.getFront());
        System.out.println("Back: " + dequeOps.getBack());

        dequeOps.extend(new int[]{3, 4, 5});
        dequeOps.display();

        dequeOps.extendLeft(new int[]{-1, -2});
        dequeOps.display();

        dequeOps.rotate(2);
        dequeOps.display();
    }
}
