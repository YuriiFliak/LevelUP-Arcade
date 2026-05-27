package usuarios.services;



public class IAService {

    // 1. Generar descripción
    public static String generarDescripcion(String nombreProducto) {

        String prompt = "Genera una descripción comercial breve del producto: " + nombreProducto;

        return LlmService.preguntarIA(prompt);
    }

    // 2. Sugerir categoría
    public static String sugerirCategoria(String nombreProducto) {

        String prompt = "Dime SOLO una categoría para este producto: " + nombreProducto;

        return LlmService.preguntarIA(prompt);
    }
}