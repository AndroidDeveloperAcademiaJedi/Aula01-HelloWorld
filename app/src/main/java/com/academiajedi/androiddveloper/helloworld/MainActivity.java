package com.academiajedi.androiddveloper.helloworld;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar; /** Variavel que vai representar o nosso Button (Tipo da variavel: Button) **/
    private EditText etNome; /** Variavel que vai representar o nosso EditText (Tipo da variavel: EditText) **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Metodo setContentView - Utilizado para especificar qual sera o layout dessa activity
         */
        setContentView(R.layout.activity_main);

        /**
         * findViewById - é o responsavel por fazer a relação do nosso componente na view com a nossa activity,
         * essa relação é feita pelo ID cadastrado no componente na view, é preciso realizar um cast para cada chamada do
         * findViewById, ou seja caso você queira pegar a referencia do button que esta na nossa view é preciso fazer o cast
         * com a classe Button - (Button)
         *
         * Na nossa activity nos podemos capturar cada elemento da view pelo seu ID, que é unico, para acessa esse ID na nossa
         * activity nos pegamos pela class R (Uma classe gerada automaticamente pelo android, essa classe não deve ser modificada
         * manualmente de nenhuma forma), a classe R guarda todos os nossos IDs, pelo atributo id nos conseguimos capturar o id
         * do componente da view
         */

        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        etNome = (EditText)findViewById(R.id.etNome);

        /**
         * Para ativar o evento de click do nosso botão, nos chamamos o metodo setOnClickListener da classe Button
         * esse metodo recebe como parameto o View.OnClickListener que é um listener que implementa o metodo onClick.
         */
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * Agora vamos implementar a classe AlertDialog para criarmos um alert quando o usuario clicar no botão Entrar
                 * No metodo setMessage nos iremos colocar a messagem que voce quer que apareca para o usuario quando o alert
                 * aparecer.
                 * No metodo .setNeutralButton nos iremos implementar o botão que vai aparecer no nosso Alert quando ele for exibido
                 * O metodo .show realiza a ação de mostrar o Alert na tela para o usuaio
                 *
                 * Iremos implementar o evento PostiveButton e NegativeButton, o primeiro parametro que eles recebem é o nome
                 * do botão, e o segundo parametro é o segundo parametro é o listener responsavel por implementar o metodo OnClick
                 */
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Bem Vindo " + etNome.getText())
                        .setNeutralButton("OK", null)
                        .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                /***
                                 * Classe Toast é utilizada para criar um alert na tela do usuario
                                 * Recebe como primeiro paremetro o contexto, o segundo parametro o texto que sera exibido
                                 * para o usuario e o terceiro parametro a duração que o texto sera exibido para o usuario
                                 */

                                Toast.makeText(MainActivity.this, "Positive",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

            }
        });




    }
}
