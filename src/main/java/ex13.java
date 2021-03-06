/*
 *  UCF COP3330 Summer 2021 Assignment 13 Solution
 *  Copyright 2021 Brandon Powell
 */
/*
/*
Exercise 13 - Determining Compound Interest

Simple interest is something you use only when making a quick guess. Most investments use a compound interest formula, which will be much more accurate. And this formula requires you to incorporate exponents into your programs.

Write a program to compute the value of an investment compounded over time. The program should ask for the starting amount, the number of years to invest, the interest rate, and the number of periods per year to compound.

The formula you’ll use for this is A = P(1 + r/n)^(n*t) where

P is the principal amount.
r is the annual rate of interest.
t is the number of years the amount is invested.
n is the number of times the interest is compounded per year.
A is the amount at the end of the investment.

Example Output

What is the principal amount? 1500
What is the rate? 4.3
What is the number of years? 6
What is the number of times the interest is compounded per year? 4
$1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.

Constraints

Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
Ensure that fractions of a cent are rounded up to the next penny.
Ensure that the output is formatted as money.

Challenges

Ensure that all of the inputs are numeric and that the program will not let the user proceed without valid inputs.
Create a version of the program that works in reverse, so you can determine the initial amount you’d need to invest to reach a specific goal.
Implement this program as a GUI app that automatically updates the values when any value changes.

 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class ex13 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //input
        System.out.print("What is the Principal amount? ");
        String str1 = in.nextLine();
        double principal = Double.parseDouble(str1);

        System.out.print("What is the rate?  ");
        String str2 = in.nextLine();
        double rate = Double.parseDouble(str2);

        System.out.print("What is the number of years? ");
        String str3 = in.nextLine();
        double years = Double.parseDouble(str3);

        System.out.print("What is the number of times the interest is compounded per year? ");
        String str4 = in.nextLine();
        double times = Double.parseDouble(str4);

       // A = P(1 + r/n)^(n*t)
        double investment = (Math.pow((1+(rate/(100*times))),(years*times)))*principal;
        BigDecimal investmentFormat = new BigDecimal(investment);
        BigDecimal displayVal = investmentFormat.setScale(2, RoundingMode.HALF_EVEN);

        //output
        System.out.print(String.format("$%.0f invested at %.1f%% for %.0f years compounded %.0f times per year is $%.2f",principal,rate,years,times,investmentFormat));


    }
}
