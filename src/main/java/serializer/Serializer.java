package serializer;

import shapes.Shape;

import java.io.IOException;
import java.io.OutputStream;

public interface Serializer {

     void serialize(Shape shape, OutputStream out) throws IOException;
}
