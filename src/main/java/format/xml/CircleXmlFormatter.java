package format.xml;

import format.Formatter;
import shapes.Circle;

public class  CircleXmlFormatter implements Formatter<Circle> {

    @Override
        public String format(Circle circle) {
        return String.format("<circle x=\"%d\" y=\"%d\" radius=\"%d\"></circle>",
                circle.getX(), circle.getY(), circle.getRadius());
    }
}


