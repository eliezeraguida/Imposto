package Imposto;

import java.util.Locale;

public class impostoRenda {


    double salarioMensal;
    double salarioAnual;
    double ganhoServico;
    double ganhoCapital;
    double impostoSalario;
    double impostoServico;
    double impostoCapital;
    double deducaoGastos;
    double gastoMedico;
    double gastoEducacional;

    public double calculoSalarioMensal() {
        salarioMensal = salarioAnual / 12;
        return salarioMensal;
    }

    public  double calcularImpostoSalario() {
        if (calculoSalarioMensal() >= 4999) {
            impostoSalario = salarioAnual * 0.2;
        } 
        else if (calculoSalarioMensal() > 3000) {
            impostoSalario = salarioAnual * 0.1;
        } 
        else {
            impostoSalario = 0;
        }
        return impostoSalario;
    }

    public double calcularImpostoServico() {
        if (ganhoServico > 0) {
            impostoServico = ganhoServico * 0.15;
        } 
        else {
            impostoServico = 0;
        }
        return impostoServico;
    }

    public double calcularImpostoGanhoCapital() {
        if (ganhoCapital > 0) {
            impostoCapital = ganhoCapital * 0.2;
        } 
        else {
            impostoCapital = 0;
        }
        return impostoCapital;
    }

    public double impostoConsolidado() {
        return calcularImpostoSalario() + calcularImpostoServico() + calcularImpostoGanhoCapital();
    }
    public  double deducaoGastos() {
       deducaoGastos = gastoMedico + gastoEducacional;
        return deducaoGastos;

   }
    
    public double impostoDevido() {
        deducaoGastos = gastoMedico + gastoEducacional;
        double impostoTotal = impostoConsolidado();
        if (deducaoGastos <= impostoTotal * 0.3) {
            return impostoTotal - deducaoGastos;
        } else {
            return impostoTotal - (impostoTotal * 0.3);
        }
    }

    public double maximoDedutivel() {
	   double maximoDedutivel = impostoConsolidado() * 0.3; 
	   return maximoDedutivel ;
    		   
    }

    public void impressao() {
    	
    	
    	
        Locale.setDefault(Locale.US);

        System.out.println("Renda anual com Salário: R$ " + salarioAnual);
        System.out.println("Renda anual com prestação de serviço: R$ " + ganhoServico);
        System.out.println("Renda anual com ganho de capital: R$ " + ganhoCapital);
        System.out.println("Gastos médicos: R$ " + gastoMedico);
        System.out.println("Gastos educacionais: R$ " + gastoEducacional);
        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("\n* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: %.2f%n", calcularImpostoSalario());
        System.out.printf("Imposto sobre serviços: %.2f%n", calcularImpostoServico());
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", calcularImpostoGanhoCapital());
        System.out.println("\n* DEDUÇÕES: ");
        System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel());
        System.out.printf("Gastos dedutíveis: %.2f%n", deducaoGastos()); 
        System.out.println("\n* RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", impostoConsolidado());
        System.out.printf("Abatimento: %.2f%n", deducaoGastos);
        System.out.printf("Imposto devido: %.2f%n", impostoDevido());
    }

    public static void main(String[] args) {

        impostoRenda pessoa1 = new impostoRenda();
        pessoa1.salarioAnual = 189000;
        pessoa1.ganhoServico = 55184.93;
        pessoa1.ganhoCapital = 20000;
        pessoa1.gastoMedico = 600;
        pessoa1.gastoEducacional = 7500;

        pessoa1.impressao();
    }

}