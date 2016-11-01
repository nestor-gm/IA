package game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MatrixPanel extends JPanel { 
	

	
	private Matrix game_board;
	private int scale_game;
	private int rows;
	private double dificultad_;
	private boolean malla;

	
	public MatrixPanel(int mainpanel_size, int scale,int dificultad){
		
		String posCoche = JOptionPane.showInputDialog(null, "Introduzca posición inicial del coche. (Ej: 4,5)");
		String[] posC = posCoche.split(",");
		int xC = Integer.parseInt(posC[0]);
		int yC = Integer.parseInt(posC[1]);
		
		String posMeta = JOptionPane.showInputDialog(null, "Introduzca posición de la meta. (Ej: 4,5)");
		String[] posM = posMeta.split(",");
		int xM = Integer.parseInt(posM[0]);
		int yM = Integer.parseInt(posM[1]);
		
		dificultad_ = dificultad;
		rows = scale ;
		//game_board = new Matrix(mainpanel_size,scale,dificultad_);
		game_board = new Matrix(mainpanel_size,scale,dificultad_, xC, yC, xM, yM);
		scale_game = (int) mainpanel_size *	 scale;
		setMalla();
		add_characteristics(); 
		//System.out.println(game_board.get_columns());
		//System.out.println(game_board.get_rows());
		//System.out.println(rows);
	}
	
	public void add_characteristics() { 
		
		this.setSize(new Dimension(600,600)); 
	}

	@Override 
	public void paint(Graphics g) { 
		
		
		final int IMAGESIZE = Math.min(this.getWidth(), this.getHeight()) / game_board.getN();
		final int IMAGESIZE2 = Math.min(this.getWidth(), this.getHeight()) / game_board.getM();
		/**
		final int IMAGESIZE = Math.min(this.getWidth(), this.getHeight()) / game_board.get_columns();
		for (int i = 0; i < game_board.get_rows(); i++)  {
			for (int j = 0; j < game_board.get_columns(); j++) {
		//g.drawImage(new ImageIcon("res/images/fondo.jpg").getImage(),0,0,1200,500,this);
				if ((i + j) % 2 == 0) {
					g.drawImage(new ImageIcon("res/images/blanca.png").getImage(), i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE,this);
				  } else {
					  g.drawImage(new ImageIcon("res/images/negra.png").getImage(), i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE,this);
				  }
			}
			
				
		}
		**/
		g.drawImage(new ImageIcon("res/images/fondo.jpg").getImage(),0,0,700,700,this);
		g.drawImage(new ImageIcon("res/images/fondo.jpg").getImage(),600,800,600,200,this);
		
		if(this.malla == true)
		{
			printMalla(g, IMAGESIZE, IMAGESIZE2);
		}
		else
		{
			printNoMalla(g, IMAGESIZE, IMAGESIZE2);
		}
		
		this.setOpaque(false);
		super.paintComponent(g);
	}

	public Matrix getGame_board(){ 
		return game_board;
	}

	public void setGame_board(Matrix game_board){ 
		this.game_board = game_board;
	}

	public int getScale_game() {
		return scale_game;
	}

	public void setScale_game(int scale_game) {
		this.scale_game = scale_game;
	}
	public void setMalla()
	{
		int malla = JOptionPane.showConfirmDialog(null, "¿Desea activar una malla para identificar mejor las casillas?");
		if(malla == 0)
		{
			this.malla = true;
		}
		else
		{
			this.malla = false;

		}
	}
	public void printNoMalla(Graphics g, int IMAGESIZE, int IMAGESIZE2)
	{
		for (int i = 0; i < game_board.getM(); i++)  {
			for (int j = 0; j < game_board.getN(); j++) 
			{
				if ( game_board.getValue(i, j) == 0)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/carretera.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 1)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/cocheabajo.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 2)
				{
					g.drawImage(new ImageIcon("res/images/Obstaculos/arbol.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 3)
				{
					g.drawImage(new ImageIcon("res/images/Obstaculos/cono.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);	
				}
				if ( game_board.getValue(i, j) == 4)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/chico.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 5)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/chica.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 6)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/meta.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
			}
		}
	}
	public void printMalla(Graphics g, int IMAGESIZE, int IMAGESIZE2)
	{
		for (int i = 0; i < game_board.getM(); i++)  {
			for (int j = 0; j < game_board.getN(); j++) 
			{
				if ( game_board.getValue(i, j) == 0)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/mcarretera.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 1)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mcocheabajo.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 2)
				{
					g.drawImage(new ImageIcon("res/images/Obstaculos/marbol.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 3)
				{
					g.drawImage(new ImageIcon("res/images/Obstaculos/mcono.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);	
				}
				if ( game_board.getValue(i, j) == 4)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mchico.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 5)
				{
					g.drawImage(new ImageIcon("res/images/Personajes/mchica.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
				if ( game_board.getValue(i, j) == 6)
				{
					g.drawImage(new ImageIcon("res/images/Carretera/mmeta.png").getImage(),j * IMAGESIZE, i * IMAGESIZE2, IMAGESIZE, IMAGESIZE2,this);
				}
			}
		}
	}
}