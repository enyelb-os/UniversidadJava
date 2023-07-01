import java.util.Stack;

import prim.PrimVoraz;
import grafo.Arista;
import grafo.Grafo;

public class Trabajos {
	double costo = 0;
	double tempPeso = 0;

	public Trabajos(Grafo reino, int costosC[]) {
		CompConectados cc = new CompConectados(reino);
		Ciclo c = new Ciclo(reino);

		if (cc.compConectados() == 1 && c.existeCiclo()) {
			System.out.println("Demoler");
			demoler(reino);
		} else if (c.existeCiclo()) {
			System.out.println("Construir\n& Demoler");
			llenarGrafo(reino, costosC);
			construir(reino);
			demoler(reino);
		} else if (reino.getNumV() < 0) {
			System.out.println("Contruir");
			llenarGrafo(reino, costosC);
			construir(reino);
		} else {
			System.out.println("Nada");
		}

	}

	public void construir(Grafo reino) {
		double diferencia = costo;
		System.out.println("------------");
		System.out.println("Construyendo");
		PrimVoraz kr = new PrimVoraz(reino, false);
		kr.mostrar();

		Arista lista[] = kr.aristas();
		Stack<Arista> pagar = new Stack<Arista>();

		for (int k = 0; k < reino.getNumV(); k++) {
			Arista ady[] = reino.adyacentes(k);
			for (int j = 0; j < ady.length; j++) {
				boolean bandera = false;
				for (int i = 0; i < lista.length; i++) {
					if (lista[i] == ady[j]) {
						bandera = true;
						if (!pagar.contains(ady[j]) && ady[j].p() > tempPeso) {
							ady[j].setP(ady[j].p() - tempPeso);
							pagar.add(ady[j]);
						}
					}
				}
				if (bandera == false && ady[j].p() >= tempPeso) {
					reino.removerArista(ady[j]);
				}
			}
		}
		System.out.println("------------");
		while (!pagar.isEmpty()) {
			Arista e = pagar.pop();
			System.out.println("Construir "+e.origen()+"-"+e.destino()+" -> Costo: "+e.p());
			costo = costo + e.p();
		}

		System.out.println("Costo: " + (costo - diferencia));
		System.out.println("------------");
	}

	public void demoler(Grafo reino) {
		double diferencia = costo;
		System.out.println("------------");
		System.out.println("Demoliendo");
		PrimVoraz kr = new PrimVoraz(reino, true);
		kr.mostrar();

		Arista a[] = kr.aristas();

		System.out.println("------------");
		for (int j = 0; j < reino.getNumV(); j++) {
			Arista b[] = reino.adyacentes(j);
			for (int k = 0; k < b.length; k++) {
				boolean bandera = false;
				for (int i = 0; i < a.length; i++) {
					if (a[i] == b[k]) {
						bandera = true;
					}
				}
				if (bandera == false) {
					reino.removerArista(b[k]);
					costo = costo + b[k].p();
					System.out.println("Demolor: "+b[k].origen()+"-"+b[k].destino()+" -> Costo: "+b[k].p());
				}
			}
		}
		System.out.println("Costo: " + (costo - diferencia));
		System.out.println("------------");
	}

	public double costo() {
		System.out.println("Costo Total: " + costo);
		return costo;
	}

	private void llenarGrafo(Grafo reino, int[] costosC) {
		tempPeso = reino.cantPeso();
		for (int i = 0; i < reino.getNumV(); i++) {
			for (int j = 0; j < reino.getNumV(); j++) {
				if (i != j)
					reino.agregarArista(i, j,
							costosC[(i * reino.getNumV()) + j] + tempPeso);
			}
		}
	}
}
