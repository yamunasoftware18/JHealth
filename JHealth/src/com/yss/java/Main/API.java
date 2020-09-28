package com.yss.java.Main;

import com.yamunasoftware.java.Main.Neuron;

@SuppressWarnings("unused")
public class API extends Train {
  /* MAIN GLOBAL API ELEMENTS */

  //Global Neuron Object (w/ Default):
  private static Neuron neuron = new Neuron();

  //Global Classes (w/ Defaults):
  public static String classes[] = {
    "Extremely Weak", "Weak", "Normal", 
    "Overweight", "Obese", "Extremely Obese"
  };
  
  //Constructor:
  public API() {
    super();
  }

  /* MAIN BMI API METHODS */

  //Gets the Male BMI Classification:
  public static String getMaleBMI(double height, double weight) throws Exception {
    //Main Class Value (w/ Default):
    String classification = "";

    //Gets the Class:
    double index = Neuron.classification(height, weight, male_ids);
    classification = classes[((int)(index))];

    //Returns the Class:
    return classification;
  }

  //Gets the Male BMI Classification:
  public static String getFemaleBMI(double height, double weight) throws Exception {
    //Main Class Value (w/ Default):
    String classification = "";

    //Gets the Class:
    double index = Neuron.classification(height, weight, female_ids);
    classification = classes[((int)(index))];

    //Returns the Class:
    return classification;
  }
}