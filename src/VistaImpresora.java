import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * Esta clase es la interfaz gráfica GUI de un ejemplo sencillo 
 * para simular una impresora. Se usa la clase JFrame proporcionada por Java.
 * @author (Milton Jesús Vera Contreras - mjvera@bari.ufps.edu.co) 
 * @version Math.sin(Math.PI-Double.MIN_VALUE) :) Agosto 2007
 */
public class VistaImpresora extends JFrame {

    /**Una referencia al objeto del modelo*/
    private ControlImpresora control;

    //A continuación los elementos de la GUI

    private JButton cmdImprimir;
    private JButton cmdRecargarPapel;
    private JButton cmdRecargarTinta;
    private JLabel lblAviso;
    private JLabel lblImagen;
    private JLabel lblPaginas;
    private JLabel lblPapel;
    private JLabel lblTinta;
    private JPanel panelBotones;
    private JPanel panelDatos;
    private JPanel panelImagen;
    private JTextField txtPaginas;
    private JTextField txtPapel;
    private JTextField txtTinta;	

    /** La vista recibe un objeto del modelo */
    public VistaImpresora() {
        initComponents();
    }
    
    /**
     * Asocia a la vista el controlador, que maneja los eventos del usuario.
     */
    public void setControl(ControlImpresora control){
     this.control = control;
     cmdRecargarTinta.addActionListener(this.control);
     cmdRecargarPapel.addActionListener(this.control);
     cmdImprimir.addActionListener(this.control);
    }

    /** 
     * Inicializa la GUI, se encarga de crear los botones
     * y las etiquetas de texto y definir la apariencia de la ventana
     */
    private void initComponents() {

        panelBotones = new JPanel();
        cmdRecargarTinta = new JButton();
        cmdRecargarPapel = new JButton();
        cmdImprimir = new JButton();
        panelImagen = new JPanel();
        lblImagen = new JLabel();
        panelDatos = new JPanel();
        lblTinta = new JLabel();
        txtTinta = new JTextField();
        lblPapel = new JLabel();
        txtPapel = new JTextField();
        lblPaginas = new JLabel();
        txtPaginas = new JTextField();
        lblAviso = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout(2, 0));

        panelBotones.setLayout(new GridLayout(1, 3, 2, 2));

        cmdRecargarTinta.setText("Recargar Tinta");
        panelBotones.add(cmdRecargarTinta);

        cmdRecargarPapel.setText("Recargar Papel");
        panelBotones.add(cmdRecargarPapel);

        cmdImprimir.setText("Imprimir");
        panelBotones.add(cmdImprimir);

        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        panelImagen.setLayout(new BorderLayout());

        lblImagen.setIcon(new ImageIcon(getClass().getResource("/impresora.jpg")));
        panelImagen.add(lblImagen, BorderLayout.CENTER);

        getContentPane().add(panelImagen, BorderLayout.EAST);

        panelDatos.setLayout(new GridLayout(3, 2, 2, 0));

        lblTinta.setFont(new Font("Verdana", 0, 12));
        lblTinta.setHorizontalAlignment(SwingConstants.CENTER);
        lblTinta.setText("Tinta(mililitros)");
        lblTinta.setBorder(BorderFactory.createTitledBorder(""));
        panelDatos.add(lblTinta);

        txtTinta.setFont(new Font("Verdana", 1, 24));
        txtTinta.setHorizontalAlignment(JTextField.CENTER);
        txtTinta.setText("0");
        txtTinta.setDisabledTextColor(new Color(0, 168, 85));
        txtTinta.setEnabled(false);
        panelDatos.add(txtTinta);

        lblPapel.setFont(new Font("Verdana", 0, 12));
        lblPapel.setHorizontalAlignment(SwingConstants.CENTER);
        lblPapel.setText("Papel (hojas)");
        lblPapel.setBorder(BorderFactory.createTitledBorder(""));
        panelDatos.add(lblPapel);

        txtPapel.setFont(new Font("Verdana", 1, 24));
        txtPapel.setHorizontalAlignment(JTextField.CENTER);
        txtPapel.setText("0");
        txtPapel.setDisabledTextColor(new Color(0, 168, 85));
        txtPapel.setEnabled(false);
        panelDatos.add(txtPapel);

        lblPaginas.setFont(new Font("Verdana", 0, 12));
        lblPaginas.setHorizontalAlignment(SwingConstants.CENTER);
        lblPaginas.setText("P\u00e1ginas en Cola");
        lblPaginas.setBorder(BorderFactory.createTitledBorder(""));
        panelDatos.add(lblPaginas);

        txtPaginas.setFont(new Font("Verdana", 1, 24));
        txtPaginas.setHorizontalAlignment(JTextField.CENTER);
        txtPaginas.setText("0");
        txtPaginas.setDisabledTextColor(new Color(0, 168, 85));
        txtPaginas.setEnabled(false);
        panelDatos.add(txtPaginas);

        getContentPane().add(panelDatos, BorderLayout.CENTER);

        lblAviso.setFont(new Font("Verdana", 1, 24));
        lblAviso.setText("Control de Impresora");
        getContentPane().add(lblAviso, BorderLayout.NORTH);

        cmdRecargarTinta.setActionCommand("cmdRecargarTinta");
       
        cmdRecargarPapel.setActionCommand("cmdRecargarPapel");
           
        cmdImprimir.setActionCommand("cmdImprimir");
     
        setTitle("Impresora");
        pack();
        setVisible(true);
    }//fin initComponents

    /**Un método que actualiza la vista desde el modelo*/
    public void actualizarGUI(int tinta, int hojas, int paginasPendientesPorImprimir,
                              boolean estaAtascadaPorPapel, boolean estaAtascadaPorTinta)
    {
        txtTinta.setText(String.valueOf(tinta));
        txtPapel.setText(String.valueOf(hojas));
        txtPaginas.setText(String.valueOf(paginasPendientesPorImprimir));
        if(estaAtascadaPorPapel) txtPapel.setDisabledTextColor(Color.red);
        else txtPapel.setDisabledTextColor(new Color(0,165,85));
        if(estaAtascadaPorTinta) txtTinta.setDisabledTextColor(Color.red);
        else txtTinta.setDisabledTextColor(new Color(0,165,85));
        if(paginasPendientesPorImprimir>0) txtPaginas.setDisabledTextColor(Color.red);
        else txtPaginas.setDisabledTextColor(new Color(0,165,85));
    }    

}//fin clase
