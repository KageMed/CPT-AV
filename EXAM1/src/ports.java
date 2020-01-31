public class ports {

    public static void main(String[] args) {

        try{




        }catch (Exception e){

            ExceptionManager exceptionManager = new ExceptionManager(e);
            exceptionManager.saveAsXML();
        }



    }

}
