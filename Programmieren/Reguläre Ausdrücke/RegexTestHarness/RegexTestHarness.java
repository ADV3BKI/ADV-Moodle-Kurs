/**
 * RegexTestHarness.java
 * 28.05.2019
 */
package regexDemo;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import input.Eingabe;

/**
 * @author stk
 *
 *
 * Kurzbeschreibung:
 */
public class RegexTestHarness
{
	public static void main(String[] args){
		// "[A-Za-z0-9\Q.!#$%&'*+-/=?^_`{|}~\E]+\@.+\.[a-zA-z]{2,4}";  E-Mail Adresse
		// \Q Start of Quote; \E End of Quote bedeutet: die Zeichen dazwischen sind wörtlich
        while (true) {

            Pattern pattern = 
            Pattern.compile(Eingabe.getString("\nEnter your regex: "));

            Matcher matcher = 
            pattern.matcher(Eingabe.getString("Enter input string to search: "));

            boolean found = false;
            while (matcher.find()) {
                System.out.printf("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
            	System.out.printf("No match found.%n");
            }
        }
    }
}
