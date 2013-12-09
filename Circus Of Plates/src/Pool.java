import java.util.ArrayList;

public class Pool {
	ArrayList<Shape> used;
	ArrayList<Shape> available;

	public Pool() {
		used = new ArrayList<Shape>();
		available = new ArrayList<Shape>();
		ShapeCreator x = ShapeCreator.getShapeCreator();
		for (int i = 0; i < 1000; i++)
			available.add(x.getRandomShape());
	}


	public Shape getShape() {
		if(available.isEmpty())return null;
		Shape a = available.get(available.size()-1);
		available.remove(available.size()-1);
		used.add(a);
		return a;
	}

}
