package br.unitau.cortesemfila;

import java.util.Calendar;
import java.util.GregorianCalendar;
import br.unitau.cortesemfila.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MarcarHorario extends Activity implements OnClickListener {
	
	private DatePicker dataPicker;
	private TimePicker timePicker;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marcarhorario);
        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        timePicker.setIs24HourView(true);
	}
	
	@Override
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		
	}

	public void marcar(View view){
		//Captura e separa a data nas strings abaixo
		dataPicker = (DatePicker) findViewById(R.id.datePicker1);
		String dia = String.valueOf(dataPicker.getDayOfMonth());
		String mes = String.valueOf(dataPicker.getMonth()+1);//Somado 1 pois janeiro é considerado 0
		String ano = String.valueOf(dataPicker.getYear());

		Calendar cal = new GregorianCalendar(Integer.parseInt(ano), Integer.parseInt(mes)-1, Integer.parseInt(dia));
		int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
		
		//Captura e separa as horas nas strings abaixo
		timePicker = (TimePicker) findViewById(R.id.timePicker1);
		String hora = String.valueOf(timePicker.getCurrentHour());
		String minuto = String.valueOf(timePicker.getCurrentMinute());
		
		//Testa os dias e horarios de funcionamentos antes de seguir com o agendamento online
		if(diaSemana<=2){
			Toast.makeText(getApplicationContext(), "Dia inválido: Trabalhamos de Terça à Sábado.", Toast.LENGTH_SHORT).show();
		} else if(Integer.parseInt(hora) < 9 || Integer.parseInt(hora) >= 18){
			Toast.makeText(getApplicationContext(), "Horario inválido: Horário de funcionamento é das 9 às 18h.", Toast.LENGTH_SHORT).show();
		}else if(diaSemana==7 && Integer.parseInt(hora) >= 17){
			Toast.makeText(getApplicationContext(), "Horario inválido: Aos Sábados o trabalhamos até as 17h.", Toast.LENGTH_SHORT).show();
		} else{
			//Vai para tela final para colocar nome e telefone
			final Context context = this;
			Intent abreTelaFinal = new Intent(context, MarcarHorario2.class);
			abreTelaFinal.putExtra("url","http://cortesemfila.netai.net/foco/index.php?phpcid=1&action=event_corte&year="+ano+"&month="+mes+"&day="+dia+"&hour="+hora+"&minute="+minuto);
			finish();
	        startActivity(abreTelaFinal);
		}
		
		//testa a saida da url
		//Toast.makeText(getApplicationContext(), "http://cortesemfila.netai.net/foco/index.php?phpcid=1&action=event_corte&year="+ano+"&month="+mes+"&day="+dia+"&hour="+hora+"&minute="+minuto+" semana: "+diaSemana, Toast.LENGTH_SHORT).show();		
		//setContentView(R.layout.marcarhorario2);
	}
}
