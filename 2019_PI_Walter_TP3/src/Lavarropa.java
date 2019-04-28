
public class Lavarropa extends Electrodomestico {

	public final static String CODIGO = "LAV-";

	// Attributes
	private float carga;
	private static int contador = 1;

	// Constructor
	public Lavarropa() {
		super();
		this.carga = 5f;
		setCodigo(CODIGO);
		contador++;
	}

	public Lavarropa(double precio, float peso) {
		super(precio, peso);
		setCodigo(CODIGO);
		contador++;
	}

	public Lavarropa(String codigo, double precio, String color, char clase, float peso, float carga) {
		super(codigo, precio, color, clase, peso);
		this.setCarga(carga);
		setCodigo(CODIGO);
		contador++;
	}

	// Getters and Setters

	@Override
	public void setCodigo(String codigo) {
		super.setCodigo(codigo + String.format("%05d", contador));
	}

	public float getCarga() {
		return carga;
	}

	public void setCarga(float kilos) {
		if (kilos > 0.0f) {
			carga = kilos;
		} else {
			carga = 5f;
		}
	}

	public double getVenta() {
		double precio = super.getVenta();
		if (carga > 30.0 && carga < 40.0) {
			precio += (precio * 10) / 100;
		}
		if (carga > 40.0 && carga < 50.0) {
			precio += (precio * 20) / 100;
		}
		if (carga > 50.0 && carga < 60.0) {
			precio += (precio * 30) / 100;
		}
		return precio;
	}

}
