/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration.generator;

import java.util.Random;

/**
 *
 * @author Alex
 */
public class RegistrationGenerator
{

    Random rand = new Random();
    static Random randomInt = new Random();

    private static final char[] vowels = new char[]
    {
        'A', 'E', 'I', 'O', 'U'
    };
    private static final String[] provinces = new String[]
    {
        "CA", "ZN", "MP", "EC", "L", "GP", "NC", "FS", "NW"
    };
    public int[] provinceCodes = new int[9];

    private boolean contains(final char[] array, final char v)
    {

        boolean result = false;

        for (int i : array)
        {
            if (i == v)
            {
                result = true;
                break;
            }
        }

        return result;
    }

    private String getLetter()
    {
        char letter;
        do
        {
            int randNum = 65 + rand.nextInt(26);
            letter = (char) randNum;
        } while (contains(vowels, letter));

        return Character.toString(letter);

    }

    public String getLetters()
    {
        String letters = "";
        for (int i = 0; i < 3; i++)
        {
            letters += getLetter();
        }
        return letters;
    }

    public static String getNumbers()
    {
        String numbers = "";
        for (int i = 0; i < 3; i++)
        {
            numbers += randomInt.nextInt(9);
        }
        return numbers;
    }

    public String getCode()
    {
        int index = rand.nextInt(9);
        return provinces[index];
    }

    public String getRegistration()
    {

        return getVehicleReg(getLetters(), Integer.parseInt(getNumbers()), getCode());

    }

    private String getVehicleReg(String letters, int numbers, String code)
    {
        String digits = String.format("%03d", numbers);
        AddProvinceCount(code);
        return letters + "-" + digits + "-" + code;
    }

    private void AddProvinceCount(String provinceCode)
    {
        switch (provinceCode)
        {
            case "CA":
                provinceCodes[0]++; //CA              
                break;
            case "ZN":
                provinceCodes[1]++; //ZN
                break;
            case "MP":
                provinceCodes[2]++; //MP
                break;
            case "EC":
                provinceCodes[3]++; //EC
                break;
            case "L":
                provinceCodes[4]++; //L
                break;
            case "GP":
                provinceCodes[5]++; //GP
                break;
            case "NC":
                provinceCodes[6]++; //NC
                break;
            case "FS":
                provinceCodes[7]++; //FS
                break;
            case "NW":
                provinceCodes[8]++; //NW      
                break;
            default:
                throw new AssertionError("Invalid Province Code " + provinceCode);
        }
    }

    public void resetProvinceCount()
    {
        provinceCodes = new int[9];
    }
}
