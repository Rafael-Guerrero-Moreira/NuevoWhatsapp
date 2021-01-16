package com.example.nuevowhatsapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.nuevowhatsapp.Menu.CallsFragment;
import com.example.nuevowhatsapp.Menu.ChatFragment;
import com.example.nuevowhatsapp.Menu.StatusFragment;
import com.example.nuevowhatsapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        setUpWithViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        setSupportActionBar(binding.toolbarMain);

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changefloatbuttonIcon(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpWithViewPager(ViewPager viewPager){
    MainActivity.SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new ChatFragment(),"Chats");
    adapter.addFragment(new StatusFragment(),"Estados");
    adapter.addFragment(new CallsFragment(),"Llamadas");
    viewPager.setAdapter(adapter);
    }


    private static class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        int id = item.getItemId();

        switch (id){
            case R.id.menu_search : Toast.makeText(MainActivity.this, "Busqueda", Toast.LENGTH_SHORT).show();break;
            case R.id.menu_options : Toast.makeText(MainActivity.this, "Opciones", Toast.LENGTH_SHORT).show();break;
        }

        return super.onOptionsItemSelected(item);

    }

    private void changefloatbuttonIcon(final int index){
        binding.tabFloatButton.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0: binding.tabFloatButton.setImageDrawable(getDrawable(R.drawable.ic_baseline_chat_24));break;
                    case 1: binding.tabFloatButton.setImageDrawable(getDrawable(R.drawable.ic_baseline_photo_camera_24));break;
                    case 2: binding.tabFloatButton.setImageDrawable(getDrawable(R.drawable.ic_baseline_add_ic_call_24));break;
                }
                binding.tabFloatButton.show();
            }
        },400);

    }

}