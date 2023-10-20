/**
* Domain classes used to produce .....
* @author Jorge
* @version 1.0
*/
package codingstandards;

import java.util.Scanner;

public class CostCalculator {
	protected CostCalculator() { }
	/**
	 * Funcion principal.
	 * @param args
	 */
	public static void main(final String[] args) {

		final int baseCost = 1000;
		final int aditionalForParis = 500;
		final int aditionalForNY = 600;
		final int minNumOfTravelersDiscount = 4;
		final int maxNumOfTravelersDiscount = 10;
		final double minTravelersDiscount = 0.1;
		final double maxTravelersDiscount = 0.2;
		final int durationOfVacationDaysDiscount = 7;
		final int durationOfVacationDiscount = 200;
		final int durationOfVacationPromo = 30;
		final int promoDurationVacation = 200;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Bienvenido al estimador de costos ");
		System.out.println(" de paquetes de vacaciones.");
		System.out.print("Por favor, ingrese la información ");
		System.out.println("solicitada a continuación:");

		System.out.print("Destino de las vacaciones: ");
		String destination = scanner.nextLine();

		validateDestinate(destination);

		System.out.print("Número de viajeros: ");
		int numOfTravelers = scanner.nextInt();

		valitateNumOfTravelers(numOfTravelers);

		System.out.print("Duración de las vacaciones en días: ");
		int durationOfVacation = scanner.nextInt();

		validateDurationOfVacation(durationOfVacation);

		int totalCost = baseCost;

		if (destination.equalsIgnoreCase("Paris")) {
			totalCost += aditionalForParis;
		} else if (destination.equalsIgnoreCase("New York City")) {
			totalCost += aditionalForNY;
		}

		if (numOfTravelers > minNumOfTravelersDiscount
				&& numOfTravelers < maxNumOfTravelersDiscount) {
			totalCost -= totalCost * minTravelersDiscount;
		} else if (numOfTravelers > maxNumOfTravelersDiscount) {
			totalCost -= totalCost * maxTravelersDiscount;
		}

		if (durationOfVacation < durationOfVacationDaysDiscount) {
			totalCost += durationOfVacationDiscount;
		}

		if (durationOfVacation > durationOfVacationPromo
				|| numOfTravelers == 2) {
			totalCost -= promoDurationVacation;
		}

		if (totalCost < 0) {
			System.out.print("Lo sentimos, ha ocurrido un error ");
			System.out.println("en el cálculo del costo total.");
			System.out.println("El costo total es: -1");
		} else {
			System.out.print("El costo total de su paquete ");
			System.out.println("de vacaciones es: $" + totalCost);
		}

		scanner.close();
}

	/**
	 * validation.
	 * @param destinate
	 * */
	public static void validateDestinate(final String destinate) {
		int cadenaVacia = 0;
		if (destinate.length() <= cadenaVacia) {
			System.out.println("Debe ingresar un lugar de destino");
			System.out.println("El costo total es: -1");
			System.exit(-1);
		}
	}

	/**
	 * validation.
	 * @param numOfTravelers
	 * */
	public static void valitateNumOfTravelers(final int numOfTravelers) {
		final int maxOfnumOfTravelers = 80;
		final int minOfnumOfTravelers = 1;
		if (numOfTravelers < minOfnumOfTravelers) {
			System.out.print("Lo sentimos, el paquete de ");
			System.out.print("vacaciones debe tener ");
			System.out.println("al menos 1 viajero.");
		}
		if (numOfTravelers > maxOfnumOfTravelers) {
			System.out.print("Lo sentimos, el paquete de ");
			System.out.print("vacaciones no está disponible ");
			System.out.println("para grupos de más de 80 personas");
		}
		if (numOfTravelers < minOfnumOfTravelers
				|| numOfTravelers > maxOfnumOfTravelers) {
			System.out.print("Por favor, intente nuevamente ");
			System.out.println("con un número menor de personas.");
			System.out.println("El costo total es: -1");
			System.exit(-1);
		}
	}

	/**
	 * validation.
	 * @param durationOfVacation
	 * */
	public static void validateDurationOfVacation(
			final int durationOfVacation) {
		int minDurationOfVacation = 1;
		if (durationOfVacation < minDurationOfVacation) {
			System.out.print("La cantidad minima aceptada ");
			System.out.println("es de 1 dia");
			System.out.println("El costo total es: -1");
			System.out.println("Por favor, intente nuevamente.");
			System.exit(-1);
		}
	}
}
