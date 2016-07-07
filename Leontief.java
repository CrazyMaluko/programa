package matrix;

import org.apache.commons.math3.linear.*;

import java.util.Scanner;

public class Leontief {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		double industriaCarvaoProduto = in.nextDouble();
		double industriaCarvaoEnergia = in.nextDouble();
		double industriaCarvaoTransporte = in.nextDouble();
		double energiaQuantidade = in.nextDouble();
		double energiaCusto = in.nextDouble();
		double energiaCarvao = in.nextDouble();
		double transporte = in.nextDouble();
		double transporteCarvao = in.nextDouble();
		double transporteEnergia = in.nextDouble();
		RealMatrix coefficients = new Array2DRowRealMatrix(
				new double[][] { { industriaCarvaoProduto, -energiaCarvao, -transporteCarvao },
						{ -industriaCarvaoEnergia, energiaQuantidade - energiaCusto, -transporteEnergia },
						{ -industriaCarvaoTransporte, -energiaCusto, transporte } },
				false);
		DecompositionSolver solver = new SingularValueDecomposition(coefficients).getSolver();
		double demandaMineradora = in.nextDouble();
		double demandaGeradora = in.nextDouble();
		double demandaFerrovia = in.nextDouble();
		RealVector constants = new ArrayRealVector(new double[] { demandaMineradora, demandaGeradora, demandaFerrovia },
				false);
		RealVector solution = solver.solve(constants);
		System.out.println(solution);
	}

}