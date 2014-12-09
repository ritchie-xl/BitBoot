public class checkDatatype {
    public static boolean isNumeric(String input){
        boolean retVal = true;
        try{
            double d = Double.parseDouble(input);
        }catch (NumberFormatException nfe){
            retVal = false;
        }
        return retVal;
    }
}
