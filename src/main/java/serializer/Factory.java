package serializer;

public class Factory {

    public static Serializer createSerializer(SerializerType type) {
        if (type == SerializerType.XML) {
            return new XmlSerializer();
        } else if (type == SerializerType.JSON) {
            return new JsonSerializer();
        } else {
            return null;
        }

    }
}
