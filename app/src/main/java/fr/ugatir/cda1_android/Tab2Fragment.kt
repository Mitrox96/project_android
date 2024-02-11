package fr.ugatir.cdal_android; // Remplacez avec le nom de votre package

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerVi	ew;
    private RoomAdapter adapter;
    private List<Room> roomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        roomList = new ArrayList<>();
        adapter = new RoomAdapter(this, roomList);
        recyclerView.setAdapter(adapter);

        // Initialisation de Retrofit avec l'URL de base fournie
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ugatirite.com/00Webshtopapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        // CrÃ©ation d'une implÃ©mentation de l'interface API
        ApiService apiService = retrofit.create(ApiService.class);

        // Appel rÃ©seau pour charger les donnÃ©es des salles
        loadRooms(apiService);
    }

    private void loadRooms(ApiService apiService) {
        apiService.getRooms().enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    roomList.clear();
                    roomList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "RÃ©ponse non rÃ©ussie", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erreur de rÃ©seau", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
