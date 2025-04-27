import java.util.LinkedList;
import java.util.Queue;


public class ColaPokemon {
    private Queue<Pokemon> cola;
    public ColaPokemon() {
        cola = new LinkedList<>();
    }
    //R1 Encolar
    public void encolarPokemones() {
        cola.add(new Pokemon()); //Primer Pokemon por defecto

        // Cuatro Pokemon con valores
        cola.add(new Pokemon("Charmander", "Fuego", 130, "Ascuas", "Activo"));
        cola.add(new Pokemon("Pikachu", "Agua", 110, "Pistola Agua", "Activo"));
        cola.add(new Pokemon("Bulbasaur", "Planta", 125, "Latigazo", "Activo"));
        cola.add(new Pokemon("Pidgey", "Volador", 95, "Ataque Rápido", "Activo"));
    }

    // R2 Mostrar Cola
    public String mostrarCola() {
        // Verificamos si la cola está vacía.
        if (cola.isEmpty()) return "La cola está vacía.";

        // Usamos StringBuilder para construir el texto que representa la cola.
        StringBuilder sb = new StringBuilder();
        for (Pokemon p : cola) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    // R3 Calcular Poder Total Ajustado
    public String calcularPoderTotalAjustado() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-- Poder Total Ajustado --\n");
        for (Pokemon p : cola) {
            double poderAjustado = p.getNivelPoder();
            if (p.getTipo().equalsIgnoreCase("Fuego")) {
                poderAjustado *= 1.3;
            } else if (p.getTipo().equalsIgnoreCase("Agua")) {
                poderAjustado *= 1.5;
            } else if (p.getTipo().equalsIgnoreCase("Planta")) {
                poderAjustado *= 1.2;
            }

            sb.append("Nombre: ").append(p.getNombre()).append("\n")
                    .append("Tipo: ").append(p.getTipo()).append("\n")
                    .append("Habilidad: ").append(p.getHabilidad()).append("\n")
                    .append("Poder Ajustado: ").append(poderAjustado).append("\n")
                    .append("------------------------------\n");
        }
        return sb.toString();
    }

    // R4 Filtrar por habilidad (corregido)
    public String filtrarPorHabilidad(String habilidadBuscada) {
        Queue<Pokemon> colaFiltrada = new LinkedList<>();
        for (Pokemon p : cola) {
            if (p.getHabilidad().equalsIgnoreCase(habilidadBuscada)) {
                colaFiltrada.add(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (colaFiltrada.isEmpty()) {
            sb.append("No se encontró habilidad: ").append(habilidadBuscada).append("\n");
        } else {
            sb.append("\nPokémon con la habilidad '").append(habilidadBuscada).append("':\n");
            for (Pokemon p : colaFiltrada) {
                sb.append(p).append("\n");
            }
        }
        return sb.toString();
    }


    // R5 Evolución y Cambio de Estado
    public String evolucionarPokemones() {
        Queue<Pokemon> colaEvolucionados = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (Pokemon p : cola) {
            boolean evoluciona = false;

            if (p.getNivelPoder() >= 140 || p.getHabilidad().equalsIgnoreCase("Ascuas")) {
                evoluciona = true;
            }

            if (evoluciona) {
                p.setEstado("Evolucionando");
                int nuevoPoder = (int) (p.getNivelPoder() * 1.2);

                // Crear un nuevo Pokémon evolucionado
                Pokemon evolucionado = new Pokemon(
                        p.getNombre(),
                        p.getTipo(),
                        nuevoPoder,
                        p.getHabilidad(),
                        p.getEstado()
                );

                colaEvolucionados.offer(evolucionado);
            }
        }

        sb.append("\nPokémon Evolucionados:\n");
        if (colaEvolucionados.isEmpty()) {
            sb.append("No hay Pokémon que evolucionen.\n");
        } else {
            for (Pokemon p : colaEvolucionados) {
                sb.append(p).append("\n------------------------\n");
            }
        }
        return sb.toString();
    }
}