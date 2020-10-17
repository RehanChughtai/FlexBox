
package flexbox;


public abstract class Cube extends ThreeDShape {
    
    /**
     * Class constructor
     */
    public Cube(){}
    
    /**
     * Cube Constructor
     * @param length
     * @param height
     * @param width 
     */
    public Cube(double length, double height, double width){
        
        /**
         * Inherits from ThreeDShape.
         */
        super(length, height, width);
    }
    
    /**
     * Method to return the length of cube
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * Method to return the height of cube.
     * @return height 
     */
    public double getHeight() {
        return height;
    }

    /**
     * Method to return the width of cube.
     * @return width 
     */
    public double getWidth() {
        return width;
    }
    
    
    /**
     * Abstract method. Implemented in Box
     * @return String information about the features of box
     */
    public abstract String featuresInformation();
    
    
    /**
     * Method to calculate the volume of cube.
     * @see ThreeDShape Abstract Class
     * @return The volume of cube
     */
    @Override
    protected double calcVolume(){
        return(length*height*width);
    }
    
    /**
     * Method to calculate the surface area of cube
     * @see ThreeDShape Abstract Class
     * @return the surface area of cube
     */
    @Override
    protected double calcSurfaceArea(){
        return((2*length*width)+(2*length*height)+(2*width*height));
    }
}
