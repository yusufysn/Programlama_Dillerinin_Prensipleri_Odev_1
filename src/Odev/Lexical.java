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
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class Lexical {
	public void Operator(File dosya) {

		try {
			Scanner myReader = new Scanner(dosya);

			int mantiksalOperator = 0;
			int iliskiselOperator = 0;
			int sayisalOperator   = 0;
			int tekliOperator     = 0;
			int ikiliOperator 	  = 0;
			int operand			  = 0;
			boolean yorum = false;
			boolean string = false;
			String regex = ".*<[ \\w\\t*<>$/,]+>.*";

			while (myReader.hasNextLine()) {
				String satir = myReader.nextLine();

				for (int i = 0; i < satir.length(); i++) {
					if (yorum != true && i != (satir.length() - 1) && satir.charAt(i) == '/'
							&& satir.charAt(i + 1) == '*') // yorum satirlerini atliyor
					{
						yorum = true;
					}
					if (yorum != false && i != (satir.length() - 1) && satir.charAt(i) == '*'
							&& satir.charAt(i + 1) == '/') // yorum satirlerini atliyor
					{
						yorum = false;
						i++;
					}
					if (yorum != true && i != (satir.length() - 1) && satir.charAt(i) == '/'
							&& satir.charAt(i + 1) == '/') // yorum satirlerini atliyor
					{
						i = satir.length() - 1;
					}
					if (string != true && i != (satir.length() - 1) && satir.charAt(i) == '"') // string ifadeleri
																								// atliyor
					{
						string = true;
						i++;
					}
					if (string != false && i != (satir.length() - 1) && satir.charAt(i) == '"') // string ifadeleri
																								// atliyor
					{
						string = false;
						i++;
					}
					// sayisal operatorler

					if (yorum != true && string != true && i != (satir.length() - 1) && i != 0
							&& satir.charAt(i - 1) != '+' && satir.charAt(i) == '+' && satir.charAt(i + 1) != '+') // +
					{
						sayisalOperator++;
						ikiliOperator++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '+'
							&& satir.charAt(i + 1) == '+') // ++
					{
						sayisalOperator++;
						tekliOperator++;
						operand++;
						i++;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && i != 0
							&& satir.charAt(i - 1) != '-' && satir.charAt(i) == '-' && satir.charAt(i + 1) != '-') // -
					{
						sayisalOperator++;
						ikiliOperator++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '-'
							&& satir.charAt(i + 1) == '-') // --
					{
						sayisalOperator++;
						tekliOperator++;
						operand++;
						i++;
					}

					if (yorum != true && string != true && i != (satir.length() - 1) && i != 0
							&& satir.charAt(i - 1) != '.' && satir.charAt(i) == '*' && satir.charAt(i + 1) != '/'
							&& satir.charAt(i + 1) != '=') // *
					{
						sayisalOperator++;
						ikiliOperator++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && i != 0
							&& satir.charAt(i - 1) != '*' && satir.charAt(i) == '/' && satir.charAt(i + 1) != '/'
							&& satir.charAt(i + 1) != '=') // /
					{
						if (satir.charAt(i + 1) == '/') {
							i++;
						}
						sayisalOperator++;
						ikiliOperator++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '%'
							&& satir.charAt(i + 1) != '=') ////////////////////////////// %
					{
						sayisalOperator++;
						ikiliOperator++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '&'
							&& satir.charAt(i + 1) != '&' && satir.charAt(i + 1) != '=') // &
					{
						if (satir.charAt(i + 1) == '&') {
							i++;
						}
						sayisalOperator++;
						operand++;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '|'
							&& satir.charAt(i + 1) != '|' && satir.charAt(i + 1) != '=') // |
					{
						if (satir.charAt(i + 1) == '|') {
							i++;
						}
						sayisalOperator++;
						operand++;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '^'
							&& satir.charAt(i + 1) != '=') ////////////////////////////// ^
					{
						sayisalOperator++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && i != 0
							&& satir.charAt(i - 1) != '!' && satir.charAt(i) == '=' && satir.charAt(i + 1) != '=') ///////////////////// =
					{
						sayisalOperator++;
						ikiliOperator++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '+'
							&& satir.charAt(i + 1) == '=') ////////////////////////////// +=
					{
						sayisalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '-'
							&& satir.charAt(i + 1) == '=') ////////////////////////////// -=
					{
						sayisalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '*'
							&& satir.charAt(i + 1) == '=') ////////////////////////////// *=
					{
						sayisalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '/'
							&& satir.charAt(i + 1) == '=') ////////////////////////////// /=
					{
						sayisalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '%'
							&& satir.charAt(i + 1) == '=') ////////////////////////////// %=
					{
						sayisalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '&'
							&& satir.charAt(i + 1) == '=') ////////////////////////////// &=
					{
						sayisalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '|'
							&& satir.charAt(i + 1) == '=') ////////////////////////////// |=
					{
						sayisalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '^'
							&& satir.charAt(i + 1) == '=') ////////////////////////////// ^=
					{
						sayisalOperator++;
						i++;
						operand+=2;
					}
					// sayisal operatorler

					// iliskisel operatorler
					if (!Pattern.matches(regex, satir) && i != 0 && yorum != true && string != true
							&& i != (satir.length() - 1) && satir.charAt(i - 1) != '<' && satir.charAt(i) == '<'
							&& satir.charAt(i + 1) != '<' && satir.charAt(i + 1) != '=') // <
					{
						iliskiselOperator++;
						operand+=2;
					}
					if (!Pattern.matches(regex, satir) && i != 0 && yorum != true && string != true
							&& i != (satir.length() - 1) && satir.charAt(i - 1) != '>' && satir.charAt(i) == '>'
							&& satir.charAt(i + 1) != '>' && satir.charAt(i + 1) != '=') // >
					{
						iliskiselOperator++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '<'
							&& satir.charAt(i + 1) == '=') ////////////////////// <=
					{
						iliskiselOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '>'
							&& satir.charAt(i + 1) == '=') ////////////////////// >=
					{
						iliskiselOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '='
							&& satir.charAt(i + 1) == '=') ////////////////////// ==
					{
						iliskiselOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '!'
							&& satir.charAt(i + 1) == '=') ////////////////////// !=
					{
						iliskiselOperator++;
						i++;
						operand+=2;
					}
					// iliskisel operatorler

					// mantiksal operatorler
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '&'
							&& satir.charAt(i + 1) == '&') // "&&" operatorunu sayiyor
					{
						mantiksalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '|'
							&& satir.charAt(i + 1) == '|') // "||" operatorunu sayiyor
					{
						mantiksalOperator++;
						i++;
						operand+=2;
					}
					if (yorum != true && string != true && i != (satir.length() - 1) && satir.charAt(i) == '!'
							&& satir.charAt(i + 1) != '=') // "!" operatorunu sayiyor
					{
						mantiksalOperator++;
						operand++;
					}
					// mantiksal operatorler
				}
			}
			System.out.println("Operator Bilgisi :");
			System.out.println("	Tekli Operator         : " + tekliOperator);
			System.out.println("	Ikili Operator         : " + ikiliOperator);
			System.out.println("	Sayisal Operator       : " + sayisalOperator);
			System.out.println("	Iliskisel Operator     : " + iliskiselOperator);
			System.out.println("	Mantiksal Operator     : " + mantiksalOperator);
			System.out.println("Operand Bilgisi :");
			System.out.println("	Toplam Operand Sayisi  : " + operand);
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
