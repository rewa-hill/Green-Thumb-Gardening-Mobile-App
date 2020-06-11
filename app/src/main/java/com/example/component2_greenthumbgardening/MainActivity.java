//Green Thumb Gardening Mobile Application created by Rewa Hill 17460727
package com.example.component2_greenthumbgardening;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        PlantAdapter.OnPlantListener {

    private DrawerLayout drawer;
    private RecyclerView mRecyclerView;
    private ArrayList<Plant> mPlants = new ArrayList<>();
    private PlantAdapter mPlantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialises variables
        mRecyclerView = findViewById(R.id.recyclerView);

        //Loads plants
        loadPlants();

        //Initialises RecyclerView
        initialiseRecyclerView();

        //Toolbar Settings
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Disables Title in Toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Navigation Drawer Layout
        drawer = findViewById(R.id.drawer_layout);
        //Opens and closes Navigation Drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onPlantClick(int position) {
        Plant plant = mPlants.get(position);
        Intent intent = new Intent(this, PlantActivity.class);
        intent.putExtra("plant_name", mPlants.get(position).getPlantName());
        intent.putExtra("plant_sci_name", mPlants.get(position).getPlantSciName());
        intent.putExtra("plant_desc", mPlants.get(position).getPlantDesc());
        intent.putExtra("plant_image", mPlants.get(position).getPlantImage());
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private void initialiseRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerView);
        mPlantAdapter = new PlantAdapter(mPlants, this);
        mRecyclerView.setAdapter(mPlantAdapter);
    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };

    private void loadPlants() {
        //Plant Name,Scientific Name,Plant Description
        //Flower Plant inserts
        Plant p1 = new Plant("Roses", "Rosa gallica", "The rose is a type of flowering shrub. Its name comes from the Latin word Rosa. The flowers of the rose grow in many different colors, from the well-known red rose or yellow roses and sometimes white or purple roses. Roses belong to the family of plants called Rosaceae.","db1");
        mPlants.add(p1);
        Plant p2 = new Plant("Lilies", "Lilium", "The lily is a genus of flowering plant. There are many species of lilies, like trumpet lilies and tiger lilies. They are usually quite tall, and are perennials. Most lilies grow from a bulb, which in some species develops into a rhizome, which carries small bulbs.","db2");
        mPlants.add(p2);
        Plant p3 = new Plant("Calla Lilies", "Zantedeschia aethiopica", "Calla lilies have long-petioled, basal leaves arising from a thick rhizome. The inflorescence, on a leafless flower stalk, consists of a spathe and spadix. The spathe, a large, flaring, trumpet-shaped bract, surrounds the spadix which is covered with tiny flowers.", "db3");
        mPlants.add(p3);
        Plant p4 = new Plant("Daisies", "Bellis perennis", "A Daisy flower is composed of white petals and a yellow center, although the flower can sometimes have a pink or rose color. Daisies are not made of just one flower. A Daisy is made up of two types of flowers - disk florets and petal-like white ray florets.", "db4");
        mPlants.add(p4);
        Plant p5 = new Plant("Gardenias", "Gardenia jasminoides", "Gardenias are native to the tropical and subtropical regions of Africa, southern Asia, Australasia and Oceania. This species can be difficult to grow elsewhere because it demands high humidity to thrive and bright (not direct) light. Some types of gardenias can be grown as houseplants.","db5");
        mPlants.add(p5);

        //Edible Plant inserts
        Plant p6 = new Plant("Globe Artichoke", "Cynara cardunculus var. scolymus", "Globe artichoke is an heirloom vegetable grown for its tender, edible flower buds. With their large, silvery-green leaves and thick stems topped with pinecone-like flower buds, artichoke plants add a strong architectural element to vegetable garden plantings.","db6");
        mPlants.add(p6);
        Plant p7 = new Plant("Basil", "Ocimum basilicum", "Basil, also known as Sweet Basil or Tulsi, is a tender low-growing herb that is grown as a perennial in warm, tropical climates. Basil is originally native to India and other tropical regions of Asia. It has been cultivated there for more than 5,000 years. It is prominently featured in many cuisines throughout the world. Some of them are Italian, Thai, Vietnamese and Laotian cuisines. It grows to between 30–60 cm tall. It has light green, silky leaves 3–5 cm long and 1–3 cm broad. The leaves are opposite each other. The flowers are quite big. They are white in color and arranged as a spike.","db7");
        mPlants.add(p7);
        Plant p8 = new Plant("Blueberries", "Cyanococcus", "A blueberry is a berry, a very small fruit. It grows in a type of woody plant called a shrub. Many types of blueberries grow in North America and eastern Asia.","db8");
        mPlants.add(p8);
        Plant p9 = new Plant("Kale", "Brassica oleracea var. sabellica", "Kale is a vegetable with green or purple leaves. It is also called borecole. It is in the group of vegetables called Brassica oleracea or wild cabbage.","db9");
        mPlants.add(p9);
        Plant p10 = new Plant("Cabbage", "Brassica oleracea var. capitata", "Cabbage is an edible plant. It is a lot like broccoli, cauliflower or Brussels sprouts. Cabbage is eaten in many ways around the world. Coleslaw and sauerkraut are popular foods that use cabbage. It is also used to make kimchi and borscht, and can also be used in salads. Red cabbage juice can be used as a pH indicator. Cabbages are usually green, but they can also be red.", "db10");
        mPlants.add(p10);

        //Shrubs inserts
        Plant p11 = new Plant("Azalea", "Rhododendron", "Rhododendron is a large genus of flowering plants. It includes 1,024 species of woody plants in the heath family (Ericaceae). Some are evergreen, and some are deciduous. They are found mainly in Asia. Most of them have quite showy flowers. What gardeners know as Azalea is in fact a kind of rhododendron. Many people have rhododendrons in their garden or flower pot. It is the national flower of Nepal. One rhododendron, Rhododendron ponticum, has become an Invasive species in North America.", "db11");
        mPlants.add(p11);
        Plant p12 = new Plant("Lavender", "Lavandula", "Lavender is a type of plant found on almost all continents. It has a purplish colour. It has a colour named after it, called lavendar. Its Latin and scientific name is Lavandula.","db12");
        mPlants.add(p12);
        Plant p13 = new Plant("Rosemary", "Rosmarinus officinalis", "Rosemary is a woody, perennial herb with fragrant evergreen needle-like leaves. It is native to the Mediterranean region. It is a member of the mint family Lamiaceae, which also includes many other herbs.", "db13");
        mPlants.add(p13);
        Plant p14 = new Plant("Aloe Vera", "Aloe barbadensis miller", "Aloe vera is a species of succulent plant in the genus Aloe. It is originally from the Arabian Peninsula but it grows wild in tropical climates around the world. It is a popular houseplant species.","db14");
        mPlants.add(p14);
        Plant p15 = new Plant("Jasmine", "Jasminum", "Jasmine is a genus of plants. They are shrubs or vines that grow in moderately warm climates. There are about 200 different species of Jasmine. They are also quite liked in gardens. Tea can be made from the flowers. Some species are used to make special oil, perfumes or incense. Women, especially from Asia sometimes wear jasmine flowers in their hair. Jasmine flowers are white or yellow in colour, although in rare instances they can be slightly reddish. Jasmine flowers are well known for their lovely smell. jasmine can also be a female name.","db15");
        mPlants.add(p15);

        //Tree inserts
        Plant p16 = new Plant("Cherry Blossom", "Prunus serrulata", "Cherry blossom or sakura are cherry trees, and their blossoms. The fruit comes from a different species.","db16");
        mPlants.add(p16);
        Plant p17 = new Plant("Crab Apple", "Malus floribunda", "Malus floribunda forms a round-headed, small deciduous tree with narrow leaves on arching branches. The flowers are white or pale pink, opening from crimson buds. The fruit is red and yellow, of about 1 cm in diameter.","db17");
        mPlants.add(p17);
        Plant p18 = new Plant("Golden Goddess Bamboo", "Bambusa multiplex", "Bambusa multiplex forms a medium sized clump with slender culms (stems) and dense foliage. This bamboo is suitable for hedges and live fences since the stems and foliage form a dense growth that create an effective barrier. The height of the stems under ideal conditions is about 10 ft. Propagation is through rhizome offsets and rooted culm (stem) cuttings. Micro propagation too is feasible through axillary bud proliferation.","db18");
        mPlants.add(p18);
        Plant p19 = new Plant("Poplar", "Populus deltoides", "Populus deltoides is a large tree growing to 20–60 m (65–195 ft) tall and with a trunk up to 2.8 m (9 ft 2 in) diameter, one of the largest North American hardwood trees. The bark is silvery-white, smooth or lightly fissured when young, becoming dark gray and deeply fissured on old trees.", "db19");
        mPlants.add(p19);
        Plant p20 = new Plant("Willow", "Salix x fragilis", "Salix fragilis is a medium-sized to large deciduous tree, which grows rapidly to 10–20 m (33–66 ft) (rarely to 29 m (95 ft)) tall, with a trunk up to 1 m (3.3 ft) diameter, often multi-trunked, and an irregular, often leaning crown. The bark is dark grey-brown, coarsely fissured in older trees. The lanceolate leaves are bright green, 9–15 cm long and 1.5–3 cm wide, with a finely serrated margin; they are very finely hairy at first in spring, but soon become hairless.", "db20");
        mPlants.add(p20);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }
}