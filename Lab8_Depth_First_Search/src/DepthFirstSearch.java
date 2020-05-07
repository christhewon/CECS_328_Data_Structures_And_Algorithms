import java.util.LinkedList;

public class DepthFirstSearch {
	private static int timer = 1;
	private static boolean cycle = false;
	
	public static LinkedList<Node> DFS(Node[] list) {
		Node cur;
		Node start = new Node("start");
		start.setStart(0);
		start.setEnd(0);
		LinkedList<Node> topology = new LinkedList<Node>();
		for(int i = 0; i < list.length; i++) {
			cur = list[i];
			if(cur.getParent() == null) {
				cur.setParent(start);
				DFSVisit(cur, topology);
			}
		}
		return topology;
	}
	
	public static void DFSVisit(Node n, LinkedList<Node> link) {
		n.setStart(timer++);
		LinkedList<Node> list = n.getAdjList();
		for(int i = 0; i < list.size(); i++) {
			Node cur = list.get(i);
			if(cur.getStart() == -1) {
				cur.setParent(n);
				DFSVisit(cur, link);
			}
			else if(cur.getEnd() == -1) {
				System.out.println();
				System.out.println(cur.getName() + " " + n.getName() + " cause a cycle");
				cycle = true;
			}
		}
		n.setEnd(timer++);
		link.add(n);
	}
	
	public static boolean getCycle() {
		return cycle;
	}
}

