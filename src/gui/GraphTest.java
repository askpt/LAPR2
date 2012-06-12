package gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

//TODO remover classe
@SuppressWarnings("serial")
public class GraphTest extends JPanel {
	private static final int MAX_SCORE = 20;
	private static final int PREF_W = 800;
	private static final int PREF_H = 650;
	private static final int BORDER_GAP = 30;
	private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
	private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
	private static final int GRAPH_POINT_WIDTH = 12;
	private static final int Y_HATCH_CNT = 10;
	private List<Integer> scores1;
	private List<Integer> scores2;
	private List<Integer> scores3;
	private List<Integer> scores4;
	private List<Integer> scores5;

	public GraphTest(List<Integer> scores1, List<Integer> scores2, List<Integer> scores3, List<Integer> scores4, List<Integer> scores5) {
		this.scores1 = scores1;
		this.scores2 = scores2;
		this.scores3 = scores3;
		this.scores4 = scores4;
		this.scores5 = scores5;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (scores1.size() - 1);
		double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (MAX_SCORE - 1);

		createLines(scores1, xScale, yScale, g2, Color.green);
		createLines(scores2, xScale, yScale, g2, Color.red);
		createLines(scores3, xScale, yScale, g2, Color.cyan);
		createLines(scores4, xScale, yScale, g2, Color.orange);
		createLines(scores5, xScale, yScale, g2, Color.yellow);

	}

	public void createLines(List<Integer> scores, double xScale, double yScale, Graphics2D g2, Color color) {
		List<Point> graphPoints = new ArrayList<Point>();
		for (int i = 0; i < scores.size(); i++) {
			int x1 = (int) (i * xScale + BORDER_GAP);
			int y1 = (int) (scores.get(i) * yScale + BORDER_GAP);
			graphPoints.add(new Point(x1, y1));
		}

		// create x and y axes
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
		g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

		// create hatch marks for y axis.
		for (int i = 0; i < Y_HATCH_CNT; i++) {
			int x0 = BORDER_GAP;
			int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
			int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
			int y1 = y0;
			g2.drawLine(x0, y0, x1, y1);
		}

		// and for x axis
		for (int i = 0; i < scores.size() - 1; i++) {
			int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (scores.size() - 1) + BORDER_GAP;
			int x1 = x0;
			int y0 = getHeight() - BORDER_GAP;
			int y1 = y0 - GRAPH_POINT_WIDTH;
			g2.drawLine(x0, y0, x1, y1);
		}

		Stroke oldStroke = g2.getStroke();
		g2.setColor(color);
		g2.setStroke(GRAPH_STROKE);
		for (int i = 0; i < graphPoints.size() - 1; i++) {
			int x1 = graphPoints.get(i).x;
			int y1 = graphPoints.get(i).y;
			int x2 = graphPoints.get(i + 1).x;
			int y2 = graphPoints.get(i + 1).y;
			g2.drawLine(x1, y1, x2, y2);
		}

		g2.setStroke(oldStroke);
		g2.setColor(GRAPH_POINT_COLOR);
		for (int i = 0; i < graphPoints.size(); i++) {
			int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
			int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;
			;
			int ovalW = GRAPH_POINT_WIDTH;
			int ovalH = GRAPH_POINT_WIDTH;
			g2.fillOval(x, y, ovalW, ovalH);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	private static void createAndShowGui() {
		List<Integer> scores1 = new ArrayList<Integer>();
		List<Integer> scores2 = new ArrayList<Integer>();
		List<Integer> scores3 = new ArrayList<Integer>();
		List<Integer> scores4 = new ArrayList<Integer>();
		List<Integer> scores5 = new ArrayList<Integer>();
		Random random = new Random();
		int maxDataPoints = 16;
		int maxScore = 20;
		for (int i = 0; i < maxDataPoints; i++) {
			scores1.add(random.nextInt(maxScore));
		}
		for (int i = 0; i < maxDataPoints; i++) {
			scores2.add(random.nextInt(maxScore));
		}
		for (int i = 0; i < maxDataPoints; i++) {
			scores3.add(random.nextInt(maxScore));
		}
		for (int i = 0; i < maxDataPoints; i++) {
			scores4.add(random.nextInt(maxScore));
		}
		for (int i = 0; i < maxDataPoints; i++) {
			scores5.add(random.nextInt(maxScore));
		}
		GraphTest mainPanel = new GraphTest(scores1, scores2, scores3, scores4, scores5);

		JFrame frame = new JFrame("DrawGraph");
		JPanel arroz = new JPanel(new BorderLayout());
		arroz.add(mainPanel, BorderLayout.WEST);
		JLabel lbl1 = new JLabel("Portugal");
		JLabel lbl2 = new JLabel("Espanha");
		JLabel lbl3 = new JLabel("Inglaterra");
		JLabel lbl4 = new JLabel("Arroz");
		JLabel lbl5 = new JLabel("Massa");
		JPanel massa = new JPanel(new GridLayout(5, 1));
		massa.add(lbl1);
		massa.add(lbl2);
		massa.add(lbl3);
		massa.add(lbl4);
		massa.add(lbl5);
		arroz.add(massa, BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().add(mainPanel);
		frame.getContentPane().add(arroz);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}