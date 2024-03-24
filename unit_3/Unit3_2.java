package unit_3;

import java.util.Date;

public class Unit3_2
{
    	public static void main(String[] args)
    	{	
			@SuppressWarnings("deprecation")
       		Date openingDate = new Date (125, 3, 15);
			@SuppressWarnings("deprecation")
			Date endingingDate = new Date (125, 3, 25);
        	System.out.print(openingDate  + "-");
        	System.out.println(endingingDate);

    	}
}