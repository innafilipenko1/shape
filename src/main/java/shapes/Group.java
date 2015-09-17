package shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements Shape, Iterable {

    private List<Shape> shapes = new ArrayList<Shape>();

//    @Override
//    public void draw(OutputStream out) throws IOException {
//        out.write("<group>".getBytes());
//        for (Shape shape : shapes) {
//            shape.draw(out);
//        }
//        out.write("</group>".getBytes());
//
//    }

    public void add(Shape shape) {

        if (shape == null) {
            throw new IllegalArgumentException("Shape cannot be null!");
        }

        shapes.add(shape);


    }

    @Override
    public Iterator iterator() {
        return new ShapeIterator();
    }

    private class ShapeIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}