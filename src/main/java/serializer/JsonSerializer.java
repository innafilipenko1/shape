package serializer;

import format.Formatter;
import format.json.CircleJsonFormatter;
import format.json.GroupJsonFormatter;
import shapes.Circle;
import shapes.Group;
import shapes.Shape;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer implements Serializer {

    private Map<Class<? extends Shape>, Formatter> map = new HashMap<Class<? extends Shape>, Formatter>();

    public JsonSerializer() {
        map.put(Circle.class, new CircleJsonFormatter());
        map.put(Group.class, new GroupJsonFormatter());
    }

    @Override
    public void serialize(Shape shape, OutputStream out) throws IOException {
        Formatter formatter = map.get(shape.getClass());
        String str = formatter.format(shape);
        out.write(str.getBytes());
    }
}
