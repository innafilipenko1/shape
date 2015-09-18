import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serializer.Factory;
import serializer.Serializer;
import serializer.SerializerType;
import shapes.Circle;
import shapes.Group;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class XmlSerializerTest {

    Serializer xml;
    ByteArrayOutputStream out;

    @Before
    public void init(){
        xml = Factory.createSerializer(SerializerType.XML);
        out = new ByteArrayOutputStream();
    }

    @Test
    public void verify_ThatCircleCanBeSerializedToXml() throws IOException {

        xml.serialize(new Circle(1, 2, 5), out);
        String actual =  new String(out.toByteArray());

        Assert.assertEquals("<circle x=\"1\" y=\"2\" radius=\"5\"></circle>", actual);
    }

    @Test
    public void verify_ThatGroupOfCirclesCanBeSerializedToXml() throws IOException {
        Group group = new Group();
        group.add(new Circle(2, 3, 8));
        group.add(new Circle(4,7,5));

        xml.serialize(group, out);
        String actual =  new String(out.toByteArray());

        Assert.assertEquals("<group>" +
                "<circle x=\"2\" y=\"3\" radius=\"8\"></circle>" +
                "<circle x=\"4\" y=\"7\" radius=\"5\"></circle>" +
                "</group>",
                actual);

    }

    @Test
    public void verify_ThatGroupInGroupCanBeSerializedToXml() throws IOException {
        Group group = new Group();
        group.add(new Circle(2, 3, 8));
        group.add(new Circle(4,7,5));

        Group group2 = new Group();
        group2.add(group);

        xml.serialize(group2, out);
        String actual =  new String(out.toByteArray());

        Assert.assertEquals("<group>"+
                "<group>" +
                        "<circle x=\"2\" y=\"3\" radius=\"8\"></circle>" +
                        "<circle x=\"4\" y=\"7\" radius=\"5\"></circle>" +
                        "</group>"+
                        "</group>",
                actual);

    }

}
