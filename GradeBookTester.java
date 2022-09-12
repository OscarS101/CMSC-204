package abc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	GradeBook g1,g2;
	@BeforeEach
	void setUp() throws Exception {
		
		g1=new GradeBook(5);
		g1.addScore(78);
		g1.addScore(92);
		g1.addScore(77);
		
		g2=new GradeBook(5);
		g2.addScore(56);
		g2.addScore(84);
		g2.addScore(80);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1=g2=null;
	}

	@Test
	void testAddScore() {
		assertTrue("78.0 92.0 77.0 ".equals(g1.toString()));
		assertEquals(3, g1.getScoreSize(), .001);
		assertEquals(3, g2.getScoreSize(), .001);
		
	}

	@Test
	void testSum() {
		assertEquals(247, g1.sum(), .001);
		assertEquals(220, g2.sum(), .001);
	}

	@Test
	void testMinimum() {
		assertEquals(77, g1.minimum() ,.001);
		assertEquals(56, g2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(170, g1.finalScore(), .001);
		assertEquals(164, g2.finalScore(), .001);
	}





	

}
