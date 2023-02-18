package marvel.avengers;

public class Villano extends Personaje implements Comparable <Villano>{

	public Villano(String nombre, Integer cantidadPoder) {
		super(nombre, cantidadPoder);
	}

	@Override
	public int compareTo(Villano o) {
		return this.getCantidadPoder().compareTo(o.getCantidadPoder());
	}
}
