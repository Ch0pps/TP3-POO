
public class Televisor extends Electrodomestico {

	public final static String CODIGO = "TEL-";

	// Attributes
	private int tamanio;
	private boolean sintonizador;
	private static int contador = 1;

	// Constructor
	public Televisor() {
		super();
		this.tamanio = 20;
		this.sintonizador = false;
		setCodigo(CODIGO);
		contador++;
	}

	public Televisor(double precio, float peso) {
		super(precio, peso);
		setCodigo(CODIGO);
		contador++;
	}

	public Televisor(String codigo, double precio, String color, char clase, float peso, int tamanio,
			boolean sintonizador) {
		super(codigo, precio, color, clase, peso);
		this.setTamanio(tamanio);
		setCodigo(CODIGO);
		contador++;
	}

	// Getters and Setters

	@Override
	public void setCodigo(String codigo) {
		super.setCodigo(codigo + String.format("%05d", contador));
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int pulgadas) {
		if (pulgadas > 0) {
			tamanio = pulgadas;
		} else {
			tamanio = 20;
		}
	}

	public boolean hasSintonizador() {
		return sintonizador;
	}

	public void setSintonizador(boolean posee) {
		sintonizador = posee;
	}

	public double getVenta() {
		double precio = super.getVenta();
		if (getTamanio() > 40) {
			precio += (precio * 30) / 100;
		}
		if (hasSintonizador()) {
			precio += 1000.0;
		}
		return precio;
	}
	

}
