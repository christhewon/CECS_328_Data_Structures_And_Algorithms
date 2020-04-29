import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node e = new Node();
		Node f = new Node();
		Node g = new Node();
		Node h = new Node();
		
		//Setting Values
		a.setValue("a");
		b.setValue("b");
		c.setValue("c");
		d.setValue("d");
		e.setValue("e");
		f.setValue("f");
		g.setValue("g");
		h.setValue("h");
		
		
		//Setting adj List
		a.getAdjList().add(c);
		a.getAdjList().add(d);
		b.getAdjList().add(c);
		b.getAdjList().add(e);
		c.getAdjList().add(a);
		c.getAdjList().add(b);
		c.getAdjList().add(d);
		d.getAdjList().add(a);
		d.getAdjList().add(c);
		d.getAdjList().add(e);
		d.getAdjList().add(f);
		e.getAdjList().add(b);
		e.getAdjList().add(d);
		e.getAdjList().add(f);
		f.getAdjList().add(d);
		f.getAdjList().add(e);
		f.getAdjList().add(h);
		h.getAdjList().add(f);
		
		Node[] list = new Node[8];
		list[0] = a;
		list[1] = b;
		list[2] = c;
		list[3] = d;
		list[4] = e;
		list[5] = f;
		list[6] = g;
		list[7] = h;
		
		/*
		for(int i = 0; i < list.length; i++) {
			System.out.println("list  for" + i);
			while(list[i].getAdjList().size() > 0) {
				System.out.print(list[i].getAdjList().poll());
			}
		}
		 */
		
		Node start = new Node();
		String choice = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a letter a-h");
		choice = input.next();
		System.out.println(choice + ".......");
		for(int i = 0; i < list.length; i++) {
			if(list[i].getValue().equals(choice)) {
				start = list[i];
			}
		}
		System.out.println("start node is " + start.getValue());
		
		BFS.breadthFirstSearch(start);
		System.out.println(BFS.isBipartite(start));
	}
}
