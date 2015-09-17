package format.xml;

import format.Formatter;
import shapes.Group;
import shapes.Shape;

public class GroupXmlFormatter implements Formatter<Group> {

    @Override
    public String format(Group group) {
        StringBuilder sb = new StringBuilder();
        sb.append("<group>");
        for (Shape shape : group) {
            group.add(shape);
        }

        sb.append("</group>");

        return sb.toString();
    }

}
