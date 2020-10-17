package flexbox;

/**
 * Abstract class.
 */
public abstract class ThreeDShape {
    protected double length;
    protected double height;
    protected double width;
    
    /**
     * Class constructor.
     */
    public ThreeDShape(){}
    
    /**
     * ThreeDShare Constructor. Overloaded.
     * @param length double.
     * @param height double.
     * @param width double.
     */
    public ThreeDShape(double length, double height, double width){
        this.length = length;
        this.height = height;
        this.width = width;
    }
    
    /**
     * Abstract method. Implemented in Cube class.
     * @see Cube Abstract Class.
     * @return The volume of shape.
     */
    protected abstract double calcVolume();
    
    /**
     * Abstract method. Implemented in Cube class.
     * @see Cube Abstract Class.
     * @return Surfe area of shape.
     */
    protected abstract double calcSurfaceArea();
    
}
