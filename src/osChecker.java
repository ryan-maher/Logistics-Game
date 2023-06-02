public class osChecker {
    
    private static String OS = System.getProperty("os.name").toLowerCase();

    public int whichOS(){

        //System.out.println(OS);
        
        if(OS.contains("win")){
            //System.out.println(0);
            return 0;
        } else {
            //System.out.println(1);
            return 1;
        }

    }

}
