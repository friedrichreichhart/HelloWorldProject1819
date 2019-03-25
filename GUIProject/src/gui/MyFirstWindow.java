package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

public class MyFirstWindow {

	protected Shell shlFrWindow;
	private Text vorname;
	private Text nachname;
	private Label lblPlz;
	private Label lblOrt;
	private Label lblStrasse;
	private Label lblHausnummer;
	private Text plz;
	private Text ort;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyFirstWindow window = new MyFirstWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFrWindow.open();
		shlFrWindow.layout();
		while (!shlFrWindow.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFrWindow = new Shell();
		shlFrWindow.setSize(450, 300);
		shlFrWindow.setText("FR Window");
		
		Button button1 = new Button(shlFrWindow, SWT.NONE);
		button1.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent me) {
				System.out.println("Maus über Knoppe bewegt");
				//
				System.out.println("Maus auf: " + me.x + " / " + me.y);
			}
		});
		button1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Knoppe gedrückt");
				//
				System.out.println(vorname.getText());
				System.out.println(nachname.getText());
			}
		});
		button1.setBounds(10, 10, 100, 35);
		button1.setText("Mein 1. Knopf");
		
		vorname = new Text(shlFrWindow, SWT.BORDER);
		vorname.setBounds(92, 51, 76, 21);
		
		Label lblVorname = new Label(shlFrWindow, SWT.NONE);
		lblVorname.setBounds(31, 54, 55, 15);
		lblVorname.setText("Vorname");
		
		Label lblNachname = new Label(shlFrWindow, SWT.NONE);
		lblNachname.setBounds(20, 87, 66, 15);
		lblNachname.setText("Nachname");
		
		nachname = new Text(shlFrWindow, SWT.BORDER);
		nachname.setBounds(92, 81, 76, 21);
		
		lblPlz = new Label(shlFrWindow, SWT.NONE);
		lblPlz.setBounds(31, 120, 55, 15);
		lblPlz.setText("PLZ");
		
		lblOrt = new Label(shlFrWindow, SWT.NONE);
		lblOrt.setBounds(31, 159, 55, 15);
		lblOrt.setText("Ort");
		
		lblStrasse = new Label(shlFrWindow, SWT.NONE);
		lblStrasse.setBounds(31, 203, 55, 15);
		lblStrasse.setText("Strasse");
		
		lblHausnummer = new Label(shlFrWindow, SWT.NONE);
		lblHausnummer.setBounds(31, 224, 55, 15);
		lblHausnummer.setText("Hausnummer");
		
		plz = new Text(shlFrWindow, SWT.BORDER);
		plz.setBounds(92, 117, 76, 21);
		
		ort = new Text(shlFrWindow, SWT.BORDER);
		ort.setBounds(92, 156, 76, 21);

	}
}
