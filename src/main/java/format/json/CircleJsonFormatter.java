package format.json;

import format.Formatter;
import shapes.Circle;

public class CircleJsonFormatter implements Formatter<Circle>{
    @Override
    public String format(Circle circle) {
        return String.format("{type:'circle', x:%d, y:%d, radius:%d}",
                circle.getX(), circle.getY(), circle.getRadius());
    }
}
