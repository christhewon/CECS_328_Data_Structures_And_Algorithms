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
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getDistance() {
		return distance;
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
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	/*
	public void setAdjList(LinkedList<Node> adjList) {
		this.adjList = adjList;
	}
	
	 */
	
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
