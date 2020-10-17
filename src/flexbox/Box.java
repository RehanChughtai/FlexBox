package flexbox;

public class Box extends Cube{
    
    protected int cardboardGrade;
    protected int numberOfColours;
    protected boolean reinforcementBottom;
    protected boolean reinforcementCorners;
    protected boolean sealableTop;
    protected int type;
    public boolean confirmedOrderBox;
    
    /**
     * Class Constructor for box features.
     * @see BoxSelector class.
     * @param cardboardGrade Integer containing the grade of cardboard.
     * @param numberOfColours Integer number of colours requested.
     * @param reinforcementBottom Boolean if user specifies reinforcement bottom.
     * @param reinforcementCorners Boolean if user specifies reinforcement corners.
     */
    public Box(int cardboardGrade,int numberOfColours, 
            boolean reinforcementBottom,boolean reinforcementCorners){
        this.cardboardGrade=cardboardGrade;
        this.numberOfColours=numberOfColours;
        this.reinforcementBottom=reinforcementBottom;
        this.reinforcementCorners=reinforcementCorners;
        
    }
    
    /**
     * Class Constructor for box.
     * @param length double length of box.
     * @param height double height of box. 
     * @param width double width of box.
     * @param cardboardGrade Integer containing the grade of cardboard.
     * @param numberOfColours Integer number of colours requested.
     * @param reinforcementBottom Boolean if user specifies reinforcement bottom.
     * @param reinforcementCorners Boolean if user specifies reinforcement corners.
     * @param sealableTop Boolean if user specifies sealable top.
     */
    public Box(double length, double height, double width, int cardboardGrade, 
            int numberOfColours, boolean reinforcementBottom, 
            boolean reinforcementCorners, boolean sealableTop){
        
        /**
         * Inherits from Cube.
         */
        super(length,height,width);
        this.cardboardGrade = cardboardGrade;
        this.numberOfColours = numberOfColours;
        this.reinforcementBottom = reinforcementBottom;
        this.reinforcementCorners = reinforcementCorners;
        this.sealableTop = sealableTop;
        this.confirmedOrderBox=false;
    }
    
    /**
     * Method to get the cardboard grade.
     * @return integer cardboard grade
     */
    public int getCardboardGrade() {
        return cardboardGrade;
    }

    /**
     * Method to get the number of colours.
     * @return integer number of colours.
     */
    public int getNumberOfColours() {
        return numberOfColours;
    }
    
    /**
     * Method to get the type of box.
     * @return integer type of box.
     */
    public int getType(){
        return type;
    }

    /**
     * Method to get reinforcement bottom.
     * @return boolean reinforcement bottom.
     */
    public boolean isReinforcementBottom() {
        return reinforcementBottom;
    }
    
    /**
     * Method to get reinforcement corners.
     * @return boolean reinforcement corners.
     */
    public boolean isReinforcementCorners() {
        return reinforcementCorners;
    }

    /**
     * Method to get sealable top.
     * @return boolean sealable top.
     */
    public boolean isSealableTop() {
        return sealableTop;
    }

    /**
     * Method to get if the user has confirmed the box.
     * @return boolean status of box confirmation.
     */
    public boolean isConfirmedOrderBox() {
        return confirmedOrderBox;
    }
    
    /**
     * Method to change the status of confirmed box.
     */
    public void changeConfirmedOrderBox(){
        confirmedOrderBox=!confirmedOrderBox;
    }
    
    /**
     * Method to convert from boolean to string for display purposes.
     * @return String value converted from boolean.
     */
    public String rBottom(){
        if(reinforcementBottom){
            return "yes";
        }
        return "no";
    }
    
    /**
     * Method to convert from boolean to string for display purposes.
     * @return String value converted from boolean.
     */
    public String rCorners(){
        if(reinforcementCorners){
            return "yes";
        }
        return "no";
    }
    
    /**
     * Method to convert from boolean to string for display purposes.
     * @return String value converted from boolean.
     */
    public String sTop(){
        if(sealableTop){
            return "yes";
        }
        return "no";
    }
    
    /**
     * Method to calculate the base cost of box.
     * @return double base price calculation.
     */
    public double baseCost(){
        switch(cardboardGrade){
            case 1: return calcSurfaceArea()*0.55;
            case 2: return calcSurfaceArea()*0.65;
            case 3: return calcSurfaceArea()*0.82;
            case 4: return calcSurfaceArea()*0.98;
            case 5: return calcSurfaceArea()*1.50;
            default: return 0;
        }
    }
    
    /**
     * Method to calculate the cost of adding colours.
     * @return double colour cost calculation.
     */
    public double colourCost(){
        switch(numberOfColours){
            case 1: return baseCost()*0.12;
            case 2: return baseCost()*0.15;
            default: return 0;
        }
    }
    
    /**
     * Method to calculate the cost of reinforcement bottom.
     * @return double reinforcement bottom cost calculation.
     */
    public double reinforcementBottomCost(){
        if(reinforcementBottom){
            return baseCost()*0.13;
        }
        return 0;
    }
    
    /**
     * Method to calculate the cost of reinforcement corners.
     * @return double reinforcement corners cost calculation.
     */
    public double reinforcementCornersCost(){
        if(reinforcementCorners){
            return baseCost()*0.12;
        }
        return 0;
    }
    
    /**
     * Method to calculate the cost of sealable top.
     * @return double sealable top cost calculation.
     */
    public double sealableTopCost(){
        if(sealableTop){
            return baseCost()*0.10;
        }
        return 0;
    }
    
    /**
     * Method to calculate the total cost of box.
     * @see baseCost(), colourCost(), reinforcementBottomCost(), reinforcementCornersCost(), sealableTopCost().
     * @return double.
     */
    public double boxCost(){
        double cost=0;
        cost += baseCost();
        cost += colourCost();
        cost += reinforcementBottomCost();
        cost += reinforcementCornersCost();
        cost += sealableTopCost();
        return cost;
    }
    
    /**
     * Method overrides defined abstract method in Cube to get the features information from the box.
     * @return String containing formation about the features of box.
     */
    @Override
    public String featuresInformation(){
        String information ="Box Type: "+Integer.toString(type);
        information +="\n"+"Cardboard grade: "+Integer.toString(cardboardGrade);
        information +="\n"+"Number of colours: "+Integer.toString(numberOfColours);
        information +="\n"+"Reinforcement Bottom: "+rBottom();
        information +="\n"+"Reinforcement Corners: "+rCorners();
        information +="\n"+"Sealable top: "+sTop();
        return information;
    }
    
    /**
     * Method to get infromation about the box dimensions.
     * @return String information about box sizes.
     */
    public String boxSizeInformation(){
        String information ="Box length(m): "+String.format("%.3f",length);
        information +="\n"+"Box height(m): "+String.format("%.3f",height);
        information +="\n"+"Box width(m): "+String.format("%.3f",width);
        information +="\n"+"Box Volume(\u33A5): "+String.format("%.3f", calcVolume());
        information +="\n"+"Box Surface Area(\u33A1): "+String.format("%.3f", calcSurfaceArea());
        return information;
    }
    
    /**
     * Method to get information about the box cost.
     * @return String information containing about prices.
     */
    public String costBreakdownInformation(){
        String information ="Base: £"+String.format("%.2f", baseCost());
        information +="\n"+"Colour: £"+String.format("%.2f", colourCost());
        information +="\n"+"Reinforcement Bottom: £"+String.format("%.2f", reinforcementBottomCost());
        information +="\n"+"Reinforcement Corners: £"+String.format("%.2f", reinforcementCornersCost());
        information +="\n"+"Sealable top: £"+String.format("%.2f", sealableTopCost());
        information +="\n"+"Price per box: £"+String.format("%.2f", boxCost());
        return information;
    }
    
    /**
     * Overrides method from java.lang.Object for HashMap purposes.
     * @see BoxSelector Class.
     * @see java.lang.Object.
     * @return intger containing number depending on set of constrains.
     */
    @Override
    public int hashCode(){
        final int defaultRandomNum=31;
        int result=0;
        result += defaultRandomNum+cardboardGrade+numberOfColours;
        if(reinforcementBottom){
            result += 2;
        }
        else if(!reinforcementBottom){
            result +=1;
        }
        if(reinforcementCorners){
            result +=4;
        }
        else if(!reinforcementCorners){
            result +=3;
        }
        return result;
    }
    
    /**
     * Overrides method from java.lang.Object for HashMap purposes.
     * @param obj created to compare.
     * @see BoxSelector Class.
     * @see java.lang.Object.
     * @return boolean indicating if the attributes matches.
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Box){
            Box box = (Box) obj;
            return((box.cardboardGrade==this.cardboardGrade)&&
                    (box.numberOfColours==this.numberOfColours)&&
                    (box.reinforcementBottom==this.reinforcementBottom)&&
                    (box.reinforcementCorners==this.reinforcementCorners));
        }
        else{
            return false;
        }
    }
}
