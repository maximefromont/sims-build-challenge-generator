package controllers;

import models.ChallengeColour;
import models.House;
import models.Sim;
import views.ViewGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewGeneratorCtrl extends ViewGenerator
{

  //PUBLIC INTERFACE
  public ViewGeneratorCtrl()
  {
    super();
    generateChallenge();
  }

  //PRIVATE INTERFACE
  private void generateChallenge()
  {
    initAttributes();
    initComponentsValues();
  }

  private void initAttributes()
  {
    _sims_list = Sim.getSimList();

    _house = new House();

    try { _challenge_colour = ChallengeColour.pickAColourFromJson(); }
    catch (Exception e) { e.printStackTrace(); }
  }

  private void initComponentsValues()
  {
   _sims_ammount_textarea.setText("You have to create " + _sims_list.size() + " sim(s) : ");
   _sims_description_textarea.setText(Sim.getSimListDescriptionAsString(_sims_list));
   _house_description_textarea.setText("You have to create a " + _house.getSizeTypeToString() + " house, in a " + _house.getStyleTypeToString() + " style.");
   if(_house.get_house_basements())
     _house_description_2_textarea.setText("It will need " + _house.get_house_floors() + " floors, one or more basements, and " + _house.get_house_rooms() + " rooms.");
   else
     _house_description_2_textarea.setText("It will need " + _house.get_house_floors() + " floors, no basements, and " + _house.get_house_rooms() + " rooms.");
   _colour_description_textarea.setText("The theme colour for your challenge will be " + _challenge_colour.get_color_name() + ".");
   _colour_square_panel.setBackground(Color.decode(_challenge_colour.get_color_hex()));
  }

  @Override
  protected void handleRegenerateButton()
  {
    int result =
            JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to generate a new challenge ?", "The current challenge is about to be erased",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

    if(result == JOptionPane.YES_OPTION)
      generateChallenge();
  }

  //PROTECTED ATTRIBUTES
  protected ArrayList<Sim> _sims_list;
  protected House          _house;
  protected ChallengeColour _challenge_colour;

}
