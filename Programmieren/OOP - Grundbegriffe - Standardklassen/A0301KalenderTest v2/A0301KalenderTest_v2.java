package oopProgStdClass;

import java.time.LocalDate;
import java.time.Month;

public class A0301KalenderTest_v2 
{
  public static void main (String [] args)
  {
    int i;
    
    System.out.printf("Aktuelles Datum: %s\n", A0301KalenderKlasse_v2.getAktuellesDatum());
    System.out.printf("Heute ist %s\n", A0301KalenderKlasse_v2.getAktWochentag());
    
    for (i=0; i<=9; i++)
    {
      System.out.printf("Format %d: %s\n", i, A0301KalenderKlasse_v2.getAktuellesDatum(i));
    }
    
    System.out.println("\nDatum: 20.12.2000");
    System.out.println(A0301KalenderKlasse_v2.getDatum(2000, 12, 20));
    
    for (i=0; i<=9; i++)
    {
        System.out.printf("Format %d: %s\n", i, 
        		A0301KalenderKlasse_v2.getDatum(2000, 12, 20, i));
    }
   
    System.out.printf("\nAktuelle Uhrzeit: %s\n", A0301KalenderKlasse_v2.getAktuelleUhrzeit());
    
    LocalDate gcHeute = LocalDate.now();
    
    System.out.printf("\nHeute: %s\n",
                     A0301KalenderKlasse_v2.getDatum(gcHeute.getYear(),
	    		                                     gcHeute.getMonthValue(),
	    		                                     gcHeute.getDayOfMonth()));
    
    gcHeute = gcHeute.minusDays(7);
    
    System.out.printf("Vor 7 Tagen: %s\n",
                      A0301KalenderKlasse_v2.getDatum(gcHeute.getYear(),
							                          gcHeute.getMonthValue(),
							                          gcHeute.getDayOfMonth()));
    
    A0301KalenderKlasse_v2.druckeAktKalenderMonat();
    System.out.println();
    A0301KalenderKlasse_v2.druckeKalenderMonat(2020, 3);
       
  }
}