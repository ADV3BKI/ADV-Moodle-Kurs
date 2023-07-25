// Aufgabe 1: Analysieren Sie den Code. Wie funktioniert der Bubble Sort?

class Bubblesort_S
      { static int[] feld;
        static final int maxIndex=9;
        // Beliebige Größe festlegbar //

          static void feldFuellen()
                 { for (int i=0; i<=maxIndex; i++)
                 {  feld[i] = (int)Math.round(Math.random()*900.0 + 100); }
                 } // feldFuellen mit Zufallszahlen (Alternativ Zugriff auf Datei oder gegebenes Array)

         static void feldAusgabe()
                { System.out.println("Das Feld enthaelt die folgenden Elemente: ");
                for (int i=0; i<=maxIndex; i++)
                    {  System.out.print(feld[i]);
                    System.out.print(" ");
                    }
                System.out.println();
                } // feldAusgabe

         static void vertausche (int a, int b)
                {  int ablage = feld[a];
                feld[a] = feld[b];
                feld[b] = ablage;
                } // vertausche (Standardoperation "3-Ecks-Tausch"

         static void bubblesort()
                {  for (int i=0; i<maxIndex; i++)
                  {  for (int k=0; k<maxIndex; k++)
                     // Aufgabe2: Testen Sie ob, k<maxIndex-i auch möglich ist
                     // und Wieso (nicht)?
                      { if (feld[k]>feld[k+1]) { vertausche(k, k+1); }
                      } // for k
                  } // for i
                }  // bubblesort (Opitmierung z.B. durch Merker, ob noch getauscht wird)

public static void main(String[] arg)
  { feld = new int[maxIndex+1];
    System.out.println("Bubblesort-Demo: ");
    feldFuellen();
    feldAusgabe();
    System.out.println("UND NACH DER SORTIERUNG");
     bubblesort();
    //    feldAusgabe();
    feldAusgabe();
  } // main
} // class Bubblesort


