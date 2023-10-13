
class TestLivreConstruction {

	public static void main(String[] args) {
		TestLivreConstruction test = new TestLivreConstruction();
		test.testeConstruction();
	}

	void testeConstruction() {
		Livre l = new Livre(6, "Sciences", 4);
		Test.assertEquals(l.getEpaisseur(), 4, "Livre - construction epaisseur");
		Test.assertEquals(l.getPoids(), 6, "Livre - construction poids");
		Test.assertEquals(l.getSection(), "Sciences", "Livre - construction section");
	}
}

class Livre {
	private int poids;
	private String section;
	private int epaisseur;

	public Livre(int poids, String section, int epaisseur) {
		this.poids = poids;
		this.section = section;
		this.epaisseur = epaisseur;
	}

	public int getPoids() {
		return poids;
	}

	public String getSection() {
		return section;
	}

	public int getEpaisseur() {
		return epaisseur;
	}

	public String versChaine() {
		return "poids:" + poids + " - ep.:" + epaisseur + " (" + section + ")";
	}

	public boolean estEgal(Livre autreLivre) {
		return this.poids == autreLivre.getPoids() &&
				this.epaisseur == autreLivre.getEpaisseur() &&
				this.section.equals(autreLivre.getSection());
	}

}
