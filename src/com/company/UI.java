package com.company;

import static com.company.EmployeeManagement.employees;
import static com.company.Utilities.*;

public class UI {

    public static String showMainMenu() {
        String menuSelection = "";
        boolean runMenu = true;
        while (runMenu) {
            System.out.print(textCyan + "\n" + """
                    -----------------MENY-----------------
                       [1] - Lägg till en anställd.
                       [2] - Uppdatera en anställd.
                       [3] - Visa alla anställda.
                       [4] - Visa alla i en yrkeskategori.
                       [5] - Visa en specifik anställd.
                       [6] - Sök efter anställd.
                       [7] - Radera en anställd.
                       [8] - Visa statistik.
                       [9] - Sortera och visa anställda.
                       [0] - Avsluta.
                    --------------------------------------""" + textReset);
            System.out.print("\nVälj en siffra från menyn: ");
            menuSelection = sc.nextLine();
            if (employees.isEmpty()) {
                if (!menuSelection.equals("1") && !menuSelection.equals("0")) {
                    System.out.println(textRed + "\nDet finns inga anställda lagrade. Välj [1] eller [0]." + textReset);
                } else {
                    runMenu = false;
                }
            } else runMenu = false;
        }
        return menuSelection;
    }

    public static String showStatisticsMenu() {
        System.out.print(textCyan + "\n" + """
                --------MENY STATISTIK-------
                   [1] - Könsfördelning.
                   [2] - Bonus.
                   [3] - Lön.
                   [0] - Åter till huvudmeny.
                -----------------------------""" + textReset);
        System.out.print("\nVälj en siffra från menyn: ");
        return sc.nextLine();
    }

    public static String showSortingMenu(){
        System.out.print(textCyan + "\n" + """
                -----VISA ANSTÄLLDA SORTERADE EFTER-----
                   [1] - Namn.
                   [2] - Ålder.
                   [3] - Lön.
                   [4] - Bonus.
                   [0] - Åter till huvudmeny.
                ----------------------------------------""" + textReset);
        System.out.print("\nVälj en siffra från menyn: ");
        return sc.nextLine();
    }

}

