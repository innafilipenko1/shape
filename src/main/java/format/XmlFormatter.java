package format;


import shapes.Shape;

public class XmlFormatter<T extends Shape> implements Formatter<T> {

    @Override
    public String format(T shape) {

//        switch (shape.getClass().getSimpleName()) {
//            case "Circle":
//                return new CircleXmlFormatter().format(((Circle) shape));
//        }
        return "" ;
    }
}

