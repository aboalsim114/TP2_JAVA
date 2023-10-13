
class TestLivreEgalite {
	public static void main(String[] args) {
		TestLivreEgalite test = new TestLivreEgalite();
		test.testeLivresEgaux();
		test.testeLivresSectionsDifferentes();
		test.testeLivresEpaisseursDifferentes();
		test.testeLivresPoidsDifferents();
		test.testeLivresTotalementDifferents();
	}
	
	
	void testeLivresTotalementDifferents() {
		Livre livre1 = new Livre(7,"Sciences",4);
		Livre livre2 = new Livre(10,"Histoire",5);
		Test.assertFalse(livre1.estEgal(livre2), "2 livres complètement différents");
	}


	void testeLivresPoidsDifferents() {
		Livre livre1 = new Livre(7,"Histoire",5);
		Livre livre2 = new Livre(10,"Histoire",5);
		Test.assertFalse(livre1.estEgal(livre2), "2 livres différents");		
	}


	void testeLivresEpaisseursDifferentes() {
		Livre livre1 = new Livre(7,"Sciences",4);
		Livre livre2 = new Livre(7,"Sciences",5);
		Test.assertFalse(livre1.estEgal(livre2), "2 livres différents");		
	}


	void testeLivresSectionsDifferentes() {
		Livre livre1 = new Livre(10,"Sciences",5);
		Livre livre2 = new Livre(10,"Histoire",5);
		Test.assertFalse(livre1.estEgal(livre2), "2 livres différents");		
	}


	void testeLivresEgaux() {
		Livre livre1 = new Livre(10,"Histoire",5);
		Livre livre2 = new Livre(10,"Histoire",5);
		Test.assertTrue(livre1.estEgal(livre2), "2 livres égaux");
	}
	
	
	
	
}
