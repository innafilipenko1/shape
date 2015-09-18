package shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements Shape, Iterable<Shape> {

    private List<Shape> shapes = new ArrayList<Shape>();

    public void add(Shape shape) {

        if (shape == null) {
            throw new IllegalArgumentException("Shape cannot be null!");
        }

        shapes.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        return new ShapeIterator(this);
    }

    private class ShapeIterator implements Iterator<Shape> {

        private final Group group;
        private int index = 0;

        public ShapeIterator(Group group) {
            this.group = group;
        }

        @Override
        public boolean hasNext() {
            return index < group.shapes.size();
        }

        @Override
        public Shape next() {
            return group.shapes.get(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
