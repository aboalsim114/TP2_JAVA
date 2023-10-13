
class TestPileLivresConstruction {
	public static void main(String[] args) {	
		TestPileLivresConstruction test = new TestPileLivresConstruction();
		test.testePileLivresConstruction();
	}

	void testePileLivresConstruction() {
		PileLivres pile = new PileLivres(100);
		Test.assertEquals(pile.getPoids(), 0, "Construction PileLivres -> poids");
		Test.assertEquals(pile.getTaille(), 0, "Construction PileLivres -> taille");
	}
	
	
}
