package marvel.avengers;

public class WorldDestroyedException extends Exception {

	private static final long serialVersionUID = 1L;

	public WorldDestroyedException() {
		
	}
	
	public WorldDestroyedException(String msj) {
		super(msj);
	}
}
