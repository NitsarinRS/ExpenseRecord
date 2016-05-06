package org.usablelabs.duedo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import java.text.SimpleDateFormat;

public class ShowActivity extends BaseActivity {

    private Task     task = null;
    private TextView dateView;
    private TextView listView1;
    private TextView listView2;
    private TextView listView3;
    private TextView listView4;
    private TextView listView5;
    private TextView listView6;
    private TextView listView7;
    private TextView revenueView1;
    private TextView revenueView2;
    private TextView revenueView3;
    private TextView revenueView4;
    private TextView revenueView5;
    private TextView revenueView6;
    private TextView revenueView7;
    private TextView expenseView1;
    private TextView expenseView2;
    private TextView expenseView3;
    private TextView expenseView4;
    private TextView expenseView5;
    private TextView expenseView6;
    private TextView expenseView7;
    private TextView tv1, tv2, tv3;

    private static final int MenuItem_EditID = 1;
    private static final int MenuItem_DeleteID = 2;
    private static final int EDIT_TASK = 10;
    private Task dating;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        setDrawer(true);
        setTitle(R.string.task);

        dateView = (TextView) findViewById(R.id.dateView);
        listView1 = (TextView) findViewById(R.id.List22);
        listView2 = (TextView) findViewById(R.id.List33);
        listView3 = (TextView) findViewById(R.id.List44);
        listView4 = (TextView) findViewById(R.id.List55);
        listView5 = (TextView) findViewById(R.id.List66);
        listView6 = (TextView) findViewById(R.id.List77);
        listView7 = (TextView) findViewById(R.id.List88);
        //  listEdit = (EditText) findViewById(R.id.List9);
        revenueView1 = (TextView) findViewById(R.id.Revenue22);
        revenueView2 = (TextView) findViewById(R.id.Revenue33);
        revenueView3 = (TextView) findViewById(R.id.Revenue44);
        revenueView4 = (TextView) findViewById(R.id.Revenue55);
        revenueView5 = (TextView) findViewById(R.id.Revenue66);
        revenueView6 = (TextView) findViewById(R.id.Revenue77);
        revenueView7 = (TextView) findViewById(R.id.Revenue88);
        //   revenueEdit = (EditText) findViewById(R.id.Revenue9);
        expenseView1 = (TextView) findViewById(R.id.Expense22);
        expenseView2 = (TextView) findViewById(R.id.Expense33);
        expenseView3= (TextView) findViewById(R.id.Expense44);
        expenseView4 = (TextView) findViewById(R.id.Expense55);
        expenseView5 = (TextView) findViewById(R.id.Expense66);
        expenseView6 = (TextView) findViewById(R.id.Expense77);
        expenseView7= (TextView) findViewById(R.id.Expense88);
        //  expenseEdit = (EditText) findViewById(R.id.Expense9);
        tv1 = (TextView)findViewById(R.id.Revenue10);
        tv2 = (TextView)findViewById(R.id.Expense10);
        tv2 = (TextView)findViewById(R.id.Expense10);
        tv3 = (TextView)findViewById(R.id.Total);

        long id = getIntent().getLongExtra("id", 0);
        setView(id);
    }

    private void setView(long id) {
        if (id > 0)
            task = Task.load(Task.class, id);
        if (task != null) {
            dateView.setText(task.date);
            listView1.setText(task.title);
            listView2.setText(task.title1);
            listView3.setText(task.title2);
            listView4.setText(task.title3);
            listView5.setText(task.title4);
            listView6.setText(task.title5);
            listView7.setText(task.title6);
            revenueView1.setText(task.content);
            revenueView2.setText(task.content1);
            revenueView3.setText(task.content2);
            revenueView4.setText(task.content3);
            revenueView5.setText(task.content4);
            revenueView6.setText(task.content5);
            revenueView7.setText(task.content6);
            expenseView1.setText(task.expense);
            expenseView2.setText(task.expense1);
            expenseView3.setText(task.expense2);
            expenseView4.setText(task.expense3);
            expenseView5.setText(task.expense4);
            expenseView6.setText(task.expense5);
            expenseView7.setText(task.expense6);
            tv1.setText(task.tv1);
            tv2.setText(task.tv2);
            tv3.setText(task.tv3);

        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        addMenuItem(menu, MenuItem_EditID, R.string.edit, buildDrawable(MaterialDesignIconic.Icon.gmi_edit));
        addMenuItem(menu, MenuItem_DeleteID, R.string.delete, buildDrawable(MaterialDesignIconic.Icon.gmi_delete));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MenuItem_EditID:
                Intent intent = new Intent(this, Record.class);
                intent.putExtra("id", task.getId());
                startActivityForResult(intent, EDIT_TASK);
                break;
            case MenuItem_DeleteID:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle(android.R.string.dialog_alert_title);
                alert.setMessage(R.string.are_you_sure);
                alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        task.delete();
                        setResult(Activity.RESULT_OK, new Intent().putExtra("refreshNeeded", true));
                        finish();
                    }
                });
                alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            switch (requestCode) {
                case EDIT_TASK:
                    if (extras != null && extras.getLong("id", 0) > 0) {
                        setView(task.getId());
                        setResult(Activity.RESULT_OK, new Intent().putExtra("refreshNeeded", true));
                    }
                    break;
            }
        }
    }
}
