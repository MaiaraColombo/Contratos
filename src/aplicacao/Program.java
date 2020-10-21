package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.ContratoHoras;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.Nivel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();

		System.out.println("Dados do funcionário: ");

		System.out.print("Nome: ");
		String nomeFuncionario = sc.nextLine();

		System.out.print("Nível: ");
		String nivelFuncionario = sc.nextLine();

		System.out.println("Salário base: ");
		double salario = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nomeFuncionario, Nivel.valueOf(nivelFuncionario), salario, new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos tem esse funcionário? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.print("Entre com a data do " + (i + 1)+ "° cadastro");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());

			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();

			System.out.print("Duração do contrato (horas): ");
			int horas = sc.nextInt();

			ContratoHoras contrato = new ContratoHoras(dataContrato, valorHora, horas);
			trabalhador.adcContrato(contrato);
		}

		System.out.println();
		System.out.print("Entre com o mês e o ano para calcular o salario: (MM/YY)");
		String mesAno = sc.next();

		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));

		System.out.println("Name: " + trabalhador.getName());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Trabalhou por: " + mesAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));
	}
}
