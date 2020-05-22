import java.util.LinkedList;

public class Node {
	private String name;
	private int distance;
	private LinkedList<Node> adjList;
	private LinkedList<Integer> adjCost;
	private Node parent;
	private int start;
	private int end;
	
	public Node() {
		name = "";
		distance = 10000;
		adjList = new LinkedList<Node>();
		adjCost = new LinkedList<Integer>();
		parent = null;
		start = -1;
		end = -1;
	}
	
	public Node(String n) {
		name = n;
		distance = 10000;
		adjList = new LinkedList<Node>();
		adjCost = new LinkedList<Integer>();
		parent = null;
		start = -1;
		end = -1;
	}
	
	public boolean checkName(String n) {
		if(this.name.equals(n)) {
			return true;
		}
		return false;
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
	
	public LinkedList<Integer> getAdjCost() {
		return adjCost;
	}
	
	//Setters
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
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
