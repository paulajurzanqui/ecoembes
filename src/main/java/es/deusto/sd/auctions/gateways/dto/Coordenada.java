/**
 * Esta clase está generada con Claude Sonnet4.5
 */
package es.deusto.sd.auctions.gateways.dto;

public class Coordenada {
    private final double latitud;
    private final double longitud;

    public Coordenada(double latitud, double longitud) {
        validar(latitud, longitud);
        this.latitud = latitud;
        this.longitud = longitud;
    }

    private void validar(double lat, double lon) {
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException(
                    "Latitud debe estar entre -90 y 90");
        }
        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException(
                    "Longitud debe estar entre -180 y 180");
        }
    }

    // Getters
    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }

    @Override
    public String toString() {
        return String.format("(%.6f, %.6f)", latitud, longitud);
    }
}
