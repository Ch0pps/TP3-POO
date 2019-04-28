
public abstract class Electrodomestico {

	// Valores por defecto
	public final static String COLOR = "Blanco";
	public final static char CLASE = 'F';
	public final static double PRECIO = 1700.00;
	public final static float PESO = 5.0f;

	// Attributes
	private String codigo;
	private double precio;
	private String color;
	private char clase;
	private float peso;

	// Constructor
	public Electrodomestico() {
		color = COLOR;
		clase = CLASE;
		precio = PRECIO;
		peso = PESO;
	}

	public Electrodomestico(double precio, float peso) {
		this("", precio, COLOR, CLASE, peso);
	}

	public Electrodomestico(String codigo, double precio, String color, char clase, float peso) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.color = color;
		this.clase = clase;
		this.peso = peso;
	}

	// Getters and Setters
	public String getCodigo() {
		return codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public String getColor() {
		return color;
	}

	public char getClase() {
		return clase;
	}

	public float getPeso() {
		return peso;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPrecioBase(double precio) {
		if (precio > 0) {
			this.precio = precio;
		}
	}

	public void setColor(String color) {
		color = color.toLowerCase();
		switch (color) {
		case "blanco":
		case "negro":
		case "rojo":
		case "azul":
		case "gris":
			this.color = color;
			break;
		default:
			this.color = COLOR;
			break;
		}
	}

	public void setClase(char letra) {
		String let = "" + letra;
		let.toUpperCase();
		letra = let.charAt(0);
		switch (letra) {
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
			this.clase = letra;
			break;
		default:
			this.clase = CLASE;
			break;
		}
	}

	public void setPeso(float peso) {
		if (peso > 0) {
			this.peso = peso;
		}
	}

	/**
	 * Metodo que evalua el precio de venta teniendo en cuenta la clase del
	 * electrodomestico y su peso
	 * 
	 * @return precio de venta
	 */
	public double getVenta() {
		double precioVenta = getPrecio();
		switch (getClase()) {
		case 'A':
			precioVenta *= 4.0;
			precioVenta += (precioVenta * getPorcentaje(getPeso())) / 100;
			return precioVenta;
		case 'B':
			precioVenta *= 3.5;
			precioVenta += (precioVenta * getPorcentaje(getPeso())) / 100;
			return precioVenta;
		case 'C':
			precioVenta *= 3.0;
			precioVenta += (precioVenta * getPorcentaje(getPeso())) / 100;
			return precioVenta;
		case 'D':
			precioVenta *= 2.5;
			precioVenta += (precioVenta * getPorcentaje(getPeso())) / 100;
			return precioVenta;
		case 'E':
			precioVenta *= 2.0;
			precioVenta += (precioVenta * getPorcentaje(getPeso())) / 100;
			return precioVenta;
		case 'F':
			precioVenta *= 1.0;
			precioVenta += (precioVenta * getPorcentaje(getPeso())) / 100;
			return precioVenta;
		default:
			return 0.0;
		}

	}

	/**
	 * Metodo privado que evalua que porcentaje debe ser tenido en cuenta segun el
	 * peso del electrodomestico
	 * 
	 * @para peso
	 * @return porcentaje
	 */
	private double getPorcentaje(float peso) {
		double porcentaje = 0;
		if (peso >= 0 && peso <= 19) {
			porcentaje = 10.0;
		}
		if (peso >= 20 && peso <= 49) {
			porcentaje = 50.0;
		}
		if (peso >= 50 && peso <= 79) {
			porcentaje = 80.0;
		}
		if (peso >= 80) {
			porcentaje = 100.0;
		}
		return porcentaje;
	}

}
