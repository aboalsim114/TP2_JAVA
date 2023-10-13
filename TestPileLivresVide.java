import java.util.ArrayList;

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

class PileLivres {
	private ArrayList<Livre> livres;

	public PileLivres(int capacite) {
		this.livres = new ArrayList<>(capacite);
	}

	public boolean estVide() {
		return livres.isEmpty();
	}

	public void empile(Livre livre) {
		livres.add(livre);
	}

	public Livre getSommet() {
		if (estVide()) {
			throw new IllegalStateException("La pile est vide");
		}
		return livres.get(livres.size() - 1);
	}

	public Livre depile() {
		if (estVide()) {
			throw new IllegalStateException("La pile est vide");
		}
		return livres.remove(livres.size() - 1);
	}

	public int getPoids() {
		int poidsTotal = 0;
		for (Livre livre : livres) {
			poidsTotal += livre.getPoids();
		}
		return poidsTotal;
	}

	public int getTaille() {
		return livres.size();
	}

}