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

public class JsonSerializerTest {

    Serializer json;
    ByteArrayOutputStream out;

    @Before
    public void init(){
        json = Factory.createSerializer(SerializerType.JSON);
        out = new ByteArrayOutputStream();
    }

    @Test
    public void verify_ThatCircleCanBeSerializedToJson() throws IOException {

        json.serialize(new Circle(1, 2, 5), out);
        String actual =  new String(out.toByteArray());

        Assert.assertEquals("{type:'circle', x:1, y:2, radius:5}", actual);
    }

    @Test
    public void verify_ThatGroupInGroupCanBeSerializedToJson() throws IOException {
        Group group = new Group();
        group.add(new Circle(2, 3, 8));
        group.add(new Circle(4,7,5));

        Group group2 = new Group();
        group2.add(group);

        json.serialize(group2, out);
        String actual =  new String(out.toByteArray());

        Assert.assertEquals("["+
                        "[" +
                        "{type:'circle', x:2, y:3, radius:8}" +
                        "{type:'circle', x:4, y:7, radius:5}" +
                        "]"+
                        "]",
                actual);

    }
}
