package com.luciofranco.piglatinator;

public class PigLatinTranslator {
	String string;
	String[] tokens;

	PigLatinTranslator() {
	}

	public void setString(String string) {
		this.string = string;
	}

	public void printPiglatin() {
		tokens = string.split("[ ]+");
		String string = " ";
		for (int i = 0; i < tokens.length; i++)
			string += toPigLatin(tokens[i]) + " ";
		System.out.println(string.trim());
	}

	public String getPigLatinPhrase() {
		string.trim();
		tokens = string.split("[ ]+");
		String bean = " ";
		for (int i = 0; i < tokens.length; i++)
			bean += toPigLatin(tokens[i]) + " ";
		return bean.trim();
	}

	public String getPigLatinPhrase(String string) {
		string.trim();
		tokens = string.split("[ ]+");
		String bean = " ";
		for (int i = 0; i < tokens.length; i++)
			bean += toPigLatin(tokens[i]) + " ";
		return bean.trim();
	}

	public String toPigLatin(String string) {
		String temp = " ", nonchar = "";

		string = string.trim();
		if (isNonChar(string))
			return string;
		if (endsWithNonChar(string)) {
			nonchar = string.substring(string.length() - 1, string.length());
			string = string.substring(0, string.length() - 1);
		}

		if (!hasVowel(string)) {
			temp += string + "ay";
		} else if (isBeginWithVowel(string)) {
			temp += string + "yay";
		} else if (hasVowel(string)) {
			temp = thirdOption(string);
		}

		temp = temp.trim();

		if (firstlettercapital(string))
			return temp.toUpperCase().substring(0, 1) + temp.substring(1)
					+ nonchar;
		else
			return temp + nonchar;
	}

	private boolean firstlettercapital(String string) {
		if ((int) string.charAt(0) >= 65 && (int) string.charAt(0) <= 90)
			return true;
		else
			return false;
	}

	private boolean endsWithNonChar(String string) {
		if (!((int) string.toLowerCase().charAt(string.length() - 1) >= 97 && (int) string
				.toLowerCase().charAt(string.length() - 1) <= 122))
			return true;
		return false;
	}

	private boolean isNonChar(String string) {
		int a = 0;
		for (int i = 0; i < string.length(); i++) {
			int b = (int) string.toLowerCase().charAt(i);
			if (b >= 97 && b <= 122) {
				a++;
			}
		}
		if (a > 0) {
			return false;
		} else
			return true;
	}

	public String thirdOption(String string) {
		String start, end, temp;
		int firstVowel = 1;

		for (int a = 0; a < string.length(); a++) {
			if ((string.toLowerCase().charAt(a) == 'a'
					|| string.toLowerCase().charAt(a) == 'e'
					|| string.toLowerCase().charAt(a) == 'i'
					|| string.toLowerCase().charAt(a) == 'o' || string
					.toLowerCase().charAt(a) == 'u')) {
				firstVowel = a;
				break;
			}
		}

		start = string.substring(0, firstVowel);
		end = string.substring(firstVowel, string.length());

		if (string.toUpperCase().equals(string)) {
			temp = end.toUpperCase() + start.toLowerCase() + "ay";
		} else {
			temp = end + start.toLowerCase() + "ay";
		}

		return temp;
	}

	private boolean hasVowel(String string) {
		int i = 0;
		for (int a = 0; a < string.length(); a++) {
			if ((string.toLowerCase().charAt(a) == 'a'
					|| string.toLowerCase().charAt(a) == 'e'
					|| string.toLowerCase().charAt(a) == 'i'
					|| string.toLowerCase().charAt(a) == 'o' || string
					.toLowerCase().charAt(a) == 'u'))
				i++;
		}

		if (i > 0)
			return true;
		return false;
	}

	private boolean isBeginWithVowel(String string) {
		if (string.toLowerCase().startsWith("a")
				|| string.toLowerCase().startsWith("e")
				|| string.toLowerCase().startsWith("i")
				|| string.toLowerCase().startsWith("o")
				|| string.toLowerCase().startsWith("u"))
			return true;
		return false;
	}
}