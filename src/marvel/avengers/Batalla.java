package marvel.avengers;

import java.util.Set;
import java.util.TreeSet;

public class Batalla {
	Set<Heroe> heroes;
	Set<Villano> villanos;
	Set<Villano> villanosGanadores;
	Set<Heroe> heroesGanadores;

	public Batalla() {
		heroes = new TreeSet<>();
		villanos = new TreeSet<>();
		villanosGanadores = new TreeSet<>();
		heroesGanadores = new TreeSet<>();
	}

	public void agregarPersonajeVillano(Villano villano) {
		villanos.add(villano);
	}
	
	public void agregarPersonajeHeroe(Heroe heroe) {
		heroes.add(heroe);
	}
	
	public void batallarEntreDosPersonajes(Heroe heroe, Villano villano) {
		// el personaje que mas puntos tenga, gana
		heroe.cargarGemas();
		villano.cargarGemas();
		
		if (heroe.getCantidadPoder() >= villano.getCantidadPoder()) {
			heroesGanadores.add(heroe);
		}
		else if (heroe.getCantidadPoder() < villano.getCantidadPoder()) {
			villanosGanadores.add(villano);
		}
	}
	
	public Set<Heroe> getHeroes() {
		return heroes;
	}

	public Set<Villano> getVillanos() {
		return villanos;
	}

	public Set<Villano> getListaVillanosGanadores() {
		// descendente
		return villanosGanadores;
	}

	public Set<Heroe> getListaHeroesGanadores() {
		// ascendente
		return heroesGanadores;
	}
	
	public boolean ganaronHeroes() throws WorldDestroyedException {
		// si la lista de heroes que ganaron es menor que la de villanos, GANA THANOS
		// WorldDestroyedException.
		if ( getListaHeroesGanadores().size() > getListaVillanosGanadores().size()) {
			return true;
		} else {
		throw new WorldDestroyedException("GAME OVER - Thanos destruyo el mundo!");
		}
	}
}
