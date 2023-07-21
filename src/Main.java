import models.Colour;
import models.GeneratorSettings;
import models.House;
import models.Sim;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main
{
  public static void main(String[] args)
  throws InterruptedException
  {
    ArrayList<Sim> sims_list = Sim.getSimList();

    House house = new House();

    Colour colour = null;
    try
    {
      colour = Colour.pickAColourFromJson();
    } catch (Exception e)
    {
      e.printStackTrace();
    }

    String ammount_of_sims_string = "You have to create " + sims_list.size() + " sim(s) : ";
    String list_of_sims_strings = "";
    for(int i=0; i<sims_list.size(); i++)
    {
      list_of_sims_strings = list_of_sims_strings + "One " + sims_list.get(i).getAgeTypeToString();
      if(i<sims_list.size()-1)
        list_of_sims_strings = list_of_sims_strings + ", ";
      else
        list_of_sims_strings = list_of_sims_strings + ".";
    }
    String house_string = "You have to create a " + house.getSizeTypeToString() + " house, in a " + house.getStyleTypeToString() + " style.";
    String house_string_2 = "";
    if(house.get_house_basements())
      house_string_2 = "It will need " + house.get_house_floors() + " floors, one or more basements, and " + house.get_house_rooms() + " rooms.";
    else
      house_string_2 = "It will need " + house.get_house_floors() + " floors, no basements, and " + house.get_house_rooms() + " rooms.";
    String house_string_3 = "";
    String colour_string = "The theme colour for your challenge will be " + colour.get_color_name() + ".";
    String separation_string = "\n";
    String good_luck_string = "Good luck with your challenge :D !";

    // Create the JFrame window
    JFrame frame = new JFrame("Simple GUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a JPanel with GridBagLayout
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = GridBagConstraints.RELATIVE;
    gbc.insets = new Insets(10, 10, 10, 10);
    panel.setBackground(Color.WHITE);

    // Create a JLabel to display the header text
    JLabel label = new JLabel("Here is a randomly generated Sims challenge:");
    label.setFont(label.getFont().deriveFont(Font.BOLD, 16f));
    panel.add(label, gbc);

    JTextArea separator = new JTextArea();
    separator.setEditable(false);
    separator.setBackground(Color.BLACK);
    separator.setPreferredSize(new Dimension(panel.getWidth(), 1));
    panel.add(separator, gbc);

    // Create JTextAreas to display the text
    JTextArea textAmmountOfSims = createStyledTextArea(ammount_of_sims_string, 14f, Color.BLACK, Color.WHITE);
    panel.add(textAmmountOfSims, gbc);
    JTextArea textSim = createStyledTextArea(list_of_sims_strings, 14f, Color.BLACK, Color.WHITE);
    textSim.setLineWrap(false); // Disable line wrap
    textSim.setWrapStyleWord(false); // Disable word wrap
    textSim.setAlignmentX(SwingConstants.LEFT);
    panel.add(textSim, gbc);
    JTextArea textHouse = createStyledTextArea(house_string, 14f, Color.BLACK, Color.WHITE);
    textHouse.setLineWrap(false); // Disable line wrap
    textHouse.setWrapStyleWord(false); // Disable word wrap
    textHouse.setAlignmentX(SwingConstants.LEFT);
    panel.add(textHouse, gbc);
    JTextArea textHouse2 = createStyledTextArea(house_string_2, 14f, Color.BLACK, Color.WHITE);
    textHouse2.setLineWrap(false); // Disable line wrap
    textHouse2.setWrapStyleWord(false); // Disable word wrap
    textHouse2.setAlignmentX(SwingConstants.LEFT);
    panel.add(textHouse2, gbc);
    JTextArea textColour = createStyledTextArea(colour_string, 14f, Color.BLACK, Color.WHITE);
    textColour.setLineWrap(false); // Disable line wrap
    textColour.setWrapStyleWord(false); // Disable word wrap
    textColour.setAlignmentX(SwingConstants.LEFT);
    panel.add(textColour, gbc);
    JPanel colorSquare = new JPanel();
    colorSquare.setBackground(Color.decode(colour.get_color_hex()));
    colorSquare.setPreferredSize(new Dimension(100, 100));
    colorSquare.setBorder(new LineBorder(Color.BLACK));
    panel.add(colorSquare, gbc);

    panel.add(separator, gbc);

    JTextArea textGoodLuck = createStyledTextArea(good_luck_string, 14f, Color.WHITE, new Color(40, 167, 69));
    textGoodLuck.setLineWrap(false); // Disable line wrap
    textGoodLuck.setWrapStyleWord(false); // Disable word wrap
    textGoodLuck.setAlignmentX(SwingConstants.LEFT);
    panel.add(textGoodLuck, gbc);

    // Set the preferred size of the panel to ensure proper layout
    panel.setPreferredSize(new Dimension(1280, 720));

    // Add the panel to the JFrame
    frame.getContentPane().add(panel);

    // Pack the frame to automatically adjust its size
    frame.pack();

    // Center the frame on the screen
    frame.setLocationRelativeTo(null);

    // Set the JFrame to be visible
    frame.setVisible(true);
  }

  private static JTextArea createStyledTextArea(String text, float fontSize, Color foregroundColor, Color backgroundColor) {
    JTextArea textArea = new JTextArea(text);
    textArea.setFont(textArea.getFont().deriveFont(fontSize));
    textArea.setForeground(foregroundColor);
    textArea.setBackground(backgroundColor);
    textArea.setEditable(false);
    textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    return textArea;
  }

  private static int getRandomBetweenConstants(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }
}