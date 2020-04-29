import java.util.LinkedList;

public class Node {
	private String value;
	private int distance;
	private LinkedList<Node> adjList;
	private Node parent;
	private int color;
	
	public Node() {
		value = "";
		distance = 0;
		adjList = new LinkedList<Node>();
		parent = null;
		color = 0;
		
	}
	
	//Getters
	public String getValue() {
		return value;
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
	
	public int getColor() {
		return color;
	}
	
	//Setters
	public void setValue(String value) {
		this.value = value;
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
	
	public void setColor(int color) {
		this.color = color;
	}
}
