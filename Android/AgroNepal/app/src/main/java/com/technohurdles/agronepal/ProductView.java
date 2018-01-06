package com.technohurdles.agronepal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.technohurdles.agronepal.model.Mediator;
import com.technohurdles.agronepal.model.Product;
import com.technohurdles.agronepal.model.Shop;

import java.util.List;

/**
 * Created by shakyas on 1/5/2018.
 */

public class ProductView extends Activity{

    private TextView prod_name, prod_desc, prod_requirement, prod_procedure, prod_shop, prod_mediator;

    private Server server;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.product);

        server = new Server();

        prod_name = (TextView) findViewById(R.id.detail_prod_name);
        prod_desc = (TextView) findViewById(R.id.detail_prod_discrption);
        prod_requirement = (TextView) findViewById(R.id.detail_prod_requirement);
        prod_procedure = (TextView) findViewById(R.id.detail_prod_procedure);
        prod_shop = (TextView) findViewById(R.id.detail_prod_req_shop);
        prod_mediator= (TextView) findViewById(R.id.detail_prod_intermediator);

        Intent gotIntent = getIntent();
        long prod_id = gotIntent.getLongExtra("id",0);
        Product product = server.getProductById(prod_id);

        prod_name.setText(product.getProdName());
        prod_desc.setText(product.getProdDecription());
        prod_requirement.setText(product.getProdRequirement());
        prod_procedure.setText(product.getProdProcedure());

        List<Shop> shops = server.getShopsByRegion(product.getProdRegId().getRegId());
        List<Mediator> mediators = server.getMedaiatorsByRegion(product.getProdRegId().getRegId());

        StringBuilder shopString = new StringBuilder();
        StringBuilder mediatorString = new StringBuilder();

        for(Shop shop : shops){
            shopString.append(shop.toString() + "\n\n");
        }

        for(Mediator mediator : mediators){
            mediatorString.append(mediator.toString() + "\n\n");
        }

        prod_shop.setText(shopString);
        prod_mediator.setText(mediatorString);
    }
}
