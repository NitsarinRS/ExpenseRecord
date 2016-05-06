package org.usablelabs.duedo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

public class Record extends BaseActivity implements View.OnClickListener {

    private static final int MenuItem_SaveID = 1;

    private Task task = null;
    private EditText date;
    private EditText ls1, ls2, ls3, ls4, ls5, ls6, ls7;
    private EditText rn1, rn2, rn3, rn4, rn5, rn6, rn7;
    private EditText ex1, ex2, ex3, ex4, ex5, ex6, ex7;
    private TextView tv1, tv2, tv3;
    private Button bt1;
  //  double num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15, num16, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        setDrawer(true);


        date = (EditText) findViewById(R.id.dateEdit);
        ls1 = (EditText) findViewById(R.id.List2);
        ls2 = (EditText) findViewById(R.id.List3);
        ls3 = (EditText) findViewById(R.id.List4);
        ls4 = (EditText) findViewById(R.id.List5);
        ls5 = (EditText) findViewById(R.id.List6);
        ls6 = (EditText) findViewById(R.id.List7);
        ls7 = (EditText) findViewById(R.id.List8);
        //  listEdit = (EditText) findViewById(R.id.List9);
        rn1 = (EditText) findViewById(R.id.Revenue2);
        rn2 = (EditText) findViewById(R.id.Revenue3);
        rn3 = (EditText) findViewById(R.id.Revenue4);
        rn4 = (EditText) findViewById(R.id.Revenue5);
        rn5 = (EditText) findViewById(R.id.Revenue6);
        rn6 = (EditText) findViewById(R.id.Revenue7);
        rn7 = (EditText) findViewById(R.id.Revenue8);
        //   revenueEdit = (EditText) findViewById(R.id.Revenue9);
        ex1 = (EditText) findViewById(R.id.Expense2);
        ex2 = (EditText) findViewById(R.id.Expense3);
        ex3 = (EditText) findViewById(R.id.Expense4);
        ex4 = (EditText) findViewById(R.id.Expense5);
        ex5 = (EditText) findViewById(R.id.Expense6);
        ex6 = (EditText) findViewById(R.id.Expense7);
        ex7 = (EditText) findViewById(R.id.Expense8);
        //  expenseEdit = (EditText) findViewById(R.id.Expense9);
        tv1 = (TextView) findViewById(R.id.Revenue10);
        tv2 = (TextView) findViewById(R.id.Expense10);
        tv3 = (TextView) findViewById(R.id.Total);
        bt1 = (Button) findViewById(R.id.button1);

        bt1.setOnClickListener(this);

        long id = getIntent().getLongExtra("id", 0);
        if (id == 0) {
            setTitle(R.string.new_task);
        } else {
            setTitle(R.string.edit_task);
            task = Task.load(Task.class, id);
            if (task != null) {
                ls1.setText(task.title);
                ls2.setText(task.title1);
                ls3.setText(task.title2);
                ls4.setText(task.title3);
                ls5.setText(task.title4);
                ls6.setText(task.title5);
                ls7.setText(task.title6);
                rn1.setText(task.content);
                rn2.setText(task.content1);
                rn3.setText(task.content2);
                rn4.setText(task.content3);
                rn5.setText(task.content4);
                rn6.setText(task.content5);
                rn7.setText(task.content6);
                ex1.setText(task.expense);
                ex2.setText(task.expense1);
                ex3.setText(task.expense2);
                ex4.setText(task.expense3);
                ex5.setText(task.expense4);
                ex6.setText(task.expense5);
                ex7.setText(task.expense6);
                tv1.setText(task.tv1);
                tv2.setText(task.tv2);
                tv3.setText(task.tv3);
            } else {
                finish();
            }
        }
    }


    //  bt1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String num1 = rn1.getText().toString();
        String num2 = rn2.getText().toString();
        String num3 = rn3.getText().toString();
        String num4 = rn4.getText().toString();
        String num5 = rn5.getText().toString();
        String num6 = rn6.getText().toString();
        String num7 = rn7.getText().toString();
        //  int sum = num1 + num2 + num3 + num4 + num5 + num6 + num7;
        tv1.setText(String.valueOf(num1 + num2 + num3 + num4 + num5 + num6 + num7));
        String num8 = ex1.getText().toString();
        String num9 = ex2.getText().toString();
        String num10 = ex3.getText().toString();
        String num11 = ex4.getText().toString();
        String num12 = ex5.getText().toString();
        String num13 = ex6.getText().toString();
        String num14 = ex7.getText().toString();
        //  int sum = num1 + num2 + num3 + num4 + num5 + num6 + num7;
        tv2.setText(String.valueOf(num8 + num9 + num10 + num11 + num12 + num13 + num14));

        String num15 = tv1.getText().toString();
        String num16 = tv2.getText().toString();

        //  int sum = num1 + num2 + num3 + num4 + num5 + num6 + num7;
        tv3.setText(String.valueOf(num15 + num16 ));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        addMenuItem(menu, MenuItem_SaveID, R.string.save, buildDrawable(MaterialDesignIconic.Icon.gmi_save));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (isEdited()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setTitle(android.R.string.dialog_alert_title);
                    alert.setMessage(R.string.unsaved_exit_alert);
                    alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            onBackPressed();
                        }
                    });
                    alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alert.show();
                    return true;
                }
                break;
            case MenuItem_SaveID:
                save();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onStart() {
        super.onStart();
        EditText dateEdit = (EditText) findViewById(R.id.dateEdit);
        dateEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
            }
        });
    }





    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /* surpass all keys in activity; force the user to use form controls */
        return true;
    }

    private boolean isEdited() {
        if (task == null)
            return date.getText().length() > 0
                    ||ls1.getText().length() > 0||ls2.getText().length() > 0||ls3.getText().length() > 0||ls4.getText().length() > 0||ls5.getText().length() > 0||ls6.getText().length() > 0||ls7.getText().length() > 0
                    || rn1.getText().length() > 0|| rn2.getText().length() > 0|| rn3.getText().length() > 0|| rn4.getText().length() > 0|| rn5.getText().length() > 0|| rn6.getText().length() > 0|| rn7.getText().length() > 0
                    || ex1.getText().length() > 0 || ex2.getText().length() > 0 || ex3.getText().length() > 0 || ex4.getText().length() > 0 || ex5.getText().length() > 0 || ex6.getText().length() > 0 || ex7.getText().length() > 0;
        else
            return !task.date.equals(date.getText().toString())
                    ||!task.title.equals(ls1.getText().toString())||!task.title1.equals(ls2.getText().toString())
                    ||!task.title2.equals(ls3.getText().toString())||!task.title3.equals(ls4.getText().toString())
                    ||!task.title4.equals(ls5.getText().toString())||!task.title5.equals(ls6.getText().toString())
                    ||!task.title6.equals(ls7.getText().toString())
                    || !task.content.equals(rn1.getText().toString())|| !task.content1.equals(rn2.getText().toString())
                    || !task.content2.equals(rn3.getText().toString())|| !task.content3.equals(rn4.getText().toString())
                    || !task.content4.equals(rn5.getText().toString())|| !task.content5.equals(rn6.getText().toString())
                    || !task.content6.equals(rn7.getText().toString())
                    || !task.expense.equals(ex1.getText().toString())|| !task.expense1.equals(ex2.getText().toString())
                    || !task.expense2.equals(ex3.getText().toString())|| !task.expense3.equals(ex4.getText().toString())
                    || !task.expense4.equals(ex5.getText().toString())|| !task.expense5.equals(ex6.getText().toString())
                    || !task.expense6.equals(ex7.getText().toString());
    }

    private void save() {
        if (date.getText().length() > 0) {
            if (task == null)
                task = new Task();
            task.date = date.getText().toString();
            task.title = ls1.getText().toString();
            task.title1 = ls2.getText().toString();
            task.title2 = ls3.getText().toString();
            task.title3 = ls4.getText().toString();
            task.title4 = ls5.getText().toString();
            task.title5 = ls6.getText().toString();
            task.title6 = ls7.getText().toString();
            task.content = rn1.getText().toString();
            task.content1 = rn2.getText().toString();
            task.content2 = rn3.getText().toString();
            task.content3 = rn4.getText().toString();
            task.content4 = rn5.getText().toString();
            task.content5 = rn6.getText().toString();
            task.content6 = rn7.getText().toString();
            task.expense = ex1.getText().toString();
            task.expense1 = ex2.getText().toString();
            task.expense2 = ex3.getText().toString();
            task.expense3 = ex4.getText().toString();
            task.expense4 = ex5.getText().toString();
            task.expense5 = ex6.getText().toString();
            task.expense6 = ex7.getText().toString();
            task.tv1 = tv1.getText().toString();
            task.tv2 = tv2.getText().toString();
            task.tv3 = tv3.getText().toString();
            task.saveWithTimestamp();
            setResult(Activity.RESULT_OK, new Intent().putExtra("id", task.getId()));
            this.finish();
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle(android.R.string.dialog_alert_title);
            alert.setMessage(R.string.title_is_required);
            alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alert.show();
        }
    }
}
