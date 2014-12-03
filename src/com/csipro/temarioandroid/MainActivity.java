package com.csipro.temarioandroid;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
	ExpandableListView expList;
	List<String> listTemas;
	List<String> tema1, tema2, tema3, tema4,tema5, tema6,tema7,tema8,tema9, tema10, tema11;
	List<List<String>> subtemas;
	Map<String, List<String>> coleccionTemas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initListTemas();
		initSubtemas();
		initTemas();
		expList = (ExpandableListView) findViewById(R.id.expandableListView1);

		ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
				this, listTemas, coleccionTemas);
		expList.setAdapter(expListAdapter);
		expList.setGroupIndicator(null);

	}

	public void initListTemas(){
		listTemas = new ArrayList<String>();
		listTemas.add("1.  Introducci�n e Instalaci�n del Entorno de Desarrollo  ");
		listTemas.add("2.  Anatom�a de un Proyecto de Android");
		listTemas.add("3.  Interfaz de Usuario y Controles ");
		listTemas.add("4.  Desarrollo de Aplicaciones Android  ");
		listTemas.add("5.  Estilos y Elementos Gr�ficos ");
		listTemas.add("6.  Men�s y Di�logos");
		listTemas.add("7.  Notificaciones y Toast");
		listTemas.add("8.  ListViews y Adapters");
		listTemas.add("9. Persistencia de Datos");
		listTemas.add("10. Soporte para M�ltiples Dispositivos  ");
		listTemas.add("11. Publicaci�n de Aplicaci�n");





	}
	public void initSubtemas(){
		tema1 = new ArrayList<String>();
		tema1.add("1.1.	Introducci�n");
		tema1.add("1.2.	Instalaci�n Eclipse IDE ");
		tema1.add("1.3.	Herramientas de Desarrollo Android (ADT) ");
		tema1.add("1.4. Instalaci�n SDK ");
		tema1.add("1.5.	Instalaci�n Genymotion");
		tema1.add("1.6.	Configuraci�n Genymotion");

		tema2 = new ArrayList<String>();
		tema2.add("2.1.	Android Manifest");
		tema2.add("2.2.	Values Resources");
		tema2.add("2.3.	Layout Resources");
		tema2.add("2.4.	Drawable Resources");

		tema3 = new ArrayList<String>();
		tema3.add("3.1.	Views  y Layouts");
		tema3.add("3.2.	Controles de Texto");
		tema3.add("3.3.	Controles de tipo Bot�n");
		tema3.add("3.4.	Componentes m�s comunes");

		tema4 = new ArrayList<String>();
		tema4.add("4.1.	Creaci�n y estructura b�sica de un proyecto ");
		tema4.add("4.2.	Creaci�n y manejo de Activities ");
		tema4.add("4.3.	Uso de Intents ");

		tema5 = new ArrayList<String>();
		tema5.add("5.1.	Creaci�n y uso de Estilos ");
		tema5.add("5.2.	Android Asset Studio");



		tema6 = new ArrayList<String>();
		tema6.add("6.1.	Opciones de Men�");
		tema6.add("6.2.	Men�s Contextuales");
		tema6.add("6.3.	Di�logos de Alerta");
		tema6.add("6.4.	Di�logos de Progreso");
		tema6.add("6.5.	Dialogos Personalizados");

		tema7 = new ArrayList<String>();
		tema7.add("7.1.	Desplegar notificaciones en barra de estatus");
		tema7.add("7.2.	Desplegar Notificaiones Toast");

		tema8 = new ArrayList<String>();
		tema8.add("8.1.	Elementos del tipo List");
		tema8.add("8.2.	List item Layout");
		tema8.add("8.3.	Creando un Custom Adapter");

		tema9 = new ArrayList<String>();
		tema9.add("9.1.	Uso de Shared Preferences");
		tema9.add("9.2.	Archivos");
		tema9.add("9.3.	Properties");
		tema9.add("9.4.	SQLite");

		tema10 = new ArrayList<String>();
		tema10.add("10.1.	Trabajando con diferentes pantallas");
		tema10.add("10.2.	Multilenguaje");

		tema11 = new ArrayList<String>();
		tema11.add("11.1.	Preparaci�n para publicaci�n");
		tema11.add("11.2.	Firma y Construci�n");
		tema11.add("11.3.	Publicaci�n de los recursos gr�ficos");
		tema11.add("11.4.	Publicaci�n en GooglePlay");


		subtemas = new ArrayList<List<String>>();
		subtemas.add(tema1);
		subtemas.add(tema2);
		subtemas.add(tema3);
		subtemas.add(tema4);
		subtemas.add(tema5);
		subtemas.add(tema6);
		subtemas.add(tema7);
		subtemas.add(tema8);
		subtemas.add(tema9);
		subtemas.add(tema10);
		subtemas.add(tema11);



	}

	public void initTemas(){
		coleccionTemas = new LinkedHashMap<String, List<String>>();
		int i = 0;
		for (String s : listTemas) {

			coleccionTemas.put(s, subtemas.get(i));
			i+=1;
		}

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
