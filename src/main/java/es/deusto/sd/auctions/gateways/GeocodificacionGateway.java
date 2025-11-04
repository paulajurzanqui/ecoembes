/**
 * Esta clase está generada con Claude Sonnet4.5
 */
package es.deusto.sd.auctions.gateways;

import es.deusto.sd.auctions.gateways.dto.Coordenada;
import es.deusto.sd.auctions.gateways.exception.GeocodificacionException;


public interface GeocodificacionGateway {
    Coordenada geodecodificar(String direccion) throws GeocodificacionException;
    String geodecodificar_inverso(double latidtud, double longitud) throws GeocodificacionException;
}
