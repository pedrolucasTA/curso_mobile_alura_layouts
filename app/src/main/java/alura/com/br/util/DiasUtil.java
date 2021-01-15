package alura.com.br.util;

public class DiasUtil {
    public static final String SINGULAR = "dia";
    public static final String PLURAL = SINGULAR + "s";

    public static String formatEmTexto(int quantidadeDeDias) {
        if(quantidadeDeDias > 1) {
            return quantidadeDeDias + " " + PLURAL;
        }
        return quantidadeDeDias + " " + SINGULAR;
    }
}
