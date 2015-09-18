package format.json;

import format.Formatter;
import shapes.Circle;
import shapes.Group;
import shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class GroupJsonFormatter implements Formatter<Group> {
    private Map<Class<? extends Shape>, Formatter> map = new HashMap<Class<? extends Shape>, Formatter>();

    public GroupJsonFormatter() {
        map.put(Circle.class, new CircleJsonFormatter());
        map.put(Group.class, this);
    }

    @Override
    public String format(Group group) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Shape shape : group) {
            Formatter formatter = map.get(shape.getClass());
            sb.append(formatter.format(shape));
        }
        sb.append("]");

        return sb.toString();

    }


}
