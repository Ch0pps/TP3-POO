public class Main {

	public static void main(String[] args) {
		Almacen a = new Almacen();
		Televisor e = new Televisor();
		Lavarropa l = new Lavarropa();
		e.setSintonizador(true);
		a.agregarElectrodomestico(l, 2);
		a.agregarElectrodomestico(e, 5);
		int c = a.entregarElectrodomestico(Televisor.CODIGO + "00001", 1);
		System.out.println("Cantidad entregada: " + c);
		System.out.println("Stock disponible: " + a.reportarStock(Televisor.CODIGO + "00001"));
		System.out.println("Valor de stock total: " + a.valorizarStock());
		System.out.println("Valor de sotck clase F: " + a.valorizarStockClase("F"));
		System.out.println("Valor de stock clase A: " + a.valorizarStockClase("A"));
		System.out.println("Valor de stock Televisor: " + a.valorizarStockTipo(Televisor.CODIGO));
		System.out.println("Valor de stock Lavarropa: " + a.valorizarStockTipo(Lavarropa.CODIGO));
	}
}
