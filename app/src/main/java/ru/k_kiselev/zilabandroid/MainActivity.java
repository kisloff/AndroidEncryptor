package ru.k_kiselev.zilabandroid;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.Arrays;

import ru.k_kiselev.zilabandroid.encryption.EncryptionProtocol;
import ru.k_kiselev.zilabandroid.encryption.Encryptor;
import ru.k_kiselev.zilabandroid.encryption.Decryptor;
import ru.k_kiselev.zilabandroid.utils.StringUtils;

public class MainActivity extends AppCompatActivity {

    public final static String HEADER = "Encryption";
    public final static String EMPTY_INPUT_MESSAGE = "Input is empty. Enter phrase to cipher.";
    public final static String WRONG_INPUT_MESSAGE = "Input is not binary. 0 or 1 are only allowed.";
    public final static String ALERT = "Alert";

    Button btnGenerateGamma;
    TextView tvGeneratedGamma;
    EditText etInput;
    Button btnEncrypt;
    TextView tvCipheredPhrase;
    Button btnDecrypt;
    TextView tvDecryptedPhrase;
    Button btnClean;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerateGamma = (Button)findViewById(R.id.btnGenerateGamma);
        tvGeneratedGamma = (TextView)findViewById(R.id.tvGeneratedGamma);
        etInput = (EditText)findViewById(R.id.etInput);
        btnEncrypt = (Button)findViewById(R.id.btnEncrypt);
        tvCipheredPhrase = (TextView)findViewById(R.id.tvCipheredPhrase);
        btnDecrypt = (Button)findViewById(R.id.btnDecrypt);
        tvDecryptedPhrase = (TextView)findViewById(R.id.tvDecryptedPhrase);
        btnClean = (Button)findViewById(R.id.btnClean);

        btnGenerateGamma.setOnClickListener(listener);
        btnEncrypt.setOnClickListener(listener);
        btnDecrypt.setOnClickListener(listener);
        btnClean.setOnClickListener(listener);
    }

    OnClickListener listener = new OnClickListener() {
        @Override
    public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnGenerateGamma:
                    generateGamma();
                    break;
                case R.id.btnEncrypt:
                    encrypt();
                    break;
                case R.id.btnDecrypt:
                    decrypt();
                    break;
                case R.id.btnClean:
                    clearAllTextFields();
                    break;
            }
        }
    };

    private void generateGamma(){
        EncryptionProtocol.generateGamma();
        String gamma = Arrays.toString(EncryptionProtocol.gamma);
        tvGeneratedGamma.setText(gamma);
    }

    private void encrypt(){
        //clearAllExceptInput();
        String input = etInput.getText().toString();

        if (input.isEmpty()) {
            //JOptionPane.showMessageDialog(null, EMPTY_INPUT_MESSAGE, ALERT, JOptionPane.INFORMATION_MESSAGE);
            Toast.makeText(getApplicationContext(), EMPTY_INPUT_MESSAGE, Toast.LENGTH_LONG).show();

            return;
        }

        if (!StringUtils.isBinary(input)) {
            //JOptionPane.showMessageDialog(null, WRONG_INPUT_MESSAGE, ALERT, JOptionPane.INFORMATION_MESSAGE);
            Toast.makeText(getApplicationContext(), WRONG_INPUT_MESSAGE, Toast.LENGTH_LONG).show();
            return;
        }

        String encrypted = Encryptor.encrypt(input);

        tvCipheredPhrase.setText(encrypted);
    }

    private void decrypt(){
        String encrypted = tvCipheredPhrase.getText().toString();
        encrypted = StringUtils.cleanString(encrypted);
        String decrypted = Decryptor.decrypt(encrypted);
        tvDecryptedPhrase.setText(decrypted);
    }

    private void clearAllTextFields() {
        clearAllExceptInput();
        etInput.setText("");
    }

    private void clearAllExceptInput(){
        tvGeneratedGamma.setText("");
        tvCipheredPhrase.setText("");
        tvDecryptedPhrase.setText("");
        etInput.setFocusable(true);
    }
}
