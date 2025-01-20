// Classe para envio via stream
package com.example.Model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class AparelhosOutputStream {
    private OutputStream out;
    private List<Aparelho> aparelhos;

    public AparelhosOutputStream(OutputStream out, List<Aparelho> aparelhos) {
        this.out = out;
        this.aparelhos = aparelhos;
    }

    public void enviarAparelhos() throws IOException {
        // Envia o número de aparelhos
        out.write(aparelhos.size());

        for (Aparelho aparelho : aparelhos) {
            byte[] modeloBytes = aparelho.getModelo().getBytes();
            byte[] precoBytes = String.valueOf(aparelho.getPreco()).getBytes();

            // Envia o tamanho e os bytes do modelo
            out.write(modeloBytes.length);
            out.write(modeloBytes);

            // Envia o tamanho e os bytes do preço
            out.write(precoBytes.length);
            out.write(precoBytes);
        }

        out.flush();
    }
}