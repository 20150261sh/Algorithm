/* CRACKING the CODING INTERVIEW
3. Stacks and Queues
3-2) Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.  */

import java.util.Stack;

public class StackMin {
	private Stack<Integer> stack_origin = new Stack<Integer>();
	private Stack<Integer> stack_min = new Stack<Integer>();
	
	void push(int input) {
		stack_origin.push(input);
		if(stack_min.isEmpty()) 
			stack_min.push(input);
		else {
			if(input <= stack_min.peek())
				stack_min.push(input);
		}
	}
	
	void pop() {
		int popValue = stack_origin.pop();
		if(popValue == stack_min.peek())
			stack_min.pop();
	}
	
	int min() {
		return stack_min.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackMin s = new StackMin();
		s.push(4);
		s.push(1);
		s.push(5);
		s.pop();
		s.pop();
		s.push(0);
		System.out.println(s.min());
	}

}
