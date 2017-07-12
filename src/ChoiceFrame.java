
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

class ChoiceFrame extends JFrame {

    private JTextField sampleField;
    private JCheckBox italicCheckBox;
    private JCheckBox boldCheckBox;
    private JRadioButton smallButton;
    private JRadioButton mediumButton;
    private JRadioButton largeButton;
    private JComboBox facenameCombo;

    public void initialize() {

        sampleField = new JTextField("Object Oriented Software Design");
        sampleField.setEditable(false);

        ActionListener listener = new ChoiceListener();

        facenameCombo = new JComboBox();
        facenameCombo.addItem("Serif");
        facenameCombo.addItem("SansSerif");
        facenameCombo.addItem("Monospaced");
        facenameCombo.setEditable(true);
        facenameCombo.addActionListener(listener);

        italicCheckBox = new JCheckBox("Italic");
        italicCheckBox.addActionListener(listener);

        boldCheckBox = new JCheckBox("Bold");
        boldCheckBox.addActionListener(listener);

        smallButton = new JRadioButton("Small");
        smallButton.setSelected(true);
        smallButton.addActionListener(listener);

        mediumButton = new JRadioButton("Medium");
        mediumButton.addActionListener(listener);

        largeButton = new JRadioButton("Large");
        largeButton.addActionListener(listener);

        // add radio buttons to button group

        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallButton);
        sizeGroup.add(mediumButton);
        sizeGroup.add(largeButton);

        // add components to panels

        JPanel facenamePanel = new JPanel();
        facenamePanel.add(facenameCombo);

        JPanel sizeGroupPanel = new JPanel();
        sizeGroupPanel.add(smallButton);
        sizeGroupPanel.add(mediumButton);
        sizeGroupPanel.add(largeButton);
        sizeGroupPanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));

        JPanel styleGroupPanel = new JPanel();
        styleGroupPanel.add(italicCheckBox);
        styleGroupPanel.add(boldCheckBox);
        styleGroupPanel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));

        // line up component panels

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 1));
        southPanel.add(facenamePanel);
        southPanel.add(sizeGroupPanel);
        southPanel.add(styleGroupPanel);

        // add panels to content pane

        Container contentPane = getContentPane();
        contentPane.add(sampleField, "Center");
        contentPane.add(southPanel, "South");

        setSampleFont();
    }

    /**
     * Gets user choice for font name, style, and size and sets the font of the
     * text field.
     */
    private void setSampleFont() {  // get font name

        String facename = (String) facenameCombo.getSelectedItem();

        // get font style

        int style = 0;
        if (italicCheckBox.isSelected()) {
            style = style + Font.ITALIC;
        }
        if (boldCheckBox.isSelected()) {
            style = style + Font.BOLD;
        }

        // get font size

        int size = 0;

        final int SMALL_SIZE = 12;
        final int MEDIUM_SIZE = 16;
        final int LARGE_SIZE = 24;

        if (smallButton.isSelected()) {
            size = SMALL_SIZE;
        } else if (mediumButton.isSelected()) {
            size = MEDIUM_SIZE;
        } else if (largeButton.isSelected()) {
            size = LARGE_SIZE;
        }

        // set font of text field

        sampleField.setFont(new Font(facename, style, size));
        sampleField.repaint();
    }

    private class ChoiceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            setSampleFont();
        }
    }
}
