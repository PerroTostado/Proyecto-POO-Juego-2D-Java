
package Utileria;
import java.util.HashMap;
import java.util.Map;
import ComunidadUIS.Jugador;

public class GestorDeArchivos {
   // Almacenamiento limitado a 4. La clave es el ID (1-4).
    private static final Map<Integer, Jugador> partidasActivas = new HashMap<>();
    private static final int MAX_PARTIDAS = 4;

    /** Crea una nueva partida y le asigna el ID más bajo disponible (1 a 4). */
    public static int crearNuevaPartida(Jugador nuevoJugador) {
        if (partidasActivas.size() >= MAX_PARTIDAS) {
            System.out.println("❌ Límite de partidas alcanzado (" + MAX_PARTIDAS + ").");
            return 0;
        }

        for (int id = 1; id <= MAX_PARTIDAS; id++) {
            if (!partidasActivas.containsKey(id)) {
                partidasActivas.put(id, nuevoJugador);
                return id; // ID asignado con éxito
            }
        }
        return 0; // No debería llegar aquí
    }

    /** Accede a una partida activa usando su ID. */
    public static Jugador obtenerPartida(int idPartida) {
        if (idPartida < 1 || idPartida > MAX_PARTIDAS || !partidasActivas.containsKey(idPartida)) {
            System.out.println("⚠️ ID " + idPartida + " no válido o partida no activa.");
            return null;
        }
        return partidasActivas.get(idPartida);
    }
    
    /** Muestra un resumen de las partidas activas. */
    public static void mostrarPartidasActivas() {
        System.out.println("\n--- Partidas Guardadas (" + partidasActivas.size() + "/" + MAX_PARTIDAS + ") ---");
        if (partidasActivas.isEmpty()) {
            System.out.println("No hay partidas guardadas.");
            return;
        }
        for (Map.Entry<Integer, Jugador> entry : partidasActivas.entrySet()) {
            Jugador j = entry.getValue();
            // Uso del objeto compuesto (rol) para mostrar el tipo de personaje
            System.out.println("ID [" + entry.getKey() + "]: Nivel " + j.getNivelPersonaje() + ", Rol: " + j.getRol().getNombreRol());
        }
        System.out.println("----------------------------------------");
    }
       
        
    }
            

