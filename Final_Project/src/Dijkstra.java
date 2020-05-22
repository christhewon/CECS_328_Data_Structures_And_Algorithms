import java.util.ArrayList;

public class Dijkstra {
	
	/**
	 * Runs Diykstras algorithm starting at node n
	 *  Finds the shortest distance between every node
	 * @param n the starting node for the dijkstras algorithm
	 */
	public static void Dijkstras(Node n) {
		Node temp = new Node();
		Heap heap = new Heap();
		Node cur = new Node();
		n.setDistance(0);
		n.setParent(n);
		heap.add(n);
		int dist = 0;
		
		while(heap.getArr().size() > 0) {
			temp = heap.remove(0); //root
			for(int i = 0; i < temp.getAdjList().size(); i++) {
				cur = temp.getAdjList().get(i);
				dist = temp.getDistance() + findWeight(temp,cur);
				if(cur.getParent() == null) {
					heap.add(cur);
				}
				if(cur.getDistance() > dist) {
					cur.setDistance(dist);
					cur.setParent(temp);
					heap.minHeapify(0,0,heap.getArr().size());
				}
			}
		}
	}
	
	/**
	 * finds the distance between two nodes
	 * @param n the first node
	 * @param s the second node
	 * @return the distance between the two nodes
	 */
	public static int findWeight(Node n, Node s) {
		int length = n.getAdjList().size();
		for(int i = 0; i < length; i++) {
			if(n.getAdjList().get(i) == s) {
				return n.getAdjCost().get(i); // need location of adjList
			}
		}
		return -1;
	}
}
