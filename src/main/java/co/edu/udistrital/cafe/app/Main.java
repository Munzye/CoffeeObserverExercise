package co.edu.udistrital.cafe.app;

import co.edu.udistrital.cafe.service.CooperativaCafeEspecial;
import co.edu.udistrital.cafe.service.TiendaCafeService;

public class Main {

    public static void main(String[] args) {
        CooperativaCafeEspecial cooperativa = new CooperativaCafeEspecial();
        TiendaCafeService service = new TiendaCafeService(cooperativa);
      
        service.crearBarista("Ana", "1010");
        service.crearBarista("Luis", "2020");
        service.crearBarista("Majo", "3030");

        service.suscribirBarista("1010");
        service.suscribirBarista("2020");

        service.registrarNuevoLote(
                "Bourbón Rosado",
                "Frutos rojos, mora, cereza, caramelo, acidez media-alta, residual a cacao",
                "Acevedo, Huila",
                1250,
                "Don Carlos",
                42.5
        );

        //Elim Luis
        service.eliminarSuscripcion("2020");

        //NotiAna
        service.registrarNuevoLote(
                "Geisha",
                "Floral, jazmín, miel, cítricos, acidez brillante",
                "Génova, Quindío",
                1750,
                "Doña Patricia",
                18.0
        );
    }
}
