package validate;

public class ValidacionImagenNombre extends ValidacionMultiValidation implements IValidacion{

    private String value;
    private String [] lista = {"jpg" , "png"};

    public ValidacionImagenNombre(String value) {
        this.value = value;
    }

    public boolean validar(){

        String nombreImagen = new String(value.substring(0 , value.lastIndexOf('.')));

        String extension = new String(value.substring(value.lastIndexOf('.') + 1));

        IValidacion [] validadores = {new ValidacionExtensionFile(extension,this.lista) ,new ValidacionCadenaSinEspacio(nombreImagen)};

        return super.validar(validadores);

    }
}
