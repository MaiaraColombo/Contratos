package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.Nivel;

public class Trabalhador {

	private String name;
	private Nivel nivelTrabalhador;
	private Double salarioBase;

	private Departamento departamento;
	private List<ContratoHoras> contratos = new ArrayList<>();

	public Trabalhador() {
	}

	public Trabalhador(String name, Nivel nivelTrabalhador, Double salarioBase, Departamento departamento) {
		this.name = name;
		this.nivelTrabalhador = nivelTrabalhador;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Nivel getNivelTrabalhador() {
		return nivelTrabalhador;
	}

	public void setNivelTrabalhador(Nivel nivelTrabalhador) {
		this.nivelTrabalhador = nivelTrabalhador;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHoras> getContratos() {
		return contratos;
	}
		
	public void adcContrato(ContratoHoras contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(ContratoHoras contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		
		for( ContratoHoras c: contratos) {
			cal.setTime(c.getDate()); // Pegou data do contrato e definiu
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			
			if (ano == c_ano && mes == c_mes) {
					soma += c.valorTotal();
			}
		}
		return soma;
	}
}
