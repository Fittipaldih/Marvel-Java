package marvel.avengers;

public class Heroe extends Personaje implements Comparable <Heroe>{

	public Heroe(String nombre, Integer cantidadPoder) {
		super(nombre, cantidadPoder);
	}

	@Override
	public int compareTo(Heroe o) {
		return this.getCantidadPoder().compareTo(o.getCantidadPoder());
	}
}
