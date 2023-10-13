
class TestLivreConstruction {
	
	public static void main(String[] args) {
		TestLivreConstruction test = new TestLivreConstruction();
		test.testeConstruction();
	}

	void testeConstruction() {
		Livre l = new Livre(6,"Sciences",4);
		Test.assertEquals(l.getEpaisseur(), 4, "Livre - construction epaisseur");
		Test.assertEquals(l.getPoids(), 6, "Livre - construction poids");
		Test.assertEquals(l.getSection(), "Sciences", "Livre - construction section");
	}
}
