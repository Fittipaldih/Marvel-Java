package marvel.avengers;

public abstract class Personaje {
	private String nombre;
	private Integer cantidadPoder;
	private Gema gema;

	public Personaje(String nombre, Integer cantidadPoder) {
		this.nombre = nombre;
		this.cantidadPoder = cantidadPoder;
	}

	public void cargarGemas() {
		// reparte gemas al azar por cada personaje cuando van a la batalla
		this.gema = this.conseguirGema();
		validarPoderDependiendoGema(gema);
	}

	private void validarPoderDependiendoGema(Gema gema) {
		// multiplica la cantidad de poder del personaje dependiendo las gemas que le tocaron
		// tiempo mente y poder valen x3
		// las otras valen x2
		if (gema.equals(Gema.MENTE) || gema.equals(Gema.TIEMPO) || gema.equals(Gema.PODER)) {
			this.cantidadPoder *= 3;
		}

		if (gema.equals(Gema.ALMA) || gema.equals(Gema.ESPACIO) || gema.equals(Gema.REALIDAD)) {
			this.cantidadPoder *= 2;
		}
	}

	private Gema conseguirGema() {
		Gema gemaAlAzar = Gema.values()[dameUnNumeroAlAzar()];
		return gemaAlAzar;
	}

	protected Integer dameUnNumeroAlAzar() {
		Integer numeroGema = (int) (Math.round(Math.random() * 5));
		return numeroGema;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Integer getCantidadPoder() {
		return cantidadPoder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Personaje " + nombre + ", cantidad de poder: " + cantidadPoder;
	}

	public Gema getGemaConseguida() {
		return this.gema;
	}
}
