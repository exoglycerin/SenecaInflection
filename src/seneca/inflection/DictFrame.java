package seneca.inflection;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class DictFrame extends JFrame implements ActionListener, FocusListener{
    private JTextField input = new JTextField(20);
    JButton search = new JButton("Search");
    JTextArea results = new JTextArea(30, 45);
    
    
    public DictFrame() {
        super("Seneca Dictionary");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setLayout(new BorderLayout());
        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();
        JLabel enter = new JLabel();
        enter.setText("Enter an English word:");
        search.addActionListener(this);
        JLabel result = new JLabel("Results:");
        results.setEditable(false);
        results.setWrapStyleWord(true);
        JScrollPane jScrollPanel = new JScrollPane(results);
        pane1.add(enter);
        pane1.add(input);
        pane1.add(search);
        pane2.add(result);
        pane2.add(jScrollPanel);
        add(pane1, BorderLayout.NORTH);
        add(pane2, BorderLayout.WEST);
        setVisible(true);
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Couldn't use the system look and feel: " + e);
        }
    }
    
    public void actionPerformed(ActionEvent event) {
        try {
            String stem = input.getText();
            System.out.println(stem);
            ArrayList output = Dictionary.dictionary(stem);
            System.out.println(output.size());
            for (int i = 0; i < output.size(); i++) {
                System.out.println(output.get(i));
                String defItem = (String)output.get(i);
                ArrayList<String> defined = new ArrayList<String>(Arrays.asList(defItem.split("\\$")));
                for (int j = 0; j < defined.size(); j++) {
                    results.append("\n" + (String)defined.get(j).toString());
                }
                //results.append("\n" + (String)output.get(i).toString());
                repaint();
            }
            
        } catch (Exception exc) {
            System.out.println("Error:");
        }
    }
    
    public void focusGained(FocusEvent event) {
        
    }
    
    public void focusLost(FocusEvent event) {
        
    }
    
    public static void main(String[] arguments) {
        DictFrame frame = new DictFrame();
    }
}