package android.oscarbetanzos.com.petinsta;

import android.oscarbetanzos.com.petinsta.Adapters.PageAdapter;
import android.oscarbetanzos.com.petinsta.Fragments.HomeFragment;
import android.oscarbetanzos.com.petinsta.Fragments.MiMascotaFragment;
import android.support.v4.app.Fragment;
import android.content.Intent;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_ENVIAR_CORREO = 1;
    ImageButton starButton;
    Toolbar miActionBar;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        setUpViewPager();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnContacto:
                Intent ctcAct = new Intent(MainActivity.this, ContactoActivity.class);
                startActivityForResult(ctcAct,CODIGO_ENVIAR_CORREO);
                break;


            case R.id.mnAbout:
                Intent aboutAct = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(aboutAct);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new MiMascotaFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_my_pet);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==CODIGO_ENVIAR_CORREO){
            if (resultCode ==RESULT_OK){
                Toast.makeText(MainActivity.this,"Mensaje enviado",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void clickStarButton(View view){
        Intent intent = new Intent(MainActivity.this,TopFiveActivity.class);
        startActivity(intent);
    }
}
