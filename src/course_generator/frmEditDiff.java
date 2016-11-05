package course_generator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import course_generator.settings.CgSettings;
import course_generator.utils.CgConst;
import course_generator.utils.CgSpinner;
import course_generator.utils.Utils;

public class frmEditDiff  extends javax.swing.JDialog {

	private ResourceBundle bundle;
	private boolean ok;
	private int start;
	private int end;
	private CgSettings settings;
	private JPanel jPanelButtons;
	private JButton btCancel;
	private JButton btOk;
	private TrackData track;
	private CgData data;
	private JPanel panelStart;
	private JPanel panelEnd;
	private JPanel panelDiff;
	private JRadioButton rbFromStart;
	private JRadioButton rbFromLine;
	private ButtonGroup groupStart;
	private JRadioButton rbToEnd;
	private JRadioButton rbToLine;
	private ButtonGroup groupEnd;
	private JRadioButton rbVeryEasy;
	private JRadioButton rbEasy;
	private JRadioButton rbAverage;
	private JRadioButton rbVeryHard;
	private JRadioButton rbHard;
	private JRadioButton rbOther;
	private ButtonGroup groupDiff;
	private CgSpinner spinFromLine;
	private CgSpinner spinToLine;
	private CgSpinner spinDiff;

	public class EditDiffResult {
		public int Start; //Start line 
		public int End; //End line 
		public double Difficulty; //Difficulty
		public boolean Valid; //Indicate if the ok was pressed 
	}
	
	/**
	 * Creates new form frmSettings
	 */
	public frmEditDiff() {
		bundle = java.util.ResourceBundle.getBundle("course_generator/Bundle");
		initComponents();
		setModal(true);
	}

	public EditDiffResult showDialog(CgSettings settings, TrackData track, int start_line, int end_line) {
		this.settings = settings;
		this.track = track;
		this.start = start_line;
		this.end = end_line;
		// Set field

		spinFromLine.setValue(start+1);
		spinToLine.setValue(end);
		
		// End set field
		ok = false;

		//-- Update the display
		//Refresh();
		
		//-- Show the dialog
		setVisible(true);

		EditDiffResult res = new EditDiffResult();
		res.Valid=ok;
		
		if (ok) {
			// Copy fields
			if (rbFromStart.isSelected())
				res.Start=0;
			else 
				res.Start=spinFromLine.getValueAsInt()-1;
			
			if (rbToEnd.isSelected())
				res.End=track.data.size()-1;
			else
				res.End=spinToLine.getValueAsInt()-1;
			
			if (rbVeryEasy.isSelected())
				res.Difficulty=CgConst.DIFF_VERYEASY;
			else if (rbEasy.isSelected())
				res.Difficulty=CgConst.DIFF_EASY;
			else if (rbAverage.isSelected())
				res.Difficulty=CgConst.DIFF_AVERAGE;
			else if (rbHard.isSelected())
				res.Difficulty=CgConst.DIFF_HARD;
			else if (rbVeryHard.isSelected())
				res.Difficulty=CgConst.DIFF_VERYHARD;
			else 
				res.Difficulty=spinDiff.getValueAsInt();
		}
		return res;
	}

	/**
	 * Manage low level key strokes ESCAPE : Close the window
	 *
	 * @return
	 */
	protected JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke strokeEscape = KeyStroke.getKeyStroke("ESCAPE");
		KeyStroke strokeEnter = KeyStroke.getKeyStroke("ENTER");

		Action actionListener = new AbstractAction() {
			public void actionPerformed(ActionEvent actionEvent) {
				setVisible(false);
			}
		};

		Action actionListenerEnter = new AbstractAction() {
			public void actionPerformed(ActionEvent actionEvent) {
				RequestToClose();
			}
		};

		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(strokeEscape, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", actionListener);

		inputMap.put(strokeEnter, "ENTER");
		rootPane.getActionMap().put("ENTER", actionListenerEnter);

		return rootPane;
	}

	private void RequestToClose() {
		boolean param_valid = true;
		// check that the parameters are ok

		// -- Ok?
		if (param_valid) {
			ok = true;
			setVisible(false);
		}
	}

	
	private void initComponents() {
		int line = 0;

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(bundle.getString("frmEditDiff.title"));
		setAlwaysOnTop(true);
		setResizable(false);
		setMinimumSize(new Dimension(300,400));
		setType(java.awt.Window.Type.UTILITY);

		// -- Layout
		// ------------------------------------------------------------
		Container paneGlobal = getContentPane();
		paneGlobal.setLayout(new GridBagLayout());

		//== Panel start
		panelStart = new JPanel();
		panelStart.setLayout(new GridBagLayout());
		panelStart.setBorder(BorderFactory.createTitledBorder(bundle.getString("frmEditDiff.panelStart.Title"))); //Start
		panelStart.setLayout(new GridBagLayout());
		Utils.addComponent(paneGlobal, panelStart, 
				0, 0, 
				1, 1, 
				0, 0, 
				10, 10, 0, 10, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.BOTH);

		rbFromStart = new JRadioButton(bundle.getString("frmEditDiff.rbFromStart.Text")); //From the start
		rbFromStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelStart, rbFromStart, 
				0, 0, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);

		rbFromLine = new JRadioButton(bundle.getString("frmEditDiff.rbFromLine.Text")); //From line
		rbFromLine.setSelected(true);
		rbFromLine.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelStart, rbFromLine, 
				0, 1, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);
		
		 groupStart = new ButtonGroup();
		 groupStart.add(rbFromStart);
		 groupStart.add(rbFromLine);
		 
		 spinFromLine = new CgSpinner(100,0,100,1);
		 Utils.addComponent(panelStart, spinFromLine, 
				1, 1, 
				1, 1, 
				1, 0, 
				5, 5, 5, 5, 
				GridBagConstraints.EAST, GridBagConstraints.NONE);

		
		//== Panel end
		panelEnd = new JPanel();
		panelEnd.setLayout(new GridBagLayout());
		panelEnd.setBorder(BorderFactory.createTitledBorder(bundle.getString("frmEditDiff.panelEnd.Title")));//End
		panelEnd.setLayout(new GridBagLayout());
		Utils.addComponent(paneGlobal, panelEnd, 
				0, 1, 
				1, 1, 
				0, 0, 
				10, 10, 0, 10, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.BOTH);

		rbToEnd = new JRadioButton(bundle.getString("frmEditDiff.rbToEnd.Text")); //To the end
		rbToEnd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelEnd, rbToEnd, 
				0, 0, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);

		rbToLine = new JRadioButton(bundle.getString("frmEditDiff.rbToLine.Text"));//To line
		rbToLine.setSelected(true);
		rbToLine.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelEnd, rbToLine, 
				0, 1, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);
		
		groupEnd = new ButtonGroup();
		groupEnd.add(rbToEnd);
		groupEnd.add(rbToLine);

		spinToLine = new CgSpinner(100,0,100,1);
		Utils.addComponent(panelEnd, spinToLine, 
				1, 1, 
				1, 1, 
				1, 0, 
				5, 5, 5, 5, 
				GridBagConstraints.EAST, GridBagConstraints.NONE);
		 
		//== Panel difficulty
		panelDiff = new JPanel();
		panelDiff.setLayout(new GridBagLayout());
		panelDiff.setBorder(BorderFactory.createTitledBorder(bundle.getString("frmEditDiff.panelDiff.Title")));//Difficulty
		panelDiff.setLayout(new GridBagLayout());
		Utils.addComponent(paneGlobal, panelDiff, 
				0, 2, 
				1, 1, 
				1, 1, 
				10, 10, 0, 10, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.BOTH);

		rbVeryEasy = new JRadioButton(bundle.getString("frmEditDiff.rbVeryEasy.Text")); //Very easy
		rbVeryEasy.setOpaque(true);
		rbVeryEasy.setBackground(CgConst.CL_DIFF_VERYEASY);
		rbVeryEasy.setSelected(true);
		rbVeryEasy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelDiff, rbVeryEasy, 
				0, 0, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);

		rbEasy = new JRadioButton(bundle.getString("frmEditDiff.rbEasy.Text")); //Easy
		rbEasy.setOpaque(true);
		rbEasy.setBackground(CgConst.CL_DIFF_EASY);
		rbEasy.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelDiff, rbEasy, 
				0, 1, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);

		rbAverage = new JRadioButton(bundle.getString("frmEditDiff.rbAverage.Text"));//Average
		rbAverage.setOpaque(true);
		rbAverage.setBackground(CgConst.CL_DIFF_AVERAGE);
		rbAverage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelDiff, rbAverage, 
				0, 2, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);

		rbHard = new JRadioButton(bundle.getString("frmEditDiff.rbHard.Text")); //Hard
		rbHard.setOpaque(true);
		rbHard.setBackground(CgConst.CL_DIFF_HARD);
		rbHard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelDiff, rbHard, 
				0, 3, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);

		rbVeryHard = new JRadioButton(bundle.getString("frmEditDiff.rbVeryHard.Text")); //Very hard
		rbVeryHard.setOpaque(true);
		rbVeryHard.setBackground(CgConst.CL_DIFF_VERYHARD);
		rbVeryHard.setForeground(Color.WHITE);
		rbVeryHard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelDiff, rbVeryHard, 
				0, 4, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);

		rbOther = new JRadioButton(bundle.getString("frmEditDiff.rbOther.Text")); //Other
		rbOther.setOpaque(true);
		rbOther.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Refresh();
			}
		});
		Utils.addComponent(panelDiff, rbOther, 
				0, 5, 
				1, 1, 
				0, 0, 
				5, 5, 0, 0, 
				GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL);

		groupDiff = new ButtonGroup();
		groupDiff.add(rbVeryEasy);
		groupDiff.add(rbEasy);
		groupDiff.add(rbAverage);
		groupDiff.add(rbHard);
		groupDiff.add(rbVeryHard);
		groupDiff.add(rbOther);

		spinDiff = new CgSpinner(100,0,100,1);
		Utils.addComponent(panelDiff, spinDiff, 
				1, 5, 
				1, 1, 
				1, 0, 
				5, 5, 5, 5, 
				GridBagConstraints.EAST, GridBagConstraints.NONE);

		// == BUTTONS
		// ===========================================================
		jPanelButtons = new javax.swing.JPanel();
		jPanelButtons.setLayout(new FlowLayout());
		Utils.addComponent(paneGlobal, jPanelButtons, 
				0, 3, 
				1, 1, 
				0, 0, 
				0, 0, 0, 0,
				GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL);

		btCancel = new javax.swing.JButton();
		btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/cancel.png")));
		btCancel.setText(bundle.getString("frmEditDiff.btCancel.text"));
		btCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setVisible(false);
			}
		});

		btOk = new javax.swing.JButton();
		btOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/course_generator/images/valid.png")));
		btOk.setText(bundle.getString("frmEditDiff.btOk.text"));
		btOk.setMinimumSize(btCancel.getMinimumSize());
		btOk.setPreferredSize(btCancel.getPreferredSize());
		btOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				RequestToClose();
			}
		});

		// -- Add buttons
		jPanelButtons.add(btOk);
		jPanelButtons.add(btCancel);

		// --
		pack();

		setLocationRelativeTo(null);
	}

	protected void Refresh() {
		spinFromLine.setEnabled(rbFromLine.isSelected());
		spinToLine.setEnabled(rbToLine.isSelected());
		spinDiff.setEnabled(rbOther.isSelected());
	}
	
}