package flexbox;

public class BoxType3 extends Box{
    
    
    /**
     * Constructor for BoxType3
     * @param length double Length of box.
     * @param height double Height of box.
     * @param width double Width of box.
     * @param cardboardGrade int Cardboardgrade of box.
     * @param numberOfColours int Number of colours of box.
     * @param reinforcementBottom boolean ReinforcementBottom of box.
     * @param reinforcementCorners boolean reinforcementCoerner of box.
     * @param sealableTop boolean sealableTop of box.
     */
    public BoxType3(double length, double height, double width, int cardboardGrade, 
            int numberOfColours, boolean reinforcementBottom, 
            boolean reinforcementCorners, boolean sealableTop){
    
        /**
         * Inherits from box.
         */
        super(length, height, width, cardboardGrade, numberOfColours, 
                reinforcementBottom, reinforcementCorners, sealableTop);
        this.type=3;
    }
}
