package com.MohFauziRamadhan_F52124052.aplikasiuts;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtCari;
    private TextView txtEmptyState;
    private ArrayList<HostingModel> hostingArrayList;
    private HostingAdapter hostingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.listViewHosting);
        edtCari = findViewById(R.id.edtCari);
        txtEmptyState = findViewById(R.id.txtEmptyState);
        hostingArrayList = new ArrayList<>();

        // 1. Niagahoster
        hostingArrayList.add(new HostingModel(
                "Niagahoster",
                "Hosting lokal yang ramah untuk pemula, dengan bantuan teknis berbahasa Indonesia setiap saat.",
                "niagahoster.co.id",
                R.drawable.logo_niagahoster));

        // 2. DomaiNesia
        hostingArrayList.add(new HostingModel(
                "DomaiNesia",
                "Pilihan layanan lengkap mulai dari hosting biasa, WordPress, cloud, sampai Cloud VPS.",
                "domainesia.com",
                R.drawable.logo_domainesia));

        // 3. Dewaweb
        hostingArrayList.add(new HostingModel(
                "Dewaweb",
                "Cloud hosting lokal yang menyatakan sudah memiliki sertifikat keamanan informasi ISO 27001.",
                "dewaweb.com",
                R.drawable.logo_dewaweb));

        // 4. Biznet Gio
        hostingArrayList.add(new HostingModel(
                "Biznet Gio",
                "Hosting dengan harga bersahabat dan fitur yang cukup seimbang.",
                "biznetgio.com",
                R.drawable.logo_biznetgio));

        // 5. IDCloudHost
        hostingArrayList.add(new HostingModel(
                "IDCloudHost",
                "Salah satu penyedia hosting lokal yang sering dibandingkan dalam ulasan tahun 2026.",
                "idcloudhost.com",
                R.drawable.logo_idcloudhost));

        // 6. Rumahweb
        hostingArrayList.add(new HostingModel(
                "Rumahweb",
                "Penyedia hosting lokal yang juga sering masuk daftar perbandingan.",
                "rumahweb.com",
                R.drawable.logo_rumahweb));

        // 7. Jagoan Hosting
        hostingArrayList.add(new HostingModel(
                "Jagoan Hosting",
                "Dikenal pengguna karena layanan bantuan langsung dan server yang stabil.",
                "jagoanhosting.com",
                R.drawable.logo_jagoanhosting));

        // Pasang Adapter
        hostingAdapter = new HostingAdapter(this, hostingArrayList);
        listView.setAdapter(hostingAdapter);

        // Fitur pencarian real-time
        edtCari.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Event klik item: tampilkan nama dan alamat situs (tidak membuka browser)
        listView.setOnItemClickListener((parent, view, position, id) -> {
            HostingModel selectedItem = (HostingModel) hostingAdapter.getItem(position);
            Toast.makeText(MainActivity.this,
                    selectedItem.getNamaHosting() + " - " + selectedItem.getWebsite(),
                    Toast.LENGTH_SHORT).show();
        });
    }

    private void filter(String text) {
        String kataKunci = text.toLowerCase();
        ArrayList<HostingModel> filteredList = new ArrayList<>();
        for (HostingModel item : hostingArrayList) {
            if (item.getNamaHosting().toLowerCase().contains(kataKunci) ||
                    item.getKeterangan().toLowerCase().contains(kataKunci) ||
                    item.getWebsite().toLowerCase().contains(kataKunci)) {
                filteredList.add(item);
            }
        }

        if (filteredList.isEmpty()) {
            txtEmptyState.setVisibility(View.VISIBLE);
        } else {
            txtEmptyState.setVisibility(View.GONE);
        }

        hostingAdapter.updateList(filteredList);
    }
}