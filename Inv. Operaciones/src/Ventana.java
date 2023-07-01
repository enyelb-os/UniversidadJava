import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = -6583294947224924310L;

    JPanel panel = new JPanel();
    JPanel panelPrincipal = new JPanel();
    JPanel panelCentral = new JPanel();
    JPanel panelLateral = new JPanel();
    JPanel panelIzq = new JPanel();

    JTextField[] titulo;
    JTextField n = new JTextField();
    JButton cantidadV = new JButton("Siguiente");

    String[] titulosDefault;
    String[][] mostrar;

    JButton tituloS = new JButton("Sigiente");

    JButton agregar = new JButton("+");
    JButton quitar = new JButton("-");
    JButton calcular = new JButton("Calcular");
    JButton reiniciar = new JButton("Reiniciar");

    ButtonGroup grupo = new ButtonGroup();
    JRadioButton min = new JRadioButton("Minimizar");
    JRadioButton max = new JRadioButton("Maximizar");

    ButtonGroup grupo2 = new ButtonGroup();
    JRadioButton simplex = new JRadioButton("Simplex");
    JRadioButton metodoM = new JRadioButton("Metodo M");

    JTextField vM = new JTextField();

    DefaultTableModel datos = new DefaultTableModel();
    JTable tabla = new JTable(datos);
    JScrollPane scroll = new JScrollPane(tabla);
    DefaultTableModel resultados = new DefaultTableModel();
    JTable tablaR = new JTable(resultados);
    JScrollPane scroll2 = new JScrollPane(tablaR);

    boolean m = true;
    boolean maxi = true;

    Ventana() {
	setVisible(true);
	setMinimumSize(new Dimension(500, 400));
	setSize(500, 400);
	setLocationRelativeTo(null);

	n.setColumns(5);
	n.setText("6");
	panel.add(n);

	cantidadV.addActionListener(this);
	tituloS.addActionListener(this);
	agregar.addActionListener(this);
	quitar.addActionListener(this);
	calcular.addActionListener(this);
	reiniciar.addActionListener(this);

	max.addActionListener(this);
	min.addActionListener(this);
	simplex.addActionListener(this);
	metodoM.addActionListener(this);

	grupo.add(max);
	grupo.add(min);

	grupo2.add(simplex);
	grupo2.add(metodoM);

	max.setSelected(true);
	simplex.setSelected(true);

	vM.setColumns(5);

	GroupLayout groupLayout = new GroupLayout(panelCentral);
	groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
		Alignment.LEADING).addGroup(
		Alignment.TRAILING,
		groupLayout
			.createSequentialGroup()
			.addContainerGap()
			.addGap(10)
			.addComponent(panelIzq, GroupLayout.DEFAULT_SIZE, 370,
				Short.MAX_VALUE)
			.addGap(10)
			.addComponent(panelLateral, GroupLayout.PREFERRED_SIZE,
				100, GroupLayout.PREFERRED_SIZE).addGap(10)));

	groupLayout
		.setVerticalGroup(groupLayout
			.createParallelGroup(Alignment.LEADING)
			.addGroup(
				Alignment.TRAILING,
				groupLayout
					.createSequentialGroup()
					.addContainerGap()
					.addGroup(
						groupLayout
							.createParallelGroup(
								Alignment.TRAILING)
							.addGroup(
								groupLayout
									.createSequentialGroup()
									.addComponent(
										panelIzq,
										GroupLayout.DEFAULT_SIZE,
										400,
										Short.MAX_VALUE)
									.addGap(10))
							.addComponent(
								panelLateral,
								Alignment.LEADING,
								GroupLayout.PREFERRED_SIZE,
								280,
								GroupLayout.PREFERRED_SIZE))
					.addGap(10)));
	panelCentral.setLayout(groupLayout);

	panelLateral.setLayout(new GridLayout(10, 2));
	panelIzq.setLayout(new GridLayout(0, 1, 0, 0));

	panel.add(cantidadV);

	panelPrincipal.setLayout(new BorderLayout());

	panelPrincipal.add(panel);

	add(panelPrincipal);

	revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == cantidadV) {
	    panel.removeAll();

	    titulo = new JTextField[Integer.parseInt(n.getText())];

	    for (int i = 0; i < titulo.length; i++) {
		titulo[i] = new JTextField();
		titulo[i].setText("x" + (i + 1));
		titulo[i].setColumns(5);
		panel.add(titulo[i]);
	    }

	    panel.add(tituloS);

	    panel.repaint();
	    this.revalidate();
	} else if (e.getSource() == tituloS) {
	    panelPrincipal.remove(panel);

	    tabla.setShowVerticalLines(true);
	    tabla.setShowHorizontalLines(true);
	    tabla.setEnabled(true);
	    tabla.setRowHeight(18);

	    tablaR.setShowVerticalLines(true);
	    tablaR.setShowHorizontalLines(true);
	    tablaR.setEnabled(false);
	    tablaR.setRowHeight(18);

	    titulosDefault = new String[titulo.length + 3];
	    titulosDefault[0] = "bas";
	    titulosDefault[1] = "z";
	    for (int i = 0; i < titulo.length; i++) {
		titulosDefault[i + 2] = titulo[i].getText();
	    }
	    titulosDefault[titulosDefault.length - 1] = "sol";

	    mostrar = new String[1][titulosDefault.length];
	    mostrar[0][0] = titulosDefault[1];

	    datos.setDataVector(mostrar, titulosDefault);
	    resultados.setColumnIdentifiers(titulosDefault);

	    panelLateral.add(max);
	    panelLateral.add(min);

	    panelLateral.add(agregar);
	    panelLateral.add(quitar);

	    panelLateral.add(simplex);
	    panelLateral.add(metodoM);

	    panelLateral.add(vM);

	    panelLateral.add(calcular);
	    panelLateral.add(reiniciar);

	    panelIzq.add(scroll);
	    panelIzq.add(scroll2);
	    panelCentral.add(panelIzq);
	    panelCentral.add(panelLateral);
	    panelPrincipal.add(panelCentral, BorderLayout.CENTER);

	    panelPrincipal.repaint();
	    this.revalidate();
	} else if (e.getSource() == agregar) {
	    String vec[] = new String[titulosDefault.length];
	    datos.addRow(vec);
	} else if (e.getSource() == quitar && datos.getRowCount() > 0) {
	    datos.removeRow(datos.getRowCount() - 1);
	} else if (e.getSource() == calcular) {

	    float valorM = 0;
	    float arr[][] = new float[datos.getRowCount()][datos
		    .getColumnCount() - 1];

	    String b[] = new String[titulosDefault.length - 2];
	    for (int i = 1; i <= b.length; i++) {
		b[i - 1] = titulosDefault[i];
	    }

	    String nb[] = new String[datos.getRowCount()];
	    for (int i = 0; i < datos.getRowCount(); i++) {
		nb[i] = (String) datos.getValueAt(i, 0);
	    }

	    try {
		for (int i = 0; i < datos.getRowCount(); i++) {
		    for (int j = 1; j < datos.getColumnCount(); j++) {
			arr[i][j - 1] = Float.parseFloat((String) datos
				.getValueAt(i, j));
			System.out.print(" " + arr[i][j - 1]);
		    }
		    System.out.println();
		}

		valorM = Float.parseFloat(vM.getText());

	    } catch (Exception e1) {
		System.out.println("Error Casillas Incompletas");
	    }

	    for (int i = 0; i < resultados.getRowCount();) {
		resultados.removeRow(i);
	    }

	    Matriz matriz = new Matriz(arr, m, maxi, b, nb, resultados, valorM);
	    matriz.simplex();

	}
	if (e.getSource() == metodoM) {
	    m = true;
	} else if (e.getSource() == simplex) {
	    m = false;
	}
	if (e.getSource() == max) {
	    maxi = true;
	} else if (e.getSource() == min) {
	    maxi = false;
	}

	if (e.getSource() == reiniciar) {
	    this.dispose();
	    Ventana v1 = new Ventana();
	    v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    }
}
