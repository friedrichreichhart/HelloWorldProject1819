package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.FileWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.Person;

import org.eclipse.swt.widgets.Label;

public class MyFirstWindow {

	protected Shell shlFrWindow;
	private Text vornameTF;
	private Text nachnameTF;
	private Label lblPlz;
	private Label lblOrt;
	private Label lblStrasse;
	private Label lblHausnummer;
	private Text plzTF;
	private Text ortTF;
	private Label vornameOut;
	private Label nachnameOut;

	/**
	 * Launch the application.
	 * 
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
//				System.out.println("Maus über Knoppe bewegt");
//				//
//				System.out.println("Maus auf: " + me.x + " / " + me.y);
			}
		});
		button1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Knoppe gedrückt");
				//
				System.out.println(vornameTF.getText());
				System.out.println(nachnameTF.getText());
				//
				getVornameOut().setText(getVornameTF().getText());
				getNachnameOut().setText(getNachnameTF().getText());
			}
		});
		button1.setBounds(10, 10, 100, 35);
		button1.setText("Mein 1. Knopf");

		vornameTF = new Text(shlFrWindow, SWT.BORDER);
		vornameTF.setBounds(92, 51, 76, 21);

		Label lblVorname = new Label(shlFrWindow, SWT.NONE);
		lblVorname.setBounds(31, 54, 55, 15);
		lblVorname.setText("Vorname");

		Label lblNachname = new Label(shlFrWindow, SWT.NONE);
		lblNachname.setBounds(20, 87, 66, 15);
		lblNachname.setText("Nachname");

		nachnameTF = new Text(shlFrWindow, SWT.BORDER);
		nachnameTF.setBounds(92, 81, 76, 21);

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

		plzTF = new Text(shlFrWindow, SWT.BORDER);
		plzTF.setBounds(92, 117, 76, 21);

		ortTF = new Text(shlFrWindow, SWT.BORDER);
		ortTF.setBounds(92, 156, 76, 21);

		vornameOut = new Label(shlFrWindow, SWT.NONE);
		vornameOut.setBounds(204, 57, 55, 15);

		nachnameOut = new Label(shlFrWindow, SWT.NONE);
		nachnameOut.setBounds(204, 87, 55, 15);

		Button btnSaveClean = new Button(shlFrWindow, SWT.NONE);
		btnSaveClean.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Person p; // Variablen-Definiton
				p = new Person(); // Variablen-Instanz
				//
				p.setVorname(getVornameTF().getText());
				p.setNachname(getNachnameTF().getText());
				//
				System.out.println("----------");
				System.out.println("Objekt:");
				System.out.println(p);
				//
				Person.getPersonenListe().add(p);
				//
				System.out.println("----------");
				System.out.println("Liste:");
				System.out.println(Person.getPersonenListe());
				//
				// finally clean fields
				getVornameTF().setText("");
				getNachnameTF().setText("");
				//
			}
		});
		btnSaveClean.setBounds(129, 10, 83, 35);
		btnSaveClean.setText("Save & Clean");

		Button btnNewButton = new Button(shlFrWindow, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				gson.serializeNulls();
				//
				String jsonString = gson.toJson(Person.getPersonenListe());
				System.out.println(jsonString);
				//
				// im explorer %TEMP%
				//
				try {
					FileWriter fw = new FileWriter(File.createTempFile("wpfjson", ".json"));
					//
					gson.toJson(Person.getPersonenListe(),fw);
					//
					fw.flush();
					fw.close();
				} catch (Exception ex) {
				}

			}
		});
		btnNewButton.setBounds(235, 10, 76, 35);
		btnNewButton.setText("2JSON");

	}

	public Label getVornameOut() {
		return vornameOut;
	}

	public Label getNachnameOut() {
		return nachnameOut;
	}

	public Text getVornameTF() {
		return vornameTF;
	}

	public Text getNachnameTF() {
		return nachnameTF;
	}

	public Text getPlzTF() {
		return plzTF;
	}

	public Text getOrtTF() {
		return ortTF;
	}
}
