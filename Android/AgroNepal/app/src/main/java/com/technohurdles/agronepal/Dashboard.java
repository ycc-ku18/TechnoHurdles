package com.technohurdles.agronepal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.technohurdles.agronepal.model.Product;
import com.technohurdles.agronepal.model.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shakyas on 1/5/2018.
 */

public class Dashboard extends Activity {

    private Spinner region;
    private ListView product_list;

    private Button btn_farmer;

    private Server server;

    private List<Product> gotProducts;
    private List<Region> gotRegions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dashboard);

        server = new Server();

        btn_farmer = (Button) findViewById(R.id.btn_framer);
        btn_farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, FarmerView.class));
            }
        });

        region = (Spinner) findViewById(R.id.region_list);
        product_list = (ListView) findViewById(R.id.product_list);

//        String[] regionList = {"हिमालि (Mountain)", "पहाडी (Hilly)", "तराई (Terai)"};
        ArrayList<String> regionList = new ArrayList<String>();
        List<Region> regions = server.getAllRegions();
        gotRegions = regions;
        for (Region region: regions) {
            regionList.add(region.getRegName());
        }
        ArrayAdapter regionAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, regionList);
        region.setAdapter(regionAdapter);

        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(Dashboard.this, "id : "+ (l+1), Toast.LENGTH_LONG).show();
                final ArrayList<String> productList = new ArrayList<String>();
                List<Product> products = server.getProductsByRegion(gotRegions.get((int)(long)l).getRegId());
                gotProducts = products;
                for (Product product: products) {
                    productList.add(product.getProdName());
                }
                ArrayAdapter adapter = new ArrayAdapter(Dashboard.this, android.R.layout.simple_list_item_1, productList);

                product_list.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//        String[] productList = {"Grain", "Wheat", "Paddy", "Potato", "Cauliflower"};
        final ArrayList<String> productList = new ArrayList<String>();
        List<Product> products = server.getProductsByRegion(gotRegions.get((int)(long)region.getSelectedItemId()).getRegId());
        gotProducts = products;
        for (Product product: products) {
            productList.add(product.getProdName());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productList);

        product_list.setAdapter(adapter);
        product_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Dashboard.this, ProductView.class);
                long id = gotProducts.get((int)(long)l).getProdId();
                intent.putExtra("id", id);
                Toast.makeText(Dashboard.this, "id : "+ l+1, Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}
