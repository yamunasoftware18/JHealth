package com.yss.java.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yamunasoftware.java.Tools.HandleData;

@SuppressWarnings("unused")
public class Access extends HandleData {
  /* MAIN GLOBAL ACCESS ELEMENTS */

  //Constructor:
  public Access() {
    super();
  }

  /* MAIN CSV ACCESS METHODS */

  //Parse Raw CSV File Method:
  public static ArrayList<List<String>> parseCSV(String file) throws Exception {
    //Main String Array and Variables (w/ Defaults):
    ArrayList<List<String>> mainList = new ArrayList<List<String>>();
    String line = "";
    String split = ",";

    //Defines Reader:
    BufferedReader br = new BufferedReader(new FileReader(file));

    //Loops through CSV:
    mainLoop: while ((line = br.readLine()) != null) {
      //Gets the Array and Adds:
      String localArray[] = line.split(split);
      mainList.add(Arrays.asList(localArray));
    }

    //Closes Reader:
    br.close();

    //Returns the String:
    return mainList;
  }

  //Writing to CSV File Method:
  public static void writeCSV(String csvOutput[][], String file) throws Exception {
    //New File Writer:
    FileWriter writer = new FileWriter(new File(file));

    //Loop Variable:
    int turns = 0;

    //Loops through Array:
    while (turns < csvOutput[0].length) {
      //Sets the Local Array and Appends:
      String localArray[] = csvOutput[turns];
      writer.append(String.join(",", localArray));
      writer.append("\n");
      
      turns++;
    }

    //Closes the Writer:
    writer.flush();
    writer.close();
  }

  /* MAIN DATA PARSING METHODS */

  //String Data Modification Method:
  public static String[][] modifyData(String csvInput[][], String check, String change) throws Exception {
    //Main String Array (w/ Default):
    String mainArray[][] = new String[csvInput.length][csvInput[0].length];

    //Loop Variable:
    int turnsWidth = 0;

    //Loops through Array:
    mainLoop: while (turnsWidth < mainArray.length) {
      //Loop Variable:
      int turnsHeight = 0;
      secondLoop: while (turnsHeight < mainArray[0].length) {
        //Gets the String Data and Modifies:
        mainArray[turnsWidth][turnsHeight] = csvInput[turnsWidth][turnsHeight].replace(check, change);

        turnsHeight++;
      }

      turnsWidth++;
    }

    //Returns the Array:
    return mainArray;
  }

  //Parse Numbers From String Method:
  public static double[][] parseDouble(String csvInput[][]) throws Exception {
    //Main Double Array:
    double mainArray[][] = new double[csvInput.length][csvInput[0].length];

    //Loop Variable:
    int turnsWidth = 0;

    //Loops through Array:
    mainLoop: while (turnsWidth < mainArray.length) {
      //Loop Variable:
      int turnsHeight = 0;
      secondLoop: while (turnsHeight < mainArray[0].length) {
        //Parses the String to Double:
        mainArray[turnsWidth][turnsHeight] = Double.parseDouble(csvInput[turnsWidth][turnsHeight]);

        turnsHeight++;
      }

      turnsWidth++;
    }

    //Returns the Array:
    return mainArray;
  }
}