package format;

import shapes.Shape;

public interface Formatter<T extends Shape> {

    String format(T shape);



}
