package gui;

import java.awt.*;

import javax.swing.*;

import jogosolimpicos.*;
import listaligada.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.*;
import org.jfree.data.xy.*;

/**
 * A simple demonstration application showing how to create a line chart using
 * data from an {@link XYDataset}.
 * 
 */
@SuppressWarnings("serial")
public class Chart extends JFrame {

	/**
	 * Creates a new demo.
	 * 
	 * @param title
	 *            the frame title.
	 */
	public Chart(final String title, final ListaLigada<String> nomes, final ListaLigada<Integer> pais1, final ListaLigada<Integer> pais2, final ListaLigada<Integer> pais3, final ListaLigada<Integer> pais4, final ListaLigada<Integer> pais5) {

		super(title);

		final CategoryDataset dataset = createDataset(nomes, pais1, pais2, pais3, pais4, pais5);
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(640, 400));
		setContentPane(chartPanel);
		setVisible(true);
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @param pais5
	 *            the fifth country
	 * @param pais4
	 *            the fourth country
	 * @param pais3
	 *            the third country
	 * @param pais2
	 *            the second country
	 * @param pais1
	 *            the first country
	 * @param nomes
	 *            linked list with country names
	 * 
	 * @return The dataset.
	 */
	private CategoryDataset createDataset(ListaLigada<String> nomes, ListaLigada<Integer> pais1, ListaLigada<Integer> pais2, ListaLigada<Integer> pais3, ListaLigada<Integer> pais4, ListaLigada<Integer> pais5) {

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		@SuppressWarnings("unused")
		ListaLigada<JogosOlimpicos> temp = sortEditions();

		if (pais1 != null) {
			for (int i = 0; i < pais1.size(); i++) {
				dataset.addValue((double) pais1.get(i), nomes.get(0), sortEditions().get(i));
			}
		}

		if (pais2 != null) {
			for (int i = 0; i < pais2.size(); i++) {
				dataset.addValue((double) pais2.get(i), nomes.get(1), sortEditions().get(i));
			}
		}

		if (pais3 != null) {
			for (int i = 0; i < pais3.size(); i++) {
				dataset.addValue((double) pais3.get(i), nomes.get(2), sortEditions().get(i));
			}
		}

		if (pais4 != null) {
			for (int i = 0; i < pais4.size(); i++) {
				dataset.addValue((double) pais4.get(i), nomes.get(3), sortEditions().get(i));
			}
		}

		if (pais5 != null) {
			for (int i = 0; i < pais5.size(); i++) {
				dataset.addValue((double) pais5.get(i), nomes.get(4), sortEditions().get(i));
			}
		}

		return dataset;

	}

	private ListaLigada<JogosOlimpicos> sortEditions() {
		ListaLigada<JogosOlimpicos> jogosTemp = new ListaLigada<JogosOlimpicos>();

		for (int i = 0; i < Main.getJogos().size(); i++) {
			jogosTemp.add(Main.getJogos().get(i));
		}
		if (jogosTemp != null) {
			for (int i = 0; i < jogosTemp.size() - 1; i++) {
				for (int j = i + 1; j < jogosTemp.size(); j++) {
					if (jogosTemp.get(i).compareTo(jogosTemp.get(j)) > 0) {
						JogosOlimpicos temp = jogosTemp.get(j);
						jogosTemp.set(j, jogosTemp.get(i));
						jogosTemp.set(i, temp);
					}
				}
			}
		}
		return jogosTemp;
	}

	/**
	 * Creates a sample chart.
	 * 
	 * @param dataset
	 *            a dataset.
	 * 
	 * @return The chart.
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {

		final JFreeChart chart = ChartFactory.createLineChart("Comparative Analysis", // chart
																						// title
				"Game Edition", // domain axis label
				"Num Medals", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // urls
				);

		chart.setBackgroundPaint(Color.WHITE);
		final CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setRangeGridlinePaint(Color.white);

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);

		final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

		renderer.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[] { 10.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(1, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[] { 6.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[] { 2.0f, 6.0f }, 0.0f));

		return chart;
	}

}
