package org.usablelabs.duedo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public abstract class BaseActivity extends AppCompatActivity {

    protected static final int NEW_TASK = 1;
    protected static final int SHOW_TASK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setDrawer(Boolean upEnabled) {
        Toolbar toolbar_main = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar_main);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            if (upEnabled) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            } else {
                final Intent intent = new Intent(this, Record.class);
                new DrawerBuilder()
                        .withActivity(this)
                        .withToolbar(toolbar_main)
                        .addDrawerItems(
                                new PrimaryDrawerItem()
                                        .withName(R.string.task)
                                        .withIcon(MaterialDesignIconic.Icon.gmi_home)
                                        .withSelectable(false)
                                        .withIdentifier(1)
                        ).withSelectedItem(-1).addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.new_task)
                                .withIcon(MaterialDesignIconic.Icon.gmi_plus_circle)
                                .withSelectable(false)
                                .withIdentifier(2)
                ).withSelectedItem(-1)
                        .addDrawerItems(
                                new PrimaryDrawerItem()
                                        .withName(R.string.calender)
                                        .withIcon(MaterialDesignIconic.Icon.gmi_calendar)
                                        .withSelectable(false)
                                        .withIdentifier(3)
                        ).withSelectedItem(-1)
                        .addDrawerItems(
                                new PrimaryDrawerItem()
                                        .withName(R.string.chart)
                                        .withIcon(MaterialDesignIconic.Icon.gmi_chart)
                                        .withSelectable(false)
                                        .withIdentifier(4)
                        ).withSelectedItem(-1)

                        .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                switch (drawerItem.getIdentifier()) {
                                    case 1:
                                        startActivityForResult(new Intent(getApplicationContext(), ListActivity.class), SHOW_TASK);
                                        break;
                                    case 2:
                                        startActivityForResult(new Intent(getApplicationContext(), Record.class), SHOW_TASK);
                                        break;
                                    case 3:
                                        startActivityForResult(new Intent(getApplicationContext(), HistoryActivity.class), NEW_TASK);
                                        break;
                                    case 4:
                                        startActivityForResult(new Intent(getApplicationContext(), ChartActivity.class), SHOW_TASK);
                                        break;
                                    //   case 5:
                                    //     startActivityForResult(new Intent(getApplicationContext(), ListChart.class), NEW_TASK);
                                    //   break;
                                }
                                return false;
                            }
                        })
                        .build();
            }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    protected Drawable buildDrawable(IIcon icon) {
        return new IconicsDrawable(this).icon(icon).color(Color.WHITE).sizeDp(24).paddingDp(4);
    }

    protected void addMenuItem(Menu menu, int id, int labelId, Drawable icon) {
        MenuItem menuItem = menu.add(Menu.NONE, id, Menu.NONE, labelId);
        menuItem.setIcon(icon);
        menuItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }
}
