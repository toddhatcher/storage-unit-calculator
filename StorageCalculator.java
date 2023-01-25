// Version 4 of Storage Calculator for Cait
// By Todd Hatcher
// 07/06/2021 - Updated prices and added the new 12x24 unit size.

// Allow the user to enter another date and view the cost of a rental on
// that future date.

import java.time.*;
import java.util.Scanner;

public class StorageCalculator
{
    public final static double FIVEXFIVE = 39.00;
	public final static double FIVEXTEN = 49.00;
	public final static double FIVEXFIFTEEN = 59.00;
	public final static double TENXTEN = 79.00;
	public final static double TENXFIFTEEN = 89.00;
	public final static double TENXTWENTY = 99.00;
	public final static double TENXTWENTYFIVE = 109.00;
	public final static double TENXTHIRTY = 119.00;
	public final static double TENXTHIRTYDOUBLEDOOR = 178.00;
    public final static double TWELVEXTWENTYFOUR = 139.00;
	public final static double TWELVEXTHIRTY = 149.00;
    public final static double FIFTEENXTWENTYSEVEN = 189.00;
    
    public final static String SFIVEXFIVE = "Five x Five";
	public final static String SFIVEXTEN = "Five x Ten";
	public final static String SFIVEXFIFTEEN = "Five x Fifteen";
	public final static String STENXTEN = "Ten x Ten";
	public final static String STENXFIFTEEN = "Ten x Fifteen";
	public final static String STENXTWENTY = "Ten x Twenty";
	public final static String STENXTWENTYFIVE = "Ten x Twenty five";
	public final static String STENXTHIRTY = "Ten x Thirty";
    public final static String STENXTHIRTYDOUBLEDOOR = "Ten x Thirty double" 
        + " door";
    public final static String STWELEVEXTWENTFOUR = "Twelve x Twenty four";
	public final static String STWELVEXTHIRTY = "Tweleve x Thirty";
    public final static String SFIFTEENXTWENTYSEVEN = "Fifteen x Twenty seven";
    public static boolean extraMonth = false;
	
	public static void main(String[] args)
	{	
		// Declare variables
		double dailyRate = 0.00;
		double monthlyRate = 0.00;
		double proRate = 0.00;
        double total = 0.00;
        Scanner keyboard = new Scanner(System.in);
        char userChoice = 'n';
        boolean keepGoing = true;
        int userMonth = 0;
        int userDay = 0;
        int userYear = 0;
        
		// Display program greeting.
        System.out.println("\n\n*******************************************");
        System.out.println("* Welcome to Caitlin's Storage Calculator! *");
        System.out.println("*******************************************");
        System.out.println("\nThis program calculates the pro-rate on" + 
            " different unit sizes.");

		// Create a date object for right now.
		LocalDate currentDate = LocalDate.now();
		// Find the current month from the date object
		int thisMonthValue = currentDate.getMonthValue();
		// Count how many days are in this month.
		int daysInMonth = currentDate.lengthOfMonth();
		// Find the current day from the date object.
		int todaysDayValue = currentDate.getDayOfMonth();
		// Calculate how many days remain in the month.
		int daysRemaining = daysInMonth - todaysDayValue;
		
        /* ADD +1 to daysRemaining, because they still charge proRate on 
            the day you come in. 
            example: 30 days in month - 2 days into the month so far = 28 days 
            remaining, but 29 days worth of pro rate charges.
        */
		daysRemaining = daysRemaining + 1;
        
		// Display date object details for testing.
        System.out.println("\nToday is the " + todaysDayValue + " day of the " 
            + thisMonthValue + " month of the year.");
        System.out.println("There are " + daysRemaining 
            + " days remaining in this month, including today.\n");

        // Add check on daysRemaining here. So that additional rent notice
        // will only be displayed once.
        if(daysRemaining <= 17)
        {
            System.out.println("Since there are " + daysRemaining + 
            " days remaining, an additional months rent will be added.\n");
            // Toggle extraMonth true for proRate
            extraMonth = true;
        }
        else
        {
            extraMonth = false;
        }
        
        // Send data for each unit type to be calculated 
        CalcTotal(SFIVEXFIVE, FIVEXFIVE, daysInMonth, daysRemaining);
        CalcTotal(SFIVEXTEN, FIVEXTEN, daysInMonth, daysRemaining);
        CalcTotal(SFIVEXFIFTEEN, FIVEXFIFTEEN, daysInMonth, daysRemaining);
        CalcTotal(STENXTEN, TENXTEN, daysInMonth, daysRemaining);
        CalcTotal(STENXFIFTEEN, TENXFIFTEEN, daysInMonth, daysRemaining);
        CalcTotal(STENXTWENTY, TENXTWENTY, daysInMonth, daysRemaining);
        CalcTotal(STENXTWENTYFIVE, TENXTWENTYFIVE, daysInMonth, daysRemaining);
        CalcTotal(STENXTHIRTY, TENXTHIRTY, daysInMonth, daysRemaining);
        CalcTotal(STENXTHIRTYDOUBLEDOOR, TENXTHIRTYDOUBLEDOOR, daysInMonth, 
            daysRemaining);
        CalcTotal(STWELEVEXTWENTFOUR, TWELVEXTWENTYFOUR, daysInMonth, daysRemaining);
        CalcTotal(STWELVEXTHIRTY, TWELVEXTHIRTY, daysInMonth, daysRemaining);
        CalcTotal(SFIFTEENXTWENTYSEVEN, FIFTEENXTWENTYSEVEN, daysInMonth, 
            daysRemaining); 
        System.out.println("\n");

        
        while(keepGoing == true)
        {
            // Ask user to run calculations on a different date?
            System.out.println("Would you like to run another date? Y or N ?");
            userChoice = keyboard.next().charAt(0);

            if(userChoice == 'n' || userChoice == 'N')
            {
                keepGoing = false;
            }
            else
            {
                // Ask user for date: month, day, year.
                System.out.println("Please enter the 4 digit year for the " + 
                "new date: ");
                userYear = keyboard.nextInt();
                System.out.println("Please enter the two digit month value " +
                 "for the new date: ");
                userMonth = keyboard.nextInt();
                System.out.println("Please enter the two digit day value " +
                "for the new date: ");
                userDay = keyboard.nextInt();

                // Create a new date from the user entered values
                LocalDate newDate1 = LocalDate.of(userYear, userMonth, userDay);

                // Find the current month from the new date object
		        thisMonthValue = newDate1.getMonthValue();
		        // Count how many days are in this month.
		        daysInMonth = newDate1.lengthOfMonth();
		        // Find the current day from the date object.
                todaysDayValue = newDate1.getDayOfMonth();
                // Find the current year from the date object.
                int yearOfNewDate = newDate1.getYear();
		        // Calculate how many days remain in the month.
		        daysRemaining = daysInMonth - todaysDayValue;
		
                /* ADD +1 to daysRemaining, because they still charge proRate on 
                the day you come in. 
                example: 30 days in month - 2 days into the month so far = 28 days 
                remaining, but 29 days worth of pro rate charges.
                */
                daysRemaining = daysRemaining + 1;
                
                // Display new date object details for testing.
                System.out.println("\nThe new date is the " + todaysDayValue 
                    + " day of the " + thisMonthValue + " month of " + yearOfNewDate);
                System.out.println("There are " + daysRemaining 
                    + " days remaining in this month, including today.\n");
                
                // Add check on daysRemaining here. So that additional rent notice
                // will only be displayed once.
                if(daysRemaining <= 17)
                {
                    System.out.println("Since there are " + daysRemaining + 
                    " days remaining, an additional months rent will be added.\n");
                    // Toggle extraMonth true for proRate
                    extraMonth = true;
                }
                else
                {
                    extraMonth = false;
                }

                // Send data for each unit type to be calculated 
                CalcTotal(SFIVEXFIVE, FIVEXFIVE, daysInMonth, daysRemaining);
                CalcTotal(SFIVEXTEN, FIVEXTEN, daysInMonth, daysRemaining);
                CalcTotal(SFIVEXFIFTEEN, FIVEXFIFTEEN, daysInMonth, 
                    daysRemaining);
                CalcTotal(STENXTEN, TENXTEN, daysInMonth, daysRemaining);
                CalcTotal(STENXFIFTEEN, TENXFIFTEEN, daysInMonth, 
                    daysRemaining);
                CalcTotal(STENXTWENTY, TENXTWENTY, daysInMonth, daysRemaining);
                CalcTotal(STENXTWENTYFIVE, TENXTWENTYFIVE, daysInMonth, 
                    daysRemaining);
                CalcTotal(STENXTHIRTY, TENXTHIRTY, daysInMonth, daysRemaining);
                CalcTotal(STENXTHIRTYDOUBLEDOOR, TENXTHIRTYDOUBLEDOOR, 
                    daysInMonth, daysRemaining);
                CalcTotal(STWELEVEXTWENTFOUR, TWELVEXTWENTYFOUR, daysInMonth, daysRemaining);
                CalcTotal(STWELVEXTHIRTY, TWELVEXTHIRTY, daysInMonth, 
                    daysRemaining);
                CalcTotal(SFIFTEENXTWENTYSEVEN, FIFTEENXTWENTYSEVEN, 
                    daysInMonth, daysRemaining); 
                System.out.println("\n");
            }
        }
    }

    static void CalcTotal(String unitType, double unitPriceMo, int daysInMo, 
        int daysRemaining)
    {
        // Calc Daily Rate
        double dailyRate = unitPriceMo / daysInMo;
        
        // Debug line
        //System.out.println("Debug: The daily rate is: " + dailyRate);

        // Calc pro rate
        double proRate = daysRemaining * dailyRate;

        // Debug line
        //System.out.println("Debug: The proRate pre extra month check is: " + proRate);

        // Check if an extra months rent should be added.
        if(extraMonth == true)
        {
            proRate = proRate + unitPriceMo;
        }

        // Debug line
        //System.out.println("Debug: The proRate post extra month check is: " + proRate);

        // Add $15.00 charge to total.
        double total = proRate + 15.00;

        // Display output
        System.out.printf("Today's total for a " + unitType 
            + " is:\t\t\t\t $%.2f%n", total);
    }
} 