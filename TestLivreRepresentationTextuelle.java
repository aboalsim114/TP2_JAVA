
class TestLivreRepresentationTextuelle {
	public static void main(String[] args) {
		TestLivreRepresentationTextuelle test = new TestLivreRepresentationTextuelle();
		test.testeVersChaine();
	}

	void testeVersChaine() {
		Livre l = new Livre(5,"Histoire",3);
		Test.assertEquals(l.versChaine(), "poids:5 - ep.:3 (Histoire)", "Livre - représentation textuelle");
	}
}
