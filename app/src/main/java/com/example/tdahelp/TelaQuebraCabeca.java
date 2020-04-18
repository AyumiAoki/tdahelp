package com.example.tdahelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class TelaQuebraCabeca extends AppCompatActivity {

    /* ORDENAÇÃO ALFABETICA */
    /* '-----------' */
    /* ' A ' B ' C ' */
    /* ' D ' E ' F ' */
    /* ' G ' H ' O ' */
    /* '-----------' */

    /* Objetos da Class JButton */
    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;

    /* Coordenadas */
    private int ZERO = 0;
    private int UM = 102;
    private int DOIS = 204;

    // Variaveis usadas para posicionamento dos botoes no tabuleiro, armezenaram
    // as coordenadas atuais dos Botões */
    private int colunaB0 = 0, linhaB0 = 0;
    private int colunaB1 = 0, linhaB1 = 0;
    private int colunaB2 = 0, linhaB2 = 0;
    private int colunaB3 = 0, linhaB3 = 0;
    private int colunaB4 = 0, linhaB4 = 0;
    private int colunaB5 = 0, linhaB5 = 0;
    private int colunaB6 = 0, linhaB6 = 0;
    private int colunaB7 = 0, linhaB7 = 0;
    private int colunaB8 = 0, linhaB8 = 0;

    /* Variaveis Auxiliar para armazenar os valores gerados pelo random */
    private int colunaAleatorio = 0;
    private int linhaAleatorio = 0;

    /* Contador do Loop */
    private int botao;

    // Instância um Objeto random da class java.leng, para gerar
    // numeros aleatórios.
    Random random = new Random();

    /* Variaveis Auxiliares para trocar de Posição */
    private int xx, yy, x, y;

    /* Variavel usada para Definir o Tamanho Horizontal e Vertical dos Botões */
    private int Horizontal = 100;
    private int Vertical = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quebra_cabeca);
        getSupportActionBar().hide();

        // Chamada dos métodos.
        CarregarBotoes();
        //CarregarEventos();
    }

    //Carrega as Configurações dos Botões.
    private void CarregarBotoes() {

        b0 = findViewById(R.id.button_9);
        b1 = findViewById(R.id.button_1);
        b2 = findViewById(R.id.button_2);
        b3 = findViewById(R.id.button_3);
        b4 = findViewById(R.id.button_4);
        b5 = findViewById(R.id.button_5);
        b6 = findViewById(R.id.button_6);
        b7 = findViewById(R.id.button_7);
        b8 = findViewById(R.id.button_8);

    }

//    /**
//     * Math.abs - Retorna o valor absoluto (módulo) do numero passado por
//     * parametro.
//     */
//    private void MathABS() {
//        //xx = Math.abs(x - b0.getX());
//        //yy = Math.abs(y - b0.getY());
//    }
//
//    /**
//     * Eventos de todos os Botões.
//     */
//    private void CarregarEventos() {
//
//        b1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//
//                /* Captura as Coordenadas Atual */
//                x = b1.getX();
//                y = b1.getY();
//
//                /* Método */
//                MathABS();
//
//                /* Condição para Troca de Posições */
//                if (xx <= 102 && yy <= 102 && xx != yy) {
//
//                    /* Define Nova Coordenada */
//                    b1.setBounds(colunaB1 = b0.getX(), linhaB1 = b0.getY(), Horizontal, Vertical);
//
//                    /* Define Nova Coordenada */
//                    b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal, Vertical);
//
//                    /* Reproduz Som
//					som = new Som();
//					som.main(null);*/
//
//                    /* Chamada do método que Verifica a Ordenação */
//                    VerificarOrdenacao();
//                }
//
//            }
//        });
//        b2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                /* Captura as Coordenadas Atual */
//                x = b2.getX();
//                y = b2.getY();
//
//                /* Método */
//                MathABS();
//
//                /* Condição para Troca de Posições */
//                if (xx <= 102 && yy <= 102 && xx != yy) {
//
//                    /* Define Nova Coordenada */
//                    b2.setBounds(colunaB2 = b0.getX(), linhaB2 = b0.getY(),
//                            Horizontal, Vertical);
//
//                    /* Define Nova Coordenada */
//                    b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
//                            Vertical);
//
//                    /* Reproduz Som
//					som = new Som();
//					som.main(null);*/
//
//                    /* Chamada do método que Verifica a Ordenação */
//                    VerificarOrdenacao();
//                }
//            }
//        });
//        b3.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                /* Captura as Coordenadas Atual */
//                x = b3.getX();
//                y = b3.getY();
//
//                /* Método */
//                MathABS();
//
//                /* Condição para Troca de Posições */
//                if (xx <= 102 && yy <= 102 && xx != yy) {
//
//                    /* Define Nova Coordenada */
//                    b3.setBounds(colunaB3 = b0.getX(), linhaB3 = b0.getY(),
//                            Horizontal, Vertical);
//
//                    /* Define Nova Coordenada */
//                    b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
//                            Vertical);
//
//                    /* Reproduz Som
//					som = new Som();
//					som.main(null);*/
//
//                    /* Chamada do método que Verifica a Ordenação */
//                    VerificarOrdenacao();
//                }
//            }
//        });
//        b4.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                /* Captura as Coordenadas Atual */
//                x = b4.getX();
//                y = b4.getY();
//
//                /* Método */
//                MathABS();
//
//                /* Condição para Troca de Posições */
//                if (xx <= 102 && yy <= 102 && xx != yy) {
//
//                    /* Define Nova Coordenada */
//                    b4.setBounds(colunaB4 = b0.getX(), linhaB4 = b0.getY(),
//                            Horizontal, Vertical);
//
//                    /* Define Nova Coordenada */
//                    b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
//                            Vertical);
//
//                    /* Reproduz Som
//					som = new Som();
//					som.main(null); */
//
//                    /* Chamada do método que Verifica a Ordenação */
//                    VerificarOrdenacao();
//                }
//            }
//        });
//        b5.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                /* Captura as Coordenadas Atual */
//                x = b5.getX();
//                y = b5.getY();
//
//                /* Método */
//                MathABS();
//
//                /* Condição para Troca de Posições */
//                if (xx <= 102 && yy <= 102 && xx != yy) {
//
//                    /* Define Nova Coordenada */
//                    b5.setBounds(colunaB5 = b0.getX(), linhaB5 = b0.getY(),
//                            Horizontal, Vertical);
//
//                    /* Define Nova Coordenada */
//                    b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
//                            Vertical);
//
//                    /* Reproduz Som
//					som = new Som();
//					som.main(null);*/
//
//                    /* Chamada do método que Verifica a Ordenação */
//                    VerificarOrdenacao();
//                }
//            }
//        });
//        b6.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                /* Captura as Coordenadas Atual */
//                x = b6.getX();
//                y = b6.getY();
//
//                /* Método */
//                MathABS();
//
//                /* Condição para Troca de Posições */
//                if (xx <= 102 && yy <= 102 && xx != yy) {
//
//                    /* Define Nova Coordenada */
//                    b6.setBounds(colunaB6 = b0.getX(), linhaB6 = b0.getY(),
//                            Horizontal, Vertical);
//
//                    /* Define Nova Coordenada */
//                    b0.setBounds(x, y, Horizontal, Vertical);
//
//                    /* Reproduz Som
//					som = new Som();
//					som.main(null);*/
//
//                    /* Chamada do método que Verifica a Ordenação */
//                    VerificarOrdenacao();
//                }
//            }
//        });
//        b7.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                /* Captura as Coordenadas Atual */
//                x = b7.getX();
//                y = b7.getY();
//
//                /* Método */
//                MathABS();
//
//                /* Condição para Troca de Posições */
//                if (xx <= 102 && yy <= 102 && xx != yy) {
//
//                    /* Define Nova Coordenada */
//                    b7.setBounds(colunaB7 = b0.getX(), linhaB7 = b0.getY(),
//                            Horizontal, Vertical);
//
//                    /* Define Nova Coordenada */
//                    b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
//                            Vertical);
//
//                    /* Reproduz Som
//					som = new Som();
//					som.main(null);*/
//
//                    /* Chamada do método que Verifica a Ordenação */
//                    VerificarOrdenacao();
//                }
//            }
//        });
//        b8.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                /* Captura as Coordenadas Atual */
//                x = b8.getX();
//                y = b8.getY();
//
//                /* Método */
//                MathABS();
//
//                /* Condição para Troca de Posições */
//                if (xx <= 102 && yy <= 102 && xx != yy) {
//
//                    /* Define Nova Coordenada */
//                    b8.setBounds(colunaB8 = b0.getX(), linhaB8 = b0.getY(),
//                            Horizontal, Vertical);
//
//                    /* Define Nova Coordenada */
//                    b0.setBounds(colunaB0 = x, linhaB0 = y, Horizontal,
//                            Vertical);
//
//                    /* Reproduz Som
//					som = new Som();
//					som.main(null);*/
//
//                    /* Chamada do método que Verifica a Ordenação */
//                    VerificarOrdenacao();
//                }
//            }
//        });
//    }
//
//    private void DistribuirBotoes() {
//        // Loop Preenchimento das coordenada dos botões.
//        for (botao = 0; botao < 9; botao++) {
//            // Variaveis auxiliares recebem os valores que foram gerados
//            // aleatoriamente de 0 á 2.
//            colunaAleatorio = random.nextInt(3);
//            linhaAleatorio = random.nextInt(3);
//
//            /* Passagem do valor da Coordenada para a Coluna */
//            if (colunaAleatorio == 0) {
//                colunaAleatorio = ZERO;
//            }
//            if (colunaAleatorio == 1) {
//                colunaAleatorio = UM;
//            }
//            if (colunaAleatorio == 2) {
//                colunaAleatorio = DOIS;
//            }
//
//            /* Passagem do valor da Coordenada para a Linha */
//            if (linhaAleatorio == 0) {
//                linhaAleatorio = ZERO;
//            }
//            if (linhaAleatorio == 1) {
//                linhaAleatorio = UM;
//            }
//            if (linhaAleatorio == 2) {
//                linhaAleatorio = DOIS;
//            }
//
//            /* Define as Coordenadas Aleatoria de cada Botão */
//            switch (botao) {
//                case 0:
//                    colunaB0 = colunaAleatorio;
//                    linhaB0 = linhaAleatorio;
//                    b0.setBounds(colunaB0, linhaB0, Horizontal, Vertical);
//                    break;
//                case 1:
//                    colunaB1 = colunaAleatorio;
//                    linhaB1 = linhaAleatorio;
//                    /* Tratamento de Erro (Espaço "Coordenada" Ocupada) */
//                    if ((colunaB1 == colunaB0) && (linhaB1 == linhaB0)
//                            || (colunaB1 == colunaB2) && (linhaB1 == linhaB2)
//                            || (colunaB1 == colunaB3) && (linhaB1 == linhaB3)
//                            || (colunaB1 == colunaB4) && (linhaB1 == linhaB4)
//                            || (colunaB1 == colunaB5) && (linhaB1 == linhaB5)
//                            || (colunaB1 == colunaB6) && (linhaB1 == linhaB6)
//                            || (colunaB1 == colunaB7) && (linhaB1 == linhaB7)
//                            || (colunaB1 == colunaB8) && (linhaB1 == linhaB8)) {
//                        // Retorna Loop para Randomisar as cooredenadas novamente,
//                        // até a condição ser falsa.
//                        botao--;
//                    } else {
//                        b1.setBounds(colunaB1, linhaB1, Horizontal, Vertical);
//                    }
//                    break;
//                case 2:
//                    if (botao == 2) {
//                        colunaB2 = colunaAleatorio;
//                        linhaB2 = linhaAleatorio;
//                        /* Tratamento de Erro (Coordenada Ocupada) */
//                        if ((colunaB2 == colunaB0) && (linhaB2 == linhaB0)
//                                || (colunaB2 == colunaB1) && (linhaB2 == linhaB1)
//                                || (colunaB2 == colunaB3) && (linhaB2 == linhaB3)
//                                || (colunaB2 == colunaB4) && (linhaB2 == linhaB4)
//                                || (colunaB2 == colunaB5) && (linhaB2 == linhaB5)
//                                || (colunaB2 == colunaB6) && (linhaB2 == linhaB6)
//                                || (colunaB2 == colunaB7) && (linhaB2 == linhaB7)
//                                || (colunaB2 == colunaB8) && (linhaB2 == linhaB8)) {
//                            // Retorna Loop para Randomisar as cooredenadas
//                            // novamente, até a condição ser falsa.
//                            botao--;
//                        } else {
//                            b2.setBounds(colunaB2, linhaB2, Horizontal, Vertical);
//                        }
//                    }
//                    break;
//                case 3:
//                    if (botao == 3) {
//                        colunaB3 = colunaAleatorio;
//                        linhaB3 = linhaAleatorio;
//                        /* Tratamento de Erro (Coordenada Ocupada) */
//                        if ((colunaB3 == colunaB0) && (linhaB3 == linhaB0)
//                                || (colunaB3 == colunaB1) && (linhaB3 == linhaB1)
//                                || (colunaB3 == colunaB2) && (linhaB3 == linhaB2)
//                                || (colunaB3 == colunaB4) && (linhaB3 == linhaB4)
//                                || (colunaB3 == colunaB5) && (linhaB3 == linhaB5)
//                                || (colunaB3 == colunaB6) && (linhaB3 == linhaB6)
//                                || (colunaB3 == colunaB7) && (linhaB3 == linhaB7)
//                                || (colunaB3 == colunaB8) && (linhaB3 == linhaB8)) {
//                            // Retorna Loop para Randomisar as cooredenadas
//                            // novamente, até a condição ser falsa.
//                            botao--;
//                        } else {
//                            b3.setBounds(colunaB3, linhaB3, Horizontal, Vertical);
//                        }
//                    }
//                    break;
//                case 4:
//                    if (botao == 4) {
//                        colunaB4 = colunaAleatorio;
//                        linhaB4 = linhaAleatorio;
//                        /* Tratamento de Erro (Coordenada Ocupada) */
//                        if ((colunaB4 == colunaB0) && (linhaB4 == linhaB0)
//                                || (colunaB4 == colunaB1) && (linhaB4 == linhaB1)
//                                || (colunaB4 == colunaB2) && (linhaB4 == linhaB2)
//                                || (colunaB4 == colunaB3) && (linhaB4 == linhaB3)
//                                || (colunaB4 == colunaB5) && (linhaB4 == linhaB5)
//                                || (colunaB4 == colunaB6) && (linhaB4 == linhaB6)
//                                || (colunaB4 == colunaB7) && (linhaB4 == linhaB7)
//                                || (colunaB4 == colunaB8) && (linhaB4 == linhaB8)) {
//                            // Retorna Loop para Randomisar as cooredenadas
//                            // novamente, até a condição ser falsa.
//                            botao--;
//                        } else {
//                            b4.setBounds(colunaB4, linhaB4, Horizontal, Vertical);
//                        }
//                    }
//                    break;
//                case 5:
//                    if (botao == 5) {
//                        colunaB5 = colunaAleatorio;
//                        linhaB5 = linhaAleatorio;
//                        /* Tratamento de Erro (Coordenada Ocupada) */
//                        if ((colunaB5 == colunaB0) && (linhaB5 == linhaB0)
//                                || (colunaB5 == colunaB1) && (linhaB5 == linhaB1)
//                                || (colunaB5 == colunaB2) && (linhaB5 == linhaB2)
//                                || (colunaB5 == colunaB3) && (linhaB5 == linhaB3)
//                                || (colunaB5 == colunaB4) && (linhaB5 == linhaB4)
//                                || (colunaB5 == colunaB6) && (linhaB5 == linhaB6)
//                                || (colunaB5 == colunaB7) && (linhaB5 == linhaB7)
//                                || (colunaB5 == colunaB8) && (linhaB5 == linhaB8)) {
//                            // Retorna Loop para Randomisar as cooredenadas
//                            // novamente, até a condição ser falsa.
//                            botao--;
//                        } else {
//                            b5.setBounds(colunaB5, linhaB5, Horizontal, Vertical);
//                        }
//                    }
//                    break;
//                case 6:
//                    if (botao == 6) {
//                        colunaB6 = colunaAleatorio;
//                        linhaB6 = linhaAleatorio;
//                        /* Tratamento de Erro (Coordenada Ocupada) */
//                        if ((colunaB6 == colunaB0) && (linhaB6 == linhaB0)
//                                || (colunaB6 == colunaB1) && (linhaB6 == linhaB1)
//                                || (colunaB6 == colunaB2) && (linhaB6 == linhaB2)
//                                || (colunaB6 == colunaB3) && (linhaB6 == linhaB3)
//                                || (colunaB6 == colunaB4) && (linhaB6 == linhaB4)
//                                || (colunaB6 == colunaB5) && (linhaB6 == linhaB5)
//                                || (colunaB6 == colunaB7) && (linhaB6 == linhaB7)
//                                || (colunaB6 == colunaB8) && (linhaB6 == linhaB8)) {
//                            // Retorna Loop para Randomisar as cooredenadas
//                            // novamente, até a condição ser falsa.
//                            botao--;
//                        } else {
//                            b6.setBounds(colunaB6, linhaB6, Horizontal, Vertical);
//                        }
//                    }
//                    break;
//                case 7:
//                    if (botao == 7) {
//                        colunaB7 = colunaAleatorio;
//                        linhaB7 = linhaAleatorio;
//                        /* Tratamento de Erro (Coordenada Ocupada) */
//                        if ((colunaB7 == colunaB0) && (linhaB7 == linhaB0)
//                                || (colunaB7 == colunaB1) && (linhaB7 == linhaB1)
//                                || (colunaB7 == colunaB2) && (linhaB7 == linhaB2)
//                                || (colunaB7 == colunaB3) && (linhaB7 == linhaB3)
//                                || (colunaB7 == colunaB4) && (linhaB7 == linhaB4)
//                                || (colunaB7 == colunaB5) && (linhaB7 == linhaB5)
//                                || (colunaB7 == colunaB6) && (linhaB7 == linhaB6)
//                                || (colunaB7 == colunaB8) && (linhaB7 == linhaB8)) {
//                            // Retorna Loop para Randomisar as cooredenadas
//                            // novamente, até a condição ser falsa.
//                            botao--;
//                        } else {
//                            b7.setBounds(colunaB7, linhaB7, Horizontal, Vertical);
//                        }
//                    }
//                    break;
//                case 8:
//                    if (botao == 8) {
//                        colunaB8 = colunaAleatorio;
//                        linhaB8 = linhaAleatorio;
//                        /* Tratamento de Erro (Coordenada Ocupada) */
//                        if ((colunaB8 == colunaB0) && (linhaB8 == linhaB0)
//                                || (colunaB8 == colunaB1) && (linhaB8 == linhaB1)
//                                || (colunaB8 == colunaB2) && (linhaB8 == linhaB2)
//                                || (colunaB8 == colunaB3) && (linhaB8 == linhaB3)
//                                || (colunaB8 == colunaB4) && (linhaB8 == linhaB4)
//                                || (colunaB8 == colunaB5) && (linhaB8 == linhaB5)
//                                || (colunaB8 == colunaB6) && (linhaB8 == linhaB6)
//                                || (colunaB8 == colunaB7) && (linhaB8 == linhaB7)) {
//                            // Retorna Loop para Randomisar as cooredenadas
//                            // novamente, até a condição ser falsa.
//                            botao--;
//                        } else {
//                            b8.setBounds(colunaB8, linhaB8, Horizontal, Vertical);
//                        }
//                    }
//                    break;
//            }
//        }
//    }

    /**
     * Esse Método e chamado sempre que um botão é movimentado, verifica
     * andamento do Jogo se Ordenou o não os Botões no Tabuleiro.
     */
//    private void VerificarOrdenacao() {
//        /* Representação da Ordenação */
//        /* '-----------' */
//        /* ' 1 ' 2 ' 3 ' */
//        /* ' 4 ' 5 ' 6 ' */
//        /* ' 7 ' 8 ' 0 ' */
//        /* '-----------' */
//
//        /* Condição da Ordenação */
//        if ((colunaB1 == ZERO && linhaB1 == ZERO)
//                && (colunaB2 == UM && linhaB2 == ZERO)
//                && (colunaB3 == DOIS && linhaB3 == ZERO)
//                && (colunaB4 == ZERO && linhaB4 == UM)
//                && (colunaB5 == UM && linhaB5 == UM)
//                && (colunaB6 == DOIS && linhaB6 == UM)
//                && (colunaB7 == ZERO && linhaB7 == DOIS)
//                && (colunaB8 == UM && linhaB8 == DOIS)
//                && (colunaB0 == DOIS && linhaB0 == DOIS)) {
//
//            JOptionPane.showMessageDialog(null,
//                    "PARABÉNS VOCÊ CONCEGUIU UMA ORDENAÇÃO!");
//        }
//    }
}
