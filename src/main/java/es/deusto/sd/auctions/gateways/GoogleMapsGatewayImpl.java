/*package es.deusto.sd.auctions.gateways;

import es.deusto.sd.auctions.gateways.dto.Coordenada;
import es.deusto.sd.auctions.gateways.exception.GeocodificacionException;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class GoogleMapsGatewayImpl implements GeocodificacionGateway{
    private final GeoApiContext context;


    public GoogleMapsGatewayImpl(String apiKey) {
        this.context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

    @Override
    public Coordenada geodecodificar(String direccion) throws GeocodificacionException {
        try {
            // TU IMPLEMENTACIÓN AQUÍ
            // 1. Llama a GeocodingApi.geocode()
            // 2. Valida que hay resultados
            // 3. Extrae lat/lon del primer resultado
            // 4. Crea y devuelve objeto Coordenadas

            throw new UnsupportedOperationException("Por implementar");

        } catch (Exception e) {
            throw new GeocodificacionException(
                    "Error al geocodificar la dirección: " + direccion, e);
        }
    }

    @Override
    public String geodecodificar_inverso(double latidtud, double longitud) throws GeocodificacionException {
        try {
            // TU IMPLEMENTACIÓN AQUÍ
            // Similar pero usando reverseGeocode()

            throw new UnsupportedOperationException("Por implementar");

        } catch (Exception e) {
            throw new GeocodificacionException(
                    "Error en geocodificación inversa", e);
        }
    }

    public void shutdown() {
        context.shutdown();
    }
}
*/