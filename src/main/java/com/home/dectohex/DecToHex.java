/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.home.dectohex;
/**
 *
 * @author PC
 */
public class DecToHex 
{

    public static void main(String[] args) throws Exception
    {
        final long MAX_INT = 2L * Integer.MAX_VALUE + 1L;
        var console = System.console();
        var bIsNumber = false;
        var uNumber = 0L;
        var strLine = "";
        System.out.println("input an unsigned integer number");
        try
        {
            strLine = console.readLine();
            uNumber = Long.parseUnsignedLong(strLine);
            bIsNumber = uNumber <= MAX_INT;
        }
        catch(Exception e)
        {
            bIsNumber = false;
        }
        if(!bIsNumber)
        {
            System.out.println("Invalid decimal number format.");
            System.exit(0);
            return;
        }
        System.out.println("Lower case ? (y/n)");
        var chAnswer = System.in.read();
        var bLowerCase = (chAnswer == 'y');
        var uTempVal = uNumber;
        strLine = "";
        while(uTempVal > 0)
        {
            char chHexDigit = '\0';
            var nHexDigit = uTempVal % 16;
            if (nHexDigit >= 0 &&  nHexDigit <= 9)
                chHexDigit = (char)(nHexDigit + '0');
            else if (nHexDigit >= 10 && nHexDigit <= 15 && bLowerCase)
                chHexDigit = (char)((nHexDigit - 10) + 'a');
            else if (nHexDigit >= 10 && nHexDigit <= 15)
                chHexDigit = (char)((nHexDigit - 10) + 'A');
            strLine = chHexDigit + strLine;
            uTempVal /= 16;
        }
        if(strLine.length() == 0)
            strLine = "0";
        System.out.format
        (
           "The hexadecimal equivalent of the decimal number %d is: %s\r\n", 
           uNumber, strLine
        );
    }
}
