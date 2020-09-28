package com.yss.java.Main;

import com.yamunasoftware.java.Tools.Trainer;

@SuppressWarnings("unused")
public class Train extends Data {
  /* MAIN GLOBAL TRAIN ELEMENTS */

  //Global Trainer Object and Values (w/ Defaults):
  private static Trainer trainer = new Trainer();

  //Global BMI File IDs (w/ Defaults):
  public static String male_ids[] = { 
    "MEW", "MW", "MN", 
    "MO", "MOB", "MEOB" 
  };

  //Global Female File IDs (w/ Defaults):
  public static String female_ids[] = { 
    "FEW", "FW", "FN", 
    "FO", "FOB", "FEOB" 
  };

  //Constructor:
  public Train() {
    super();
  }

  /* MAIN BMI MODEL TRAIN METHODS */

  //Train Male Model on BMI Dataset:
  public static void trainMaleBMI(double padding, boolean remove) throws Exception {
    //Checks the Case:
    if (remove) {
      //Removes Outliers from All Datasets:
      Trainer.removeOutliers(male_ew[0], male_ew[1]);
      Trainer.removeOutliers(male_w[0], male_w[1]);
      Trainer.removeOutliers(male_n[0], male_n[1]);
      Trainer.removeOutliers(male_o[0], male_o[1]);
      Trainer.removeOutliers(male_ob[0], male_ob[1]);
      Trainer.removeOutliers(male_eob[0], male_eob[1]);
    }
    
    //Trains on All Datasets:
    Trainer.findBoxValues(male_ew[0], male_ew[1], padding, male_ids[0]);
    Trainer.findBoxValues(male_w[0], male_w[1], padding, male_ids[1]);
    Trainer.findBoxValues(male_n[0], male_n[1], padding, male_ids[2]);
    Trainer.findBoxValues(male_o[0], male_o[1], padding, male_ids[3]);
    Trainer.findBoxValues(male_ob[0], male_ob[1], padding, male_ids[4]);
    Trainer.findBoxValues(male_eob[0], male_eob[1], padding, male_ids[5]);
  }

  //Train Female Model on BMI Dataset:
  public static void trainFemaleBMI(double padding, boolean remove) throws Exception {
    //Checks the Case:
    if (remove) {
      //Removes Outliers from All Datasets:
      Trainer.removeOutliers(female_ew[0], female_ew[1]);
      Trainer.removeOutliers(female_w[0], female_w[1]);
      Trainer.removeOutliers(female_n[0], female_n[1]);
      Trainer.removeOutliers(female_o[0], female_o[1]);
      Trainer.removeOutliers(female_ob[0], female_ob[1]);
      Trainer.removeOutliers(female_eob[0], female_eob[1]);
    }
    
    //Trains on All Datasets:
    Trainer.findBoxValues(female_ew[0], female_ew[1], padding, female_ids[0]);
    Trainer.findBoxValues(female_w[0], female_w[1], padding, female_ids[1]);
    Trainer.findBoxValues(female_n[0], female_n[1], padding, female_ids[2]);
    Trainer.findBoxValues(female_o[0], female_o[1], padding, female_ids[3]);
    Trainer.findBoxValues(female_ob[0], female_ob[1], padding, female_ids[4]);
    Trainer.findBoxValues(female_eob[0], female_eob[1], padding, female_ids[5]);
  }

  /* MAIN TRAINING UTILITY METHODS */

  //Sets the Directories of BMI Files Method:
  public static void setBMIDirectories(String maleDirectory, String femaleDirectory) throws Exception {
    //Loop Variable:
    int turns = 0;

    //Loops through Array:
    mainLoop: while (turns < male_ids.length) {
      //Sets the Directories:
      male_ids[turns] = maleDirectory + male_ids[turns];
      female_ids[turns] = femaleDirectory + female_ids[turns];

      turns++;
    }
  }
}