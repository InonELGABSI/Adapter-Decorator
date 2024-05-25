package test;

public interface Moveable {
	
	public enum Direction{up,down,left,right}
	boolean moveMe(Direction d);
}
