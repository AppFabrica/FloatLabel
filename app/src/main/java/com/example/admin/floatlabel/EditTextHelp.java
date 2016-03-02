package com.example.admin.floatlabel;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;



import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Administrador on 28/07/2015.
 */
public class EditTextHelp extends LinearLayout
{
    EditText editText;
    LinearLayout layoutEditText;
    String text;
    String hint;
    String error;
    int inputType;
    boolean editable;
    boolean esDecimal = false;

    public EditTextHelp(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.edit_text_help, this, true);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EditTextHelpOptions, 0, 0);
        text = a.getString(R.styleable.EditTextHelpOptions_text);
        hint =  a.getString(R.styleable.EditTextHelpOptions_hint);
        editable = a.getBoolean(R.styleable.EditTextHelpOptions_android_editable, true);
        inputType = a.getInt(R.styleable.EditTextHelpOptions_android_inputType, InputType.TYPE_CLASS_TEXT);


        editText = (EditText)findViewById(R.id.helpEditText);
        layoutEditText = (LinearLayout)findViewById(R.id.layoutEditTextHelp);
        editText.setText(text);
        editText.setHint(hint);
        editText.setInputType(inputType);
        if(!editable)
            editText.setInputType(0);


    }

    @Override
    protected void onFinishInflate() {


    }

    public void OnFocus(boolean hasFocus)
    {

    }

    public void setEsDecimal(boolean esDecimal) {
        this.esDecimal = esDecimal;
    }

    public String getText()
    {
        if(editText != null && editText.getText() != null)
            return editText.getText().toString();
        else
            return "";
    }

    public void setText(String text) {
        editText.setText(text);
    }

    public void setEditable(boolean esEditable)
    {
        //editText.setFocusable(esEditable);
        if(esEditable)
            editText.setInputType(inputType);
        else
            editText.setInputType(0);
    }

    public void setDouble(double value)
    {
//
    }

    public void setFecha(Date fecha)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        if(fecha != null)
            this.editText.setText(simpleDateFormat.format(fecha));
    }

    public void setInt(int value)
    {
        editText.setText(String.valueOf(value));
    }

    public String getHint() {
        return editText.getHint().toString();
    }

    public void setHint(String hint) {
        editText.setHint(hint);
    }

    public String getError() {
        return editText.getError().toString();
    }

    public void setError(String error) {
        editText.setError(error);
    }

    public EditText getEditText() {
        return editText;
    }

    public int getInt()
    {
        if(this.getText().equals(""))
            return 0;
        return Integer.parseInt(this.getText());
    }

    public double getDouble()
    {
       return 0;

    }
}
