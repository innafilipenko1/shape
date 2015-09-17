import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import serializer.Factory;
import serializer.Serializer;
import serializer.SerializerType;
import shapes.Circle;

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

        Assert.assertEquals("{type:'circle', x=1, y=2, radius=5}", actual);
    }
}
