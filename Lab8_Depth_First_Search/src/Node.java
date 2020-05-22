import java.util.LinkedList;

public class Node {
	private String name;
	private int distance;
	private LinkedList<Node> adjList;
	private Node parent;
	private int start;
	private int end;
	
	public Node() {
		name = "";
		distance = 0;
		adjList = new LinkedList<Node>();
		parent = null;
		start = -1;
		end = -1;
	}
	
	/**
	 * Constructor with a parameter for the name
	 * @param n used to set the name of the node
	 */
	public Node(String n) {
		name = n;
		distance = 0;
		adjList = new LinkedList<Node>();
		parent = null;
		start = -1;
		end = -1;
	}
	
	
	
	
	//Getters
	
	public String getName() {
		return name;
	}
	
	public LinkedList<Node> getAdjList() {
		return adjList;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	
	//Setters
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
}
