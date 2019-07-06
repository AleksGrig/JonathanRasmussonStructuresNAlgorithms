package questions.stacks;

import java.util.ArrayList;

public class StackOfPlates {

	private ArrayList<Stack> stacksList;
	private int maxHeight;
	private int size;

	public StackOfPlates(int maxHeight) {
		this.stacksList = new ArrayList<Stack>();
		this.maxHeight = maxHeight;
		this.size = 0;
	}

	public void push(int data) {
		int stackNumber = size / maxHeight;
		if (size % maxHeight == 0) {
			stacksList.add(new Stack());
		}
		stacksList.get(stackNumber).push(data);
		size++;
	}

	public int pop() {
		if(size > 0) {
			int stackNumber = (size - 1) / maxHeight;
			int res = stacksList.get(stackNumber).pop();
			size--;
			if(size % maxHeight == 0) {
				stacksList.remove(stackNumber);
			}
			return res;
		} else {
			throw new IllegalStateException("pop(): Stack is empty");
		}
	}
}
