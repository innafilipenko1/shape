package format.xml;

import format.Formatter;
import shapes.Circle;
import shapes.Group;
import shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class GroupXmlFormatter implements Formatter<Group> {

    private Map<Class<? extends Shape>, Formatter> map = new HashMap<Class<? extends Shape>, Formatter>();

    public GroupXmlFormatter() {
        map.put(Circle.class, new CircleXmlFormatter());
        map.put(Group.class, this);
    }

    @Override
    public String format(Group group) {
        StringBuilder sb = new StringBuilder();
        sb.append("<group>");
        for (Shape shape : group) {
            Formatter formatter = map.get(shape.getClass());
            sb.append(formatter.format(shape));
        }
        sb.append("</group>");

        return sb.toString();
    }

}
