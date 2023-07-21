package views;

import models.ChallengeColour;
import models.House;
import models.Sim;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class ViewGenerator
{

  //PROTECTED INTERFACE
  protected ViewGenerator()
  {
   initComponents();
  }

  //PRIVATE INTERFACE
  private void initComponents()
  {
    _gbc = new GridBagConstraints();
    _gbc.gridx = 0;
    _gbc.gridy = GridBagConstraints.RELATIVE;
    _gbc.insets = new Insets(10, 10, 10, 10);

    _main_frame = new JFrame("Sims Build Challenge Generator");
    _main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    _main_panel = new JPanel(new GridBagLayout());
    _main_panel.setBackground(Color.WHITE);

    _title_label = new JLabel("Here is a randomly generated Sims challenge :");
    _title_label.setFont(_title_label.getFont().deriveFont(Font.BOLD, 16f));
    _main_panel.add(_title_label, _gbc);

    _separator_textarea = new JTextArea();
    _separator_textarea.setEditable(false);
    _separator_textarea.setBackground(Color.BLACK);
    _separator_textarea.setPreferredSize(new Dimension(_main_panel.getWidth(), 1));
    _main_panel.add(_separator_textarea, _gbc);

    _sims_ammount_textarea = createStyledTextArea(EMPTY_STRING,14f, Color.BLACK, Color.WHITE);
    _main_panel.add(_sims_ammount_textarea, _gbc);

    _sims_description_textarea = createStyledTextArea(EMPTY_STRING,14f, Color.BLACK, Color.WHITE);
    _sims_description_textarea.setLineWrap(false); // Disable line wrap
    _sims_description_textarea.setWrapStyleWord(false); // Disable word wrap
    _sims_description_textarea.setAlignmentX(SwingConstants.LEFT);
    _main_panel.add(_sims_description_textarea, _gbc);

    _house_description_textarea = createStyledTextArea(EMPTY_STRING,14f, Color.BLACK, Color.WHITE);
    _house_description_textarea.setLineWrap(false); // Disable line wrap
    _house_description_textarea.setWrapStyleWord(false); // Disable word wrap
    _house_description_textarea.setAlignmentX(SwingConstants.LEFT);
    _main_panel.add(_house_description_textarea, _gbc);

    _house_description_2_textarea = createStyledTextArea(EMPTY_STRING,14f, Color.BLACK, Color.WHITE);
    _house_description_2_textarea.setLineWrap(false); // Disable line wrap
    _house_description_2_textarea.setWrapStyleWord(false); // Disable word wrap
    _house_description_2_textarea.setAlignmentX(SwingConstants.LEFT);
    _main_panel.add(_house_description_2_textarea, _gbc);

    _colour_description_textarea = createStyledTextArea(EMPTY_STRING,14f, Color.BLACK, Color.WHITE);
    _colour_description_textarea.setLineWrap(false); // Disable line wrap
    _colour_description_textarea.setWrapStyleWord(false); // Disable word wrap
    _colour_description_textarea.setAlignmentX(SwingConstants.LEFT);
    _main_panel.add(_colour_description_textarea, _gbc);

    _colour_square_panel = new JPanel();
    _colour_square_panel.setPreferredSize(new Dimension(100, 100));
    _colour_square_panel.setBorder(new LineBorder(Color.BLACK));
    _main_panel.add(_colour_square_panel, _gbc);

    _main_panel.add(_separator_textarea, _gbc);

    _goodluck_textarea = createStyledTextArea("Good luck with your challenge :D !",14f, Color.WHITE, new Color(40, 167, 69));
    _goodluck_textarea.setLineWrap(false); // Disable line wrap
    _goodluck_textarea.setWrapStyleWord(false); // Disable word wrap
    _goodluck_textarea.setAlignmentX(SwingConstants.LEFT);
    _main_panel.add(_goodluck_textarea, _gbc);

    _main_panel.setPreferredSize(new Dimension(1280, 720));

    _main_frame.getContentPane().add(_main_panel);
    _main_frame.pack();
    _main_frame.setLocationRelativeTo(null);
    _main_frame.setVisible(true);
  }

  //PRIVATE STATIC INTERFACE
  private static JTextArea createStyledTextArea(String text, float fontSize, Color foregroundColor, Color backgroundColor)
  {
    JTextArea textArea = new JTextArea(text);
    textArea.setFont(textArea.getFont().deriveFont(fontSize));
    textArea.setForeground(foregroundColor);
    textArea.setBackground(backgroundColor);
    textArea.setEditable(false);
    textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    return textArea;
  }

  //PROTECTED ATTRIBUTES
  protected JFrame    _main_frame;
  protected JPanel    _main_panel;
  protected JLabel    _title_label;
  protected JTextArea _separator_textarea;

  protected JTextArea _sims_ammount_textarea;
  protected JTextArea _sims_description_textarea;
  protected JTextArea _house_description_textarea;
  protected JTextArea _house_description_2_textarea;
  protected JTextArea _colour_description_textarea;
  protected JPanel _colour_square_panel;

  protected JTextArea _goodluck_textarea;

  //PRIVATE STATIC ATTRIBUTES
  private static GridBagConstraints _gbc;

  //PRIVATE STATIC CONSTANTS
  private static final String EMPTY_STRING = "";
}
