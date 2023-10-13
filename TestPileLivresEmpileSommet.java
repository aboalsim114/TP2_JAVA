
class TestPileLivresEmpileSommet {
	public static void main(String[] args) {
		TestPileLivresEmpileSommet test = new TestPileLivresEmpileSommet();
		test.testeEmpile();
		test.testeTestPileLivresVideSommet();
	}

	void testeEmpile() {
		PileLivres pile = new PileLivres(4);
		Livre livre = new Livre(10, "Histoire", 5);
		pile.empile(livre);
		Test.assertFalse(pile.estVide(), "La pile n'est pas vide");
		Test.assertEquals(pile.getTaille(), 1, "il y a un élément dans la pile");
		Test.assertEquals(pile.getSommet(), livre, "le livre du sommet est celui qui a été ajouté");
		Test.assertEquals(pile.getPoids(), 10, "le poids de la pile");

		Livre livre2 = new Livre(4, "Sciences", 7);
		pile.empile(livre2);
		Test.assertFalse(pile.estVide(), "La pile n'est pas vide");
		Test.assertEquals(pile.getTaille(), 2, "il y a un élément dans la pile");
		Test.assertEquals(pile.getSommet(), livre2, "le livre du sommet est celui qui a été ajouté");
		Test.assertEquals(pile.getPoids(), 14, "le poids de la pile");
	}

	private void testeTestPileLivresVideSommet() {
		PileLivres pile = new PileLivres(100);
		Test.assertError(() -> pile.getSommet(), "La pile est vide");
		Test.assertErrorMessageChanged(() -> pile.getSommet(), "message d'erreur modifié");
	}

}
