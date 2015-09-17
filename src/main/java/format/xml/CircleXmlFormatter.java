package format.xml;

import format.Formatter;
import shapes.Circle;

public class  CircleXmlFormatter implements Formatter<Circle> {

    @Override
    public String format(Circle shape) {
        return String.format("<circle x=\"%d\" y=\"%d\" radius=\"%d\"></circle>",
                shape.getX(), shape.getY(), shape.getRadius());
    }
}


