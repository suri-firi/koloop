// BAZOWY DEKORATOR (Taka ogólna "kurtka", z której dziedziczą inne kurtki zimowe, letnie itp.)
public abstract class ShapeDecorator implements Shape {

    protected Shape shape; // protected = widoczne dla mnie i moich dzieci (innych dekoratorów)

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    // Domyślnie kurtka nie zmienia rozmiaru
    @Override
    public BoundingBox boundingBox() {
        return shape.boundingBox();
    }
}