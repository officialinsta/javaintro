package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import data.Person;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class gui {

	protected Shell shell;
	private Text vorname;
	private Text nachname;
	private Text adresse;
	private Text strasse;
	private Text plz;
	private Text ort;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			gui window = new gui();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();

			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackgroundImage(SWTResourceManager.getImage(
				"\\\\ams-gym-pfs\\schuelerprofiledata\\moritz-eliasschultze\\Documents\\Eigene Bilder\\skellington.jpeg"));
		shell.setSize(874, 658);
		shell.setText("SWT Application");

		Label lblVorname = new Label(shell, SWT.NONE);
		lblVorname.setBounds(271, 73, 55, 15);
		lblVorname.setText("Vorname");

		Label lblNachname = new Label(shell, SWT.NONE);
		lblNachname.setBounds(272, 114, 83, 15);
		lblNachname.setText("Nachname");

		Label lblAdresse = new Label(shell, SWT.NONE);
		lblAdresse.setBounds(271, 163, 55, 15);
		lblAdresse.setText("Adresse");

		vorname = new Text(shell, SWT.BORDER);
		vorname.setBounds(361, 70, 76, 21);

		nachname = new Text(shell, SWT.BORDER);
		nachname.setBounds(361, 111, 76, 21);

		adresse = new Text(shell, SWT.BORDER);
		adresse.setBounds(361, 160, 76, 21);

		Button btnButton = new Button(shell, SWT.NONE);
		btnButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//
				try {
					Person p = new Person();
					//
					p.setVorname(getVorname().getText());
					p.setNachname(getNachname().getText());
					p.setAdresse(getAdresse().getText());
					p.setStrasse(getStrasse().getText());
					p.setOrt(getORT().getText());
					p.setPlz(Integer.parseInt(getPLZ().getText()));
					// System.out.println(p);
					Person.getPersonenListe().add(p);
					//
					// for(int i = 0; i < Person.getPersonenListe().size(); i++) {
					// System.out.println(Person.getPersonenListe().get(i));
					//
					// }
					clearMask();
					//
				
				} catch (NumberFormatException nfe) {
					System.out.println("Fehler bei plz");
					//
					MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					mb.setText("Fehler");
					mb.setMessage("plz im falschen format");
					mb.open();
					
					//
				}

			}
		});

		//
		//
		//
		btnButton.setBounds(445, 109, 75, 25);
		btnButton.setText("Button");

		strasse = new Text(shell, SWT.BORDER);
		strasse.setBounds(361, 212, 76, 21);

		plz = new Text(shell, SWT.BORDER);
		plz.setBounds(361, 266, 76, 21);

		ort = new Text(shell, SWT.BORDER);
		ort.setBounds(361, 321, 76, 21);

		Label lblStrasse = new Label(shell, SWT.NONE);
		lblStrasse.setBounds(271, 212, 55, 15);
		lblStrasse.setText("Strasse");

		Label lblPlz = new Label(shell, SWT.NONE);
		lblPlz.setBounds(271, 266, 55, 15);
		lblPlz.setText("PLZ");

		Label lblOrt = new Label(shell, SWT.NONE);
		lblOrt.setBounds(271, 321, 55, 15);
		lblOrt.setText("ORT");
		
		Button btnWrite2JSON = new Button(shell, SWT.NONE);
		btnWrite2JSON.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Person.write2JASON();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnWrite2JSON.setBounds(673, 504, 126, 25);
		btnWrite2JSON.setText("Write2JSON");
	}

	protected void clearMask() {
		vorname.setText("");
		nachname.setText("");
		adresse.setText("");
		strasse.setText("");
		plz.setText("");
		ort.setText("");
	}

	public Text getVorname() {
		return vorname;
	}

	public Text getNachname() {
		return nachname;
	}

	public Text getAdresse() {
		return adresse;
	}

	public Text getStrasse() {
		return strasse;
	}

	public Text getPLZ() {
		return plz;
	}

	public Text getORT() {
		return ort;
	}
}
