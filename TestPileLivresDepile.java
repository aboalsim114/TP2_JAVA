
class TestPileLivresDepile {
	public static void main(String[] args) {
		TestPileLivresDepile test = new TestPileLivresDepile();
		test.testeDepilePileVide();
		test.testeDepilePileNonVide();
	}

	void testeDepilePileVide() {
		PileLivres pile = new PileLivres(4);
		Test.assertError(() -> pile.depile(), "La pile est vide");
		Test.assertErrorMessageChanged(() -> pile.depile(), "message d'erreur modifié");
		Test.assertEquals(pile.getTaille(), 0, "la taille de la pile est 1");
		Test.assertEquals(pile.getPoids(), 0, "le poids de la pile");
	}
	
	void testeDepilePileNonVide() {
		PileLivres pile = new PileLivres(5);
		Livre livre1 = new Livre(7,"Sciences",4);
		Livre livre2 = new Livre(10,"Histoire",5);
		pile.empile(livre1);
		pile.empile(livre2);
		
		Test.assertEquals(pile.depile(), livre2, "Le livre dépilé est le livre 2");
		Test.assertEquals(pile.getTaille(), 1, "la taille de la pile est 1");
		Test.assertEquals(pile.getPoids(), 7, "le poids de la pile");
	}
}
