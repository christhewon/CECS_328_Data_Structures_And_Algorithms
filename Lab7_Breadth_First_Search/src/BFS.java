import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {
	
	/**
	 * Runs the Breadth First Search algorithm starting at Node v and prints the distance to all other nodes.
	 * @param v the starting node that is being used to find the distance to all other nodes.
	 */
	public static void breadthFirstSearch(Node v) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(v);
		while(q.size() > 0) {
			Node cur = q.poll();
			LinkedList<Node> list = cur.getAdjList();
			for(int i = 0; i < list.size(); i++) {
				Node n = list.get(i);
				if(n.getParent() == null) {
					q.add(n);
					n.setParent(cur);
					n.setDistance(cur.getDistance() + 1);
					System.out.println("distance to " + n.getValue() + " is " + n.getDistance());
				}
			}
		}
	}
	
	/**
	 * Given a Node v, checks if the graph associated with the node if bipartite
	 * @param v The starting Node of the graph that the bipartite check will be run on
	 * @return true or false depending on if the graph is bipartite or not
	 */
	public static Boolean isBipartite(Node v) {
		int colorCheck = 1;
		Queue<Node> q = new LinkedList<Node>();
		q.add(v);
		while(q.size() > 0) {
			if(colorCheck == 1) {
				colorCheck = 2;
			}
			else if(colorCheck == 2) {
				colorCheck = 1;
			}
			Node cur = q.poll();
			LinkedList<Node> list = cur.getAdjList();
			for(int i = 0; i < list.size(); i++) {
				Node n = list.get(i);
				if(n.getColor() == 0) {
					q.add(n);
					n.setColor(colorCheck);
				}
				else if(n.getColor() == cur.getColor()) {
					return false;
				}
			}
		}
		return true;
	}
}
