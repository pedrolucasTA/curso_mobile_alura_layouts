package alura.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import alura.com.br.R;
import alura.com.br.model.Pacote;
import alura.com.br.util.MoedaUtil;

import static alura.com.br.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPreco(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this,
                ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasilero(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}