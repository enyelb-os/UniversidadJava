import javax.swing.table.DefaultTableModel;

public class Matriz {
    private float matriz[][];
    private boolean m;
    private boolean min = false, max = true;
    private String basicas[];
    private String noBasicas[];
    private boolean candidatas[];
    private int entrada = 0;
    private int salida = 0;
    private DefaultTableModel r;
    private float valorM;

    Matriz(float[][] matriz, boolean m, boolean maxi, String[] b, String[] nb,
	    DefaultTableModel r, float valorM) {
	this.matriz = matriz;
	this.m = m;
	basicas = b;
	noBasicas = nb;

	if (maxi == true) {
	    max = true;
	    min = false;
	} else {
	    min = true;
	    max = false;
	}
	this.r = r;
	this.valorM = valorM;
    }

    private void igualarRs() {
	for (int j = 0; j < matriz.length; j++) {
	    for (int i = 0; i < matriz[0].length; i++) {

		if (min == true && noBasicas[j].contains("r")) {
		    matriz[0][i] = matriz[0][i] + (matriz[j][i] * valorM);
		} else if (max == true && noBasicas[j].contains("r")) {
		    matriz[0][i] = matriz[0][i] - (matriz[j][i] * valorM);
		}
	    }
	}
    }

    public void simplex() {

	if (m == true) {
	    igualarRs();
	    m = false;
	}
	entrada();
	salida();

	mostrarM();

	if (entrada != 0) {
	    nuevaMatriz();
	    simplex();
	}

    }

    private void nuevaMatriz() {

	float matrizt[][] = new float[matriz.length][matriz[0].length];
	float pivote = matriz[salida][entrada];

	for (int i = 0; i < matriz[0].length; i++) {
	    if (pivote != 0) {
		matriz[salida][i] = matriz[salida][i] / pivote;
		matrizt[salida][i] = matriz[salida][i];
	    } else {
		matrizt[salida][i] = matriz[salida][i];
	    }

	}
	for (int i = 0; i < matriz.length; i++) {
	    for (int j = 0; j < matriz[0].length; j++) {
		if (i != salida) {
		    matrizt[i][j] = (matriz[i][j])
			    - (matriz[i][entrada] * matriz[salida][j]);
		}
	    }
	}
	matriz = matrizt;

	noBasicas[salida] = basicas[entrada];
    }

    private void entrada() {
	entrada = 0;
	if (max == true) {
	    candidatas();
	    float temp = 0;
	    for (int i = 0; i < candidatas.length; i++) {
		if (candidatas[i] == true) {
		    if (matriz[0][i] < temp && matriz[0][i] < 0) {
			entrada = i;
			temp = matriz[0][i];
		    } else {

		    }
		}
	    }
	}

	else if (min == true) {
	    candidatas();
	    float temp = 0;
	    for (int i = 0; i < candidatas.length; i++) {
		if (candidatas[i] == true) {
		    if (matriz[0][i] > temp && matriz[0][i] > 0) {
			entrada = i;
			temp = matriz[0][i];
		    }
		}
	    }
	}
    }

    private void salida() {
	float temp[] = new float[matriz.length - 1];
	for (int i = 1; i < matriz.length; i++) {
	    if (matriz[i][entrada] != 0) {
		temp[i - 1] = matriz[i][matriz[i].length - 1]
			/ matriz[i][entrada];
	    } else {
		temp[i - 1] = -1;
	    }
	}
	if (salida != 0 && temp[salida - 1] == 0) {
	    temp[salida - 1] = -1;
	}
	int mayor = 0;
	for (int i = 0; i < temp.length; i++) {
	    if (temp[mayor] < temp[i]) {
		mayor = i;
		System.out.println("mayor" + temp[mayor] + "<" + temp[i]);
	    }

	}
	salida = mayor + 1;
	for (int i = 0; i < temp.length; i++) {
	    System.out.println("minimo temp " + temp[mayor] + " " + mayor);
	    if (temp[i] < temp[mayor] && temp[i] >= 0) {
		salida = i + 1;
		mayor = i;
	    }
	}
    }

    private void candidatas() {
	candidatas = new boolean[basicas.length];
	for (int i = 0; i < basicas.length; i++) {
	    for (int j = 0; j < noBasicas.length; j++) {
		if (basicas[i].equals(noBasicas[j])) {
		    candidatas[i] = false;
		    j = noBasicas.length;
		} else {
		    candidatas[i] = true;
		}
	    }
	}
    }

    public void mostrarM() {

	String temp[] = new String[matriz[0].length + 1];

	temp[0] = "bas";
	for (int i = 0; i < basicas.length; i++) {
	    temp[i + 1] = basicas[i];
	}
	temp[matriz[0].length] = "sol";
	r.addRow(temp);

	for (int i = 0; i < matriz.length; i++) {
	    for (int j = 0; j < matriz[i].length; j++) {
		System.out.print("\t" + matriz[i][j]);
		temp[j + 1] = "" + matriz[i][j];
	    }
	    temp[0] = noBasicas[i];
	    r.addRow(temp);
	    System.out.println();
	}
	temp = null;
	r.addRow(temp);
    }

    public String[][] matriz() {
	String matrizt[][] = new String[matriz.length][matriz[0].length];
	for (int i = 0; i < matriz.length; i++) {
	    for (int j = 0; j < matriz[i].length; j++) {
		matrizt[i][j] = "" + matriz[i][j];
	    }
	}
	return matrizt;
    }

}
