package validate;

/**
 * Clase que calcula o valida un documento de identificación del reino de España. (DNI,NIE,CIF).
 * @author yo
 * El antecedente del NIF es el CIF, utilizado en personas jurídicas
 */
public class ValidacionDNINIECIF extends ValidacionAlMenosUno implements IValidacion{

    private String documento;

    private static final  String mensajeError = "Documento Incorrecto";


    public ValidacionDNINIECIF(String documento){
        this.documento = documento;
    }

    @Override
    public boolean validar() {
        IValidacion [] validaciones = {new ValidacionDNINIF(documento),new ValidacionNIE(documento), new ValidacionNIFCIF(documento)};
        return super.validar(validaciones);
    }

    @Override
    public String getError() {
        return mensajeError;
    }

}
