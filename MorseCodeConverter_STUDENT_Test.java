package abc;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeConverter_STUDENT_Test {

	@Test
	public void testConvertToEnglish() {
		String phrase1=MorseCodeConverter.convertToEnglish(".... .. / -- -.-- / -. .- -- . / .. ... / --- ... -.-. .- .-.");
		String phrase2=MorseCodeConverter.convertToEnglish(".. / .... --- .--. . / - .... .. ... / .-- --- .-. -.- ...");
		
		assertEquals("hi my name is oscar",phrase1);
		assertEquals("i hope this works",phrase2);
		
	}
	
	@Test
	public void testToConvertEnglishFile() {
		File file1=new File("src/Daisy.txt");
		File file2=new File("src/DaisyDaisy.txt");
		File file3=new File("src/LoveLooksNot.txt");
		assertEquals("give me your answer do",MorseCodeConverter.convertToEnglish(file1));
		assertEquals("im half crazy all for the love of you",MorseCodeConverter.convertToEnglish(file2));
		assertEquals("love looks not with the eyes but with the mind",MorseCodeConverter.convertToEnglish(file3));
	}
	
	
	
	
}
