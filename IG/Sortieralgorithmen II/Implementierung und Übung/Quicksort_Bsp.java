public class Quicksort_Bsp
{
  static int[] feld= {5,-1,1,3,2};   //laesst sich einfach zu Uebungszwecke anpassen, maxIndex ggf. veraendern.
  static int maxIndex = feld.length-1;
  static void feldFuellen()

    {     }


  static void feldAusgabe()
  { System.out.println("Das Feld enthaelt die folgenden Elemente: ");
    for (int i=0; i<= maxIndex; i++)
    {  System.out.print(feld[i]);
       System.out.print(" ");
    }
    System.out.println();
  } // feldAusgabe

  static void vertausche (int a, int b)
  {  int ablage = feld[a];

      feld[a] = feld[b];
      feld[b] = ablage;
      //feldAusgabe();
  } // vertausche

static void quicksort(int links, int rechts)
{ int j = rechts; // Laufindex, der vom rechten Ende nach links laeuft
  int i= links; // Laufindex, der vom linken Ende nach rechts laeuft
  System.out.println(".....");  
  System.out.println("Aufruf Quicksort mit Grenzen i = " + i + " und j= " + j);
  System.out.println(".....");  
  if (i< j)
       { // Pivotelement bestimmen
         int pivot = feld[(i+ j)/2];

         while (i<= j)
         
         {    // Links erstes Element suchen, das
              // groesser oder gleich dem Pivotelement ist
              while ((i< rechts) && (feld[i] < pivot))
                   i++ ;


              // Rechts erstes Element suchen, das
              // kleiner oder gleich dem Pivotelement ist
              while ((j > links) && (feld[j] > pivot))
                   j--;

              // Wenn nicht aneinander vorbei gelaufen, Inhalte vertauschen
              if (i<= j)
                    {System.out.println("Vor dem Tausch  i= " + i+"   j = " + j);
                    feldAusgabe();
                     vertausche(i, j);
                     i++;
                     j--;
                     System.out.println("Nach dem Tausch i= " + i+"  j = " + j);
                     feldAusgabe();
                     System.out.println("--------");
                                     
                    }
         } // end while

         // Linken Teil sortieren
         if (j > links) quicksort (links, j);

         // Rechten Teil sortieren
         if (i< rechts) quicksort (i, rechts);

       } // end if
}  // quicksort

  public static void main(String[] arg)
  { System.out.println("Quicksort-Demo: ");
    System.out.println("Aufgabe:");
    feldAusgabe();
    System.out.println("--------");
    quicksort(0,maxIndex);


     System.out.println("--------");
    feldAusgabe();

  } // main
} // class quicksort