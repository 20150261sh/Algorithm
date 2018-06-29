import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class DirectedGraph {
	// static int v;
	// static int e;

	static int nV; // �� vertex ����
	static int nE; // �� edge ����

public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    nV = scan.nextInt();
    nE = scan.nextInt();
    ArrayList<ArrayList<Integer>> adList = new <ArrayList<Integer>> ArrayList();
    
    for(int i=0;i<nV;i++) adList.add(new<Integer> ArrayList());
    //adList�� ���� ����Ʈ(�� vertex���� ������ vertext�� ǥ���� ����Ʈ)
    
    for(int i=0;i<nE;i++) {
        int vertex1, vertex2;
        vertex1 = scan.nextInt();
        vertex2 = scan.nextInt();
        
        adList.get(vertex1).add(vertex2);
    }
    
    
    //��������Ʈ ���
    for(int i=0;i<nV;i++) {
        Iterator<Integer> iter = adList.get(i).iterator();
        System.out.print(i);
        if(iter.hasNext()) System.out.print("-");
        while(iter.hasNext()) System.out.print(iter.next() + " ");
        System.out.println("");
    }
}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// Scanner scan = new Scanner(System.in);
	// System.out.println("Number of vertex: ");
	// v = scan.nextInt();
	// System.out.println("Number of edge: ");
	// e = scan.nextInt();
	// ArrayList<ArrayList<Integer>> list = new <ArrayList<Integer>> ArrayList();
	// }

}
