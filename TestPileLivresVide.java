
class TestPileLivresVide {
	public static void main(String[] args) {
		TestPileLivresVide test = new TestPileLivresVide();
		test.testEstVide();
	}

	void testEstVide() {
		PileLivres pile = new PileLivres(4);
		Test.assertTrue(pile.estVide(), "La pile est vide");
	}
}
