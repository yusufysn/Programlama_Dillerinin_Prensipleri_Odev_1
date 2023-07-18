/**
*
* @author Yusuf Yesin
* @since 20/03/2022
* <p>
* 1. Ogretim C Grubu
* </p>
*/
package Odev;

import java.io.File;

public class Main {
  public static void main(String[] args) {
	File dosya = new File(args[0]);
	
	Lexical lexical = new Lexical();
	lexical.Operator(dosya);
  }
}
