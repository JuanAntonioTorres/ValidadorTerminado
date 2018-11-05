package validate;

public class ValidacionAlMenosUno {
    private String error;

    protected boolean validar(IValidacion validadores[]) {

        for (int i = 0; i < validadores.length; i++) {

            if (validadores[i].validar()) {

                return true;
            }

            this.error = validadores[i].getError();
        }


        return false;
    }

    public String getError() {
        return error;
    }

}




