package Labels;

import java.util.ArrayList;

import javax.swing.JLabel;

public class Labels {
	private ArrayList<JLabel> labels;
	
	public Labels() {
		setLabels(new ArrayList<JLabel>());
	}

	public ArrayList<JLabel> getLabels() {
		return labels;
	}

	public void setLabels(ArrayList<JLabel> labels) {
		this.labels = labels;
	}
	
	public void agregarVals(JLabel labels) {
		this.labels.add(labels);
	}
}
