
class TestEtagereConstruction {
	public static void main(String[] args) {
		TestEtagereConstruction test = new TestEtagereConstruction();
		test.testeEtagereConstruction();
	}

	void testeEtagereConstruction() {
		Etagere etagere = new Etagere(50);
		Test.assertEquals(etagere.getLongueurMax(), 50, "Construction Etagere -> longueur maximale");
		Test.assertEquals(etagere.getTailleCourante(), 0, "Construction Etagere -> taille courante");
	}

}

class Etagere {
	private int longueurMax;
	private int tailleCourante;

	public Etagere(int longueurMax) {
		this.longueurMax = longueurMax;
		this.tailleCourante = 0;
	}

	public int getLongueurMax() {
		return longueurMax;
	}

	public int getTailleCourante() {
		return tailleCourante;
	}
}
