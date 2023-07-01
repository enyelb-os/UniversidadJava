import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class VentanaScroll extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	Impresora a;
	Color colorP=new Color(255,255,255);
	Font fuenteS=new Font("Comic Sans MS",Font.BOLD,13);	// Fuente  Purisa, Comic Sans MS
	Font fuenteN=new Font("Purisa",Font.ITALIC,13);         //Fuente
	Font fuenteCola=new Font("Arial",Font.ITALIC,20);       // Fuente
	Font fuenteP=new Font("Arial",Font.BOLD,13);            //Fuente
	PanelScroll lamina=new PanelScroll();
	
	String[] titulosDefault={"Prioridad","Nombre","Id","PUsuario","Paginas","Reciente"};
	String [][] mostrar;
	DefaultTableModel datos=new DefaultTableModel(mostrar,titulosDefault);
	JTable tabla=new JTable(datos);
	JScrollPane scroll=new JScrollPane(tabla);
	
	JButton insertar=new JButton("Insertar");               // Boton
	JButton extraer=new JButton("Extraer");                 // Boton
	
	JLabel cola=new JLabel("");                             // Text
	JLabel costo=new JLabel("Sin Datos");                            // Text
	JLabel saliendo[]=new JLabel[6];						// TextS Vector
	JLabel nombres[]=new JLabel[4];						// TextS Vector
	
	VentanaScroll(Impresora a){
		this.a=a;
		this.setTitle("IMPRESORA");
		this.setVisible(true);
        this.setResizable(false);
		this.setSize(600, 400);
		this.setLocation(100, 100);
		//-------------------------------------------////Scroll
		mostrar=a.mostrar();
		
		datos.setDataVector(mostrar, titulosDefault);
		
		scroll.setBounds(6, 37, 350, 292);
		
		tabla.setShowVerticalLines(false);
		tabla.setShowHorizontalLines(false);
		tabla.setEnabled(false);
		tabla.setBackground(colorP);
		tabla.setRowHeight(18);
		tabla.setFont(fuenteS);
		lamina.add(scroll);
		//-------------------------------------------////SALIENDO
		for(int i=0;i<6;i++){
			saliendo[i]=new JLabel("");                                            // Crea los txt de el que Va saliendo
			saliendo[i].setFont(fuenteS);                                          //Fuentes del q va saliendo
			saliendo[i].setBounds(370 , (i*20)+10, 210, 20);                       //Posiciones del q va saliendo
			saliendo[i].setHorizontalAlignment(JLabel.CENTER);
			lamina.add(saliendo[i]);                                               // Se agregan los text al Panel;
		}
		//-------------------------------------------////Nombres
		for(int i=0;i<4;i++){
			nombres[i]=new JLabel();                                            // Crea los txt de el que Va saliendo
			nombres[i].setFont(fuenteN);                                          //Fuentes del q va saliendo
			nombres[i].setBounds(370 , (i*20)+210, 210, 20);                       //Posiciones del q va saliendo
			lamina.add(nombres[i]);                                               // Se agregan los text al Panel;
		}
		nombres[0].setText("Andrea Vera       22600908");
		nombres[1].setText("Enyelberth Gonzalez 26200431");
		nombres[2].setText("Jose Boscan        25439050");
		nombres[3].setText("Josibel Torcato    25296390");
		//-------------------------------------------////COLA INFO
		cola.setBounds(420, 340, 120, 20);
		cola.setFont(fuenteCola);
		cola.setForeground(new Color(53,172,255));
		lamina.add(cola);
		//-------------------------------------------////COSTO INFO
		costo.setBounds(362, 140, 227, 25);
		costo.setFont(fuenteCola);
		costo.setVerticalAlignment(JLabel.CENTER);
		costo.setHorizontalAlignment(JLabel.CENTER);
		costo.setForeground(new Color(53,172,255));
		lamina.add(costo);
		//-------------------------------------------////BOTONES
		insertar.setBounds(60, 340, 100, 20);
		extraer.setBounds(190, 340, 100, 20);
		insertar.addActionListener(this);
		extraer.addActionListener(this);
		lamina.add(insertar);
		lamina.add(extraer);
		//-------------------------------------------////LAMINA
		lamina.setLayout(null);
		add(lamina);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object pulsado=e.getSource();
		//------------------------------------------////Extraer
		if(pulsado==extraer){
			if(!a.esVacio()){
				TrabajoImp aux=a.extraer();
				//----------------------------------////Actualiza Tabla
				String[][] mostrar=new String[a.getn()][5];
				mostrar=a.mostrar();
				for(int i=0;i<a.getn();i++){
					for(int j=0;j<6;j++){
						datos.setValueAt(mostrar[i][j], i, j);
					}
				}
				//----------------------------------////Limpiar Ultimo Tabla
				for(int i=a.getn();i<a.getN();){
					datos.removeRow(i);
					break;
				}
				//----------------------------------////COLA VACIA
				if(a.esVacio()){
					cola.setText("Cola Vacia!");
				}
				//----------------------------------////Actuliza la COLA
				else{
					cola.setText("");
				}
				//----------------------------------////Mostrar Ultimo
				saliendo[0].setText("Nombre: "+aux.getNombre());
				saliendo[1].setText("Prioridad: "+Integer.toString(aux.getPrioridad()));
				saliendo[2].setText("Identificacion: "+Integer.toString(aux.getID()));
				saliendo[3].setText("Prioridad de Usuario: "+Integer.toString(aux.getPUsuario()));
				saliendo[4].setText("Numero de Paginas: "+Integer.toString(aux.getNPaginas()));
				saliendo[5].setText("Trabajos Reciente: "+Integer.toString(aux.getIReciente()));
				if(aux.getIoE()==true){
					TrabajoImpExterno aux2=new TrabajoImpExterno(aux.getNombre(),aux.getID(),aux.getPUsuario(),aux.getNPaginas(),aux.getIoE(),aux.getIReciente());
					costo.setText("Costo: "+Integer.toString(aux2.getCosto())+"Bs");
				}else{
					TrabajoImpInterno aux2=new TrabajoImpInterno(aux.getNombre(),aux.getID(),aux.getPUsuario(),aux.getNPaginas(),aux.getIoE(),aux.getIReciente());
					costo.setText("Trabajo Interno: "+Integer.toString(aux2.getCosto())+"Bs");
				}
			}
		}
		//------------------------------------------////Insertar
		if(pulsado==insertar){
			if(!a.esLLeno()){
				int id = 0,pu=0,np=0,ie=0;boolean bandera ,i_e ;String nombre;
				//---------------------------------////Nombre
				nombre=JOptionPane.showInputDialog(null,"Ingrese Su Nombre");
				//---------------------------------////Validacion de Id
				do{
					try{
						id=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese La Identificacion: Solo Numeros"));
						bandera=true;
						if(id<0){
							JOptionPane.showMessageDialog(null,"Solo Se Permiten Numeros Positivos");
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null,"Solo Se Permiten Numeros");
						bandera=false;
					}
				}while(!bandera  || id<0);
				//---------------------------------////Validacion de Prioridad de User
				do{
					try{
						pu=Integer.parseInt(JOptionPane.showInputDialog(null,"Prioridad: Solo Numeros \n1) Alta  2) Media  3)Baja"));
						bandera=true;
						if(!(pu>0&&pu<4)){
							JOptionPane.showMessageDialog(null,"Solo Se Permiten Numeros Entre 1-3");
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null,"Solo Se Permiten Numeros");
						bandera=false;
					}
				}while(!bandera  ||!(pu>0 && pu<4) );
				//---------------------------------////Validacion de Numero de Paginas
				do{
					try{
						np=Integer.parseInt(JOptionPane.showInputDialog(null,"Cantidad De Paginas"));
						bandera=true;
						if(np<=0){
							JOptionPane.showMessageDialog(null,"Solo Se Permiten Numeros Mayores a 0");
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null,"Solo Se Permiten Numeros");
						bandera=false;
					}
				}while(!bandera  || np<=0);
				//---------------------------------////Validacion de clase interna o externa
				do{
					try{
						ie=Integer.parseInt(JOptionPane.showInputDialog(null,"Clase Externa \n 1) Verdadero  0) Falso "));
						bandera=true;
						if((ie!=0 && ie!=1)){
							JOptionPane.showMessageDialog(null,"Solo Se Permite 1 ó 0");
						}
					}catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(null,"Solo Se Permiten Numeros");
						bandera=false;
					}
				}while(!bandera  || (ie!=0 && ie!=1));
				if(ie==1)
					i_e=true;
				else
					i_e=false;
				//---------------------------------////Inserta
				a.insertar(nombre,id,pu,np,i_e);
				//---------------------------------////Actualiza la Matiz
				String[][] mostrar=new String[a.getn()][5];
				mostrar=a.mostrar();
				datos.addRow(titulosDefault);
				for(int i=0;i<a.getn();i++){
					for(int j=0;j<6;j++){
						datos.setValueAt(mostrar[i][j], i, j);
					}
				}
				//---------------------------------////Actualiza la COLA
				cola.setText("");
			}
			else{
				//---------------------------------////COLA LLENA
				cola.setText("Cola LLena!");
			}
		}
	}

}
class PanelScroll extends JPanel{

	private static final long serialVersionUID = 1L;
	
	Color colorP=new Color(255,255,255);
	Font fuenteP=new Font("Arial",Font.BOLD,13);       //Fuente
	PanelScroll(){
	}
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(new Color(230,230,230));
		g.fillRect(0, 0, 600, 400);      //Relleno
		g.setColor(Color.lightGray);
		for(int i=0;i<30;i++){
			g.drawLine(i*20,0, 600+(i*20), 600);      //Borde
			g.drawLine(0,i*20, 600, 600+(i*20));      //Borde
		}

		g.setColor(colorP);             //Color         Cuadro 1
		g.fillRect(5, 7, 350, 23);      //Relleno
		g.setColor(Color.gray);         //Color
		g.drawRect(5, 7, 350, 23);      //Borde
		
		g.setColor(colorP);             //Color         cuadro 3
		g.fillRect(360, 7, 230, 321);   //Relleno
		g.setColor(Color.gray);         //Color
		g.drawRect(360, 7, 230, 321);   //Borde
			
		g.setColor(colorP);             //Color         cuadro 4
		g.fillRect(360, 335, 230, 30);  //Relleno
		g.setColor(Color.gray);         //Color
		g.drawRect(360, 335, 230, 30);  //Borde
			
		g.setColor(Color.black);
		g.setFont(fuenteP);
		g.drawString("Proyecto 3 - Cola de impresión",10,24);
	}
}
