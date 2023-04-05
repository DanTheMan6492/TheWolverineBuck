import java.util.ArrayList;
import ADT.*;

public class Driver {

	class Coord {
		public int x, y;
		public Coord() {}
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Coord left()  {return new Coord(x-1, y);}
		public Coord right() {return new Coord(x+1, y);}
		public Coord up()    {return new Coord(x, y-1);}
		public Coord down()  {return new Coord(x, y+1);}
	}
	
	public int mode;
	public static void main(String[] args) {
		
	}
	
	public <T> ArrayList deepCopyList(ArrayList<T> list) {
		ArrayList<T> result = new ArrayList<T>();
		for(T el : list) {
			result.add(el);
		}
		return result;
	}
	
	public void Qbased(char[][] map) {
		//find the coordinates of the starting position
		Coord start = null;
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[0].length; c++) {
				if(map[r][c] == 'W') start = new Coord(c, r);
			}
		}
		
		//If W is not present in the map, exit the program
		if(start == null) System.exit(-1);
		
		
		Queue<Coord> pos = new Queue<Coord>();
		Queue<ArrayList<Coord>> paths = new Queue<ArrayList<Coord>>();
		pos.enqueue(start);
		while(true) {
			Coord next = pos.dequeue();
			ArrayList<Coord> path = paths.dequeue();
			
			if(next.x != 0) {
				pos.enqueue(next.left());
			}
			if(next.x != map[0].length) {
				pos.enqueue(next.right());
			}
			if(next.y != 0) {
				pos.enqueue(next.up());
			}
			if(next.y != map.length) {
				pos.enqueue(next.down());
			}
			
		}
	}
}
