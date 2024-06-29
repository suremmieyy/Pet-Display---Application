import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PetDisplay extends JFrame {

    private JRadioButton horseButton;
    private JRadioButton chameleonButton;
    private JRadioButton parrotButton;
    private JRadioButton monkeyButton;
    private JRadioButton hedgehogButton;
    private JLabel petImageLabel;

    private Map<String, ImageIcon> petImageMap;

    public PetDisplay() {
        super("Pet Display");
        setLayout(new FlowLayout());

        horseButton = new JRadioButton("Horse");
        chameleonButton = new JRadioButton("Chameleon");
        parrotButton = new JRadioButton("Parrot");
        monkeyButton = new JRadioButton("Monkey");
        hedgehogButton = new JRadioButton("Hedgehog");
        petImageLabel = new JLabel();

        ButtonGroup group = new ButtonGroup();
        group.add(horseButton);
        group.add(chameleonButton);
        group.add(parrotButton);
        group.add(monkeyButton);
        group.add(hedgehogButton);

        add(horseButton);
        add(chameleonButton);
        add(parrotButton);
        add(monkeyButton);
        add(hedgehogButton);
        add(petImageLabel);

        // Create the pet image map
        petImageMap = new HashMap<>();
        petImageMap.put("Horse", new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\pets\\horse.jpeg"));
        petImageMap.put("Chameleon", new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\pets\\chameleon.jpeg"));
        petImageMap.put("Parrot", new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\pets\\parrot.jpeg"));
        petImageMap.put("Monkey", new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\pets\\monkey.jpeg"));
        petImageMap.put("Hedgehog", new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\pets\\hedgehog.jpeg"));

        JButton selectButton = new JButton("Select");
        add(selectButton);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPet = getSelectedPet();
                if (selectedPet != null) {
                    ImageIcon petImage = petImageMap.get(selectedPet);
                    if (petImage != null) {
                        petImageLabel.setIcon(petImage);
                        petImageLabel.revalidate(); // Add this line to revalidate the label
                        petImageLabel.repaint(); // Add this line to repaint the label
                        JOptionPane.showMessageDialog(PetDisplay.this, "You selected: " + selectedPet);
                    } else {
                        JOptionPane.showMessageDialog(PetDisplay.this, "No image found for " + selectedPet);
                    }
                } else {
                    JOptionPane.showMessageDialog(PetDisplay.this, "Please select a pet");
                }
            }
        });

        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private String getSelectedPet() {
        if (horseButton.isSelected()) {
            return "Horse";
        } else if (chameleonButton.isSelected()) {
            return "Chameleon";
        } else if (parrotButton.isSelected()) {
            return "Parrot";
        } else if (monkeyButton.isSelected()) {
            return "Monkey";
        } else if (hedgehogButton.isSelected()) {
            return "Hedgehog";
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetDisplay());
    }
}
