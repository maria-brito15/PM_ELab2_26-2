/** 
 * MIT License
 *
 * Copyright(c) 2026 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * @author João Caram - caram@pucminas.br
 * Utilização do Copilot para geração de documentação da classes.  
 */

/**
 * Representa um analista da empresa.
 * <p>
 * O analista possui salário base fixo e pode acumular horas extras,
 * que são pagas proporcionalmente no momento do registro de pagamento.
 * </p>
 */
public class Analista extends Funcionario {

	private static final double SALARIO_ANALISTA = 4836;
	private static final double FRACAO_HORA = 1.0 / 90;
	private static final int MAX_HORAS_EXTRAS = 40;
	private double horasExtras;

	/**
	 * Cria um novo analista.
	 *
	 * @param nome nome do analista
	 * @param CPF  CPF do analista
	 */
	public Analista(String nome, String CPF) {
		super(nome, CPF);

	}

	/**
	 * Calcula o valor correspondente às horas extras acumuladas.
	 *
	 * @return valor das horas extras
	 */
	private double valorHorasExtras() {
		double constantePagamento = FRACAO_HORA * SALARIO_ANALISTA;
		double valor = 0;
		int contHoras = 0;

		for (int i = 0; i < this.horasExtras; i++) {
			if (contHoras <= MAX_HORAS_EXTRAS) {
				valor += constantePagamento;
				contHoras++;
			} else {
				break;
			}
		}

		return valor;
	}

	/**
	 * Acrescenta horas extras ao acumulado do analista.
	 *
	 * @param quantidade quantidade de horas extras a adicionar
	 * @return total de horas extras acumuladas após a atualização
	 */
	public double addHorasExtras(double quantidade) {
		if (quantidade > 0 && horasExtras < MAX_HORAS_EXTRAS)
			horasExtras += quantidade;

		return horasExtras;
	}

	/**
	 * Registra o pagamento do analista, somando salário base e horas extras
	 * e obedecendo as regras da empresa.
	 * 
	 * @return valor total pago ao analista
	 */
	public double registrarPagamento() {
		double pagamento = SALARIO_ANALISTA + valorHorasExtras();
		this.ultimoSalario = pagamento;
		this.horasExtras = 0;

		return pagamento;
	}

	/**
	 * Retorna uma descrição textual do analista.
	 *
	 * @return descrição textual do analista
	 */
	@Override
	public String toString() {
		return "ANALISTA " + super.toString();
	}

}