package bstech.ollypool;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    public static int ENABLE_BLUETOOTH = 1;
    public static int SELECT_PAIRED_DEVICE = 2;
    public static int SELECT_DISCOVERED_DEVICE = 3;

    static TextView statusMessage;
    ConnectionThread connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!btAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, ENABLE_BLUETOOTH);
        }


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == ENABLE_BLUETOOTH) {
           resultCode = RESULT_OK;
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Bt ok");
            AlertDialog al = yep.create();
            al.show();
        }
        else if(requestCode == SELECT_PAIRED_DEVICE || requestCode == SELECT_DISCOVERED_DEVICE) {
            if(resultCode == RESULT_OK) {
                AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
                yep.setMessage("Connected");
                AlertDialog al = yep.create();
                al.show();

                connect = new ConnectionThread(data.getStringExtra("btDevAddress"));
                connect.start();
            }
        }
    }

    public void searchDv(MenuItem item) {

        Intent searchPairedDevicesIntent = new Intent(this, PairedDevices.class);
        startActivityForResult(searchPairedDevicesIntent, SELECT_PAIRED_DEVICE);

    }

    public void hidroON(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {
            String messageBoxString = "hidron";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }
    }

    public void hidroOFF(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {
            String messageBoxString = "hidroff";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }
    }

    public void filtON(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {
            String messageBoxString = "filton";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }

    }

    public void filtOFF(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {
            String messageBoxString = "filtoff";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }
    }

    public void aquecON(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {
            String messageBoxString = "aquecon";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }

    }

    public void aquecOFF(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {
            String messageBoxString = "aquecoff";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }
    }

    public void ilumON(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {
            /*ImageView imV = findViewById(R.id.imageView4);
            imV.setImageDrawable(getResources().getDrawable(R.drawable.lamp2));*/
            String messageBoxString = "ilumon";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }
    }

    public void ilumOFF(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {

            /*ImageView imV = findViewById(R.id.imageView4);
            imV.setImageDrawable(getResources().getDrawable(R.drawable.lamp));*/
            String messageBoxString = "ilumoff";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }
    }

    public void filtAuto(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }

        else {

            EditText a = (EditText) findViewById(R.id.ontime);
            String b = a.getText().toString();

            EditText c = (EditText) findViewById(R.id.offtime);
            String d = c.getText().toString();

            String messageBoxString = "x" + b + "-" + d + "x";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }

    }

    public void ilum1ON(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {
            /*ImageView imV = findViewById(R.id.imageView4);
            imV.setImageDrawable(getResources().getDrawable(R.drawable.lamp2));*/
            String messageBoxString = "ilum1on";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }
    }

    public void ilum1OFF(View view) {

        if(connect == null)
        {
            AlertDialog.Builder yep = new AlertDialog.Builder(MainActivity.this);
            yep.setMessage("Sem conexão Bluetooth");
            AlertDialog al = yep.create();
            al.show();
        }
        else {

            /*ImageView imV = findViewById(R.id.imageView4);
            imV.setImageDrawable(getResources().getDrawable(R.drawable.lamp));*/
            String messageBoxString = "ilum1off";
            byte[] data = messageBoxString.getBytes();
            connect.write(data);
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1Hidro tab1 = new Tab1Hidro();
                    return tab1;
                case 1:
                    Tab2Filtro tab2 = new Tab2Filtro();
                    return tab2;
                case 2:
                    Tab3Aquec tab3 = new Tab3Aquec();
                    return tab3;
                case 3:
                    Tab4Ilum tab4 = new Tab4Ilum();
                    return tab4;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }

}
