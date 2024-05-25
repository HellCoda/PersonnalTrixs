package WindowsMain;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CollapsiblePanel extends JPanel {

private JButton button; // le bouton pour réduire ou agrandir le panneau
private JPanel content; // le contenu du panneau
private boolean collapsed; // l'état du panneau

public CollapsiblePanel(String title, Component component) {
super(new BorderLayout());
button = new JButton(title); // créer le bouton avec le titre
button.addActionListener(new ActionListener() { // ajouter un écouteur d'action
public void actionPerformed(ActionEvent e) {
toggle(); // changer l'état du panneau
}
});
content = new JPanel(new BorderLayout()); // créer le panneau du contenu
content.add(component, BorderLayout.CENTER); // ajouter le composant au centre
add(button, BorderLayout.NORTH); // ajouter le bouton au nord
add(content, BorderLayout.CENTER); // ajouter le contenu au centre
collapsed = false; // initialiser l'état à false
}

public void toggle() {
collapsed = !collapsed; // inverser l'état
content.setVisible(!collapsed); // changer la visibilité du contenu
revalidate(); // redimensionner le panneau
repaint(); // redessiner le panneau
}
}
