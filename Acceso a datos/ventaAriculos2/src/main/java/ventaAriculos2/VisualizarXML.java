package ventaAriculos2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



public class VisualizarXML extends JFrame {

    private static final String MIARCHIVO_XML = "C:\\Users\\Usuario\\eclipse-workspaceAD\\VentasArticulos2\\ventasarticulosdos.xml";
	private static final long serialVersionUID = 1L;
	private JTable tableArticulos;
    private JTable tableVentas;
    private DefaultTableModel articulosModel;
    private DefaultTableModel ventasModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarXML frame = new VisualizarXML();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public JframeVentasArticulos2()   {
		setTitle("Ventas de Artículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(null);

        // Crear el botón para cargar el archivo XML
        JButton btnCargarXML = new JButton("Cargar XML");
        btnCargarXML.setBounds(10, 10, 120, 25);
        getContentPane().add(btnCargarXML);

        // Modelo de tabla para los artículos
        articulosModel = new DefaultTableModel(new Object[]{"Código", "Nombre", "PVP"}, 0);
        tableArticulos = new JTable(articulosModel);
        JScrollPane scrollArticulos = new JScrollPane(tableArticulos);
        scrollArticulos.setBounds(10, 50, 760, 200);
        getContentPane().add(scrollArticulos);

        // Modelo de tabla para las ventas
        ventasModel = new DefaultTableModel(new Object[]{"Nº Venta", "Fecha Venta", "Nombre Cliente", "Unidades", "Importe"}, 0);
        tableVentas = new JTable(ventasModel);
        JScrollPane scrollVentas = new JScrollPane(tableVentas);
        scrollVentas.setBounds(10, 270, 760, 200);
        getContentPane().add(scrollVentas);

        // Agregar el listener para el botón de cargar XML
        btnCargarXML.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarXML();
            }
        });
    }

    // Método para cargar el archivo XML y mostrar los datos en las tablas
    private void cargarXML() {
        try {
            // Crear el contexto JAXB
            JAXBContext context = JAXBContext.newInstance(VentasArticulos.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal del archivo XML
            VentasArticulos ventasArticulos = (VentasArticulos) unmarshaller.unmarshal(new File(MIARCHIVO_XML));

            // Limpiar las tablas antes de cargar nuevos datos
            articulosModel.setRowCount(0);
            ventasModel.setRowCount(0);

            // Procesar y mostrar los artículos en la tabla
            ArrayList<Articulo> articulos = ventasArticulos.getArticulo();
            for (Articulo articulo : articulos) {
                Artic detalle = articulo.getArtic();
                articulosModel.addRow(new Object[]{detalle.getCodigo(), detalle.getDenominacion(), detalle.getPrecio()});

                // Mostrar ventas para el artículo actual
                ArrayList<Venta> ventas = articulo.getVentas().getVenta();
                for (Venta venta : ventas) {
                    int unidades = venta.getUnidades();
                    double importe = unidades * detalle.getPrecio();
                    ventasModel.addRow(new Object[]{venta.getNumventa(), venta.getFecha(), venta.getNombre(), unidades, importe});
                }
            }

        } catch (JAXBException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo XML", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }   

}