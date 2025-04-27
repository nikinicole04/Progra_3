import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JButton btnEncolar;
    private JButton btnCalcular;
    private JButton btnBuscar;
    private JTextField txtBuscar;
    private JTextArea txtPokemon;
    private JButton btnEvolucion;
    private ColaPokemon mColaPokemon;

    public Ventana() {
        mColaPokemon = new ColaPokemon();
        btnEncolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mColaPokemon.encolarPokemones();
                txtPokemon.setText(mColaPokemon.mostrarCola());

                JOptionPane.showMessageDialog(null, "Se han encolado los Pokémon.");
            }
        });
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                      txtPokemon.setText(mColaPokemon.calcularPoderTotalAjustado());
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habilidad = txtBuscar.getText().trim();
                if (habilidad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa una habilidad para buscar.");
                } else {
                    String resultado = mColaPokemon.filtrarPorHabilidad(habilidad);
                    if (resultado.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún Pokémon con esa habilidad.");
                    } else {
                        txtPokemon.setText(resultado);
                    }
                }
            }
        });
        btnEvolucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = mColaPokemon.evolucionarPokemones();
                if (resultado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay Pokémon que evolucionen.");
                } else {
                    txtPokemon.setText(resultado);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
