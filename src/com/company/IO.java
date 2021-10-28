package com.company;

import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.List;

import static com.company.EmployeeManagement.*;
import static com.company.Utilities.textRed;
import static com.company.Utilities.textReset;

public class IO {

    private static String file = "C:\\Users\\flyin\\IdeaProjects\\StaffManagementProject\\src\\com\\company\\EmpReg.txt";

    public static void readFromFile() {
        List<Employee> tempEmployees = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(inputStream);
            setEmployees((ArrayList<Employee>) input.readObject());
            fixCounter();
            inputStream.close();
            input.close();
            //tempEmployees = (ArrayList<Employee>) input.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(textRed + "\nFilen med sparade ansällda gick ej att hitta.\nDetaljer: " + e + textReset);
            //e.printStackTrace();
        } catch (EOFException e) {
            System.out.println(textRed + "\nInga sparade anställda hittades.\nDetaljer: " + e + textReset);
        } catch (IOException e) {
            System.out.println(textRed + "\nInga sparade anställda hittades.\nDetaljer: " + e + textReset);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      /*  for (Employee e : tempEmployees) {

        }*/
    }

    public static void writeToFile() {
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(outputStream);
            output.writeObject(getEmployees());
            outputStream.close();
            output.close();
        } catch (IOException e) {
            System.out.println(textRed + "\nAnställda gick ej att spara.\nDetaljer: " + e + textReset);
            //e.printStackTrace();
        }
    }

}
