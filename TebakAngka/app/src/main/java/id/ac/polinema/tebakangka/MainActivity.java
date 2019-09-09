package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private EditText numberInput;
	private Button guessButton;
	private int randomNum;

	//  TODO: deklarasikan variabel di sini

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		numberInput = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		initRandomNumber();
		// TODO: bind layout di sini
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "App on Start", Toast.LENGTH_SHORT).show();
	}

	// TODO: tambahkan callback onStop() di sini

	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this, "App on Stop", Toast.LENGTH_SHORT).show();
	}

	// TODO: lengkapi callback untuk onRestart() onResume() onPause() onDestroy()

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "App on Restart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "App on Resume", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		Toast.makeText(this, "App on Pause", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "App on Destroy", Toast.LENGTH_SHORT).show();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random rand = new Random();
		int min = 1;
		int max = 100;
		randomNum = rand.nextInt(max - min) + min;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		int masukanAngka=Integer.parseInt(numberInput.getText().toString());
		final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

		if(masukanAngka==randomNum){
			alertDialogBuilder.setMessage("Tebakan anda benar!");
			guessButton.setEnabled(false);
		}else if(masukanAngka>randomNum){
			alertDialogBuilder.setMessage("Tebakan anda terlalu besar!");
		}else if(masukanAngka<randomNum){
			alertDialogBuilder.setMessage("Tebakan anda terlalu kecil");
		}

		alertDialogBuilder.setNegativeButton("Tutup", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which){
			}
		});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		numberInput.setText("");
		guessButton.setEnabled(true);
		initRandomNumber();
	}
}
