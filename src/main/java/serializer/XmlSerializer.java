package serializer;

import format.Formatter;
import format.xml.CircleXmlFormatter;
import format.xml.GroupXmlFormatter;
import shapes.Circle;
import shapes.Group;
import shapes.Shape;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlSerializer implements Serializer {

    private Map<Class<? extends Shape>, Formatter> map = new HashMap<Class<? extends Shape>, Formatter>();

    public XmlSerializer() {
        map.put(Circle.class, new CircleXmlFormatter());
        map.put(Group.class, new GroupXmlFormatter());
    }

    @Override
    public void serialize(Shape shape, OutputStream out) throws IOException {
        Formatter formatter = map.get(shape.getClass());
        String str = formatter.format(shape);
        out.write(str.getBytes());
    }

}
