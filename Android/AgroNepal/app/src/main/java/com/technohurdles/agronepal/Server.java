package com.technohurdles.agronepal;

import android.os.AsyncTask;
import android.util.Log;

import com.technohurdles.agronepal.model.Mediator;
import com.technohurdles.agronepal.model.Product;
import com.technohurdles.agronepal.model.Profile;
import com.technohurdles.agronepal.model.Region;
import com.technohurdles.agronepal.model.Shop;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shakyas on 1/5/2018.
 */

public class Server {

    ///Get All Regions
    class GetAllRegions extends AsyncTask<String, Void, List<Region>>{
        @Override
        protected List<Region> doInBackground(String... urls) {
            final String url = urls[0];
            RestTemplate restTemplate = new RestTemplate();
            List<Region> regionList = new ArrayList<Region>();
            try{
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Region[]> responseEntity = restTemplate.getForEntity(url, Region[].class);
                Object[] objects = responseEntity.getBody();
                for(Object region : objects){
                    regionList.add((Region)region);
                }
            } catch (Exception e){
                Log.e("[GetAllRegions] : ", e.getMessage(), e);
            } finally {
                return regionList;
            }
        }

        @Override
        protected void onPostExecute(List<Region> regionList) {
            super.onPostExecute(regionList);
        }
    }

    public List<Region> getAllRegions(){
        final String url = "http://192.168.137.1:8080/region/getAllRegions";
        List<Region> regionList = new ArrayList<Region>();
        try{
            regionList = new GetAllRegions().execute(url).get();
        } catch (Exception e){
            Log.e("[getAllRegions] : ", e.getMessage(), e);
        } finally {
            return regionList;
        }
    }




    ///Get All Products according to region

    class GetProductsByRegion extends AsyncTask<String, Void, List<Product>> {

        @Override
        protected List<Product> doInBackground(String... urls){
            final String url = urls[0];
            RestTemplate restTemplate = new RestTemplate();
            List<Product> productList = new ArrayList<Product>();
            try{
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(url, Product[].class);
                Object[] objects = responseEntity.getBody();
                for (Object obj: objects
                        ) {
                    productList.add((Product) obj);
                }
            }  catch (Exception e) {
                Log.e("GetProductsByRegion] : ", e.getMessage(), e);
            } finally{
                return productList;
            }
        }

        @Override
        protected void onPostExecute(List<Product> productList) {
        }
    }

    public List<Product> getProductsByRegion(int id){
        final String url = "http://192.168.137.1:8080/product/getProductsByRegion/"+id+"";
        List<Product> productList = new ArrayList<Product>();
        try{
            productList  = new GetProductsByRegion().execute(url).get();
        } catch(Exception e){
            Log.e("[getProductsByRegion]: ", e.getMessage(), e);
        } finally {
            return productList;
        }
    }




    ///Get one Products according to product id

    class GetProductsById extends AsyncTask<String, Void, Product> {

        @Override
        protected Product doInBackground(String... urls){
            final String url = urls[0];
            RestTemplate restTemplate = new RestTemplate();
            Product product = new Product();
            try{
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                product = restTemplate.getForObject(url, Product.class);
            }  catch (Exception e) {
                Log.e("[GetProductById] : ", e.getMessage(), e);
            } finally {
                return product;
            }
        }

        @Override
        protected void onPostExecute(Product product) {
        }
    }

    public Product getProductById(long id){
        final String url = "http://192.168.137.1:8080/product/getProductById/"+id+"";
        Product product = new Product();
        try{
            product  = new GetProductsById().execute(url).get();
        } catch(Exception e){
            Log.e("[getProductById] : ", e.getMessage(), e);
        } finally {
            return product;
        }
    }


    ///Get Profiles

    class GetProfiles extends AsyncTask<String, Void, List<Profile>> {

        @Override
        protected List<Profile> doInBackground(String... urls){
            final String url = urls[0];
            RestTemplate restTemplate = new RestTemplate();
            List<Profile> profileList = new ArrayList<Profile>();
            try{
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Profile[]> responseEntity = restTemplate.getForEntity(url, Profile[].class);
                Object[] objects = responseEntity.getBody();
                for (Object obj: objects
                        ) {
                    profileList.add((Profile) obj);
                }
            }  catch (Exception e) {
                Log.e("[GetProfiles] : ", e.getMessage(), e);
            } finally {
                return profileList;
            }
        }

        @Override
        protected void onPostExecute(List<Profile> profileList) {
        }
    }

    public List<Profile> getProfiles(){
        final String url = "http://192.168.137.1:8080/profile/getProfiles";
        List<Profile> profileList = new ArrayList<Profile>();
        try{
            profileList  = new GetProfiles().execute(url).get();
        } catch(Exception e){
            Log.e("[GetProfiles] : ", e.getMessage(), e);
        } finally {
            return profileList;
        }
    }



    ///Get Profile By Id
    class GetProfileById extends AsyncTask<String, Void, Profile> {

        @Override
        protected Profile doInBackground(String... urls){
            final String url = urls[0];
            RestTemplate restTemplate = new RestTemplate();
            Profile profile = new Profile();
            try{
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                profile = restTemplate.getForObject(url, Profile.class);
            }  catch (Exception e) {
                Log.e("[GetProfileById] : ", e.getMessage(), e);
            } finally {
                return profile;
            }
        }

        @Override
        protected void onPostExecute(Profile profile) {
        }
    }

    public Profile getProfileById(long id){
        final String url = "http://192.168.137.1:8080/profile/getProfileById/"+id+"";
        Profile profile = new Profile();
        try{
            profile = new GetProfileById().execute(url).get();
        } catch(Exception e){
            Log.e("[GetProfileById] : ", e.getMessage(), e);
        } finally {
            return profile;
        }
    }



    ///Get Mediators By Regions

    class GetMediatorsByRegion extends AsyncTask<String, Void, List<Mediator>> {

        @Override
        protected List<Mediator> doInBackground(String... urls){
            final String url = urls[0];
            RestTemplate restTemplate = new RestTemplate();
            List<Mediator> mediatorList = new ArrayList<Mediator>();
            try{
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Mediator[]> responseEntity = restTemplate.getForEntity(url, Mediator[].class);
                Object[] objects = responseEntity.getBody();
                for (Object obj: objects
                        ) {
                    mediatorList.add((Mediator) obj);
                }
            }  catch (Exception e) {
                Log.e("[GetMediatorsByRegion]:", e.getMessage(), e);
            } finally {
                return mediatorList;
            }
        }

        @Override
        protected void onPostExecute(List<Mediator> mediatorList) {
        }
    }

    public List<Mediator> getMedaiatorsByRegion(int id){
        final String url = "http://192.168.137.1:8080/mediator/getMediatorsByRegion/"+id+"";
        List<Mediator> mediatorList = new ArrayList<Mediator>();
        try{
            mediatorList  = new GetMediatorsByRegion().execute(url).get();
        } catch(Exception e){
            Log.e("[GetMediatorsByRegion]:", e.getMessage(), e);
        } finally {
            return mediatorList;
        }
    }




    ///Get Shops By Regions

    class GetShopsByRegion extends AsyncTask<String, Void, List<Shop>> {

        @Override
        protected List<Shop> doInBackground(String... uri){
            final String url = uri[0];
            RestTemplate restTemplate = new RestTemplate();
            List<Shop> shopList = new ArrayList<Shop>();
            try{
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<Shop[]> responseEntity = restTemplate.getForEntity(url, Shop[].class);
                Object[] objects = responseEntity.getBody();
                for (Object obj: objects
                        ) {
                    shopList.add((Shop) obj);
                }
            }  catch (Exception e) {
                Log.e("[GetShopsByRegion]:", e.getMessage(), e);
            } finally {
                return shopList;
            }
        }

        @Override
        protected void onPostExecute(List<Shop> shops) {
        }
    }

    public List<Shop> getShopsByRegion(int id){
        final String url = "http://192.168.137.1:8080/shop/getShopsByRegion/"+id+"";
        List<Shop> shopList = new ArrayList<Shop>();
        try{
            shopList  = new GetShopsByRegion().execute(url).get();
        } catch(Exception e){
            Log.e("[GetShopsByRegion]:", e.getMessage(), e);
        } finally {
            return shopList;
        }
    }
}
