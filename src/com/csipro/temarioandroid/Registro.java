package com.csipro.temarioandroid;


import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;



import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Registro extends Activity {
	EditText nombre, apellido, correo;	
	Spinner spinner;
	Spinner spinnerLaptop;
	Dialog dialog;
	Button salir, temario;
	Button cancelar, registrarme;
	ProgressDialog pd;
	ArrayAdapter<CharSequence> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		spinner = (Spinner) findViewById(R.id.semestres);
		spinnerLaptop = (Spinner) findViewById(R.id.laptop);
		// Create an ArrayAdapter using the string array and a default spinner layout
		adapter = ArrayAdapter.createFromResource(this,
				R.array.opciones_spinner, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);

		adapter = ArrayAdapter.createFromResource(this,
				R.array.opciones_laptop, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerLaptop.setAdapter(adapter);

		cancelar = (Button) findViewById(R.id.bt_cancelar);
		cancelar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();

			}
		});

		nombre = (EditText)findViewById(R.id.et_nombre);
		apellido = (EditText)findViewById(R.id.et_apellido);
		correo = (EditText)findViewById(R.id.et_correo);

		registrarme = (Button) findViewById(R.id.bt_registro);
		registrarme.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				RequestQueue queue = Volley.newRequestQueue(Registro.this);
				final String snombre = nombre.getText().toString();
				final String sapellido = apellido.getText().toString();
				final String scorreo = correo.getText().toString();
				final String ssemestre = spinner.getSelectedItem().toString();
				final String slaptop =  spinnerLaptop.getSelectedItem().toString();


				if (validar()) {
					pd = ProgressDialog.show(Registro.this,"Registrando...","Por favor espere...");
						
					StringRequest myReq = new StringRequest(Method.POST,
							"http://lacachora.com/CSIPRO/registro.php",
							createMyReqSuccessListener(),
							createMyReqErrorListener()) {

						protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
							Map<String, String> params = new HashMap<String, String>();
							params.put("nombre", snombre);
							params.put("apellido", sapellido);
							params.put("correo", scorreo);
							params.put("semestre", ssemestre);
							params.put("laptop", slaptop);
							return params;
						};
					};
					queue.add(myReq);
				}


			}
		});

	}

	public boolean validar(){
		if( nombre.getText().toString().length() == 0 ){
			nombre.setError( "¡Este campo es obligatorio!" );
		
			return false;
		}

		if( apellido.getText().toString().length() == 0 ){
			apellido.setError( "¡Este campo es obligatorio!" );
		
			return false;
		}


		if( correo.getText().toString().length() == 0 ){
			correo.setError( "¡Este campo es obligatorio!" );
	
			return false;
		}




		return true;
	}
	private void resetFields(){
		nombre.setText("");
		apellido.setText("");
		correo.setText("");
	}
	private Response.Listener<String> createMyReqSuccessListener() {
		return new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				 pd.dismiss();
				resetFields();
				showCustomDialog();
				//  Toast.makeText(Registro.this, "Regitrado con éxito", Toast.LENGTH_LONG).show(); 

			}
		};
	}


	private Response.ErrorListener createMyReqErrorListener() {
		return new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				 pd.dismiss();
				Toast.makeText(Registro.this, error.getMessage(), Toast.LENGTH_LONG).show();

			}
		};
	}


	public void showCustomDialog() {

		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);


		dialog.setContentView(R.layout.dialog_login);
		salir = (Button) dialog.findViewById(R.id.bt_salir);
		temario = (Button) dialog.findViewById(R.id.bt_vertemario);

		dialog.setCancelable(false);
		dialog.setCanceledOnTouchOutside(false);

		dialog.show();
		salir.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				dialog.dismiss();
				finish();
			}
		});

		temario.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				dialog.dismiss();
				finish();
				Intent i = new Intent(Registro.this, MainActivity.class);
				startActivity(i);

			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registro, menu);
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
