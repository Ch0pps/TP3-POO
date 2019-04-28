import java.util.HashMap;
import java.util.Map;

public class Almacen {

	private Map<Electrodomestico, Integer> almacen = new HashMap<>();

	public void agregarElectrodomestico(Electrodomestico electrodomestico, int cantidad) {
		if (almacen.containsKey(electrodomestico)) {
			int cantidadAux = almacen.get(electrodomestico);
			almacen.replace(electrodomestico, cantidadAux + cantidad);
		} else {
			almacen.put(electrodomestico, cantidad);
		}
	}

	public int entregarElectrodomestico(String codigo, int cantidad) {
		int cantidadAux;
		int cantidadEntregada = 0;
		Electrodomestico e;
		for (Map.Entry<Electrodomestico, Integer> entry : almacen.entrySet()) {
			e = entry.getKey();
			if (e.getCodigo().equals(codigo)) {
				cantidadAux = almacen.get(e);
				if (cantidad > cantidadAux && cantidadAux != 0) {
					cantidad = cantidadAux;
					almacen.replace(e, 0);
					cantidadEntregada = cantidad;
				} else if (cantidadAux == 0) {
					cantidadEntregada = 0;
				} else if (cantidadAux >= cantidad) {
					almacen.replace(e, cantidadAux - cantidad);
					cantidadEntregada = cantidad;
				}
			}
		}
		return cantidadEntregada;
	}

	public int reportarStock(String codigo) {
		int stock = 0;
		Electrodomestico e;
		for (Map.Entry<Electrodomestico, Integer> entry : almacen.entrySet()) {
			e = entry.getKey();
			if (e.getCodigo().equals(codigo)) {
				stock = entry.getValue();
			}
		}
		return stock;
	}

	public double valorizarStock() {
		double valorTotal = 0.0;
		Electrodomestico e;
		for (Map.Entry<Electrodomestico, Integer> entry : almacen.entrySet()) {
			e = entry.getKey();
			valorTotal += entry.getValue() * e.getVenta();
		}
		return valorTotal;
	}

	public double valorizarStockClase(String clase) {
		Electrodomestico e;
		clase = clase.toUpperCase();
		char c = clase.charAt(0);
		double valorTotal = 0.0;
		for (Map.Entry<Electrodomestico, Integer> entry : almacen.entrySet()) {
			e = entry.getKey();
			if (e.getClase() == c) {
				valorTotal += entry.getValue() * e.getVenta();
			}
		}
		return valorTotal;
	}

	public double valorizarStockTipo(String tipo) {
		double valorTotal = 0.0;
		Electrodomestico e;
		for (Map.Entry<Electrodomestico, Integer> entry : almacen.entrySet()) {
			e = entry.getKey();
			if (e.getCodigo().startsWith(tipo)) {
				valorTotal += entry.getValue() * e.getVenta();
			}
		}
		return valorTotal;
	}

}
