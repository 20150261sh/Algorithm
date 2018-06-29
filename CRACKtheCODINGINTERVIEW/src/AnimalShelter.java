/* CRACKING the CODING INTERVIEW
3. Stacks and Queues
3-6) Animal Shelter*/

import java.util.LinkedList;

public class AnimalShelter {
	LinkedList<String> care = new LinkedList<String>();

	void print() {
		for(int i = 0; i < care.size(); i++) {
			System.out.print(care.get(i) + " ");
		}
		System.out.println();
	}
	
	void enqueue(String animal) {
		care.addLast(animal);
	}

	String dequeueAny() {
		String del = care.removeFirst();
		return del;
	}

	String dequeueDog() {
		for(int i = 0; i < care.size(); i++) {
			if(care.get(i).equals("dog")) {
				String del = care.remove(i);
				return del;
			}
		}
		return "Dog is not in shelter";
	}

	String dequeueCat() {
		for(int i = 0; i < care.size(); i++) {
			if(care.get(i).equals("cat")) {
				String del = care.remove(i);
				return del;
			}
		}
		return "Cat is not in shelter";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalShelter shel = new AnimalShelter();
		shel.enqueue("dog");
		shel.enqueue("cat");
		shel.enqueue("dog");
		shel.enqueue("dog");
		shel.print();
		shel.dequeueAny();
		shel.print();
		shel.dequeueDog();
		shel.print();
		shel.dequeueCat();
		shel.print();
	}

}
