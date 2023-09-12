package utp.sanchezsanchez.sistemajtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TicketActivity extends AppCompatActivity {
    ImageView mapa;
    TextView imagen_razon, ticket, cliente, mufa, razon, descripcion_razon,
            celular_cliente, direccion, cita_programada, tiempo_resolver;
    Button llamar, whatsapp;

    String _celular_cliente;
    public void logout(View view){
        Intent i = new Intent(TicketActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
    public void goSettings(View view){
        Intent i = new Intent(TicketActivity.this, ConfigActivity.class);
        startActivity(i);
    }

    public void call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + _celular_cliente));
        startActivity(intent);
    }

    public void goWhatsapp(View view){
        String url = "https://api.whatsapp.com/send?phone=+51" + _celular_cliente;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Intent i = getIntent();

        TextView ticket = findViewById(R.id.ticket);
        ImageView mapa = findViewById(R.id.mapa);
        TextView cliente = findViewById(R.id.cliente);
        TextView direccion = findViewById(R.id.direccion);
        TextView mufa = findViewById(R.id.mufa);
        TextView razon = findViewById(R.id.razon);
        TextView descripcion_razon = findViewById(R.id.descripcion_razon);
        TextView cita_programada = findViewById(R.id.cita_programada);
        TextView tiempo_resolver = findViewById(R.id.tiempo_resolver);

        Button llamar = findViewById(R.id.llamar);
        Button whatsapp = findViewById(R.id.whatsapp);

        String _imagen_razon = i.getStringExtra("imagen_razon");
        String _ID_ticket = i.getStringExtra("ID_ticket");
        String _ID_cliente = i.getStringExtra("ID_cliente");
        String _cliente = i.getStringExtra("cliente");
        String _mufa = i.getStringExtra("mufa");
        String _razon = i.getStringExtra("razon");
        String _descripcion_razon = i.getStringExtra("descripcion_razon");
        _celular_cliente = i.getStringExtra("celular_cliente");
        String _direccion = i.getStringExtra("direccion");
        String _cita_programada = i.getStringExtra("cita_programada");
        String _tiempo_resolver = i.getStringExtra("tiempo_resolver");


        switch(_imagen_razon){
            case "game_servers_svgrepo_com":    mapa.setImageResource(R.drawable.game_servers_svgrepo_com); break;
            case "cloud_dns":                   mapa.setImageResource(R.drawable.cloud_dns); break;
            case "gke_on_prem_svgrepo_com":     mapa.setImageResource(R.drawable.gke_on_prem_svgrepo_com); break;
            case "cloud_nat_svgrepo_com":       mapa.setImageResource(R.drawable.cloud_nat_svgrepo_com); break;
            case "cloud_vpn_svgrepo_com":       mapa.setImageResource(R.drawable.cloud_vpn_svgrepo_com); break;
            case "runtime_config_svgrepo_com":  mapa.setImageResource(R.drawable.runtime_config_svgrepo_com); break;
        }
        ticket.setText("Ticket " + _ID_ticket);
        cliente.setText("Cliente: " + _cliente + " (" + _ID_cliente + ")");
        direccion.setText("Dirección del cliente: " + _direccion);
        mufa.setText("Mufa: " + _mufa);
        razon.setText("Razón de visita: " + _razon);
        descripcion_razon.setText("Descripción del problema: " + _descripcion_razon);
        cita_programada.setText("Cita programada: " + _cita_programada);
        tiempo_resolver.setText("Tiempo aproximado para resolver el desperfecto es de " + _tiempo_resolver);


    }
}