package marvel.avengers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestMarvel {

	@Test
	public void testQueSePuedanAgregarLosPersonajesALaBatalla() {
		Batalla batalla = new Batalla();
		assertNotNull(batalla);
		
		Personaje heroe1 = new Heroe("Thor", 100);
		Personaje heroe2 = new Heroe("Capitan-America", 120);
		Personaje heroe3 = new Heroe("Hulk", 130);
		Personaje heroe4 = new Heroe("Black Widow", 85);
		Personaje heroe5 = new Heroe("Iron Man", 110);
		
		batalla.agregarPersonajeHeroe((Heroe)heroe5);
		batalla.agregarPersonajeHeroe((Heroe)heroe4);
		batalla.agregarPersonajeHeroe((Heroe)heroe3);
		batalla.agregarPersonajeHeroe((Heroe)heroe2);
		batalla.agregarPersonajeHeroe((Heroe)heroe1);
		
		Personaje villano1 = new Villano("Loki", 80);
		Personaje villano2 = new Villano("Ronnan", 110);
		Personaje villano3 = new Villano("Red Skull", 130);
		Personaje villano4 = new Villano("Soldado Del Invierno", 120);
		Personaje villano5 = new Villano("Hela", 115);
		
		batalla.agregarPersonajeVillano((Villano)villano1);
		batalla.agregarPersonajeVillano((Villano)villano2);
		batalla.agregarPersonajeVillano((Villano)villano3);
		batalla.agregarPersonajeVillano((Villano)villano4);
		batalla.agregarPersonajeVillano((Villano)villano5);
		
		assertTrue(batalla.getHeroes().contains(heroe5));
		assertTrue(batalla.getHeroes().contains(heroe4));
		assertTrue(batalla.getHeroes().contains(heroe3));
		assertTrue(batalla.getHeroes().contains(heroe2));
		assertTrue(batalla.getHeroes().contains(heroe1));
		assertEquals(batalla.getHeroes().size(), 5);
		
		assertTrue(batalla.getVillanos().contains(villano5));
		assertTrue(batalla.getVillanos().contains(villano4));
		assertTrue(batalla.getVillanos().contains(villano3));
		assertTrue(batalla.getVillanos().contains(villano2));
		assertTrue(batalla.getVillanos().contains(villano1));
		assertEquals(batalla.getVillanos().size(), 5);
	}

	@Test
	public void queNoSePuedaAgregarUnPersonajeYaExistente() {
		Personaje heroe1 = new Heroe("Thor", 100);
		Personaje heroe2 = new Heroe("Thor", 100);
		
		Batalla batalla = new Batalla();
		assertNotNull(batalla);
		
		batalla.agregarPersonajeHeroe((Heroe)heroe1);
		batalla.agregarPersonajeHeroe((Heroe)heroe2);
		
		assertTrue(batalla.getHeroes().contains(heroe1));
		assertEquals(batalla.getHeroes().size(), 1);
	}

	@Test
	public void obtenerListaDeVillanosDescendente() {
		Batalla batalla = new Batalla();
		assertNotNull(batalla);
		
		Personaje villano1 = new Villano("Red Skull", 130);
		Personaje villano2 = new Villano("Soldado Del Invierno", 120);
		Personaje villano3 = new Villano("Loki", 80);
		Personaje villano4 = new Villano("Ronnan", 110);
		Personaje villano5 = new Villano("Hela", 115);
		
		batalla.agregarPersonajeVillano((Villano)villano1);
		batalla.agregarPersonajeVillano((Villano)villano2);
		batalla.agregarPersonajeVillano((Villano)villano3);
		batalla.agregarPersonajeVillano((Villano)villano4);
		batalla.agregarPersonajeVillano((Villano)villano5);
		
		List <Villano> villanosOrdenados = new ArrayList<>();
		villanosOrdenados.addAll(batalla.getVillanos());
		
		assertEquals(villanosOrdenados.get(0), villano1);
		assertEquals(villanosOrdenados.get(1), villano2);
		assertEquals(villanosOrdenados.get(2), villano5);
		assertEquals(villanosOrdenados.get(3), villano4);
		assertEquals(villanosOrdenados.get(4), villano3);
	}

	@Test
	public void obtenerListaDeHeroesAscendente() {
		Batalla batalla = new Batalla();
		assertNotNull(batalla);
		
		Personaje heroe1 = new Heroe("Thor", 100);
		Personaje heroe2 = new Heroe("Capitan-America", 120);
		Personaje heroe3 = new Heroe("Hulk", 130);
		Personaje heroe4 = new Heroe("Black Widow", 85);
		Personaje heroe5 = new Heroe("Iron Man", 110);
		
		batalla.agregarPersonajeHeroe((Heroe)heroe5);
		batalla.agregarPersonajeHeroe((Heroe)heroe4);
		batalla.agregarPersonajeHeroe((Heroe)heroe3);
		batalla.agregarPersonajeHeroe((Heroe)heroe2);
		batalla.agregarPersonajeHeroe((Heroe)heroe1);
		
		List <Heroe> heroesOrdenados = new ArrayList<>();
		heroesOrdenados.addAll(batalla.getHeroes());
		
		assertEquals(heroesOrdenados.get(0),heroe4);
		assertEquals(heroesOrdenados.get(1),heroe1);
		assertEquals(heroesOrdenados.get(2),heroe5);
		assertEquals(heroesOrdenados.get(3),heroe2);
		assertEquals(heroesOrdenados.get(4),heroe3);
	}
	
	@Test
	public void verSiGanaronHeroesYSeSalvoElMundo() throws WorldDestroyedException {
		Batalla batalla = new Batalla();
		assertNotNull(batalla);
		
		Personaje heroe1 = new Heroe("Thor", 1000);
		Personaje heroe2 = new Heroe("Capitan-America", 1200);
		Personaje heroe3 = new Heroe("Hulk", 1300);
		Personaje heroe4 = new Heroe("Black Widow", 850);
		Personaje heroe5 = new Heroe("Iron Man", 1100);
		
		batalla.agregarPersonajeHeroe((Heroe)heroe5);
		batalla.agregarPersonajeHeroe((Heroe)heroe4);
		batalla.agregarPersonajeHeroe((Heroe)heroe3);
		batalla.agregarPersonajeHeroe((Heroe)heroe2);
		batalla.agregarPersonajeHeroe((Heroe)heroe1);
		
		Personaje villano1 = new Villano("Loki", 80);
		Personaje villano2 = new Villano("Ronnan", 110);
		Personaje villano3 = new Villano("Red Skull", 130);
		Personaje villano4 = new Villano("Soldado Del Invierno", 120);
		Personaje villano5 = new Villano("Hela", 115);
		
		batalla.agregarPersonajeVillano((Villano)villano1);
		batalla.agregarPersonajeVillano((Villano)villano2);
		batalla.agregarPersonajeVillano((Villano)villano3);
		batalla.agregarPersonajeVillano((Villano)villano4);
		batalla.agregarPersonajeVillano((Villano)villano5);
		
		batalla.batallarEntreDosPersonajes((Heroe)heroe1, (Villano)villano1);
		batalla.batallarEntreDosPersonajes((Heroe)heroe2, (Villano)villano2);
		batalla.batallarEntreDosPersonajes((Heroe)heroe3, (Villano)villano3);
		batalla.batallarEntreDosPersonajes((Heroe)heroe4, (Villano)villano4);
		batalla.batallarEntreDosPersonajes((Heroe)heroe5, (Villano)villano5);
		
		assertTrue(batalla.ganaronHeroes());
	}
	
	@Test (expected = WorldDestroyedException.class)
	public void verSiGanaronLosVillanosYLanzaLaExcepcion() throws WorldDestroyedException {
		Batalla batalla = new Batalla();
		assertNotNull(batalla);
		
		Personaje heroe1 = new Heroe("Thor", 100);
		Personaje heroe2 = new Heroe("Capitan-America", 120);
		Personaje heroe3 = new Heroe("Hulk", 130);
		Personaje heroe4 = new Heroe("Black Widow", 85);
		Personaje heroe5 = new Heroe("Iron Man", 110);
		
		batalla.agregarPersonajeHeroe((Heroe)heroe5);
		batalla.agregarPersonajeHeroe((Heroe)heroe4);
		batalla.agregarPersonajeHeroe((Heroe)heroe3);
		batalla.agregarPersonajeHeroe((Heroe)heroe2);
		batalla.agregarPersonajeHeroe((Heroe)heroe1);
		
		Personaje villano1 = new Villano("Loki", 800);
		Personaje villano2 = new Villano("Ronnan", 1100);
		Personaje villano3 = new Villano("Red Skull", 1300);
		Personaje villano4 = new Villano("Soldado Del Invierno", 1200);
		Personaje villano5 = new Villano("Hela", 1150);
		
		batalla.agregarPersonajeVillano((Villano)villano1);
		batalla.agregarPersonajeVillano((Villano)villano2);
		batalla.agregarPersonajeVillano((Villano)villano3);
		batalla.agregarPersonajeVillano((Villano)villano4);
		batalla.agregarPersonajeVillano((Villano)villano5);
		
		batalla.batallarEntreDosPersonajes((Heroe)heroe1, (Villano)villano1);
		batalla.batallarEntreDosPersonajes((Heroe)heroe2, (Villano)villano2);
		batalla.batallarEntreDosPersonajes((Heroe)heroe3, (Villano)villano3);
		batalla.batallarEntreDosPersonajes((Heroe)heroe4, (Villano)villano4);
		batalla.batallarEntreDosPersonajes((Heroe)heroe5, (Villano)villano5);
		
		assertTrue( ! batalla.ganaronHeroes());
	}
}
