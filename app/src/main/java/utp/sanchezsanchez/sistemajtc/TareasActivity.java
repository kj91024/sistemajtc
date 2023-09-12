package utp.sanchezsanchez.sistemajtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TareasActivity extends AppCompatActivity {
    LinearLayout listTickets;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        date = findViewById(R.id.date);
        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        date.setText(nowDate.format(formatDate));

        listTickets = findViewById(R.id.listTickets);
        List<Map<String, String>> tickets = getData();
        for ( int i = 0; i < tickets.size(); i++){
            addTicket(tickets.get(i));
        }

    }
    private int randomNumber(int min, int max){
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
    private List<Map<String, String>> getData(){
        List<Map<String, String>> tickets = new ArrayList<Map<String, String>>();

        int totalData = randomNumber(8, 20);
        String[] names = { "Maria", "Ana", "Juan", "Jose", "Felipe", "Aaron", "Ricardo", "Pedro", "Susana", "Kevin", "Cesar"};
        String[] last_names = { "González", "Rodríguez", "Pérez", "García", "Fernández", "López", "Torres", "Ramírez", "Flores", "Castillo" };
        String[] reason = {
            "Cambio de modem",
            "Arreglar Mufa",
            "Actualizacion de modem",
            "Cambio de cableado",
            "Instalación del servicio",
            "Desintalación del servicio"
        };
        String[] reasonDescription = {
            "Estoy muy molesto por el cambio de modem de mi proveedor de Internet, ya que fue abrupto, mal comunicado y ha afectado negativamente mi velocidad de conexión.",
            "Estoy frustrado por la demora y falta de respuesta de la empresa para arreglar la mufa de mi cuadra, lo cual ha causado inconvenientes porque nadie en la cuadra tiene internet.",
            "La actualización de mi modem fue un desastre. Mi proveedor no me notificó adecuadamente y la nueva versión solo ha traído problemas de conexión y velocidad.",
            "La señal intermitente de Internet es inaceptable. Ustedes deben de  resolver este problema, ya que afecta gravemente mi trabajo y actividades diarias en línea.",
            "Solicito la instalación de Internet en mi hogar lo antes posible, ya que lo necesito para trabajar y para el acceso a servicios esenciales en línea.",
            "Solicito la desinstalación de mi servicio de Internet a partir de la fecha especificada. Gracias."
        };
        String[] reasonImage = {
            "game_servers_svgrepo_com",
            "cloud_dns",
            "gke_on_prem_svgrepo_com",
            "cloud_nat_svgrepo_com",
            "cloud_vpn_svgrepo_com",
            "runtime_config_svgrepo_com"
        };
        String[] address = {
            "Mz M lote 18 URB San Gabriel SJL",
            "Mz M lote 18 URB Las Casuarinas SJL",
            "Av Wise 432 SJL",
            "Mz M lote 18 Interior 2H SJL",
            "Mz K lote 20 La Huayrona SJL"
        };
        for (int i = 0; i < totalData; i++) {
            int numReason = randomNumber(0, reason.length-1);
            Map<String, String> item = new HashMap<String, String>();

            item.put("ID_ticket", Integer.toString(randomNumber(100, 1000)));
            item.put("ID_cliente", Integer.toString(randomNumber(9234, 10000)));
            item.put("cliente", names[randomNumber(0, names.length-1)] + " " + last_names[randomNumber(0, last_names.length-1)]);
            item.put("mufa", Integer.toString(randomNumber(84568, 94568)));
            item.put("razon", reason[numReason]);

            item.put("descripcion_razon", reasonDescription[numReason]);
            item.put("imagen_razon", reasonImage[numReason]);
            item.put("celular_cliente", Integer.toString(randomNumber(911000111, 999333444)));

            item.put("direccion", address[randomNumber(0, address.length-1)]);
            item.put("cita_programada", Integer.toString(randomNumber(12, 8)) + "PM");
            item.put("tiempo_resolver", Integer.toString(randomNumber(1, 3)) + " hora/s");
            tickets.add(item);
        }

        return tickets;
    }

    public void logout(View view){
        Intent i = new Intent(TareasActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
    public void goSettings(View view){
        Intent i = new Intent(TareasActivity.this, ConfigActivity.class);
        startActivity(i);
    }
    private void addTicket(Map<String, String> ticket){
        final float scale = getResources().getDisplayMetrics().density;

        LinearLayout lh = new LinearLayout(this);
        lh.setOrientation(LinearLayout.HORIZONTAL);
        lh.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        int padding = (int)(10 * scale);
        lh.setPadding(padding, padding, padding, padding);

        ImageView imagenTicket = new ImageView(this);
        int dpWidthInPx  = (int) (74 * scale);
        int dpHeightInPx = (int) (90 * scale);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpWidthInPx, dpHeightInPx);
        imagenTicket.setLayoutParams(layoutParams);

        switch(ticket.get("imagen_razon")){
            case "game_servers_svgrepo_com":    imagenTicket.setImageResource(R.drawable.game_servers_svgrepo_com); break;
            case "cloud_dns":                   imagenTicket.setImageResource(R.drawable.cloud_dns); break;
            case "gke_on_prem_svgrepo_com":     imagenTicket.setImageResource(R.drawable.gke_on_prem_svgrepo_com); break;
            case "cloud_nat_svgrepo_com":       imagenTicket.setImageResource(R.drawable.cloud_nat_svgrepo_com); break;
            case "cloud_vpn_svgrepo_com":       imagenTicket.setImageResource(R.drawable.cloud_vpn_svgrepo_com); break;
            case "runtime_config_svgrepo_com":  imagenTicket.setImageResource(R.drawable.runtime_config_svgrepo_com); break;
        }

        LinearLayout lv = new LinearLayout(this);
        lv.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins((int) (10 * scale),0,0,0);
        lv.setLayoutParams(params);

        TextView info1 = new TextView(this);
        TextView info2 = new TextView(this);
        TextView info3 = new TextView(this);
        TextView info4 = new TextView(this);

        info1.setText("Ticket: T" + ticket.get("ID_ticket"));
        info1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        info1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        info2.setText("Cliente: " + ticket.get("cliente") + " (C" + ticket.get("ID_cliente") + ")");
        info2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        info2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        info3.setText("Mufa: M" + ticket.get("mufa"));
        info3.setTextSize(TypedValue. COMPLEX_UNIT_SP, 16);
        info3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        info4.setText("Razon de visita: " + ticket.get("razon"));
        info4.setTextSize(TypedValue. COMPLEX_UNIT_SP, 16);
        info4.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        lv.addView(info1);
        lv.addView(info2);
        lv.addView(info3);
        lv.addView(info4);

        lh.addView(imagenTicket);
        lh.addView(lv);

        lh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TareasActivity.this, TicketActivity.class);

                i.putExtra("ID_ticket", ticket.get("ID_ticket"));
                i.putExtra("ID_cliente", ticket.get("ID_cliente"));
                i.putExtra("cliente", ticket.get("cliente"));
                i.putExtra("mufa", ticket.get("mufa"));
                i.putExtra("razon", ticket.get("razon"));
                i.putExtra("descripcion_razon", ticket.get("descripcion_razon"));
                i.putExtra("imagen_razon", ticket.get("imagen_razon"));
                i.putExtra("celular_cliente", ticket.get("celular_cliente"));

                i.putExtra("direccion", ticket.get("direccion"));
                i.putExtra("cita_programada", ticket.get("cita_programada"));
                i.putExtra("tiempo_resolver", ticket.get("tiempo_resolver"));
                startActivity(i);

                Toast.makeText(TareasActivity.this, "Ticket " + ticket.get("ID_ticket"), Toast.LENGTH_SHORT).show();
            }
        });

        listTickets.addView(lh);
    }
}