import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JLabel lblPrueba;
    private JTextArea txtPila;

    public Ventana() {


        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = txtCodigo.getText();
                Stack<Character> pila = new Stack<>();
                txtPila.setText(""); // Limpiar el área de pila

                for (int i = 0; i < texto.length(); i++) {
                    char c = texto.charAt(i);
                    // Si es un carácter de apertura, lo metemos a la pila
                    if (c == '(' || c == '{' || c == '[') {
                        pila.push(c);
                        JOptionPane.showMessageDialog(null, "Se agregó: " + c + " a la pila.");
                        // Si es un carácter de cierre, se verifica
                    } else if (c == ')' || c == '}' || c == ']') {
                        if (pila.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Código incorrecto");
                            return;
                        }
                        // Sacamos el último elemento
                        char apertura = pila.pop();
                        JOptionPane.showMessageDialog(null, "Se extrajo: " + apertura + " de la pila.");

                        if (!esPar(apertura, c)) {
                            JOptionPane.showMessageDialog(null, "Código incorrecto");
                            return;
                        }
                    }

                    // Mostrar pila actual en el txtPila
                    txtPila.append("Paso " + (i + 1) + ": " + pila.toString() + "\n");
                }
                // Verificamos si la pila está vacía
                if (pila.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Código correcto");
                } else {
                    JOptionPane.showMessageDialog(null, "Código incorrecto");
                }

            }
        });
    }

    private boolean esPar(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '{' && cierre == '}') ||
                (apertura == '[' && cierre == ']');
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
